package com.jalvis.SciNet.services.interfaces;

import com.jalvis.SciNet.entities.Luser;
import com.jalvis.SciNet.entities.User;

public interface AccountService {
    public boolean register(User user);
    public boolean login(Luser luser);
}
