
@Validate({String.class, Integer.class})
public class ValidateExmpl {

    public void Test() {
        System.out.println("ValidateExmpl class have an annotation: "
                + ValidateExmpl.class.getAnnotation(Validate.class)
                + " with value -> "
                + ValidateExmpl.class.getAnnotation(Validate.class).value());

        System.out.println("Default annotation class have an annotation: "
                + Default.class.getAnnotation(Validate.class)
                + " with value -> "
                + Default.class.getAnnotation(Validate.class).value());
    }

}
