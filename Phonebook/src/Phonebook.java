import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Phonebook {
    private final Map<String, List<String>> pb = new HashMap<>();
    public List<String> getNumber(String name){
        if (!this.pb.containsKey(name)) throw new IllegalArgumentException("Контакт " + name + " не существует");
        return this.pb.get(name);

    }
    public List<String> getContact(String phone) {
        List<String> tempPeople = new ArrayList<>();
        this.pb.forEach((key, value) -> {if (value.contains(phone)) tempPeople.add(key);});
        return tempPeople;
    }
    public boolean addContact(String name){
        if(this.pb.containsKey(name))throw new IllegalArgumentException("Контакт " + name + " уже существует");
        List<String> phone = new ArrayList<String>();
        this.pb.put(name,phone);
        return true;
    }
    public boolean delContact(String name) {
        if (!this.pb.containsKey(name)) throw new IllegalArgumentException("Контакт " + name + "не найден");
        this.pb.remove(name);
        return true;
    }
    public boolean addNumber(String name, String phone){
        if(!this.pb.containsKey(name)) throw new IllegalArgumentException("Контакт " + name + " не существует");
        if (!phone.matches("^[0-9+*#/-]+")) throw new IllegalArgumentException("Неверный формат номера");
        List<String> contactList = this.pb.get(name);
        if (contactList.contains(phone)) throw new IllegalArgumentException("Номер" + phone + " уже существует");
        contactList.add(phone);
        return true;
    }
    public boolean delNumber(String name, String phone){
        if(!this.pb.containsKey(name)) throw new IllegalArgumentException("Контакт " + name + " не существует");
        List<String> contactList = this.pb.get(name);
        if (!contactList.contains(phone)) throw new IllegalArgumentException("Номер " + phone + " не существует");
        contactList.remove(phone);
        return true;
    }
}
