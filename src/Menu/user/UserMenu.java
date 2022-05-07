package Menu.user;
import Main.MainFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserMenu extends Container {
    public UserMenu(){
        setSize(500, 500);
        setLayout(null);

        JButton catalogButton = new JButton("Product catalog");
        catalogButton.setBounds(100, 70, 300, 40);
        add(catalogButton);

        JButton findButton = new JButton("Find a musical instrument");
        findButton.setBounds(100, 120, 300, 40);
        add(findButton);

        JButton discountButton = new JButton("Discount products");
        discountButton.setBounds(100, 170, 300, 40);
        add(discountButton);

        JButton purchasedGoodsButton = new JButton("Purchased goods");
        purchasedGoodsButton.setBounds(100, 220, 300, 40);
        add(purchasedGoodsButton);

        JButton backButton = new JButton("Back to menu");
        backButton.setBounds(100, 270, 300, 40);
        add(backButton);

        catalogButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.userMenu.setVisible(false);
                MainFrame.catalogMenu.setVisible(true);
            }
        });

        findButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.userMenu.setVisible(false);
                MainFrame.findMenu.setVisible(true);
            }
        });

        discountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.userMenu.setVisible(false);
                MainFrame.discountMenu.setVisible(true);
            }
        });

        purchasedGoodsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.userMenu.setVisible(false);
                MainFrame.purchasedGoods.setVisible(true);
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.userMenu.setVisible(false);
                MainFrame.menu.setVisible(true);
            }
        });
    }
}
