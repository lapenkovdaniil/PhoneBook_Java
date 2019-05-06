import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class Testing {
    private Map<String, List<String>> map = new HashMap<>();
    private Phonebook pb = new Phonebook();
    private List<String> numbersOfPhone = new ArrayList<>();
    private List<String> contactList = new ArrayList<>();
    private boolean mode = true;


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
        if(map.containsKey("Daniel")) mode = true;
        assertEquals(mode, pb.addContact("Daniel"));
        assertThrows(IllegalArgumentException.class, () -> pb.addContact("Daniel"));
    }
    @Test
    public void delContact() {
        pb.addContact("Daniel");
        pb.addNumber("Daniel","+79214190709");
        assertEquals(mode, pb.delContact("Daniel"));
        assertThrows(IllegalArgumentException.class, () -> pb.delContact("Daniel"));
    }
    @Test
    public void addNumber() {
        numbersOfPhone.add("+79214190709");
        map.put("Daniel", numbersOfPhone);
        pb.addContact("Daniel");
        assertEquals(mode, pb.addNumber("Daniel", "+79214190709"));
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
        assertEquals(mode, pb.delNumber("Daniel", "+79214190709"));
        assertThrows(IllegalArgumentException.class, () -> pb.delNumber("Daniel", "+79214190709"));
        assertThrows(IllegalArgumentException.class, () -> pb.delNumber("Kris", "+79214190708"));
    }
}
