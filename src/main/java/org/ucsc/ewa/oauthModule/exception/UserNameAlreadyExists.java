package org.ucsc.ewa.oauthModule.exception;

public class UserNameAlreadyExists extends Exception {

    public UserNameAlreadyExists(){
        super();
    }

    public UserNameAlreadyExists(String message){
        super(message);
    }
}
