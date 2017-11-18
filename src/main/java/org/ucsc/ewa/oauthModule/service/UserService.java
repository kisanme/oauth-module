package org.ucsc.ewa.oauthModule.service;

import org.ucsc.ewa.oauthModule.dto.ResetPasswordDTO;
import org.ucsc.ewa.oauthModule.dto.TokenDTO;
import org.ucsc.ewa.oauthModule.dto.UserDTO;
import org.ucsc.ewa.oauthModule.exception.InvalidToken;
import org.ucsc.ewa.oauthModule.exception.UserNameAlreadyExists;
import org.ucsc.ewa.oauthModule.model.AppUser;

public interface UserService {
    public UserDTO createUser(UserDTO user) throws UserNameAlreadyExists;
    public void validateToken(TokenDTO token) throws InvalidToken;
    public void resetPassword(ResetPasswordDTO resetPasswordDTO);
}
