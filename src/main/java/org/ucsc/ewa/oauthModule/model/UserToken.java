package org.ucsc.ewa.oauthModule.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "user_token")
public class UserToken extends BaseEntity{

    @Column(name = "user_token")
    private String userToken;

    @Column(name = "app_user_id")
    private long appUserId;

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }

    public long getAppUserId() {
        return appUserId;
    }

    public void setAppUserId(long appUserId) {
        this.appUserId = appUserId;
    }
}
