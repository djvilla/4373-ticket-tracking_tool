package com.gui;

import com.mock.Authentication;

import javax.swing.*;
import java.awt.*;

public class Login extends JFrame{
    private JPanel mainPanel;
    private JTextField userEdit;
    private JTextField passwordEdit;
    private JButton loginButton;

    public Login() {
        add(mainPanel);
        setTitle("Ticket Manager");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);

        loginButton.addActionListener(actionEvent -> {
            int Authenticate = Authentication.login(userEdit.getText(), passwordEdit.getText());
            //og
            if(Authenticate != -1){
                new MainWindow().setVisible(true);
                dispose();//end of og
            }
        });
    }

    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        SwingUtilities.invokeLater(() -> {
            new Login().setVisible(true);
        });
    }
}
