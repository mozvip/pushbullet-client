package com.github.mozvip.pushbullet.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Channel {
    @JsonProperty("channel_tag")
    private String channelTag;

    public String getChannelTag() {
        return channelTag;
    }

    public void setChannelTag(String channelTag) {
        this.channelTag = channelTag;
    }
}
