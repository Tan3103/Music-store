package Menu.user;
import DataBase.PackageData;
import Main.Main;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CatalogMenu extends Container {
    public static JTextArea textArea;
    public static int count;
    public CatalogMenu(){
        setSize(500, 500);
        setLayout(null);

        JButton guitarsButton = new JButton("Guitars");
        guitarsButton.setBounds(70, 50, 360, 25);
        add(guitarsButton);

        JButton keyboardButton = new JButton("Keyboard instruments");
        keyboardButton.setBounds(70, 80, 360, 25);
        add(keyboardButton);

        JButton percussionButton = new JButton("Percussion instruments");
        percussionButton.setBounds(70, 110, 360, 25);
        add(percussionButton);

        textArea = new JTextArea();
        textArea.setBounds(70, 145, 360, 170);
        add(textArea);
        textArea.setText(null);

        JLabel label = new JLabel("Enter the number of the item you want to buy");
        label.setBounds(70, 320, 270, 25);
        add(label);

        JTextField numberField = new JTextField();
        numberField.setBounds(350, 320, 80, 25);
        add(numberField);

        JButton backButton = new JButton("Back to menu");
        backButton.setBounds(255, 360, 175, 30);
        add(backButton);

        JButton buyProductButton = new JButton("Buy a product");
        buyProductButton.setBounds(70, 360, 175, 30);
        add(buyProductButton);

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

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.catalogMenu.setVisible(false);
                Main.frame.userMenu.setVisible(true);
            }
        });

        buyProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(numberField.getText() != null) {
                        PackageData pd3 = new PackageData("Get Count", Integer.parseInt(numberField.getText()));
                        Main.connect(pd3);
                        if(count > 0) {
                            PackageData pd = new PackageData("Buy Product", Integer.parseInt(numberField.getText()));
                            Main.connect(pd);
                            PackageData pd2 = new PackageData("Add Cart", LoginUser.visitor.getId(), Integer.parseInt(numberField.getText()));
                            Main.connect(pd2);

                            textArea.setText(null);
                            numberField.setText(null);
                        }else {
                            JOptionPane.showMessageDialog(null, "This product is missing!!!");
                            textArea.setText(null);
                            numberField.setText(null);
                        }
                    }
                }
                catch (Exception a){
                    a.printStackTrace();
                    textArea.setText("ERROR");
                }
            }
        });
    }
}
