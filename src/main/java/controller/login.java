package controller;

import DAO.readWriteCSV;
import DAO.user;
import view.ChatView;
import view.LoginView;
import view.SignupView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class login {
    LoginView loginView;
    SignupView signupView;
    ChatView chatView;
    List<user> list;
    public login(LoginView loginView){
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
            list = readWriteCSV.read();
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
            signup controller = new signup(signupView);
            controller.showSignup();
            loginView.setVisible(false);
        }
    }
}
