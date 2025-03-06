
@Default(value = DefaultExmpl.class)
public class DefaultExmpl {

    @Default(value = String.class)
    private Object field;

    public void Test() {

        System.out.println("DefaultExmpl class have an annotation: " + DefaultExmpl.class.getAnnotation(Default.class));

        try {
            System.out.println("DefaultExmpl`s object type field  have an annotation: " + DefaultExmpl.class.getDeclaredField("field").getAnnotation(Default.class));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
