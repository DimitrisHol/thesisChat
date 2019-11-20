package hello.service;

import hello.controllerAPI.LoginController;
import hello.dao.LoginDao;
import hello.dao.MessageDao;
import hello.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class LoginService {


    private final LoginDao loginDao;

    @Autowired
   public LoginService(@Qualifier("userList") LoginDao loginDao){
        this.loginDao = loginDao;
    }

    public void userJoined(User user){

        loginDao.userLoggedIn(user);
    }

    public void userLeft(User user){

        loginDao.userLoggedOut(user);
    }

}

