package org.ucsc.ewa.oauthModule.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.ucsc.ewa.oauthModule.dto.ResetPasswordDTO;
import org.ucsc.ewa.oauthModule.dto.TokenDTO;
import org.ucsc.ewa.oauthModule.dto.UserDTO;
import org.ucsc.ewa.oauthModule.exception.InvalidToken;
import org.ucsc.ewa.oauthModule.exception.UserNameAlreadyExists;
import org.ucsc.ewa.oauthModule.model.AppUser;
import org.ucsc.ewa.oauthModule.service.UserService;
import org.ucsc.ewa.oauthModule.util.EwaResponse;

@RestController
@RequestMapping(value = "api/user")
public class PersonController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "reset-password/{email}", method = RequestMethod.GET)
    public void sendEmail(@PathVariable("email") String email) {


    }


    @RequestMapping(value = "reset-password/", method = RequestMethod.PUT)
    public void resetpassword(@RequestBody ResetPasswordDTO passwordDTO) {


    }


    @RequestMapping(value = "/", method = RequestMethod.POST)
    public EwaResponse<UserDTO> createPerson(@RequestBody UserDTO user) {

        try {
            UserDTO user1 = userService.createUser(user);
            EwaResponse<UserDTO> p = new EwaResponse<>();
            p.setData(user1);

            p.setStatusCode(200);
            return p;
        }catch (UserNameAlreadyExists ex){
            EwaResponse<UserDTO> p = new EwaResponse<>();
            p.setMessage("userNameAlreadyThere");
            p.setStatusCode(400);
            return p;
        }
        catch (Exception ex) {
            EwaResponse<UserDTO> p = new EwaResponse<>();
            p.setStatusCode(500);
            return p;
        }

    }


    @RequestMapping(value = "/activate", method = RequestMethod.PUT)
    public EwaResponse<TokenDTO> activateUser(@RequestBody TokenDTO tokenDTO) {

        try {
            userService.validateToken(tokenDTO);
            EwaResponse<TokenDTO> p = new EwaResponse<>();
            p.setStatusCode(200);
            p.setMessage("success user create");
            return p;
        }catch (InvalidToken ex){
            EwaResponse<TokenDTO> p = new EwaResponse<>();
            p.setMessage("invalid token");
            p.setStatusCode(400);
            return p;
        }
        catch (Exception ex) {
            EwaResponse<TokenDTO> p = new EwaResponse<>();
            p.setStatusCode(500);
            return p;
        }

    }




}
