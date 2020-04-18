package com.github.mozvip.pushbullet.model;

import java.time.Instant;

public class SubscriptionResponse {

    private boolean active;
    private ChannelDetails channel;
    private Instant created;
    private String iden;
    private Instant modified;

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public ChannelDetails getChannel() {
        return channel;
    }

    public void setChannel(ChannelDetails channel) {
        this.channel = channel;
    }

    public Instant getCreated() {
        return created;
    }

    public void setCreated(Instant created) {
        this.created = created;
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
}
