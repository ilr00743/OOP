package domain;

import java.io.FileWriter;
import java.io.IOException;

public class Order extends Person{
    
    private String dateTime;
    private byte type;

    public Order(int id, String name, String courier, String dateTime, byte type) {
        this.id = id;
        this.firstName = name;
        this.lastName = courier;
        this.dateTime = dateTime;
        this.type = type;
    }
    
    public Order() {
        this(3, "Nokia 3310", "Ivanov", "12.12.2012 12:12:12", (byte)1);
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
    public String getFirstName() {
        return super.getFirstName();
    }

    @Override
    public void setFirstName(String firstName) {
        super.setFirstName(firstName);
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
    public String toString() {
        return super.toString() + "\nDate Time: " + dateTime + "\nType: " + type + "\n";
    }
}
