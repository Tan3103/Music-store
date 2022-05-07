package Main;
import DataBase.PackageData;
import Menu.admin.AddProduct;
import Menu.admin.DeleteProduct;
import Menu.admin.DeleteUser;
import Menu.user.*;
import com.company.*;
import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class Main {
    public static MainFrame frame;
    public static void connect(PackageData pd){
        try{
            Socket socket = new Socket("127.0.0.1", 4999);
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());

            if(pd.getOperationType().equals("ADD") || pd.getOperationType().equals("ADDGuitar") || pd.getOperationType().equals("ADDKeyboard") ||
                    pd.getOperationType().equals("ADDPercussion") || pd.getOperationType().equals("Add Cart") ||
                    pd.getOperationType().equals("Delete Visitor") || pd.getOperationType().equals("Delete Product") ||
                    pd.getOperationType().equals("Buy Product")){
                outputStream.writeObject(pd);

            }///////////////////////////////////////////////////////////////////////////////////////////////////////////
            else if(pd.getOperationType().equals("LIST")){
                outputStream.writeObject(pd);
                PackageData infoFromServer = (PackageData)inputStream.readObject();
                ArrayList<Visitor> arrayListFromServer = infoFromServer.getVisitors();
                String s = "";

                for(int i=0; i< arrayListFromServer.size(); i++){
                    s += arrayListFromServer.get(i).info()+ "\n";
                }
                DeleteUser.textArea.append(s);
            }
            else if(pd.getOperationType().equals("LIST Guitar")){
                outputStream.writeObject(pd);
                PackageData infoFromServer = (PackageData)inputStream.readObject();
                ArrayList<Guitar> arrayListFromServer = infoFromServer.getGuitars();
                String s = "";

                for(int i=0; i< arrayListFromServer.size(); i++){
                    s += arrayListFromServer.get(i).info()+ "\n";
                }
                AddProduct.textArea.append(s);
                DeleteProduct.textArea.append(s);
                CatalogMenu.textArea.append(s);
            }
            else if(pd.getOperationType().equals("LIST Keyboard")){
                outputStream.writeObject(pd);
                PackageData infoFromServer = (PackageData)inputStream.readObject();
                ArrayList<KeyboardInstruments> arrayListFromServer = infoFromServer.getKeyboardInstruments();
                String s1 = "";

                for(int i=0; i< arrayListFromServer.size(); i++){
                    s1 += arrayListFromServer.get(i).info()+ "\n";
                }
                AddProduct.textArea.append(s1);
                DeleteProduct.textArea.append(s1);
                CatalogMenu.textArea.append(s1);
            }
            else if(pd.getOperationType().equals("LIST Percussion")){
                outputStream.writeObject(pd);
                PackageData infoFromServer = (PackageData)inputStream.readObject();
                ArrayList<PercussionInstruments> arrayListFromServer = infoFromServer.getPercussionInstruments();
                String s = "";

                for(int i=0; i< arrayListFromServer.size(); i++){
                    s += arrayListFromServer.get(i).info()+ "\n";
                }
                AddProduct.textArea.append(s);
                DeleteProduct.textArea.append(s);
                CatalogMenu.textArea.append(s);

            }///////////////////////////////////////////////////////////////////////////////////////////////////////////
            else if(pd.getOperationType().equals("Find Guitar")){
                 outputStream.writeObject(pd);
                 PackageData infoFromServer = (PackageData)inputStream.readObject();
                 String guitar = infoFromServer.getFind();

                FindMenu.textArea.append(guitar);
            }
            else if(pd.getOperationType().equals("Find Keyboard")){
                outputStream.writeObject(pd);
                PackageData infoFromServer = (PackageData)inputStream.readObject();
                String guitar = infoFromServer.getFind();

                FindMenu.textArea.append(guitar);
            }
            else if(pd.getOperationType().equals("Find Percussion")){
                outputStream.writeObject(pd);
                PackageData infoFromServer = (PackageData)inputStream.readObject();
                String guitar = infoFromServer.getFind();

                FindMenu.textArea.append(guitar);
            }
            else if(pd.getOperationType().equals("Find Type Guitar")){
                outputStream.writeObject(pd);
                PackageData infoFromServer = (PackageData)inputStream.readObject();
                String guitar = infoFromServer.getFind();

                FindMenu.textArea.append(guitar);
            }
            else if(pd.getOperationType().equals("Find Type Keyboard")){
                outputStream.writeObject(pd);
                PackageData infoFromServer = (PackageData)inputStream.readObject();
                String guitar = infoFromServer.getFind();

                FindMenu.textArea.append(guitar);
            }
            else if(pd.getOperationType().equals("Find Type Percussion")){
                outputStream.writeObject(pd);
                PackageData infoFromServer = (PackageData)inputStream.readObject();
                String guitar = infoFromServer.getFind();

                FindMenu.textArea.append(guitar);

            }///////////////////////////////////////////////////////////////////////////////////////////////////////////
            else if(pd.getOperationType().equals("LIST Discount")){
                outputStream.writeObject(pd);
                PackageData infoFromServer = (PackageData)inputStream.readObject();
                ArrayList<Product> arrayListFromServer = infoFromServer.getProducts();
                String s = "";

                for(int i=0; i< arrayListFromServer.size(); i++){
                    s += arrayListFromServer.get(i).countDiscount()+ "\n";
                }
                DiscountMenu.textArea.append(s);
            }
            else if(pd.getOperationType().equals("LIST CART")){
                outputStream.writeObject(pd);
                PackageData infoFromServer = (PackageData)inputStream.readObject();
                ArrayList<Product> arrayListFromServer = infoFromServer.getProducts();
                String s = "";

                for(int i=0; i< arrayListFromServer.size(); i++){
                    s += arrayListFromServer.get(i).listInfo()+ "\n";
                }
                PurchasedGoods.textArea.append(s);
            }
            else if(pd.getOperationType().equals("Check Login")){
                outputStream.writeObject(pd);
                PackageData infoFromServer = (PackageData)inputStream.readObject();
                Boolean checkLogin = infoFromServer.getLogin();

                LoginUser.checkLogin = checkLogin;
            }
            else if(pd.getOperationType().equals("Get Visitor")){
                outputStream.writeObject(pd);

                PackageData infoFromServer = (PackageData)inputStream.readObject();
                Visitor visitor = infoFromServer.getVisitor();
                LoginUser.visitor = visitor;
            }
            else if(pd.getOperationType().equals("Get Count")){
                outputStream.writeObject(pd);

                PackageData infoFromServer = (PackageData)inputStream.readObject();
                int count = infoFromServer.getId();
                CatalogMenu.count = count;
                DiscountMenu.count = count;
                FindMenu.count = count;
            }
            inputStream.close();
            outputStream.close();
            socket.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
        frame.setVisible(true);
    }
}