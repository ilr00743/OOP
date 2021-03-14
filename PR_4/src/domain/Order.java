package domain;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Order extends Person{
    private String name;
    private String dateTime;
    private byte type;
    private ArrayList<Order> arrayList;

    public Order(int id, String name, String courier, String dateTime, byte type) {
        this.id = id;
        this.name = name;
        this.lastName = courier;
        this.dateTime = dateTime;
        this.type = type;
        this.arrayList = new ArrayList<>();
    }
    
    public Order() {
        this(3, "Nokia 3310", "Ivanov", "12.12.2012 12:12:12", (byte)1);
    }
    
    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public void setId(int id) {
        super.setId(id);
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setLastName(String lastName) {
        super.setLastName(lastName);
    }

    @Override
    public String getLastName() {
        return super.getLastName();
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public byte getType() {
        return type;
    }

    public void setType(byte type) {
        this.type = type;
    }

    public void fillingArrayList() {
        Order order = new Order(id, name, lastName, dateTime, type);
        arrayList.add(order);
    }
    
    public void sortById() {
        Collections.sort(arrayList, new SorterById());
    }
    
    public void reverseSortById() {
        Collections.sort(arrayList, Collections.reverseOrder(new SorterById()));
    }
    
    public void sortByDate() {
        Collections.sort(arrayList, new SorterByDate());
    }
    
    @Override
    public String toString() {
        return "ID: " + id + "\nName of product: " + name + "\nLast name of courier: " + lastName + "\nDate Time: " + dateTime + "\nType: " + type + '\n';
    }
    
    public void writeFile() {
        try(FileWriter fileWriter = new FileWriter("orders.txt", false)) {
            StringBuilder strBuilder = new StringBuilder();
            
            arrayList.forEach((string) -> {
                strBuilder.append(string).append('\n');
            });
            
            fileWriter.write(String.valueOf(strBuilder));
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
}
