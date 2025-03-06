import com.sun.org.apache.xpath.internal.operations.Bool;



import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;
import java.util.List;


public class Main {


    public enum Text {
        BAD_INPUT("Your input data is corrupted. "),
        BAD_INPUT_UNDER("Not enough variables."),
        BAD_INPUT_ABOVE("Too much variables."),
        INTRO("Type number of a Task: "),

        TASK_1(""),
        TASK_1_INPUT("Write some float value: "),                          // Enumerator Для всех текстовых сообщений "дружественного" interface
                                                                            // Enum - набор констант, каждая константа содержит текст, который передается в конструктор.
        TASK_2(""),
        TASK_2_INPUT("Write symbol ( 0 1 2 3 4 5 6 7 8 9): "),

        TASK_3(""),
        TASK_3_INPUT("Write an integer: "),
        TASK_3_RESPONSE1("Is integer "),
        TASK_3_RESPONSE2(" 2 digit?: "),

        TASK_4(""),
        TASK_4_INPUT_BOND1("Write an integer value for first boundary: "),
        TASK_4_INPUT_BOND2("Write an integer value for second boundary: "),
        TASK_4_INPUT("Write an integer value to check if in range: "),

        TASK_4_RESPONSE1("Is number "),
        TASK_4_RESPONSE2(" within boundaries?: "),

        TASK_5(""),
        TASK_5_INPUT("Write 3 integer values: "),
        TASK_5_RESOINSE("Is 3 integers equal?: "),

        TASK_6(""),
        TASK_6_INPUT("Enter an integer: "),

        TASK_7(""),
        TASK_7_INPUT("Enter an integer value to check: "),

        TASK_8(""),
        TASK_8_INPUT("Enter a line of integer values (1 2 3 4 5..): "),

        TASK_9(""),
        TASK_9_INPUT("Enter two integer values (5 6..): "),

        TASK_10(""),
        TASK_10_INPUT("Enter a number in range from 1 to 7; "),

        TASK_11(""),
        TASK_11_INPUT("Enter an integer: "),

        TASK_12(""),
        TASK_12_INPUT("Enter an integer: "),

        TASK_13(""),
        TASK_13_INPUT("Enter an long number: "),

        TASK_14(""),
        TASK_14_INPUT("Enter scale of a square to paint: "),

        TASK_15(""),
        TASK_15_INPUT("Enter scale of a triangle to paint: "),

        TASK_16(""),
        TASK_16_INPUT("Enter an array of numbers (1 2 3 4 5): "),
        TASK_16_INPUT2("Enter a number to find: "),

        TASK_18(""),
        TASK_18_INPUT("Enter an array of numbers (1 2 3 4 5): "),
        TASK_18_INPUT_INS("Enter an array of numbers to insert in first array (1 2 3 4 5): "),
        TASK_18_INPUT2("Enter a number of position of insertion (index, srart with 0): "),


        TASK_MAX("");      // плейсхолдер чисто чтобы постоянно не переносить ; меня это бесит уже на 2 задании

        private final String text; // поле для текста

        Text(String text) {
            this.text = text;
        }  // конструктор, инициализирует поле text для каждой константы, когда она создается.

        @Override
        public String toString() {
            return text;
        }                                       // перезаписуем метод, для удобства пользования вооот, просто отдаем поле text
    }                                          // при System.out.println(Text.BAD_INPUT) - к экземпляру Text применяется toString(), таким образом мы получаем текстовое сообщение из элемента перечисления.

