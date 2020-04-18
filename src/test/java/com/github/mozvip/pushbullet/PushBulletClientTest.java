package com.github.mozvip.pushbullet;

import com.github.mozvip.pushbullet.model.*;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.List;

public class PushBulletClientTest {

	static PushBulletClient client = PushBulletClient.Builder().accessToken( System.getenv("PUSHBULLET_ACCESS_TOKEN")).build();
	static OkHttpClient httpClient = new OkHttpClient();

	private static String deviceId;
	private static Instant testStart = Instant.now();
	
	@BeforeClass
	public static void init() throws IOException {
		List<PushBulletDevice> devices = client.getDevices();
		for (PushBulletDevice device : devices) {
			if (device.isActive() && device.isPushable() && device.getNickname() != null && !"windows".equals(device.getType())) {
				deviceId = device.getIden();
				System.out.println("Selected device : " + device.toString());
				break;
			}
		}
	}

	@Test
	public void pushNote() throws IOException {
		client.pushNote(deviceId, "Test Note", "Note contents");
	}

	@Test
	public void pushLink() throws IOException {
		client.pushLink(deviceId, "Test Link", "Link to google", "https://www.google.com");
	}

	@Test
	public void testCreateText() throws IOException {
		TextData data = new TextData();
		data.getAddresses().add(System.getenv("PHONE_SMS"));
		data.setMessage("Hello World");
		data.setTargetDeviceIden(deviceId);

		client.createText(data, null, false);
	}

	@Test
	public void testCreateTextWithImage() throws IOException, URISyntaxException {
		final String fileUrl = uploadFile();

		TextData data = new TextData();
		data.getAddresses().add(System.getenv("PHONE_MMS"));
		data.setTargetDeviceIden(deviceId);
		data.setFileType("image/jpeg");

		client.createText(data, fileUrl, false);
	}

	private String uploadFile() throws URISyntaxException, IOException {
		final URL resource = getClass().getResource("/cat.jpg");
		final Path localFilePath = Paths.get(resource.toURI());
		final String fileUrl = client.upload(localFilePath);
		Assert.assertNotNull(fileUrl);
		return fileUrl;
	}

	@Test
	public void getSubscriptions() throws IOException {
		final SubscriptionsResponse subscriptions = client.getSubscriptions();
		Assert.assertNotNull(subscriptions);
	}

	@Test
	public void createSubscription() throws IOException {
		final SubscriptionsResponse subscriptions = client.getSubscriptions();
		for (SubscriptionResponse subscription : subscriptions.getSubscriptions()) {
			if (subscription.getChannel().getTag().equals("humblebundle")) {
				client.deleteSubscription(subscription.getIden());
			}
		}
		final SubscriptionResponse subscription = client.createSubscription("humblebundle");
		Assert.assertNotNull(subscription);
	}

	@Test
	public void testUploadAndPushFile() throws IOException, URISyntaxException {
		final URL resource = getClass().getResource("/cat.jpg");
		final Path localFilePath = Paths.get(resource.toURI());
		final String fileUrl = uploadFile();

		Request request = new Request.Builder()
				.url(fileUrl)
				.build();

		String contentType;
		try (Response response = httpClient.newCall(request).execute()) {
			Assert.assertEquals(200, response.code());
			contentType = response.header("Content-Type");
			Assert.assertEquals("image/jpeg", contentType);
			final long contentLength = Long.parseLong(response.header("Content-Length"));
			Assert.assertEquals(Files.size(localFilePath), contentLength);
		}

		client.pushFile(deviceId, "A nice image", localFilePath.getFileName().toString(), contentType, fileUrl);
	}

	@Test
	public void getChannelInfo() throws IOException {
		final ChannelInfoResponse channelInfo = client.getChannelInfo("humblebundle", false);
		Assert.assertEquals(channelInfo.getTag(), "humblebundle");
	}


	@Test
	public void getDevices() throws IOException {
		List<PushBulletDevice> devices = client.getDevices();
		for (PushBulletDevice pushBulletDevice : devices) {
			System.out.println(pushBulletDevice.toString());
		}
		Assert.assertTrue( devices.size() > 0);
	}

	@AfterClass
	public static void getPushes() throws IOException {
		final List<Push> pushes = client.getPushes(testStart, true, null, 10);
		Assert.assertEquals(3, pushes.size());
	}


	@Test
	public void getCurrentUser() throws IOException {
		User user = client.getCurrentUser();
		Assert.assertTrue( user != null);
	}
}
