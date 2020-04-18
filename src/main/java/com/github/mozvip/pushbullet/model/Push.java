package com.github.mozvip.pushbullet.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;
import java.util.List;

public class Push {

    private boolean active;
    private String body;
    private Instant created;
    private String direction;
    private boolean dismissed;
    private String iden;
    private Instant modified;
    @JsonProperty("receiver_email")
    private String receiverEmail;
    @JsonProperty("receiver_email_normalized")
    private String receiverEmailNormalized;
    @JsonProperty("receiver_iden")
    private String receiverIden;
    @JsonProperty("sender_email")
    private String senderEmail;
    @JsonProperty("sender_email_normalized")
    private String senderEmailNormalized;
    @JsonProperty("sender_iden")
    private String senderIden;
    @JsonProperty("sender_name")
    private String senderName;
    @JsonProperty("target_device_iden")
    private String targetDeviceIden;
    private String title;
    private String type;
    private String url;
    @JsonProperty("file_name")
    private String fileName;
    @JsonProperty("file_type")
    private String fileType;
    @JsonProperty("file_url")
    private String fileUrl;
    @JsonProperty("image_width")
    private Integer imageWidth;
    @JsonProperty("image_height")
    private Integer imageHeight;
    @JsonProperty("image_url")
    private String imageUrl;

    private String channel_iden;

    private List<String> awake_app_guids;


    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Instant getCreated() {
        return created;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public boolean isDismissed() {
        return dismissed;
    }

    public void setDismissed(boolean dismissed) {
        this.dismissed = dismissed;
    }

    public String getIden() {
        return iden;
    }

    public void setIden(String iden) {
        this.iden = iden;
    }

    public Instant getModified() {
        return modified;
    }

    public void setModified(Instant modified) {
        this.modified = modified;
    }

    public String getReceiverEmail() {
        return receiverEmail;
    }

    public void setReceiverEmail(String receiverEmail) {
        this.receiverEmail = receiverEmail;
    }

    public String getReceiverEmailNormalized() {
        return receiverEmailNormalized;
    }

    public void setReceiverEmailNormalized(String receiverEmailNormalized) {
        this.receiverEmailNormalized = receiverEmailNormalized;
    }

    public String getReceiverIden() {
        return receiverIden;
    }

    public void setReceiverIden(String receiverIden) {
        this.receiverIden = receiverIden;
    }

    public String getSenderEmail() {
        return senderEmail;
    }

    public void setSenderEmail(String senderEmail) {
        this.senderEmail = senderEmail;
    }

    public String getSenderEmailNormalized() {
        return senderEmailNormalized;
    }

    public void setSenderEmailNormalized(String senderEmailNormalized) {
        this.senderEmailNormalized = senderEmailNormalized;
    }

    public String getSenderIden() {
        return senderIden;
    }

    public void setSenderIden(String senderIden) {
        this.senderIden = senderIden;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getTargetDeviceIden() {
        return targetDeviceIden;
    }

    public void setTargetDeviceIden(String targetDeviceIden) {
        this.targetDeviceIden = targetDeviceIden;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public Integer getImageWidth() {
        return imageWidth;
    }

    public void setImageWidth(Integer imageWidth) {
        this.imageWidth = imageWidth;
    }

    public Integer getImageHeight() {
        return imageHeight;
    }

    public void setImageHeight(Integer imageHeight) {
        this.imageHeight = imageHeight;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getChannel_iden() {
        return channel_iden;
    }

    public void setChannel_iden(String channel_iden) {
        this.channel_iden = channel_iden;
    }

    public List<String> getAwake_app_guids() {
        return awake_app_guids;
    }

    public void setAwake_app_guids(List<String> awake_app_guids) {
        this.awake_app_guids = awake_app_guids;
    }
}
