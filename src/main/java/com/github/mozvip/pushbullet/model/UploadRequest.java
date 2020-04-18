package com.github.mozvip.pushbullet.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class UploadRequest {

    @JsonProperty("file_name")
    private String fileName;
    @JsonProperty("file_type")
    private String fileType;
    @JsonProperty("file_url")
    private String fileUrl;
    @JsonProperty("upload_url")
    private String uploadUrl;

    private Map<String, String> data;

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

    public String getUploadUrl() {
        return uploadUrl;
    }

    public void setUploadUrl(String uploadUrl) {
        this.uploadUrl = uploadUrl;
    }

    public Map<String, String> getData() {
        return data;
    }

    public void setData(Map<String, String> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "UploadRequest{" +
                "fileName='" + fileName + '\'' +
                ", fileType='" + fileType + '\'' +
                ", fileUrl='" + fileUrl + '\'' +
                ", uploadUrl='" + uploadUrl + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
