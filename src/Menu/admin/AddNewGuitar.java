package Menu.admin;
import DataBase.PackageData;
import com.company.Guitar;
import Main.Main;
import Main.MainFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddNewGuitar extends Container {
    public AddNewGuitar(){
        setSize(500, 500);
        setLayout(null);

        String[] typeGuitar = {"Electronic", "Acoustic", "Bass", "Ukulele"};

        JLabel Label = new JLabel("GUITAR");
        Label.setBounds(220, 40, 125, 25);
        Label.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(Label);

        JLabel typeLabel = new JLabel("Type:");
        typeLabel.setBounds(75, 75, 125, 25);
        add(typeLabel);

        JComboBox typeField = new JComboBox(typeGuitar);
        typeField.setBounds(225, 75, 200, 25);
        add(typeField);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(75, 110, 125, 25);
        add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setBounds(225, 110, 200, 25);
        add(nameField);

        JLabel numberStringLabel = new JLabel("Number of strings:");
        numberStringLabel.setBounds(75, 145, 125, 25);
        add(numberStringLabel);

        JTextField numberStringField = new JTextField();
        numberStringField.setBounds(225, 145, 200, 25);
        add(numberStringField);

        JLabel fretsLabel = new JLabel("Number of frets:");
        fretsLabel.setBounds(75, 180, 125, 25);
        add(fretsLabel);

        JTextField fretsField = new JTextField();
        fretsField.setBounds(225, 180, 200, 25);
        add(fretsField);

        JLabel costLabel = new JLabel("Product price:");
        costLabel.setBounds(75, 215, 125, 25);
        add(costLabel);

        JTextField costField = new JTextField();
        costField.setBounds(225, 215, 200, 25);
        add(costField);

        JLabel countLabel = new JLabel("Number of products:");
        countLabel.setBounds(75, 250, 125, 25);
        add(countLabel);

        JTextField countField = new JTextField();
        countField.setBounds(225, 250, 200, 25);
        add(countField);

        JLabel discountLabel = new JLabel("Discount:");
        discountLabel.setBounds(75, 285, 125, 25);
        add(discountLabel);

        JTextField discountField = new JTextField();
        discountField.setBounds(225, 285, 200, 25);
        add(discountField);

        JButton addButton = new JButton("Add product");
        addButton.setBounds(75, 320, 170, 30);
        add(addButton);

        JButton backButton = new JButton("Back to menu");
        backButton.setBounds(255, 320, 170, 30);
        add(backButton);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.addNewGuitar.setVisible(false);
                MainFrame.addProduct.setVisible(true);
            }
        });

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Guitar newProduct = new Guitar(null, (String) typeField.getSelectedItem(), nameField.getText(),
                            Integer.parseInt(costField.getText()), Integer.parseInt(countField.getText()),
                            Integer.parseInt(discountField.getText()), Integer.parseInt(numberStringField.getText()), Integer.parseInt(fretsField.getText()));

                    PackageData packageData = new PackageData("ADDGuitar", newProduct);
                    Main.connect(packageData);

                    nameField.setText(null);
                    costField.setText(null);
                    countField.setText(null);
                    discountField.setText(null);
                    numberStringField.setText(null);
                    fretsField.setText(null);
                } catch (Exception a) {
                    a.printStackTrace();
                }
            }
        });
    }
}
