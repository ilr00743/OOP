package domain;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Contact extends Person{

    protected String address;

    public Contact(int id, String firstName, String lastName, String address, ArrayList<String> arrayList) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.arrayList = arrayList;
    }
    
    public Contact() {
        this(5, "Petya", "Poroh", "Pushkin St.", new ArrayList<>());
    }
    
    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public void setId(int id) {
        if (id >= 0) {
            super.setId(id);
        }
        else {
            System.out.println("Id не може бути менше нуля!");
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
        return super.toString() + "\nAddress: " + getAddress() + "\n";
    }
    
    public void writeFile() {
        try(FileWriter fileWriter = new FileWriter("contacts.txt", false)) {
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
