package DataBase;
import com.company.*;
import java.io.Serializable;
import java.util.ArrayList;

public class PackageData implements Serializable {
    private String operationType;
    private int id;
    private int id2;
    private String find;
    private String find2;
    private Boolean login;

    private Visitor visitor;
    private KeyboardInstruments keyboardInstrument;
    private PercussionInstruments percussionInstrument;
    private Guitar guitar;
    private Product product;

    private ArrayList<Visitor> visitors;
    private ArrayList<Guitar> guitars;
    private ArrayList<KeyboardInstruments> keyboardInstruments;
    private ArrayList<PercussionInstruments> percussionInstruments;
    private ArrayList<Product> products;

    public PackageData(Visitor visitor) {
        this.visitor = visitor;
    }

    public PackageData() {
    }

    public PackageData(int id) {
        this.id = id;
    }

    public PackageData(ArrayList<Product> products) {
        this.products = products;
    }

    public PackageData(String operationType, int id, int id2) {
        this.operationType = operationType;
        this.id = id;
        this.id2 = id2;
    }

    public PackageData(Boolean login) {
        this.login = login;
    }

    public PackageData(int id, int id2) {
        this.id = id;
        this.id2 = id2;
    }

    public PackageData(Product product) {
        this.product = product;
    }

    public PackageData(String operationType, Product product) {
        this.operationType = operationType;
        this.product = product;
    }

    public PackageData(String operationType, String find) {
        this.operationType = operationType;
        this.find = find;
    }

    public PackageData(String operationType, String find, String find2) {
        this.operationType = operationType;
        this.find = find;
        this.find2 = find2;
    }

    public PackageData(String operationType, int id) {
        this.operationType = operationType;
        this.id = id;
    }

    public PackageData(String operationType, Visitor visitor) {
        this.operationType = operationType;
        this.visitor = visitor;
    }

    public PackageData(String operationType, Guitar guitar) {
        this.operationType = operationType;
        this.guitar = guitar;
    }

    public PackageData(String operationType, KeyboardInstruments keyboardInstrument) {
        this.operationType = operationType;
        this.keyboardInstrument = keyboardInstrument;
    }

    public PackageData(String operationType, PercussionInstruments percussionInstrument) {
        this.operationType = operationType;
        this.percussionInstrument = percussionInstrument;
    }

    public PackageData(String operationType) {
        this.operationType = operationType;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public Visitor getVisitor() {
        return visitor;
    }

    public void setVisitor(Visitor visitor) {
        this.visitor = visitor;
    }

    public KeyboardInstruments getKeyboardInstrument() {
        return keyboardInstrument;
    }

    public void setKeyboardInstrument(KeyboardInstruments keyboardInstrument) {
        this.keyboardInstrument = keyboardInstrument;
    }

    public PercussionInstruments getPercussionInstrument() {
        return percussionInstrument;
    }

    public void setPercussionInstrument(PercussionInstruments percussionInstrument) {
        this.percussionInstrument = percussionInstrument;
    }

    public Guitar getGuitar() {
        return guitar;
    }

    public void setGuitar(Guitar guitar) {
        this.guitar = guitar;
    }

    public ArrayList<Visitor> getVisitors() {
        return visitors;
    }

    public void setVisitors(ArrayList<Visitor> visitors) {
        this.visitors = visitors;
    }

    public ArrayList<Guitar> getGuitars() {
        return guitars;
    }

    public void setGuitars(ArrayList<Guitar> guitars) {
        this.guitars = guitars;
    }

    public ArrayList<KeyboardInstruments> getKeyboardInstruments() {
        return keyboardInstruments;
    }

    public void setKeyboardInstruments(ArrayList<KeyboardInstruments> keyboardInstruments) {
        this.keyboardInstruments = keyboardInstruments;
    }

    public ArrayList<PercussionInstruments> getPercussionInstruments() {
        return percussionInstruments;
    }

    public void setPercussionInstruments(ArrayList<PercussionInstruments> percussionInstruments) {
        this.percussionInstruments = percussionInstruments;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFind() {
        return find;
    }

    public void setFind(String find) {
        this.find = find;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public String getFind2() {
        return find2;
    }

    public void setFind2(String find2) {
        this.find2 = find2;
    }

    public Boolean getLogin() {
        return login;
    }

    public void setLogin(Boolean login) {
        this.login = login;
    }

    public int getId2() {
        return id2;
    }

    public void setId2(int id2) {
        this.id2 = id2;
    }
}