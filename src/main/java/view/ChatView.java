package view;

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


public class ChatView extends JFrame implements ActionListener {
    //panel-----
    private JLabel userLabel;
    private JLabel pictureLabel;
    private JLabel titleLabel;
    private String username;
    private JButton logoutBtn;

    private JScrollPane jScrollPaneOnlineTable;
    private JTable onlineTable;

    private String[] columnNames = new String[]{"ONLINE"};
    private Object data = new Object[][]{};

    //panel 1 ---
    JTextArea textArea;
    JScrollPane jScollTextPane;
    JTextField msgField;
    JButton sendBtn;
    JButton fileBtn;
    public ChatView(String name){
        this.username = name;
        InitComponents();
    }
    //sets the properties of the display
    private void InitComponents() {
        Border border = BorderFactory.createLineBorder(Color.LIGHT_GRAY);
        Border borderLog = BorderFactory.createLineBorder(Color.WHITE);
        userLabel = new JLabel(this.username + " ---------");
        userLabel.setForeground(new Color(120, 90, 40));
        userLabel.setFont(new Font("Verdana", Font.PLAIN, 15));
        titleLabel = new JLabel("---------");
        titleLabel.setForeground(new Color(120, 90, 40));
        titleLabel.setFont(new Font("Verdana", Font.PLAIN, 15));
        logoutBtn = new JButton("LOGOUT CHATTING");
        logoutBtn.setForeground(new Color(120, 90, 40));
        logoutBtn.setFont(new Font("Verdana", Font.PLAIN, 15));
        logoutBtn.setPreferredSize(new Dimension(180,50));
        logoutBtn.setBorder(borderLog);
        logoutBtn.setBackground(Color.LIGHT_GRAY);
        logoutBtn.addActionListener(this);
        // set panel 1 here
        try{
            BufferedImage myPicture = ImageIO.read(new File("src\\main\\java\\view\\penguin-icon.png"));
            pictureLabel = new JLabel(new ImageIcon(myPicture));


        }catch (IOException e){
            e.printStackTrace();
        }

        jScrollPaneOnlineTable = new JScrollPane();
        onlineTable = new JTable();

        onlineTable.setModel(new DefaultTableModel((Object[][]) data, columnNames));
        jScrollPaneOnlineTable.setViewportView(onlineTable);
        jScrollPaneOnlineTable.setPreferredSize(new Dimension(300, 250));

        SpringLayout layout = new SpringLayout();
        JPanel panel = new JPanel();
        panel.setSize(300,650);
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setLayout(layout);
        panel.add(pictureLabel);
        panel.add(titleLabel);
        panel.add(userLabel);
        panel.add(jScrollPaneOnlineTable);
        panel.add(logoutBtn);

        layout.putConstraint(SpringLayout.WEST,pictureLabel,30,SpringLayout.WEST,panel);
        layout.putConstraint(SpringLayout.WEST,titleLabel,20,SpringLayout.WEST,panel);
        layout.putConstraint(SpringLayout.NORTH,titleLabel,250,SpringLayout.NORTH,pictureLabel);
        layout.putConstraint(SpringLayout.WEST,userLabel,70,SpringLayout.WEST,titleLabel);
        layout.putConstraint(SpringLayout.NORTH,userLabel,250,SpringLayout.NORTH,pictureLabel);
        layout.putConstraint(SpringLayout.NORTH,jScrollPaneOnlineTable,50,SpringLayout.NORTH,userLabel);
        layout.putConstraint(SpringLayout.WEST,logoutBtn,60,SpringLayout.WEST,panel);
        layout.putConstraint(SpringLayout.NORTH,logoutBtn,258,SpringLayout.NORTH,jScrollPaneOnlineTable);
        // end panel 1
        //------------------------------------------------------
        //set panel 2 here
        msgField = new JTextField();
        msgField.setPreferredSize(new Dimension(530,40));
        msgField.setBorder(border);
        sendBtn = new JButton();
        sendBtn.setPreferredSize(new Dimension(70,40));
        sendBtn.setBorder(border);
        sendBtn.setBackground(Color.WHITE);

        sendBtn.addActionListener(this);
        Image image;
        Icon icon = new ImageIcon("src\\main\\java\\view\\icon-send.png");
        sendBtn.setIcon(icon);
        Icon icon1 = new ImageIcon("src\\main\\java\\view\\icons-file.png");
        fileBtn = new JButton();
        fileBtn.setPreferredSize(new Dimension(70,40));
        fileBtn.setIcon(icon1);
        fileBtn.setBorder(border);
        fileBtn.setBackground(Color.WHITE);
        textArea = new JTextArea(33,70);
        textArea.setEditable(false);
        jScollTextPane = new JScrollPane(textArea);
        SpringLayout layout1 = new SpringLayout();
        JPanel panel1 = new JPanel();
        panel1.setSize(724,650);
        panel1.setBackground(Color.WHITE);

        panel1.setLayout(layout1);
        panel1.add(msgField);
        panel1.add(sendBtn);
        panel1.add(fileBtn);
        panel1.add(jScollTextPane);

        layout1.putConstraint(SpringLayout.WEST,msgField,305,SpringLayout.WEST,panel);
        layout1.putConstraint(SpringLayout.NORTH,msgField,560,SpringLayout.NORTH,panel);
        layout1.putConstraint(SpringLayout.WEST,sendBtn,540,SpringLayout.WEST,msgField);
        layout1.putConstraint(SpringLayout.NORTH,sendBtn,560,SpringLayout.NORTH,panel);
        layout1.putConstraint(SpringLayout.WEST,fileBtn,80,SpringLayout.WEST,sendBtn);
        layout1.putConstraint(SpringLayout.NORTH,fileBtn,560,SpringLayout.NORTH,panel);
        layout1.putConstraint(SpringLayout.WEST,jScollTextPane,305,SpringLayout.WEST,panel);
        layout1.putConstraint(SpringLayout.NORTH,jScollTextPane,5,SpringLayout.NORTH,panel);
        this.add(panel);
        this.add(panel1);

        this.pack();
        this.setTitle("Chat application - log in");
        this.setSize(1024,650);
        this.setResizable(false);
    }
    public String getName(){
        return this.username;
    }

    public void setTextArea(String text){
        textArea.setText(text);
    }
    public String getTextArea(){
        return textArea.getText().trim();
    }
    public void setTable(Object[][] online){
        onlineTable.setModel(new DefaultTableModel(online, columnNames));
    }

    public void actionPerformed(ActionEvent e) {

    }
    public void addSendListener(ActionListener listener){
        sendBtn.addActionListener(listener);
    }
    public String getNameOnline(){
        return onlineTable.getValueAt(onlineTable.getSelectedRow(),onlineTable.getSelectedColumn()).toString();
    }
    public String getMsg(){
        return msgField.getText().trim();
    }
    public void clearMsg(){
        msgField.setText("");
    }

    public void addLogoutListener(ActionListener listener){
        logoutBtn.addActionListener(listener);
    }
}