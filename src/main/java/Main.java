import controller.SignupController;
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
        SignupController controller = new SignupController(signupView);
        controller.showSignup();
    }
}
