import java.util.ArrayList;
import java.util.HashMap;

public class Phonebook {
    public static HashMap<String, ArrayList<String>> pb = new HashMap<>();
    public ArrayList<String> getNumber(String name){
        if (!this.pb.containsKey(name)) throw new IllegalArgumentException("Контакт" + name + " не существует");
        return this.pb.get(name);
    }
    public ArrayList<String> getContact(String phone) {
        ArrayList<String> contactList = new ArrayList<String>() {};
        this.pb.entrySet().forEach(entry -> {
            String key = entry.getKey();
            ArrayList<String> value = entry.getValue();
            if (value.contains(phone)) contactList.add(key);
        });
        return contactList;
    }
    public HashMap<String, ArrayList<String>> addContact(String name){
        if(this.pb.containsKey(name))throw new IllegalArgumentException("Контакт" + name + " уже существует");
        ArrayList<String> phone = new ArrayList<String>();
        this.pb.put(name,phone);
        return this.pb;
    }
    public HashMap<String, ArrayList<String>> delContact(String name) {
        if (!this.pb.containsKey(name)) throw new IllegalArgumentException("Контакт" + name + "не найден");
        this.pb.remove(name);
        return this.pb;
    }
    public HashMap<String, ArrayList<String>> addNumber(String name,String phone){
        if(!this.pb.containsKey(name)) throw new IllegalArgumentException("Контакт" + name + " не существует");
        if (!phone.matches("^[0-9+*#/-]+")) throw new IllegalArgumentException("Неверный формат номера");
        ArrayList<String> contactList = this.pb.get(name);
        if (contactList.contains(phone)) throw new IllegalArgumentException("Номер" + phone + " уже существует");
        contactList.add(phone);
        this.pb.put(name,contactList);
        return this.pb;
    }
    public HashMap<String, ArrayList<String>> delNumber(String name,String phone){
        if(!this.pb.containsKey(name)) throw new IllegalArgumentException("Контакт" + name + " не существует");
        ArrayList<String> contactList = this.pb.get(name);
        if (!contactList.contains(phone)) throw new IllegalArgumentException("Номер " + phone + " не существует");
        contactList.remove(phone);
        this.pb.put(name,contactList);
        return this.pb;
    }
}
