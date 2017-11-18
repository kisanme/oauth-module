package org.ucsc.ewa.oauthModule.util;

public class EwaResponse<t> {
    private t data;
    private int statusCode;
    private String message;

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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
