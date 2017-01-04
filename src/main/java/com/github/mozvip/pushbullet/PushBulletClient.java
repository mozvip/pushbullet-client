package com.github.mozvip.pushbullet;

import java.io.IOException;
import java.util.List;

import com.github.mozvip.pushbullet.model.PushBulletDevice;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

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

	private String accessToken;

	private PushBulletClient(String accessToken) {
		this.accessToken = accessToken;

		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl("https://api.pushbullet.com")
				.addConverterFactory(JacksonConverterFactory.create())
				.build();
		service = retrofit.create(PushBulletService.class);
	}

	public void push(String device_iden, String type, String title, String body, String url) throws IOException {
		service.push("Bearer " + accessToken, device_iden, type, title, body, url).execute();
	}
	
	public void pushNote( String device_iden, String title, String body ) throws IOException {
		service.push("Bearer " + accessToken, device_iden, "note", title, body, null).execute();
	}

	public void pushLink( String device_iden, String title, String body, String url ) throws IOException {
		service.push("Bearer " + accessToken, device_iden, "link", title, body, url).execute();
	}	

	public List<PushBulletDevice> getDevices() throws IOException {
		return service.getDevices("Bearer " + accessToken).execute().body().getDevices();
	}
	
	

}
