package view;


import DAO.user;
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

public class SignupView extends JFrame implements ActionListener {
    private JLabel titleLabel;
    private JLabel nameLabel;
    private JTextField nameField;
    private JLabel userLabel;
    private JTextField userField;
    private JLabel passwordLabel;
    private JPasswordField passwordField;
    private JLabel confirmLabel;
    private JPasswordField confirmField;
    private JLabel pictureLabel;
    private JButton loginBtn;
    private JButton signupBtn;
    public SignupView(){
        InitComponents();
    }

    private void InitComponents(){
        titleLabel = new JLabel(" SIGN UP CHATTING");
        titleLabel.setFont(new Font("Verdana", Font.PLAIN, 20));
        titleLabel.setForeground(new Color(120, 90, 40));
        Border border = BorderFactory.createLineBorder(Color.GRAY);
        nameLabel = new JLabel( "Enter your name:");
        nameLabel.setForeground(new Color(120, 90, 40));
        nameLabel.setFont(new Font("Verdana", Font.PLAIN, 15));
        nameField = new JTextField();
        nameField.setPreferredSize(new Dimension(250,30));
        nameField.setBorder(border);
        userLabel = new JLabel( "Enter your username:");
        userLabel.setForeground(new Color(120, 90, 40));
        userLabel.setFont(new Font("Verdana", Font.PLAIN, 15));
        userField = new JTextField();
        userField.setPreferredSize(new Dimension(250,30));
        userField.setBorder(border);
        passwordLabel = new JLabel( "Enter your password:");
        passwordLabel.setForeground(new Color(120, 90, 40));
        passwordLabel.setFont(new Font("Verdana", Font.PLAIN, 15));
        passwordField = new JPasswordField();
        passwordField.setPreferredSize(new Dimension(250,30));
        passwordField.setBorder(border);
        confirmLabel = new JLabel( "Confirm password:");
        confirmLabel.setForeground(new Color(120, 90, 40));
        confirmLabel.setFont(new Font("Verdana", Font.PLAIN, 15));
        confirmField = new JPasswordField();
        confirmField.setPreferredSize(new Dimension(250,30));
        confirmField.setBorder(border);
        loginBtn = new JButton("You have a account? Log in now!");
        loginBtn.setForeground(Color.BLUE);
        loginBtn.setFont(new Font("Verdana", Font.PLAIN, 10));
        loginBtn.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        loginBtn.setBackground(Color.WHITE);
        signupBtn = new JButton();
        signupBtn.setText("Sign up");
        signupBtn.setForeground(new Color(120, 90, 40));
        signupBtn.setFont(new Font("Verdana", Font.PLAIN, 15));
        signupBtn.setBorder(border);
        signupBtn.setPreferredSize(new Dimension(80,30));
        signupBtn.setBackground(Color.LIGHT_GRAY);

        try{
            BufferedImage myPicture = ImageIO.read(new File("src\\main\\java\\view\\penguin.png"));
            pictureLabel = new JLabel(new ImageIcon(myPicture));


        }catch (IOException e){
            e.printStackTrace();
        }

        loginBtn.addActionListener(this);
        signupBtn.addActionListener(this);
        SpringLayout layout = new SpringLayout();
        JPanel panel = new JPanel();
        panel.setSize(600,500);
        panel.setBackground(Color.WHITE);
        panel.setLayout(layout);
        panel.add(pictureLabel);
        panel.add(titleLabel);
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(userField);
        panel.add(userLabel);
        panel.add(signupBtn);
        panel.add(loginBtn);
        panel.add(passwordField);
        panel.add(passwordLabel);
        panel.add(confirmField);
        panel.add(confirmLabel);
        layout.putConstraint(SpringLayout.WEST, titleLabel,320, SpringLayout.WEST,panel);
        layout.putConstraint(SpringLayout.NORTH, titleLabel,50, SpringLayout.NORTH,panel );
        layout.putConstraint(SpringLayout.WEST,nameLabel,320,SpringLayout.WEST,panel);
        layout.putConstraint(SpringLayout.NORTH,nameLabel,60, SpringLayout.NORTH,titleLabel);
        layout.putConstraint(SpringLayout.WEST,nameField,320,SpringLayout.WEST,panel);
        layout.putConstraint(SpringLayout.NORTH,nameField,30,SpringLayout.NORTH,nameLabel);
        layout.putConstraint(SpringLayout.WEST,userLabel,320,SpringLayout.WEST,panel);
        layout.putConstraint(SpringLayout.NORTH,userLabel,40, SpringLayout.NORTH,nameField);
        layout.putConstraint(SpringLayout.WEST,userField,320,SpringLayout.WEST,panel);
        layout.putConstraint(SpringLayout.NORTH,userField,30,SpringLayout.NORTH,userLabel);
        layout.putConstraint(SpringLayout.WEST,passwordLabel,320,SpringLayout.WEST,panel);
        layout.putConstraint(SpringLayout.NORTH,passwordLabel,40, SpringLayout.NORTH,userField);
        layout.putConstraint(SpringLayout.WEST,passwordField,320,SpringLayout.WEST,panel);
        layout.putConstraint(SpringLayout.NORTH,passwordField,30,SpringLayout.NORTH,passwordLabel);
        layout.putConstraint(SpringLayout.WEST,confirmLabel,320,SpringLayout.WEST,panel);
        layout.putConstraint(SpringLayout.NORTH,confirmLabel,40, SpringLayout.NORTH,passwordField);
        layout.putConstraint(SpringLayout.WEST,confirmField,320,SpringLayout.WEST,panel);
        layout.putConstraint(SpringLayout.NORTH,confirmField,30,SpringLayout.NORTH,confirmLabel);
        layout.putConstraint(SpringLayout.WEST, loginBtn,360,SpringLayout.WEST,panel);
        layout.putConstraint(SpringLayout.NORTH,loginBtn,40,SpringLayout.NORTH,confirmField);
        layout.putConstraint(SpringLayout.WEST,signupBtn,400,SpringLayout.WEST,panel);
        layout.putConstraint(SpringLayout.NORTH,signupBtn,30,SpringLayout.NORTH,loginBtn);

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
    public void actionPerformed(ActionEvent e) {

    }
    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    public boolean confirmPassword(){
        if(String.copyValueOf(passwordField.getPassword()).equals(String.copyValueOf(confirmField.getPassword()))){
            return true;
        }
        return false;
    }
    public user getUser(){
        return  new user(nameField.getText().trim(),userField.getText().trim(),String.copyValueOf(passwordField.getPassword()));
    }
    public void addSignupListener(ActionListener listener){
        signupBtn.addActionListener(listener);
    }
    public  boolean checkEmpty(){
        if(nameField.getText().equals("") || passwordField.getPassword().equals("") || confirmField.getPassword().equals("")){
            return true;
        }
        return false;
    }
    public void addLoginListener(ActionListener listener){loginBtn.addActionListener(listener);}
}
