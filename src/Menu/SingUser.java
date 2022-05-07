package Menu;
import Checker.Checker;
import DataBase.PackageData;
import Main.Main;
import com.company.Visitor;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SingUser extends Container {
    public SingUser(){
        setSize(500, 500);
        setLayout(null);

        JLabel nameLabel = new JLabel("NAME:");
        nameLabel.setBounds(100, 70, 100, 30);
        add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setBounds(200, 70, 200, 30);
        add(nameField);

        JLabel surnameLabel = new JLabel("SURNAME:");
        surnameLabel.setBounds(100, 110, 100, 30);
        add(surnameLabel);

        JTextField surnameField = new JTextField();
        surnameField.setBounds(200, 110, 200, 30);
        add(surnameField);

        JLabel loginLabel = new JLabel("LOGIN:");
        loginLabel.setBounds(100, 150, 100, 30);
        add(loginLabel);

        JTextField loginField = new JTextField();
        loginField.setBounds(200, 150, 200, 30);
        add(loginField);

        JLabel label = new JLabel("The password must contain at least 1 uppercase letter,");
        JLabel label1 = new JLabel("1 lowercase letter, 1 digit, 1 special character (@,$,!, ^)");
        JLabel label2 = new JLabel("and a length greater than or equal to 8.");
        label.setBounds(95, 185, 310, 20);
        label1.setBounds(95, 200, 310, 20);
        label2.setBounds(95, 215, 310, 20);
        add(label);
        add(label1);
        add(label2);

        JLabel passwordLabel = new JLabel("PASSWORD:");
        passwordLabel.setBounds(100, 240, 100, 30);
        add(passwordLabel);

        JTextField passwordField = new JTextField();
        passwordField.setBounds(200, 240, 200, 30);
        Checker checker = new Checker();
        add(passwordField);

        JButton singButton = new JButton("Sign up");
        singButton.setBounds(100, 280, 140, 40);
        add(singButton);

        JButton backButton = new JButton("Back to menu");
        backButton.setBounds(250, 280, 150, 40);
        add(backButton);

        singButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if(checker.checkerPassword(passwordField.getText())){
                        Visitor new_visitor = new Visitor(null, loginField.getText(), passwordField.getText(), nameField.getText(), surnameField.getText());

                        PackageData packageData = new PackageData("ADD", new_visitor);
                        Main.connect(packageData);

                        JOptionPane.showMessageDialog(null, "Thank you for registering!!!");
                    }else{
                        JOptionPane.showMessageDialog(null, "You wrote something wrong!!!");
                    }
                }catch (Exception a){
                    a.printStackTrace();
                }

                nameField.setText(null);
                surnameField.setText(null);
                loginField.setText(null);
                passwordField.setText(null);
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.singUser.setVisible(false);
                Main.frame.menu.setVisible(true);
            }
        });
    }
}
