package org.ucsc.ewa.oauthModule.exception;

public class InvalidToken extends Exception {

    public InvalidToken(){
        super();
    }

    public InvalidToken(String message){
        super(message);
    }
}
