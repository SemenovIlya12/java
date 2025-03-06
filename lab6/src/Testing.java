import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Testing {


    @Test
    public void Test1() {
        String expected = "B {x = 5,hey = hey,}";
        B b = new B();
        assertEquals(expected, b.toString(), "Class doesnt marked up with ToString(No), but field hmm does.");


    }

    @Test
    public void Test2() {
        String expected = "C {hey = hey,}";
        C c = new C();
        assertEquals(expected, c.toString(), "Class marked up with ToString(No). But field 'hey' does.");
    }

    @Test
    public void Test3() {
        String expected = "D {hm = null,x = 5,hey = hey,}";
        D d = new D();
        assertEquals(expected, d.toString(), "Standart class.");


    }
}
