package controller;

import multithreadtcp.Client;
import view.ChatView;
import view.LoginView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ChatController{
    LoginView loginView;
    ChatView chatView;
    String user;
    Client client;

    public ChatController(ChatView chatView){
        this.chatView = chatView;
        client = new Client(this.chatView.getName());
        client.sendName();
        setTableOnline(client);
        chatView.addSendListener(new SendListener());
        chatView.addLogoutListener(new LogoutListener());
    }
    public void showChatView(){
        chatView.setVisible(true);
    }
    public void setTableOnline(final Client client){
        Runnable target;
        Thread readMsg = new Thread(new Runnable() {
            public void run() {
                try {
                    int i =0;
                    Object[][] online = new Object[50][1];
                    while (true){
                        String msg = client.getInput().readUTF();
                        String[] ex = msg.split(":");
                        if(ex.length > 1){
                            chatView.setTextArea(chatView.getTextArea() +'\n' + msg + '\n');
                        }else{
                            int j = 0;
                            for(j = 0;j<i;j++){
                                if(msg.equals(online[j][0])) break;
                            }
                            if(j ==i && !msg.equals(client.getUsername())){
                                online[i++][0] = msg;
                            }
                            chatView.setTable(online);
                        }
                    }
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        });
        readMsg.start();

    }
    class SendListener implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            chatView.setTextArea(chatView.getTextArea() + '\n' +" + You to "+chatView.getNameOnline()+":"+chatView.getMsg() + '\n');
            client.writeMessage(chatView.getNameOnline() + "#" + chatView.getMsg());
            chatView.clearMsg();
        }
    }

    class LogoutListener implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            client.writeMessage("logout");
            loginView = new LoginView();
            LoginController controller = new LoginController(loginView);
            controller.showLoginView();
            chatView.setVisible(false);
        }
    }
}
