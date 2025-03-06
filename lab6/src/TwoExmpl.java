public class TwoExmpl {

    @Two(first = "YO", second = 5)
    private Object someField;

    @Two(first = "HEYY", second = 42)
    private Object yetAnotherField;

    public void Test() {
        try {
            System.out.println("TwoExmpl class`s field 'someField' have annotation"
                    + TwoExmpl.class.getDeclaredField("someField").getAnnotation(Two.class)
                    + " with values -> "
                    + "first: " + TwoExmpl.class.getDeclaredField("someField").getAnnotation(Two.class).first()
                    + ", second: " + TwoExmpl.class.getDeclaredField("someField").getAnnotation(Two.class).second()
            );


            System.out.println("TwoExmpl class`s field 'yetAnotherField' have annotation"
                    + TwoExmpl.class.getDeclaredField("yetAnotherField").getAnnotation(Two.class)
                    + " with values -> "
                    + "first: " + TwoExmpl.class.getDeclaredField("yetAnotherField").getAnnotation(Two.class).first()
                    + ", second: " + TwoExmpl.class.getDeclaredField("yetAnotherField").getAnnotation(Two.class).second()
            );


        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
