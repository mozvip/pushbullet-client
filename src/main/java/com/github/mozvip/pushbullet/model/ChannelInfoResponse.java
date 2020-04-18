package com.github.mozvip.pushbullet.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;
import java.util.List;

public class ChannelInfoResponse {

    private boolean active;
    private Instant created;
    private String description;
    private String iden;
    private String image_url;
    private String website_url;
    private Instant modified;
    private String name;
    private int subscriber_count;
    private String tag;
    @JsonProperty("recent_pushes")
    private List<Push> recentPushes;

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Instant getCreated() {
        return created;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIden() {
        return iden;
    }

    public void setIden(String iden) {
        this.iden = iden;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public Instant getModified() {
        return modified;
    }

    public void setModified(Instant modified) {
        this.modified = modified;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSubscriber_count() {
        return subscriber_count;
    }

    public void setSubscriber_count(int subscriber_count) {
        this.subscriber_count = subscriber_count;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getWebsite_url() {
        return website_url;
    }

    public void setWebsite_url(String website_url) {
        this.website_url = website_url;
    }

    public List<Push> getRecentPushes() {
        return recentPushes;
    }

    public void setRecentPushes(List<Push> recentPushes) {
        this.recentPushes = recentPushes;
    }

}
