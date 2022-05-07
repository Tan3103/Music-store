package Main;
import Menu.*;
import Menu.admin.*;
import Menu.user.*;
import javax.swing.*;

public class MainFrame extends JFrame {
    public static MainMenu menu;
    public static LoginUser loginUser;
    public static SingUser singUser;
    public static UserMenu userMenu;
    public static AdminMenu adminMenu;
    public static CatalogMenu catalogMenu;
    public static FindMenu findMenu;
    public static DiscountMenu discountMenu;
    public static DeleteUser deleteUser;
    public static AddProduct addProduct;
    public static DeleteProduct deleteProduct;
    public static AddNewGuitar addNewGuitar;
    public static AddNewKeyboard addNewKeyboard;
    public static AddNewPercussion addNewPercussion;
    public static PurchasedGoods purchasedGoods;

    public MainFrame(){
        setSize(500, 500);
        setTitle("Musical Instrument Store");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        menu = new MainMenu();
        menu.setLocation(0, 0);
        add(menu);

        loginUser = new LoginUser();
        loginUser.setLocation(0, 0);
        loginUser.setVisible(false);
        add(loginUser);

        singUser = new SingUser();
        singUser.setLocation(0, 0);
        singUser.setVisible(false);
        add(singUser);

        userMenu = new UserMenu();
        userMenu.setLocation(0,0);
        userMenu.setVisible(false);
        add(userMenu);

        adminMenu = new AdminMenu();
        adminMenu.setLocation(0, 0);
        adminMenu.setVisible(false);
        add(adminMenu);

        catalogMenu = new CatalogMenu();
        catalogMenu.setLocation(0, 0);
        catalogMenu.setVisible(false);
        add(catalogMenu);

        findMenu = new FindMenu();
        findMenu.setLocation(0, 0);
        findMenu.setVisible(false);
        add(findMenu);

        discountMenu = new DiscountMenu();
        discountMenu.setLocation(0, 0);
        discountMenu.setVisible(false);
        add(discountMenu);

        deleteUser = new DeleteUser();
        deleteUser.setLocation(0, 0);
        deleteUser.setVisible(false);
        add(deleteUser);

        addProduct = new AddProduct();
        addProduct.setLocation(0, 0);
        addProduct.setVisible(false);
        add(addProduct);

        deleteProduct = new DeleteProduct();
        deleteProduct.setLocation(0, 0);
        deleteProduct.setVisible(false);
        add(deleteProduct);

        addNewGuitar = new AddNewGuitar();
        addNewGuitar.setLocation(0, 0);
        addNewGuitar.setVisible(false);
        add(addNewGuitar);

        addNewKeyboard = new AddNewKeyboard();
        addNewKeyboard.setLocation(0, 0);
        addNewKeyboard.setVisible(false);
        add(addNewKeyboard);

        addNewPercussion = new AddNewPercussion();
        addNewPercussion.setLocation(0, 0);
        addNewPercussion.setVisible(false);
        add(addNewPercussion);

        purchasedGoods = new PurchasedGoods();
        purchasedGoods.setLocation(0,0);
        purchasedGoods.setVisible(false);
        add(purchasedGoods);
    }
}