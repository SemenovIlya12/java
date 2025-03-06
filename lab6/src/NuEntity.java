import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public abstract class NuEntity {


    @Override
    public String toString() {
        Field[] Fields = this.getClass().getDeclaredFields();       // рефлексия (Какие поля я имею??) -- получаем поля класса.

        Map<String, Object> result = new HashMap<String, Object>();


        ToString classCheck = this.getClass().getAnnotation(ToString.class);
        boolean exclude = classCheck != null && classCheck.value() == ToString.opt.NO;

        for (Field f : Fields) {
            f.setAccessible(true);  // Разрешаем доступ к private полям
            ToString fieldCheck = f.getAnnotation(ToString.class);

            // Используем тернарный оператор для определения, включать ли поле
            boolean include = exclude
                    ? (fieldCheck != null && fieldCheck.value() == ToString.opt.YES) // Если класс помечен @ToString(NO), то включаем только поля с @ToString(YES)
                    : (fieldCheck == null || fieldCheck.value() != ToString.opt.NO); // Если класс не помечен @ToString(NO), то исключаем только поля с @ToString(NO)

            if (include) {
                try {
                    //System.out.println(f.getAnnotation(ToString.class));
                    String name = f.getName();
                    Object insides = f.get(this);
                    result.put(name, insides);
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        sb.append(this.getClass().getSimpleName()+" {");

        Set keys = result.keySet();

        for (Object o : keys) {
            sb.append(o + " = " + result.get(o)+",");
        }

        sb.append("}");

        return sb.toString();

    }
}
