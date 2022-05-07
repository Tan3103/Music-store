package DataBase;
import com.company.*;
import java.sql.*;
import java.util.ArrayList;

public class DBManager {
    public static Connection connection = null;

    public void connect(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/tannurdb?useUnicode=true&serverTimezone=UTC", "root", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addGuitar(Guitar guitar) {
            try{
            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO product (id, type, name, price, count, discount, string, frets, type_id) " +
                    "VALUES (NULL, ?, ?, ?, ?, ?, ?, ?, ?)");

            statement.setString(1, guitar.getType());
            statement.setString(2, guitar.getName());
            statement.setInt(3, guitar.getCost());
            statement.setInt(4, guitar.getCount());
            statement.setInt(5, guitar.getDiscount());
            statement.setInt(6, guitar.getNumberStrings());
            statement.setInt(7, guitar.getFrets());
            statement.setInt(8, 1);

            statement.executeUpdate();

            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void addKeyboard(KeyboardInstruments keyboardInstruments) {
        try{
            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO product (id, type, name, price, count, discount, keyss, type_id) " +
                    "VALUES (NULL, ?, ?, ?, ?, ?, ?, ?)");

            statement.setString(1, keyboardInstruments.getType());
            statement.setString(2, keyboardInstruments.getName());
            statement.setInt(3, keyboardInstruments.getCost());
            statement.setInt(4, keyboardInstruments.getCount());
            statement.setInt(5, keyboardInstruments.getDiscount());
            statement.setInt(6, keyboardInstruments.getNumberKeys());
            statement.setInt(7, 2);

            statement.executeUpdate();
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void addPercussion(PercussionInstruments percussionInstruments) {
        try{
            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO product (id, type, name, price, count, discount, diameter, type_id) " +
                    "VALUES (NULL, ?, ?, ?, ?, ?, ?, ?)");

            statement.setString(1, percussionInstruments.getType());
            statement.setString(2, percussionInstruments.getName());
            statement.setInt(3, percussionInstruments.getCost());
            statement.setInt(4, percussionInstruments.getCount());
            statement.setInt(5, percussionInstruments.getDiscount());
            statement.setString(6, percussionInstruments.getDiameter());
            statement.setInt(7, 3);

            statement.executeUpdate();
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void addVisitor(Visitor visitor) {
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO visitor (id, login, password, name, surname) " +
                    "VALUES (NULL, ?, ?, ?, ?)");
            statement.setString(1, visitor.getLogin());
            statement.setString(2, visitor.getPassword());
            statement.setString(3, visitor.getName());
            statement.setString(4, visitor.getSurname());
            statement.executeUpdate();

            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //////////////////////////////////////////////////////

    public ArrayList<Visitor> getAllVisitor(){
        ArrayList<Visitor> visitorList = new ArrayList<>();
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM visitor");
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                Integer id = resultSet.getInt("id");
                String login = resultSet.getString("login");
                String password = resultSet.getString("password");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                visitorList.add(new Visitor(id, login, password, name, surname));
            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return visitorList;
    }

    public ArrayList<Guitar> getAllGuitar(){
        ArrayList<Guitar> guitarsList = new ArrayList<>();
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM product WHERE type_id = 1");
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                Integer id = resultSet.getInt("id");
                String type = resultSet.getString("type");
                String name = resultSet.getString("name");
                int price = resultSet.getInt("price");
                int count = resultSet.getInt("count");
                int discount = resultSet.getInt("discount");
                int strings = resultSet.getInt("string");
                int frets = resultSet.getInt("frets");

                guitarsList.add(new Guitar(id, type, name, price, count, discount, strings, frets));
            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return guitarsList;
    }

    public ArrayList<KeyboardInstruments> getAllKeyboard(){
        ArrayList<KeyboardInstruments> keyboardList = new ArrayList<>();
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM product WHERE type_id = 2");
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                Integer id = resultSet.getInt("id");
                String type = resultSet.getString("type");
                String name = resultSet.getString("name");
                int price = resultSet.getInt("price");
                int count = resultSet.getInt("count");
                int discount = resultSet.getInt("discount");
                int keyss = resultSet.getInt("keyss");

                keyboardList.add(new KeyboardInstruments(id, type, name, price, count, discount,keyss));
            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return keyboardList;
    }

    public ArrayList<PercussionInstruments> getAllPercussion(){
        ArrayList<PercussionInstruments> percussionList = new ArrayList<>();
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM product WHERE type_id = 3");
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                Integer id = resultSet.getInt("id");
                String type = resultSet.getString("type");
                String name = resultSet.getString("name");
                int price = resultSet.getInt("price");
                int count = resultSet.getInt("count");
                int discount = resultSet.getInt("discount");
                String diameter = resultSet.getString("diameter");

                percussionList.add(new PercussionInstruments(id,  type, name, price, count, discount, diameter));
            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return percussionList;
    }

    //////////////////////////////////////////////////////

    public void deleteVisitors(Integer id){
        try{
            PreparedStatement statement = connection.prepareStatement("" + "DELETE FROM visitor WHERE id = ?");
            statement.setInt(1, id);
            statement.executeUpdate();
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void deleteProduct(Integer id){
        try{
            PreparedStatement statement = connection.prepareStatement("" + "DELETE FROM product WHERE id = ?");
            statement.setInt(1, id);
            statement.executeUpdate();
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //////////////////////////////////////////////////////

    public void updateProduct(Integer id) {
        try{
            PreparedStatement statement = connection.prepareStatement("" + "UPDATE product SET count=count-1 WHERE id=?");

            statement.setInt(1, id);
            statement.executeUpdate();
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //////////////////////////////////////////////////////

    public String findGuitar(String findName){
        String s = "";
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM product WHERE type_id = 1 AND name = '" + findName + "'");
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String type = resultSet.getString("type");
                String name = resultSet.getString("name");
                int price = resultSet.getInt("price");
                int count = resultSet.getInt("count");
                int discount = resultSet.getInt("discount");
                int strings = resultSet.getInt("strings");
                int frets = resultSet.getInt("frets");

                Guitar find = new Guitar(id, type, name, price, count, discount, strings, frets);
                s = find.info();
            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return s;
    }

    public String findKeyboard(String findName){
        String s = "";
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM product WHERE type_id = 2 AND name = '" + findName + "'");
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String type = resultSet.getString("type");
                String name = resultSet.getString("name");
                int price = resultSet.getInt("price");
                int count = resultSet.getInt("count");
                int discount = resultSet.getInt("discount");
                int keyss = resultSet.getInt("keyss");

                KeyboardInstruments find = new KeyboardInstruments(id, type, name, price, count, discount, keyss);
                s = find.info();
            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return s;
    }

    public String findPercussion(String findName){
        String s = "";
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM product WHERE type_id = 3 AND name = '" + findName + "'");
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String type = resultSet.getString("type");
                String name = resultSet.getString("name");
                int price = resultSet.getInt("price");
                int count = resultSet.getInt("count");
                int discount = resultSet.getInt("discount");
                String diameter = resultSet.getString("diameter");

                PercussionInstruments find = new PercussionInstruments(id, type, name, price, count, discount, diameter);
                s = find.info();
            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return s;
    }

    public String findTypeGuitar(String findType){
        String s = "";
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM product WHERE type_id = 1 AND type = '" + findType + "'");
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String type = resultSet.getString("type");
                String name = resultSet.getString("name");
                int price = resultSet.getInt("price");
                int count = resultSet.getInt("count");
                int discount = resultSet.getInt("discount");
                int strings = resultSet.getInt("strings");
                int frets = resultSet.getInt("frets");

                Guitar find = new Guitar(id, type, name, price, count, discount, strings, frets);
                s = find.info();
            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return s;
    }

    public String findTypeKeyboard(String findType){
        String s = "";
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM product WHERE type_id = 2 AND type = '" + findType + "'");
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String type = resultSet.getString("type");
                String name = resultSet.getString("name");
                int price = resultSet.getInt("price");
                int count = resultSet.getInt("count");
                int discount = resultSet.getInt("discount");
                int keyss = resultSet.getInt("keyss");

                KeyboardInstruments find = new KeyboardInstruments(id, type, name, price, count, discount, keyss);
                s = find.info();
            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return s;
    }

    public String findTypePercussion(String findType){
        String s = "";
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM product WHERE type_id = 3 " +
                    "AND type = '" + findType + "'");
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String type = resultSet.getString("type");
                String name = resultSet.getString("name");
                int price = resultSet.getInt("price");
                int count = resultSet.getInt("count");
                int discount = resultSet.getInt("discount");
                String diameter = resultSet.getString("diameter");

                PercussionInstruments find = new PercussionInstruments(id, type, name, price, count, discount, diameter);
                s = find.info();
            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return s;
    }

    //////////////////////////////////////////////////////

    public ArrayList<Product> getAllDiscount(){
        ArrayList<Product> discountList = new ArrayList<>();
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM product");
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                Integer id = resultSet.getInt("id");
                String type = resultSet.getString("type");
                String name = resultSet.getString("name");
                int price = resultSet.getInt("price");
                int count = resultSet.getInt("count");
                int discount = resultSet.getInt("discount");

                discountList.add(new Guitar(id, type, name, price, count, discount));
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return discountList;
    }

    public void addBasket(Integer visitor_id, Integer product_id) {
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO cartt (id, visitor_id, product_id) " +
                    "VALUES (NULL, ?, ?)");
            statement.setInt(1,visitor_id);
            statement.setInt(2, product_id);

            statement.executeUpdate();
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public ArrayList<Product> getAllCart(Integer idka){
        ArrayList<Product> productList = new ArrayList<>();
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM cartt WHERE visitor_id = '" + idka + "'");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int name = resultSet.getInt("product_id");
                productList.add(getProduct(name));
            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return productList;
    }

    //////////////////////////////////////////////////////

    public Visitor getVisitor(String fname){
        Visitor visitor = new Visitor();
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM visitor WHERE login = '" + fname + "'");
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                Integer id = resultSet.getInt("id");
                String login = resultSet.getString("login");
                String password = resultSet.getString("password");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                visitor = new Visitor(id, login, password, name, surname);
            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return visitor;
    }

    public Product getProduct(Integer idka){
        Product product = new Guitar();
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM product WHERE id = '" + idka + "'");
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                Integer id = resultSet.getInt("id");
                String type = resultSet.getString("type");
                String name = resultSet.getString("name");
                int price = resultSet.getInt("price");
                int count = resultSet.getInt("count");
                int discount = resultSet.getInt("discount");
                product = new Guitar(id, type, name, price, count, discount);
            }

            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return product;
    }

    public Boolean checkLogin(String login, String password){
        Boolean check = false;
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM visitor WHERE login = '" + login + "' " +
                    "AND password = '" + password + "'");
            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){
                check = true;
            }else check = false;

            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return check;
    }

    public int getCountProduct(Integer idka){
        int count = 0;
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM product WHERE id = '" + idka + "'");
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                count = resultSet.getInt("count");
            }

            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return count;
    }
}