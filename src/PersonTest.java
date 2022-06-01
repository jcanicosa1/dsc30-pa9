import static org.junit.Assert.*;
import java.util.ArrayList;

public class PersonTest {

    @org.junit.Test
    public void getName() {
    }

    @org.junit.Test
    public void addPhoneNumber() {
    }

    @org.junit.Test
    public void getPhoneNumbers() {
        ArrayList<String> arr = new ArrayList<>();
        arr.add("6502910892");
        Person obj = new Person("Jeff", arr);
        obj.addPhoneNumber("6502910891");
        obj.addPhoneNumber("6502910890");
        obj.addPhoneNumber("6502910893");
        System.out.print(obj.getArray());

    }

    @org.junit.Test
    public void deletePhoneNumber() {
    }
}