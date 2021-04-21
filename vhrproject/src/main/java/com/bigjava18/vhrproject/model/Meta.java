package com.bigjava18.vhrproject.model;

import java.io.Serializable;

/**
 * @Author zgp
 * @Since 2020 -11 -25 09 :55
 * @Description
 */
public class Meta implements Serializable {

    private Boolean keepAlive;
    private Boolean requireAuth;

    public Boolean getKeepAlive() {
        return keepAlive;
    }

    public void setKeepAlive(Boolean keepAlive) {
        this.keepAlive = keepAlive;
    }

    public Boolean getRequireAuth() {
        return requireAuth;
    }

    public void setRequireAuth(Boolean requireAuth) {
        this.requireAuth = requireAuth;
    }
}
