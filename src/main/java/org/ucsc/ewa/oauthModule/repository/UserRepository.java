package org.ucsc.ewa.oauthModule.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.ucsc.ewa.oauthModule.model.AppUser;


@Repository
public interface UserRepository extends JpaRepository<AppUser, Long> {

    AppUser findOneByUsername(String userName);
}
