package org.ucsc.ewa.oauthModule.util;

public class EwaResponse<t> {
    private t data;
    private int statusCode;

    public t getData() {
        return data;
    }

    public void setData(t data) {
        this.data = data;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}
