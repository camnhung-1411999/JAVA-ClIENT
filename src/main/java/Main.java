import controller.login;
import controller.signup;
import view.ChatView;
import view.LoginView;
import view.SignupView;

import java.awt.*;

public class Main {
    public static void main(String[] args){
//        LoginView loginView = new LoginView();
//        login controller = new login(loginView);
//        controller.showLoginView();
        SignupView signupView = new SignupView();
        signup controller = new signup(signupView);
        controller.showSignup();
    }
}
