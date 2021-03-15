package domain;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Contact extends Person{

    private ArrayList<Contact> arrayList;
     
    private String address;
    
    public Contact(int id, String firstName, String lastName, String address) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.arrayList = new ArrayList<>();
    }
    
    public Contact() {
        this(5, "Petya", "Petrov", "Pushkin St.");
    }
    
    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public void setId(int id) {
        super.setId(id);
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
    
    public void fillingArrayList() {
        Contact contact = new Contact(id, firstName, lastName, address);
        arrayList.add(contact);
    }
    
    public void sortById() {
        Collections.sort(arrayList, new SorterById());
    }
    
    public void reverseSortById() {
        Collections.sort(arrayList, Collections.reverseOrder(new SorterById()));
    }
    
    public void sortByLastName() {
        Collections.sort(arrayList, new SorterByLastName());
    }
    
    public void reverseSortByLastName() {
        Collections.sort(arrayList, Collections.reverseOrder(new SorterByLastName()));
    }
    
    @Override
    public String toString() {
        return super.toString() + "\nAddress: " + getAddress() + '\n';
    }
    
    public void writeFile() {
        try(FileWriter fileWriter = new FileWriter("contacts.txt", false)) {
            StringBuilder strBuilder = new StringBuilder();
            
            arrayList.forEach((person) -> {
                strBuilder.append(person).append('\n');
            });
            
            fileWriter.write(String.valueOf(strBuilder));
            fileWriter.close();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
}