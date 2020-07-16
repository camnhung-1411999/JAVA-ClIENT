package view;


import multithreadtcp.Client;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class LoginView extends JFrame implements ActionListener {
    private JLabel titleLabel;
    private JLabel nameLabel;
    private JTextField nameField;
    private JLabel passwordLabel;
    private JPasswordField passwordField;
    private JLabel pictureLabel;
    private JButton loginBtn;
    private JButton signupBtn;
    public LoginView(){
        InitComponents();
    }

    private void InitComponents(){
        titleLabel = new JLabel(" LOG IN CHAT TOGETHER");
        titleLabel.setFont(new Font("Verdana", Font.PLAIN, 20));
        titleLabel.setForeground(new Color(120, 90, 40));
        Border border = BorderFactory.createLineBorder(Color.GRAY);
        nameLabel = new JLabel( "Enter your name:");
        nameLabel.setForeground(new Color(120, 90, 40));
        nameLabel.setFont(new Font("Verdana", Font.PLAIN, 15));
        nameField = new JTextField();
        nameField.setPreferredSize(new Dimension(250,30));
        nameField.setBorder(border);
        passwordLabel = new JLabel( "Enter your password:");
        passwordLabel.setForeground(new Color(120, 90, 40));
        passwordLabel.setFont(new Font("Verdana", Font.PLAIN, 15));
        passwordField = new JPasswordField();
        passwordField.setPreferredSize(new Dimension(250,30));
        passwordField.setBorder(border);
        signupBtn = new JButton("You haven't account? Go to sign up");
        signupBtn.setForeground(Color.BLUE);
        signupBtn.setFont(new Font("Verdana", Font.PLAIN, 10));
        signupBtn.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        signupBtn.setBackground(Color.WHITE);
        loginBtn = new JButton();
        loginBtn.setText("Log in");
        loginBtn.setForeground(new Color(120, 90, 40));
        loginBtn.setFont(new Font("Verdana", Font.PLAIN, 15));
        loginBtn.setBorder(border);
        loginBtn.setPreferredSize(new Dimension(80,30));
        loginBtn.setBackground(Color.LIGHT_GRAY);

        loginBtn.addActionListener(this);
        signupBtn.addActionListener(this);
        try{
            BufferedImage myPicture = ImageIO.read(new File("src\\main\\java\\view\\penguin.png"));
            pictureLabel = new JLabel(new ImageIcon(myPicture));


        }catch (IOException e){
            e.printStackTrace();
        }

        loginBtn.addActionListener(this);

        SpringLayout layout = new SpringLayout();
        JPanel panel = new JPanel();
        panel.setSize(600,500);
        panel.setBackground(Color.WHITE);
        panel.setLayout(layout);
        panel.add(pictureLabel);
        panel.add(titleLabel);
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(signupBtn);
        panel.add(loginBtn);
        panel.add(passwordField);
        panel.add(passwordLabel);

        layout.putConstraint(SpringLayout.WEST, titleLabel,310, SpringLayout.WEST,panel);
        layout.putConstraint(SpringLayout.NORTH, titleLabel,120, SpringLayout.NORTH,panel );
        layout.putConstraint(SpringLayout.WEST,nameLabel,320,SpringLayout.WEST,panel);
        layout.putConstraint(SpringLayout.NORTH,nameLabel,80, SpringLayout.NORTH,titleLabel);
        layout.putConstraint(SpringLayout.WEST,nameField,320,SpringLayout.WEST,panel);
        layout.putConstraint(SpringLayout.NORTH,nameField,30,SpringLayout.NORTH,nameLabel);
        layout.putConstraint(SpringLayout.WEST,passwordLabel,320,SpringLayout.WEST,panel);
        layout.putConstraint(SpringLayout.NORTH,passwordLabel,40, SpringLayout.NORTH,nameField);
        layout.putConstraint(SpringLayout.WEST,passwordField,320,SpringLayout.WEST,panel);
        layout.putConstraint(SpringLayout.NORTH,passwordField,30,SpringLayout.NORTH,passwordLabel);
        layout.putConstraint(SpringLayout.WEST, signupBtn,350,SpringLayout.WEST,panel);
        layout.putConstraint(SpringLayout.NORTH,signupBtn,40,SpringLayout.NORTH,passwordField);
        layout.putConstraint(SpringLayout.WEST,loginBtn,400,SpringLayout.WEST,panel);
        layout.putConstraint(SpringLayout.NORTH,loginBtn,80,SpringLayout.NORTH,passwordField);

        this.add(panel);
        this.pack();
        this.setBackground(Color.pink);
        this.setTitle("Chat application - log in");
        this.setSize(600,500);
        this.setResizable(false);
    }
    public String getName(){
        return nameField.getText().toString();
    }
    public String getPassword(){return String.copyValueOf(passwordField.getPassword());}
    public void actionPerformed(ActionEvent e) { }
    public boolean checkEmpty(){
        if(nameField.getText().equals("") || String.copyValueOf(passwordField.getPassword()).equals("")){
            return true;
        }
        return false;
    }
    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
    public void addLoginListener(ActionListener listener){
        loginBtn.addActionListener(listener);
    }
    public void addSignupListener(ActionListener listener){
        signupBtn.addActionListener(listener);
    }

}
