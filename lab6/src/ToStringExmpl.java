
@ToString  // на класс вешаем аннотацию без указания значения свойства
public class ToStringExmpl {

    @ToString(ToString.opt.NO)  // на поле whatever вешаем аннотацию с значением свойства NO
    private Object whatever;

    public void Test() {
        System.out.println("ToStringExmpl class have an annotation: "
                + ToStringExmpl.class.getAnnotation(ToString.class)
                + " with value -> "
                + ToStringExmpl.class.getAnnotation(ToString.class).value());

        try {
            System.out.println("ToStringExmpl`s object type field | whatever |  have an annotation: "
                    + ToStringExmpl.class.getDeclaredField("whatever").getAnnotation(ToString.class)
                    + "with value -> "
                    + ToStringExmpl.class.getDeclaredField("whatever").getAnnotation(ToString.class).value()
            );
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
