package com.github.mozvip.pushbullet.api;

import com.github.mozvip.pushbullet.model.*;
import retrofit2.Call;
import retrofit2.http.*;

public interface PushBulletService {

    @POST("/v2/texts")
    Call<TextResponse> createText(@Header("Authorization") String authorizationHeader,
                                  @Body TextRequest request);

    @GET("/v2/subscriptions")
    Call<SubscriptionsResponse> getSubscriptions(@Header("Authorization") String authorizationHeader);

    /**
     * Unsubscribe from a channel.
     *
     * @param authorizationHeader
     * @param iden
     * @return
     */
    @DELETE("/v2/subscriptions/{iden}")
    Call<Void> deleteSubscription(@Header("Authorization") String authorizationHeader, @Path("iden") String iden);

    @POST("/v2/subscriptions")
    Call<SubscriptionResponse> createSubscription(@Header("Authorization") String authorizationHeader,
                                                  @Body Channel channel);

    @FormUrlEncoded
    @POST("/v2/texts/{iden}")
    Call<Void> updateText(@Header("Authorization") String authorizationHeader,
                          @Path("iden") String iden,
                          @Field("data") String data,
                          @Field("skip_delete_file") boolean skip_delete_file);

    @FormUrlEncoded
    @POST("/v2/pushes")
    Call<Void> pushFile(@Header("Authorization") String authorizationHeader,
                        @Field("device_iden") String device_iden,
                        @Field("email") String email,
                        @Field("channel_tag") String channel_tag,
                        @Field("client_iden") String client_iden,
                        @Field("type") String type,
                        @Field("body") String body,
                        @Field("file_name") String file_name,
                        @Field("file_type") String file_type,
                        @Field("file_url") String file_url);

    @FormUrlEncoded
    @POST("/v2/pushes")
    Call<Void> pushNote(@Header("Authorization") String authorizationHeader,
                        @Field("device_iden") String device_iden,
                        @Field("email") String email,
                        @Field("channel_tag") String channel_tag,
                        @Field("client_iden") String client_iden,
                        @Field("type") String type,
                        @Field("title") String title,
                        @Field("body") String body);

    @FormUrlEncoded
    @POST("/v2/pushes")
    Call<Void> pushLink(@Header("Authorization") String authorizationHeader,
                        @Field("device_iden") String device_iden,
                        @Field("email") String email,
                        @Field("channel_tag") String channel_tag,
                        @Field("client_iden") String client_iden,
                        @Field("type") String type,
                        @Field("title") String title,
                        @Field("body") String body,
                        @Field("url") String url);

    @GET("/v2/pushes")
    Call<PushBulletReponse> getPushes(@Header("Authorization") String authorizationHeader,
                                      @Query("modified_after") String modifiedAfter,
                                      @Query("active") String active,
                                      @Query("cursor") String cursor,
                                      @Query("limit") int limit);

    @GET("/v2/channel-info")
    Call<ChannelInfoResponse> getChannelInfo(@Header("Authorization") String authorizationHeader,
                                             @Query("tag") String tag,
                                             @Query("no_recent_pushes") boolean noRecentPushes);

    @GET("/v2/devices")
    Call<PushBulletReponse> getDevices(@Header("Authorization") String authorizationHeader);

    @GET("/v2/users/me")
    Call<User> getCurrentUser(@Header("Authorization") String authorizationHeader);

    @FormUrlEncoded
    @POST("/v2/upload-request")
    Call<UploadRequest> uploadRequest(@Header("Authorization") String authorizationHeader,
                                      @Field("file_name") String fileName,
                                      @Field("file_type") String fileType);

}
