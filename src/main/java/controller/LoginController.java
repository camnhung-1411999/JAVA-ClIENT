package controller;

import DAO.ReadWriteCSV;
import DAO.User;
import view.ChatView;
import view.LoginView;
import view.SignupView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class LoginController {
    LoginView loginView;
    SignupView signupView;
    ChatView chatView;
    List<User> list;
    public LoginController(LoginView loginView){
        this.loginView = loginView;
        loginView.addLoginListener(new LoginListener());
        loginView.addSignupListener(new SignupListener());
    }
    public  void showLoginView(){
        loginView.setVisible(true);
    }

    class  LoginListener implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            if(loginView.checkEmpty()){
                loginView.showMessage("Please enter all fields");
                return;
            }
            list = ReadWriteCSV.read();
            for(int i=0;i<list.size();i++) {
                if (list.get(i).getUsername().equals(loginView.getName())) {
                    if (list.get(i).getPassword().equals(loginView.getPassword())) {
                        chatView = new ChatView(loginView.getName());
                        chat controller = new chat(chatView);
                        controller.showChatView();
                        loginView.setVisible(false);
                    }
                    else{
                        loginView.showMessage("Password wrong!");
                    }
                }
                else{
                    loginView.showMessage("User not exist !");
                }
            }
        }
    }
    class SignupListener implements ActionListener{

        public void actionPerformed(ActionEvent e) {

            signupView = new SignupView();
            SignupController controller = new SignupController(signupView);
            controller.showSignup();
            loginView.setVisible(false);
        }
    }
}
