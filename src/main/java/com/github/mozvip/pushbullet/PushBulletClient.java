package com.github.mozvip.pushbullet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.github.mozvip.pushbullet.api.PushBulletService;
import com.github.mozvip.pushbullet.model.*;
import okhttp3.*;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import retrofit2.http.GET;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Instant;
import java.util.List;

public class PushBulletClient {

    public static final class Builder {

		private String accessToken;

		public Builder accessToken(String accessToken) {
			this.accessToken = accessToken;
			return this;
		}

		public PushBulletClient build() {
			return new PushBulletClient(accessToken);
		}

	}

	public static Builder Builder() {
		return new Builder();
	}

	private PushBulletService service;

	private String authorizationHeader;

	private OkHttpClient client;
	private ObjectMapper mapper;

	private PushBulletClient(String accessToken) {
		this.authorizationHeader = "Bearer " + accessToken;

		mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());

		client = new OkHttpClient().newBuilder()
				.build();

		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl("https://api.pushbullet.com")
				.client(client)
				.addConverterFactory(JacksonConverterFactory.create(mapper))
				.build();

		service = retrofit.create(PushBulletService.class);
	}

	public void pushNote(String device_iden, String title, String messageBody) throws IOException {
		final retrofit2.Call<Void> call = service.pushNote(authorizationHeader, device_iden, null, null, null, "note", title, messageBody);
		final Response<Void> response = call.execute();
		if (response.code() != 200) {
			throw new IOException(response.message());
		}
	}

	public void pushLink(String device_iden, String title, String messageBody, String url) throws IOException {
		final retrofit2.Call<Void> call = service.pushLink(authorizationHeader, device_iden, null, null, null, "link", title, messageBody, url);
		final Response<Void> response = call.execute();
		if (response.code() != 200) {
			throw new IOException(response.message());
		}
	}

	public void pushFile(String device_iden, String messageBody, String fileName, String fileType, String fileUrl) throws IOException {
		final retrofit2.Call<Void> call = service.pushFile(authorizationHeader, device_iden, null, null, null, "file", messageBody, fileName, fileType, fileUrl);
		final Response<Void> response = call.execute();
		if (response.code() != 200) {
			throw new IOException(response.message());
		}
	}

	public SubscriptionsResponse getSubscriptions() throws IOException {
		final Response<SubscriptionsResponse> response = service.getSubscriptions(authorizationHeader).execute();
		if (response.code() != 200) {
			throw new IOException(response.message());
		}
		return response.body();
	}

	public void deleteSubscription(String iden) throws IOException {
		final Response<Void> response = service.deleteSubscription(authorizationHeader, iden).execute();
		if (response.code() != 200) {
			throw new IOException(response.message());
		}
	}

	public SubscriptionResponse createSubscription(String channelTag) throws IOException {
		Channel channel = new Channel();
		channel.setChannelTag(channelTag);
		final Response<SubscriptionResponse> response = service.createSubscription(authorizationHeader, channel).execute();
		if (response.code() != 200) {
			throw new IOException(response.message());
		}
		return response.body();
	}

	public ChannelInfoResponse getChannelInfo(String tag, boolean noRecentPushes) throws IOException {
		final Response<ChannelInfoResponse> response = service.getChannelInfo(authorizationHeader, tag, noRecentPushes).execute();
		if (response.code() != 200) {
			throw new IOException(response.message());
		}
		return response.body();
	}

	/**
	 * @param data Values specifying this text message
	 * @param fileUrl File download url for an image to send with the text message.
	 * @param skipDeleteFile If set to false, delete the attached file when the Text is deleted.
	 * @return
	 * @throws IOException
	 */
	public TextResponse createText(TextData data, String fileUrl, boolean skipDeleteFile) throws IOException {
		TextRequest request = new TextRequest();
		request.setData(data);
		request.setFileUrl(fileUrl);
		request.setSkipDeleteFile(skipDeleteFile);
		final Response<TextResponse> response = service.createText(authorizationHeader, request).execute();
		if (response.code() != 200) {
			throw new IOException(response.message());
		}
		return response.body();
	}

	public void updateText(String iden, TextData data, boolean skipDeleteFile) throws IOException {
		final Response<Void> response = service.updateText(authorizationHeader, iden, mapper.writeValueAsString(data), skipDeleteFile).execute();
		if (response.code() != 200) {
			throw new IOException(response.message());
		}
	}

	public List<PushBulletDevice> getDevices() throws IOException {
		return service.getDevices(authorizationHeader).execute().body().getDevices();
	}

	public UploadRequest uploadRequest(String fileName, String fileType) throws IOException {
		final Response<UploadRequest> response = service.uploadRequest(authorizationHeader, fileName, fileType).execute();
		if (response.code() != 200) {
			throw new IOException(response.message());
		}
		return response.body();
	}

	public String upload(Path localFile) throws IOException {
		final String fileName = localFile.getFileName().toString();
		final String contentType = Files.probeContentType(localFile);

		final UploadRequest uploadRequest = uploadRequest(fileName, contentType);

		RequestBody requestBody = new MultipartBody.Builder()
				.setType(MultipartBody.FORM)
				.addFormDataPart("file", fileName, RequestBody.create(MediaType.parse(contentType), localFile.toFile()))
				.build();
		Request request = new Request.Builder()
				.url(uploadRequest.getUploadUrl())
				.post(requestBody)
				.build();

		Call call = client.newCall(request);
		okhttp3.Response response = call.execute();
		if (response.code() != 204) {
			throw new IOException(response.message());
		}

		return uploadRequest.getFileUrl();
	}

	public List<Push> getPushes(Instant modifiedAfter, boolean active, String cursor, int limit) throws IOException {
		final Response<PushBulletReponse> response = service.getPushes(authorizationHeader, modifiedAfter != null ? Long.toString(modifiedAfter.getEpochSecond()) : null, Boolean.toString(active), cursor, limit).execute();
		if (response.code() != 200) {
			throw new IOException(response.message());
		}
		return response.body().getPushes();
	}

	public User getCurrentUser() throws IOException {
		final Response<User> response = service.getCurrentUser(authorizationHeader).execute();
		if (response.code() != 200) {
			throw new IOException(response.message());
		}
		return response.body();
	}

}
