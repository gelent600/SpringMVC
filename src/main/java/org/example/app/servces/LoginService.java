package org.example.app.servces;

import org.apache.log4j.Logger;
import org.example.web.dto.LoginForm;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private Logger logger=Logger.getLogger(LoginService.class);
    public boolean authenticate(LoginForm loginForm){
        logger.info("try auth with user_form: "+loginForm.toString());
        return loginForm.getName().equals("root")&&loginForm.getPassword().equals("123");
    }
}
