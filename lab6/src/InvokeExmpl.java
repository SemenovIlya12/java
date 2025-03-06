import java.lang.reflect.Method;

public class InvokeExmpl {

    @Invoke
    public void Invoked() {

    }

    public void Test() {
        try {
            System.out.println(this.getClass().getDeclaredMethod("Invoked").isAnnotationPresent(Invoke.class));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
