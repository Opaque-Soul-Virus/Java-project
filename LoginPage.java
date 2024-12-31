package StudentTeacherRecordSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class LoginPage implements ActionListener {
    private JFrame frame = new JFrame("Login Page : ");
    private JButton loginButton = new JButton("Login");
    private JButton resetButton = new JButton("Reset");
    private JTextField userIDField = new JTextField();
    private JPasswordField userPasswordField = new JPasswordField();
    private JLabel userIDLabel = new JLabel("USER ID:");
    private JLabel userPasswordLabel = new JLabel("PASSWORD :");
    private JLabel messageLabel = new JLabel();
    private HashMap<String,String> logininfo = new HashMap<String,String>();

    public LoginPage(HashMap<String, String> logininfo) {
        this.logininfo = logininfo;

        userIDLabel.setBounds(50,100,75,25);
        userPasswordLabel.setBounds(50,150,75,25);

        messageLabel.setBounds(125,250,250,25);
        messageLabel.setFont(new Font(null,Font.ITALIC,20));

        userIDField.setBounds(130,100,200,25);
        userPasswordField.setBounds(130,150,200,25);

        loginButton.setBounds(130,200,90,30);
        loginButton.setFocusable(false);
        loginButton.addActionListener((this));
        resetButton.setBounds(240,200,90,30);
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);

        frame.add(userIDLabel);
        frame.add(userPasswordLabel);
        frame.add(messageLabel);
        frame.add(userIDField);
        frame.add(userPasswordField);
        frame.add(loginButton);
        frame.add(resetButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,450);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.getContentPane().setBackground(Color.CYAN);
        frame.setLocation(400,150);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==resetButton){
            userIDField.setText("");
            userPasswordField.setText("");
            JOptionPane.showMessageDialog(null,"Reset Records!!!");
        } else if (e.getSource()==loginButton) {
            String userID = userIDField.getText();
            String password = String.valueOf(userPasswordField.getPassword());

            if(logininfo.containsKey(userID)) {
                if (logininfo.get(userID).equals(password)) {
                    messageLabel.setForeground(Color.green);
                    messageLabel.setText("Login successful");
                    JOptionPane.showMessageDialog(null,"Login successful.");
                    frame.dispose();
                    StudentTeacherSelectionClass selectionClass = new StudentTeacherSelectionClass();
                }else {
                    messageLabel.setForeground(Color.red);
                    messageLabel.setText("Wrong Password!!");
                }
            }else {
                messageLabel.setForeground(Color.red);
                messageLabel.setText("username not found");
            }
        }
    }
}
