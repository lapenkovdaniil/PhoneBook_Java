import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.HashMap;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class Testing {
    // Проверять по очереди
    HashMap<String, ArrayList<String>> map = new HashMap<>();
    Phonebook pb = new Phonebook();
    ArrayList<String> numbersOfPhone = new ArrayList<>();
    ArrayList<String> contactList = new ArrayList<>();

    @Test
    public void getNumbers() {
        contactList.add("+79214190709");
        contactList.add("+79214190708");
        pb.addContact("Daniel");
        pb.addNumber("Daniel", "+79214190709");
        pb.addNumber("Daniel", "+79214190708");
        assertEquals(contactList, pb.getNumber("Daniel"));
        assertThrows(IllegalArgumentException.class, () -> pb.getNumber("Kris"));
    }
    @Test
    public void getContact() {
        contactList.add("Daniel");
        pb.addContact("Daniel");
        pb.addNumber("Daniel", "+79214190709");
        pb.addNumber("Daniel", "+79214190708");
        assertEquals(contactList, pb.getContact("+79214190709"));
        assertEquals(contactList, pb.getContact("+79214190708"));
    }
    @Test
    public void addContact(){
        map.put("Daniel",new ArrayList<>());
        assertEquals(map, pb.addContact("Daniel"));
        assertThrows(IllegalArgumentException.class, () -> pb.addContact("Daniel"));
    }
    @Test
    public void delContact() {
        pb.addContact("Daniel");
        pb.addNumber("Daniel","+79214190709");
        assertEquals(map, pb.delContact("Daniel"));
        assertThrows(IllegalArgumentException.class, () -> pb.delContact("Daniel"));
    }
    @Test
    public void addNumber() {
        numbersOfPhone.add("+79214190709");
        map.put("Daniel", numbersOfPhone);
        pb.addContact("Daniel");
        assertEquals(map, pb.addNumber("Daniel", "+79214190709"));
        assertThrows(IllegalArgumentException.class, () -> pb.addNumber("Daniel", "&)(#$"));
        assertThrows(IllegalArgumentException.class, () -> pb.addNumber("Kris", "+79214190709"));
    }
    @Test
    public void delNumber() {
        numbersOfPhone.add("+79214190708");
        map.put("Daniel", numbersOfPhone);
        pb.addContact("Daniel");
        pb.addNumber("Daniel", "+79214190708");
        pb.addNumber("Daniel", "+79214190709");
        assertEquals(map, pb.delNumber("Daniel", "+79214190709"));
        assertThrows(IllegalArgumentException.class, () -> pb.delNumber("Daniel", "+79214190709"));
        assertThrows(IllegalArgumentException.class, () -> pb.delNumber("Kris", "+79214190708"));
    }






}
