package controller;

import DAO.ReadWriteCSV;
import DAO.User;
import view.ChatView;
import view.LoginView;
import view.SignupView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class SignupController {
    SignupView signupView;
    LoginView loginView;
    ChatView chatView;
    List<User> list;

    public SignupController(SignupView signupView){
        this.signupView = signupView;
        signupView.addLoginListener(new LoginListener());
        signupView.addSignupListener(new SignupListener());
    }
    public void showSignup(){
        signupView.setVisible(true);
    }
    class LoginListener implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            loginView = new LoginView();
            login controller = new login(loginView);
            controller.showLoginView();
            signupView.setVisible(false);

        }
    }
    class SignupListener implements ActionListener{

        public void actionPerformed(ActionEvent e) {

            if(signupView.checkEmpty()){
                signupView.showMessage("Please enter all fields");
                return;
            }
            if(!signupView.confirmPassword()){
                signupView.showMessage("Confirm password fail !");
                return;
            }
            User iuser = signupView.getUser();
            list = ReadWriteCSV.read();
            list.add(iuser);
            ReadWriteCSV.write(list);
            chatView = new ChatView(iuser.getName());
            chat controller = new chat(chatView);
            controller.showChatView();
            signupView.setVisible(false);

        }
    }
}
