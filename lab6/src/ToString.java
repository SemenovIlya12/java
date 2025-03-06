import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ToString {
    enum opt {YES, NO};   // перечисление возможных значений свойства value
    opt value() default opt.YES;  // Свойство value становится необязательным, т.к у нас указано значение по умолчанию из перечисления возможных значений.
}
