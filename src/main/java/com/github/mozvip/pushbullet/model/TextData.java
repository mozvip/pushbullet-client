package com.github.mozvip.pushbullet.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TextData {

    /**
     * The device_iden of the Device to send the message. This device must have SMS Android permissions granted.
     */
    @JsonProperty("target_device_iden")
    private String targetDeviceIden;
    /**
     * A list of 1 more phone numbers to send this message to. Including more than one number sends a group MMS message.
     */
    private List<String> addresses = new ArrayList<>();
    /**
     * The text content of the text message.
     */
    private String message = "";
    /**
     * Unique identifier optionally set by the client, used to identify a text message to ensure it is not sent
     * multiple times in the case create-text is called for it more than once.
     */
    private String guid;
    /**
    /**
     * The mime type of the file_url being sent with this message. Only required for messages sending a file.
     */
    @JsonProperty("file_type")
    private String fileType;

    public TextData() {
        this.guid = UUID.randomUUID().toString();
    }

    public String getTargetDeviceIden() {
        return targetDeviceIden;
    }

    public void setTargetDeviceIden(String targetDeviceIden) {
        this.targetDeviceIden = targetDeviceIden;
    }

    public List<String> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<String> addresses) {
        this.addresses = addresses;
    }

    public void addAdress(String address) {
        addresses.add(address);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }
}
