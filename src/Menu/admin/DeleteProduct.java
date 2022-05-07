package Menu.admin;
import DataBase.PackageData;
import Main.Main;
import DataBase.DBManager;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Integer.parseInt;

public class DeleteProduct extends Container {
    public static JTextArea textArea;
    public DeleteProduct(){
        setSize(500, 500);
        setLayout(null);

        JButton guitarsButton = new JButton("List of Guitars");
        guitarsButton.setBounds(70, 40, 360, 25);
        add(guitarsButton);

        JButton keyboardButton = new JButton("List of Keyboard instruments");
        keyboardButton.setBounds(70, 70, 360, 25);
        add(keyboardButton);

        JButton percussionButton = new JButton("List of Percussion instruments");
        percussionButton.setBounds(70, 100, 360, 25);
        add(percussionButton);

        textArea = new JTextArea();
        textArea.setBounds(70, 130, 360, 200);
        add(textArea);

        JLabel label = new JLabel("Enter the number of the item you want to delete:");
        label.setBounds(70, 340, 280, 25);
        add(label);

        JTextField numberField = new JTextField();
        numberField.setBounds(360, 340, 70, 25);
        add(numberField);

        JButton deleteProductButton = new JButton("Delete Product");
        deleteProductButton.setBounds(70, 375, 175, 25);
        add(deleteProductButton);

        JButton backButton = new JButton("Back to menu");
        backButton.setBounds(255, 375, 175, 25);
        add(backButton);

        guitarsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText(null);
                PackageData pd = new PackageData("LIST Guitar");
                Main.connect(pd);
            }
        });

        keyboardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText(null);
                PackageData pd = new PackageData("LIST Keyboard");
                Main.connect(pd);
            }
        });

        percussionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText(null);
                PackageData pd = new PackageData("LIST Percussion");
                Main.connect(pd);
            }
        });

        deleteProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PackageData pd = new PackageData("Delete Product", Integer.parseInt((numberField.getText())));
                Main.connect(pd);

                numberField.setText(null);
                textArea.setText(null);
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.deleteProduct.setVisible(false);
                Main.frame.adminMenu.setVisible(true);
            }
        });
    }
}

