package org.ucsc.ewa.oauthModule.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.ucsc.ewa.oauthModule.model.AppUser;
import org.ucsc.ewa.oauthModule.model.UserToken;

@Repository
public interface UserTokenRepository  extends JpaRepository<UserToken, Long> {

    UserToken findOneByAppUserIdAndUserToken(Long appUserId , String userToken);

}
