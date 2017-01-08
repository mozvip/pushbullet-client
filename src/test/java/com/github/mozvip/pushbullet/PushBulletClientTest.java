package com.github.mozvip.pushbullet;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.github.mozvip.pushbullet.PushBulletClient;
import com.github.mozvip.pushbullet.model.PushBulletDevice;

public class PushBulletClientTest {

	static PushBulletClient client = PushBulletClient.Builder().accessToken( System.getenv("PUSHBULLET_ACCESS_TOKEN")).build();
	private static String deviceId;
	
	@BeforeClass
	public static void init() throws IOException {
		List<PushBulletDevice> devices = client.getDevices();
		for (PushBulletDevice pushBulletDevice : devices) {
			if (pushBulletDevice.isActive() && pushBulletDevice.isPushable() && pushBulletDevice.getNickname() != null) {
				deviceId = pushBulletDevice.getIden();
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
	public void getDevices() throws IOException {
		List<PushBulletDevice> devices = client.getDevices();
		for (PushBulletDevice pushBulletDevice : devices) {
			System.out.println(pushBulletDevice.getIden() + " " + pushBulletDevice.getModel());
		}
		Assert.assertTrue( devices.size() > 0);
	}

}
