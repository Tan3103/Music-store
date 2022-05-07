package Menu.user;
import DataBase.PackageData;
import Main.Main;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DiscountMenu extends Container {
    public static JTextArea textArea;
    public static int count;
    public DiscountMenu(){
        setSize(500, 500);
        setLayout(null);

        JButton listButton = new JButton("LIST");
        listButton.setBounds(50, 50, 400, 25);
        add(listButton);

        textArea = new JTextArea();
        textArea.setBounds(50, 90, 400, 200);
        add(textArea);

        JLabel label = new JLabel("Enter the number of the item you want to buy");
        label.setBounds(50, 300, 270, 25);
        add(label);

        JTextField numberField = new JTextField();
        numberField.setBounds(350, 300, 80, 25);
        add(numberField);

        JButton backButton = new JButton("Back to menu");
        backButton.setBounds(260, 340, 190, 30);
        add(backButton);

        JButton buyButton = new JButton("Buy a product");
        buyButton.setBounds(50, 340, 190, 30);
        add(buyButton);

        listButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText(null);

                PackageData pd = new PackageData("LIST Discount");
                Main.connect(pd);
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.discountMenu.setVisible(false);
                Main.frame.userMenu.setVisible(true);
            }
        });

        buyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
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
                }catch (Exception a) {
                    a.printStackTrace();
                }
            }
        });
    }
}
