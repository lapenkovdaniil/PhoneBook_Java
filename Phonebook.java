import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Phonebook {
    private  Map<String, List<String>> pb = new HashMap<>();
    List<String> getNumber(String name){
        if (!this.pb.containsKey(name)) throw new IllegalArgumentException("Контакт" + name + " не существует");
        return this.pb.get(name);
    }
    List<String> getContact(String phone) {
        List<String> contactList = new ArrayList<String>() {};
        for (Map.Entry<String, List<String>> entry : this.pb.entrySet()) {
            String key = entry.getKey();
            List<String> value = entry.getValue();
            if (value.contains(phone)) contactList.add(key);
        }
        return contactList;
    }
    Map<String, List<String>> addContact(String name){
        if(this.pb.containsKey(name))throw new IllegalArgumentException("Контакт" + name + " уже существует");
        List<String> phone = new ArrayList<String>();
        this.pb.put(name,phone);
        return this.pb;
    }
    Map<String, List<String>> delContact(String name) {
        if (!this.pb.containsKey(name)) throw new IllegalArgumentException("Контакт" + name + "не найден");
        this.pb.remove(name);
        return this.pb;
    }
    Map<String, List<String>> addNumber(String name, String phone){
        if(!this.pb.containsKey(name)) throw new IllegalArgumentException("Контакт" + name + " не существует");
        if (!phone.matches("^[0-9+*#/-]+")) throw new IllegalArgumentException("Неверный формат номера");
        List<String> contactList = this.pb.get(name);
        if (contactList.contains(phone)) throw new IllegalArgumentException("Номер" + phone + " уже существует");
        this.pb.get(name).add(phone);
        return this.pb;
    }
    Map<String, List<String>> delNumber(String name, String phone){
        if(!this.pb.containsKey(name)) throw new IllegalArgumentException("Контакт" + name + " не существует");
        List<String> contactList = this.pb.get(name);
        if (!contactList.contains(phone)) throw new IllegalArgumentException("Номер " + phone + " не существует");
        contactList.remove(phone);
        this.pb.put(name,contactList);
        return this.pb;
    }
}
