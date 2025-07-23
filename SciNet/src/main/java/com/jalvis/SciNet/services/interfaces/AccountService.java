package com.jalvis.SciNet.services.interfaces;

import com.jalvis.SciNet.entities.Luser;
import com.jalvis.SciNet.entities.User;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;

public interface AccountService {
    public boolean register(User user);
    public ResponseCookie login(Luser luser);
}
