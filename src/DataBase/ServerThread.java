package DataBase;
import com.company.*;
import java.net.Socket;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ServerThread extends Thread  {
    private Socket socket;
    public ServerThread(Socket socket){
        this.socket = socket;
    }

    public void run(){
        try{
            DBManager manager = new DBManager();
            manager.connect();

            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());

            PackageData packageData = null;

            while((packageData = ((PackageData)inputStream.readObject())) != null){
                if(packageData.getOperationType().equals("ADD")){
                    Visitor visitor = packageData.getVisitor();
                    manager.addVisitor(visitor);
                    break;
                }else if(packageData.getOperationType().equals("ADDGuitar")){
                    Guitar guitar = packageData.getGuitar();
                    manager.addGuitar(guitar);
                    break;
                }else if(packageData.getOperationType().equals("ADDKeyboard")){
                    KeyboardInstruments keyboardInstruments = packageData.getKeyboardInstrument();
                    manager.addKeyboard(keyboardInstruments);
                    break;
                }else if(packageData.getOperationType().equals("ADDPercussion")){
                    PercussionInstruments percussionInstruments = packageData.getPercussionInstrument();
                    manager.addPercussion(percussionInstruments);
                    break;

                }////////////////////////////////////////////////////////////////////////////////////////////
                else if(packageData.getOperationType().equals("LIST")){
                    ArrayList<Visitor> arrayVisitor = manager.getAllVisitor();
                    PackageData toVisitor = new PackageData();
                    toVisitor.setVisitors(arrayVisitor);
                    outputStream.writeObject(toVisitor);
                    break;
                }else if(packageData.getOperationType().equals("LIST Guitar")){
                    ArrayList<Guitar> arrayGuitar = manager.getAllGuitar();
                    PackageData toGuitar = new PackageData();
                    toGuitar.setGuitars(arrayGuitar);
                    outputStream.writeObject(toGuitar);
                    break;
                }else if(packageData.getOperationType().equals("LIST Keyboard")){
                    ArrayList<KeyboardInstruments> arrayKeyboard = manager.getAllKeyboard();
                    PackageData toKeyboard = new PackageData();
                    toKeyboard.setKeyboardInstruments(arrayKeyboard);
                    outputStream.writeObject(toKeyboard);
                    break;
                }else if(packageData.getOperationType().equals("LIST Percussion")){
                    ArrayList<PercussionInstruments> arrayPercussion = manager.getAllPercussion();
                    PackageData toPercussion = new PackageData();
                    toPercussion.setPercussionInstruments(arrayPercussion);
                    outputStream.writeObject(toPercussion);
                    break;

                }////////////////////////////////////////////////////////////////////////////////////////////
                else if(packageData.getOperationType().equals("Delete Visitor")){
                    int idServer = packageData.getId();
                    manager.deleteVisitors(idServer);
                    break;
                }
                else if(packageData.getOperationType().equals("Delete Product")){
                    int idServer = packageData.getId();
                    manager.deleteProduct(idServer);
                    break;

                }////////////////////////////////////////////////////////////////////////////////////////////
                else if(packageData.getOperationType().equals("Buy Product")){
                    int idServer = packageData.getId();
                    manager.updateProduct(idServer);
                    break;

                }////////////////////////////////////////////////////////////////////////////////////////////
                else if(packageData.getOperationType().equals("Find Guitar")){
                    String findGuitar = manager.findGuitar(packageData.getFind());
                    PackageData toPercussion = new PackageData();
                    toPercussion.setFind(findGuitar);
                    outputStream.writeObject(toPercussion);
                    break;
                }
                else if(packageData.getOperationType().equals("Find Keyboard")){
                    String findGuitar = manager.findKeyboard(packageData.getFind());
                    PackageData toPercussion = new PackageData();
                    toPercussion.setFind(findGuitar);
                    outputStream.writeObject(toPercussion);
                    break;
                }
                else if(packageData.getOperationType().equals("Find Percussion")){
                    String findGuitar = manager.findPercussion(packageData.getFind());
                    PackageData toPercussion = new PackageData();
                    toPercussion.setFind(findGuitar);
                    outputStream.writeObject(toPercussion);
                    break;
                }
                else if(packageData.getOperationType().equals("Find Type Guitar")){
                    String findGuitar = manager.findTypeGuitar(packageData.getFind());
                    PackageData toPercussion = new PackageData();
                    toPercussion.setFind(findGuitar);
                    outputStream.writeObject(toPercussion);
                    break;
                }
                else if(packageData.getOperationType().equals("Find Type Keyboard")){
                    String findGuitar = manager.findTypeKeyboard(packageData.getFind());
                    PackageData toPercussion = new PackageData();
                    toPercussion.setFind(findGuitar);
                    outputStream.writeObject(toPercussion);
                    break;
                }
                else if(packageData.getOperationType().equals("Find Type Percussion")){
                    String findGuitar = manager.findTypePercussion(packageData.getFind());
                    PackageData toPercussion = new PackageData();
                    toPercussion.setFind(findGuitar);
                    outputStream.writeObject(toPercussion);
                    break;

                }////////////////////////////////////////////////////////////////////////////////////////////
                else if(packageData.getOperationType().equals("LIST Discount")){
                    ArrayList<Product> arrayPercussion = manager.getAllDiscount();
                    PackageData toPercussion = new PackageData();
                    toPercussion.setProducts(arrayPercussion);
                    outputStream.writeObject(toPercussion);
                    break;
                }
                else if(packageData.getOperationType().equals("Add Cart")){
                    manager.addBasket(packageData.getId(), packageData.getId2());
                    break;
                }
                else if(packageData.getOperationType().equals("LIST CART")){
                    ArrayList<Product> arrayPercussion = manager.getAllCart(packageData.getId());
                    PackageData toPercussion = new PackageData();
                    toPercussion.setProducts(arrayPercussion);
                    outputStream.writeObject(toPercussion);
                    break;

                }////////////////////////////////////////////////////////////////////////////////////////////
                else if(packageData.getOperationType().equals("Check Login")){
                    Boolean checkLogin = manager.checkLogin(packageData.getFind(), packageData.getFind2());
                    PackageData toPercussion = new PackageData(checkLogin);
                    outputStream.writeObject(toPercussion);
                    break;
                }
                else if(packageData.getOperationType().equals("Get Visitor")){
                    Visitor visitor = manager.getVisitor(packageData.getFind());
                    PackageData toPercussion = new PackageData(visitor);
                    outputStream.writeObject(toPercussion);
                    break;
                }
                else if(packageData.getOperationType().equals("Get Count")){
                    int count = manager.getCountProduct(packageData.getId());
                    PackageData toPercussion = new PackageData(count);
                    outputStream.writeObject(toPercussion);
                    break;
                }
            }
            inputStream.close();
            outputStream.close();
            socket.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
