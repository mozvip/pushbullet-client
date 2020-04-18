package com.github.mozvip.pushbullet.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TextRequest {

    private TextData data;
    @JsonProperty("file_url")
    private String fileUrl;
    @JsonProperty("skip_delete_file")
    private boolean skipDeleteFile;

    public TextData getData() {
        return data;
    }

    public void setData(TextData data) {
        this.data = data;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public boolean isSkipDeleteFile() {
        return skipDeleteFile;
    }

    public void setSkipDeleteFile(boolean skipDeleteFile) {
        this.skipDeleteFile = skipDeleteFile;
    }
}
