package domain;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Order extends Person{
    private String name;
    private String dateTime;
    private byte type;

    public Order(int id, String name, String courier, String dateTime, byte type, ArrayList<String> arrayList) {
        this.id = id;
        this.name = name;
        this.lastName = courier;
        this.dateTime = dateTime;
        this.type = type;
        this.arrayList = arrayList;
    }
    
    public Order() {
        this(3, "Nokia 3310", "Ivanov", "12.12.2012 12:12:12", (byte)1, new ArrayList<String>());
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public void setId(int id) {
        if(id >= 0) {
            super.setId(id);
        }
        else {
            System.out.println("ID не може бути менше нуля!!!");
        }
    }

    @Override
    public String getLastName() {
        return super.getLastName();
    }

    @Override
    public void setLastName(String lastName) {
        super.setLastName(lastName);
    }
    
    @Override
    public ArrayList<String> getArrayList() {
        return super.getArrayList();
    }
    
    @Override
    public void fillingArrayList() {
        super.fillingArrayList();
    }
    
    @Override
    public void sortingArrayList() {
        super.sortingArrayList();
    }
    
    @Override
    public String toString() {
        return super.toString() + "\nName of product: " + name + "\nDate Time: " + dateTime + "\nType: " + type + '\n';
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
