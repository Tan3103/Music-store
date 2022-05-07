package Menu.user;
import DataBase.PackageData;
import Main.Main;
import Main.MainFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FindMenu extends Container {
    public static  JTextArea textArea;
    public static int count;
    public FindMenu(){
        setSize(500, 500);
        setLayout(null);

        JLabel typeLabel = new JLabel("TYPE PRODUCT:");
        typeLabel.setBounds(70, 50, 120, 25);
        add(typeLabel);

        JTextField typeField = new JTextField();
        typeField.setBounds(190, 50, 240, 25);
        add(typeField);

        JLabel find1Label = new JLabel("FIND:");
        find1Label.setBounds(70, 80, 40, 25);
        add(find1Label);

        JButton find1GuitarButton = new JButton("Guitar");
        find1GuitarButton.setBounds(120, 80, 100, 25);
        add(find1GuitarButton);

        JButton find1KeyboardButton = new JButton("Keyboard");
        find1KeyboardButton.setBounds(225, 80, 100, 25);
        add(find1KeyboardButton);

        JButton find1PercussionButton = new JButton("Percussion");
        find1PercussionButton.setBounds(330, 80, 100, 25);
        add(find1PercussionButton);

        //////////////////////////////////////////////////////////////

        JLabel nameProductLabel = new JLabel("NAME PRODUCT:");
        nameProductLabel.setBounds(70, 125, 120, 25);
        add(nameProductLabel);

        JTextField nameProductField = new JTextField();
        nameProductField.setBounds(190, 125, 240, 25);
        add(nameProductField);

        JLabel findLabel = new JLabel("FIND:");
        findLabel.setBounds(70, 155, 50, 25);
        add(findLabel);

        JButton find2GuitarButton = new JButton("Guitar");
        find2GuitarButton.setBounds(120, 155, 100, 25);
        add(find2GuitarButton);

        JButton find2KeyboardButton = new JButton("Keyboard");
        find2KeyboardButton.setBounds(225, 155, 100, 25);
        add(find2KeyboardButton);

        JButton find2PercussionButton = new JButton("Percussion");
        find2PercussionButton.setBounds(330, 155, 100, 25);
        add(find2PercussionButton);


        ///////////////////////////////////////////

        textArea = new JTextArea();
        textArea.setBounds(70, 190, 360, 140);
        add(textArea);

        JLabel label = new JLabel("Enter the number of the item you want to buy");
        label.setBounds(70, 340, 270, 25);
        add(label);

        JTextField numberField = new JTextField();
        numberField.setBounds(350, 340, 80, 25);
        add(numberField);

        JButton backButton = new JButton("Back to menu");
        backButton.setBounds(255, 370, 175, 25);
        add(backButton);

        JButton buyProductButton = new JButton("Buy product");
        buyProductButton.setBounds(70, 370, 175, 25);
        add(buyProductButton);

        find1GuitarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText(null);

                PackageData pd = new PackageData("Find Type Guitar", typeField.getText());
                Main.connect(pd);
            }
        });

        find1KeyboardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText(null);

                PackageData pd = new PackageData("Find Type Keyboard", typeField.getText());
                Main.connect(pd);
            }
        });

        find1PercussionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText(null);

                PackageData pd = new PackageData("Find Type Percussion", typeField.getText());
                Main.connect(pd);
            }
        });

        find2GuitarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText(null);

                PackageData pd = new PackageData("Find Guitar", nameProductField.getText());
                Main.connect(pd);
            }
        });

        find2KeyboardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText(null);

                PackageData pd = new PackageData("Find Keyboard", nameProductField.getText());
                Main.connect(pd);
            }
        });

        find2PercussionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText(null);

                PackageData pd = new PackageData("Find Percussion", nameProductField.getText());
                Main.connect(pd);
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
                            typeField.setText(null);
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

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.findMenu.setVisible(false);
                MainFrame.userMenu.setVisible(true);
            }
        });
    }
}
