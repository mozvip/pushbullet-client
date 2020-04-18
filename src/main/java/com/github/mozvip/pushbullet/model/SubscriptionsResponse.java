package com.github.mozvip.pushbullet.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown=true)
public class SubscriptionsResponse {
    List<SubscriptionResponse> subscriptions;

    public List<SubscriptionResponse> getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(List<SubscriptionResponse> subscriptions) {
        this.subscriptions = subscriptions;
    }
}
