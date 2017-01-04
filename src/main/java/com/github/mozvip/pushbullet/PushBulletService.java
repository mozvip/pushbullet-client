package com.github.mozvip.pushbullet;

import com.github.mozvip.pushbullet.model.PushBulletReponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface PushBulletService {
	
	@FormUrlEncoded
	@POST("/v2/pushes")
	public Call<Void> push(@Header("Authorization") String accessToken, @Field("device_iden") String device_iden , @Field("type") String type, @Field("title") String title, @Field("body") String body , @Field("url") String url);
	
	@GET("/v2/devices")
	public Call<PushBulletReponse> getDevices(@Header("Authorization") String accessToken);

}
