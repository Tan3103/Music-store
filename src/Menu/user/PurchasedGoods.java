package Menu.user;
import DataBase.PackageData;
import Main.Main;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PurchasedGoods extends Container {
    public static JTextArea textArea;
    public PurchasedGoods(){
        setSize(500, 500);
        setLayout(null);

        JButton listButton = new JButton("LIST");
        listButton.setBounds(50, 50, 400, 30);
        add(listButton);

        textArea = new JTextArea();
        textArea.setBounds(50, 90, 400, 240);
        add(textArea);

        JButton backButton = new JButton("Back to menu");
        backButton.setBounds(50, 340, 400, 30);
        add(backButton);

        listButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText(null);

                PackageData pd = new PackageData("LIST CART", LoginUser.visitor.getId());
                Main.connect(pd);
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.purchasedGoods.setVisible(false);
                Main.frame.userMenu.setVisible(true);
            }
        });
    }
}