    public static void main(String[] args) {

        System.setProperty("file.encoding", "UTF-8");  // почему то у меня ничего подобного не работает, поэтому я и пишу на английском, у меня на пк чет не дружеестввенно как то ????????ххх**%%4#

        //ArrayList<String> dA = new ArrayList<String>();

        Main m = new Main();
        Scanner sc = new Scanner(System.in);


        System.out.println(Text.INTRO);

        try {                                     //  Запрашиваем номер задания, кэтчим все exceptions и перезапускаем мейн если что то не так, ну и кричим что то то не так BAD_INPUT
            int Id = sc.nextInt();                // Ообрабатываем каждое задание с интерфейсом

            switch (Id) {
                case 1: {
                    System.out.println(Text.TASK_1);
                    System.out.println(Text.TASK_1_INPUT);
                    double num = sc.nextDouble();
                    System.out.println(m.fraction(num));
                } break;
                case 2: {
                    System.out.println(Text.TASK_2);
                    System.out.println(Text.TASK_2_INPUT);
                    char chr = sc.next().charAt(0);
                    System.out.println(m.charToNum(chr));
                } break;
                case 3: {
                    System.out.println(Text.TASK_3);
                    System.out.println(Text.TASK_3_INPUT);
                    int num = sc.nextInt();
                    System.out.println(Text.TASK_3_RESPONSE1 + Integer.toString(num) + Text.TASK_3_RESPONSE2 + Boolean.toString(m.is2Digits(num)));
                } break;
                case 4: {
                    System.out.println(Text.TASK_4);
                    System.out.println(Text.TASK_4_INPUT_BOND1);

                    int bound_1 = sc.nextInt();
                    System.out.println(Text.TASK_4_INPUT_BOND2);

                    int bound_2 = sc.nextInt();

                    System.out.println(Text.TASK_4_INPUT);

                    int num = sc.nextInt();

                    System.out.println(Text.TASK_4_RESPONSE1 + Integer.toString(num) + Text.TASK_4_RESPONSE2 +  m.isInRange(bound_1, bound_2, num));

                } break;
                case 5: {
                    System.out.println(Text.TASK_5);
                    System.out.println(Text.TASK_5_INPUT);
                    String inp = sc.nextLine();
                    while (inp.isEmpty()) {  /// костыль потоому что сканер скипает юзер инпут, я тупой и ничего не понимаю, пусть будет так (мб в java так надо)
                        inp = sc.nextLine();
                    }

                    String[] inputs = inp.split(" ");
                    if (inputs.length < 3) {                            // Проверка количества переменных, ниже будет еще подобное (не комментирую ниже), ненавижу scanner
                        System.out.println(Text.BAD_INPUT_UNDER);
                        throw new IllegalArgumentException();
                    } else if (inputs.length > 3) {
                        System.out.println(Text.BAD_INPUT_ABOVE);
                        throw new IllegalArgumentException();
                    } else {
                        System.out.println(Text.TASK_5_RESOINSE + Boolean.toString(m.isEqual(Integer.parseInt(inputs[0]), Integer.parseInt(inputs[1]), Integer.parseInt(inputs[2]))));
                    }
                } break;
                case 6: {
                    System.out.println(Text.TASK_6);
                    System.out.println(Text.TASK_6_INPUT);
                    int inp = sc.nextInt();
                    System.out.println(m.abs(inp));
                } break;
                case 7: {
                    System.out.println(Text.TASK_7_INPUT);
                    int inp = sc.nextInt();
                    System.out.println(m.is35(inp));
                } break;
                case 8: {
                    System.out.println(Text.TASK_8_INPUT);
                    String inp = sc.nextLine();
                    while (inp.isEmpty()) {
                        inp = sc.nextLine();
                    }

                    String[] inputs = inp.split(" ");
                    if (inputs.length < 3) {
                        System.out.println(Text.BAD_INPUT_UNDER);
                        throw new IllegalArgumentException();
                    } else if (inputs.length > 3) {
                        System.out.println(Text.BAD_INPUT_ABOVE);
                        throw new IllegalArgumentException();
                    } else {
                        System.out.println(m.max3(Integer.parseInt(inputs[0]), Integer.parseInt(inputs[1]), Integer.parseInt(inputs[2])));
                    }
                } break;
                case 9: {
                    System.out.println(Text.TASK_9_INPUT);
                    String inp = sc.nextLine();
                    while (inp.isEmpty()) {
                        inp = sc.nextLine();
                    }

                    String[] inputs = inp.split(" ");
                    if (inputs.length < 2) {
                        System.out.println(Text.BAD_INPUT_UNDER);
                        throw new IllegalArgumentException();
                    } else if (inputs.length > 2) {
                        System.out.println(Text.BAD_INPUT_ABOVE);
                        throw new IllegalArgumentException();
                    } else {
                        System.out.println(m.sum2(Integer.parseInt(inputs[0]), Integer.parseInt(inputs[1])));
                    }
                } break;
                case 10: {
                    System.out.println(Text.TASK_10_INPUT);
                    int num = sc.nextInt();
                    System.out.println(m.day(num));
                } break;
                case 11: {
                    System.out.println(Text.TASK_11_INPUT);
                    int num = sc.nextInt();
                    System.out.println(m.listNums(num));
                } break;
                case 12: {
                    System.out.println(Text.TASK_12_INPUT);
                    int num = sc.nextInt();
                    System.out.println(m.chet(num));
                } break;
                case 13: {
                    System.out.println(Text.TASK_13_INPUT);
                    Long num = sc.nextLong();
                    System.out.println(m.numLen(num));
                } break;
                case 14: {
                    System.out.println(Text.TASK_14_INPUT);
                    int num = sc.nextInt();
                    m.square(Math.abs(num));
                } break;
                case 15: {
                    System.out.println(Text.TASK_15_INPUT);
                    int num = sc.nextInt();
                    m.rightTriangle(num);
                } break;
                case 16: {
                    System.out.println(Text.TASK_16_INPUT);
                    String inp = sc.nextLine();
                    while (inp.isEmpty()) {
                        inp = sc.nextLine();
                    }

                    String[] inputs = inp.split(" ");
                    int[] arr = new int[inputs.length];
                    for (int i = 0; i < inputs.length; i++) {
                        arr[i] = Integer.parseInt(inputs[i]);
                    }

                    System.out.println(Text.TASK_16_INPUT2);
                    int x = sc.nextInt();

                    System.out.println(m.findFirst(arr, x));
                } break;
                case 17: {
                    System.out.println(Text.TASK_16_INPUT);
                    String inp = sc.nextLine();
                    while (inp.isEmpty()) {
                        inp = sc.nextLine();
                    }

                    String[] inputs = inp.split(" ");
                    int[] arr = new int[inputs.length];
                    for (int i = 0; i < inputs.length; i++) {
                        arr[i] = Integer.parseInt(inputs[i]);
                    }



                    System.out.println(m.maxAbs(arr));
                } break;
                case 18: {
                    System.out.println(Text.TASK_18_INPUT);
                    String inp = sc.nextLine();
                    while (inp.isEmpty()) {
                        inp = sc.nextLine();
                    }

                    String[] inputs = inp.split(" ");
                    int[] arr = new int[inputs.length];
                    for (int i = 0; i < inputs.length; i++) {
                        arr[i] = Integer.parseInt(inputs[i]);
                    }

                    System.out.println(Text.TASK_18_INPUT_INS);
                    String inp2 = sc.nextLine();
                    while (inp2.isEmpty()) {
                        inp2 = sc.nextLine();
                    }

                    String[] inputs2 = inp2.split(" ");
                    int[] arr2 = new int[inputs2.length];
                    for (int i = 0; i < inputs2.length; i++) {
                        arr2[i] = Integer.parseInt(inputs2[i]);
                    }

                    System.out.println(Text.TASK_18_INPUT2);
                    int x = sc.nextInt();

                    int[] result = m.add(arr, arr2, x);
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < result.length; i++) {
                        sb.append(result[i]+" ");
                    }
                    System.out.println(sb.toString());
                } break;
                case 19: {
                    System.out.println(Text.TASK_16_INPUT);
                    String inp = sc.nextLine();
                    while (inp.isEmpty()) {
                        inp = sc.nextLine();
                    }

                    String[] inputs = inp.split(" ");
                    int[] arr = new int[inputs.length];
                    for (int i = 0; i < inputs.length; i++) {
                        arr[i] = Integer.parseInt(inputs[i]);
                    }


                    int[] result = m.reverseBack(arr);
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < result.length; i++) {
                        sb.append(result[i]+" ");
                    }
                    System.out.println(sb.toString());
                } break;
                case 20: {
                    System.out.println(Text.TASK_16_INPUT);
                    String inp = sc.nextLine();
                    while (inp.isEmpty()) {
                        inp = sc.nextLine();
                    }

                    String[] inputs = inp.split(" ");
                    int[] arr = new int[inputs.length];
                    for (int i = 0; i < inputs.length; i++) {
                        arr[i] = Integer.parseInt(inputs[i]);
                    }

                    System.out.println(Text.TASK_16_INPUT2);
                    int x = sc.nextInt();

                    int[] result = m.findAll(arr, x);
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < result.length; i++) {
                        sb.append(result[i]);
                    }
                    System.out.println(sb.toString());
                } break;
            }
        } catch (Exception e) {
            System.out.println(Text.BAD_INPUT + e.toString());
                m.main(args);
        }

    }

    public double fraction(double x) {

        String x_str = Double.toString(x);

        //System.out.println(x_str.substring( (x_str.indexOf(".")) + 1 ) + "       index - > " + x_str.indexOf("."));

        return Double.parseDouble("0." + x_str.substring( (x_str.indexOf(".")) + 1 ));
    };


    public int charToNum (char x) {
        return (int) x - 48;
    }

    public boolean is2Digits (int x){
        return Integer.toString(Math.abs(x)).length() == 2;
    }

    public boolean isInRange (int a, int b, int num) {
        return (Math.min(a,b) <= num) && (num <= Math.max(a,b));
    }

    public boolean isEqual(int a, int b, int c) {
        return (a == b) && (b == c);
    }

    public int abs (int x) {
        return x >= 0 ? x : -x;
    }

    public boolean is35 (int x) {
        return ((x % 3 == 0) || (x % 5 == 0)) && !((x % 3 == 0) && (x % 5 == 0));
    }

    public int max3 (int x, int y, int z) {
        //return Math.max(Math.max(x, y), z);
        int n = (x >= y ? x : y);
        return n >= z ? n : z;

    }

    public int sum2 (int x, int y) {
        int sum = x + y;
        if (!isInRange(10, 19, sum)) {
            return sum;
        } else {
            return 20;
        }
    }

    public String day (int x) {
        if (!isInRange(1,7, x)) {
            System.out.println("Not a day of a week");
            throw new IllegalArgumentException();
        }
        String[] days = {"START", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        return days[x];
    }

    public String listNums (int x) {
//        String result = "0";
//
//        for (int i = 1; i <= x; i++) {
//            result += " " + i;
//        }
//
//        return result;
        StringBuilder b = new StringBuilder();
        for (int i = 0; i != x + (x > 0 ? 1 : -1); i += (x > 0 ? 1 : -1)) {
            b.append(" " + i);
        }
        return b.toString();
    }

    public String chet (int x) {
//        String result = "0";
//
//        for (int i = 2; i <= x; i+=2) {
//            result += " " + i;
//        }
//
//        return result;
        StringBuilder b = new StringBuilder();
        for (int i = 0; Math.abs(i) <= Math.abs(x); i += x >= 0 ? 2 : -2) {
            b.append(" " + i);
        }
        return b.toString();
    }

    public int numLen (long x) {
        int count = 0;
        long xx = Math.abs(x);
        String str = Long.toString(xx);
        while (!str.isEmpty()) {
            count ++;
            str = str.substring(1);
        }
        return count;
    }

    public void square (int x) {
        for (int i = 0; i < x; i++) {
            //System.out.println("*".repeat(x));    Старый jdk IDK не работает, мб на лабе заработает (надеюсь все остальное то не сломается, вроде как java нереально крут в обратной совместительности)
            StringBuilder sb = new StringBuilder();
            for (int k = 0; k < x; k++) {
                sb.append("*");
            }
            System.out.println(sb.toString());
        }
    }

    public void rightTriangle (int x) {

        for (int i = 1; i <= x; i++) {

            for (int j = 1; j <= x - i; j++) {
                System.out.print(" ");
            }

            for (int k = 1; k <= i; k++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }

    public int findFirst (int[] arr, int x) {
        int result = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                result = i;
                break;
            }
        }
        return result;
    }

    public int maxAbs (int[] arr) {
        int result = -1;
        for (int i = 0; i < arr.length; i++) {
            if (Math.abs(arr[i]) >= result) {
                result = Math.abs(arr[i]);
            }
        }
        return result;
    }

    public int[] add (int[] arr, int[] ins, int pos) {

        if (pos < 0 || pos > arr.length) {
            throw new IllegalArgumentException("Invalid position");
        }

        int[] result = new int[arr.length + ins.length];

        for (int i = 0; i < pos; i++) {
            result[i] = arr[i];
        }

        for (int i = 0; i < ins.length; i++) {
            result[pos+i] = ins[i];
        }

        for (int i = pos; i < arr.length; i++) {
                result[ins.length + i] = arr[i];
            }


        return result;
    }

    public int[] reverseBack (int[] arr) {
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = arr[arr.length-1-i];
        }

        return result;
    }

    public int[] findAll (int[] arr, int x) {
        List<Integer> IArr = new ArrayList<Integer>();


        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                IArr.add(i);
            }
        }

        int[] arr2 = new int[IArr.size()];
        for (int i = 0; i < IArr.size(); i++) {
            arr2[i] = IArr.get(i);
        }

        return arr2;
    }
}
