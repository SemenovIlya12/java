import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public abstract class Entity {

    @Override
    public String toString() {
        Field[] Fields = this.getClass().getDeclaredFields();       // рефлексия (Какие поля я имею??) -- получаем поля класса.

        Map<String, Object> result = new HashMap<String, Object>();

        for (Field f : Fields) {
            f.setAccessible(true);  // Разрешаем доступ к private полям
            try {
                String name = f.getName();
                Object insides = f.get(this);
                result.put(name, insides);
            } catch (Exception e) {
                System.err.println(e.getMessage());
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
