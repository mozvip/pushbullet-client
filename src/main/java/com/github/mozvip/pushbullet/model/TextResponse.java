package com.github.mozvip.pushbullet.model;

import java.time.Instant;

public class TextResponse {

    private boolean active;
    private String iden;
    private Instant created;
    private Instant modified;
    private TextData data;

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getIden() {
        return iden;
    }

    public void setIden(String iden) {
        this.iden = iden;
    }

    public Instant getCreated() {
        return created;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public Instant getModified() {
        return modified;
    }

    public void setModified(Instant modified) {
        this.modified = modified;
    }

    public TextData getData() {
        return data;
    }

    public void setData(TextData data) {
        this.data = data;
    }
}
