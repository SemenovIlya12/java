import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public Polyline StreamPoints(List<Point> Points) {
        Polyline poly = new Polyline(Points.stream()
                .distinct()
                .sorted(Comparator.comparingInt(Point::getX))
                .map(point -> new Point(point.getX(), Math.abs(point.getY())))
                .collect(Collectors.toList()));

        return poly;
    }

    public static void MakeThemMeoow(Meowing entity) {
        Random randomizer = new Random();
        int rng = 1+ randomizer.nextInt(7);
        System.out.println("Rng number is: " + rng);
        for (int k = 1; k <= rng; k++) {
            entity.meow();
        }
    }



    public static ArrayList<Object> WeirdInsert(ArrayList<Object> objcs, Object o) {
        if (!objcs.contains(o)) throw new IllegalStateException("Array does not contain specified object.");

        //int size = objcs.size();
        int index = objcs.indexOf(o);

        ArrayList<Object> newObjcs = new ArrayList<Object>();

        for (int i = 0; i <= index; i++) {
            newObjcs.add(objcs.get(i));
        }

        for (Object obj : objcs) {
            newObjcs.add(obj);
        }

        for (int i = index + 1; i < objcs.size(); i++) {
            newObjcs.add(objcs.get(i));
        }

        return newObjcs;
    }

    public static String FormtatName(String name) {
        String low = name.toLowerCase();
        return low.substring(0,1).toUpperCase() + low.substring(1);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Enter task number: ");
            int id = sc.nextInt();
            switch (id) {
                case 1: {
                    Frac fr = new Frac(2, 5) {    // Создаем анонимный класс
                        public double cached;
                        public boolean isCached = false;       // поле для кэшированного значения и флаг, который указывает на наличие/актуальность кэша.

                        @Override
                        public double getValue() {
                            if (!isCached) {
                                this.cached = super.getValue();   // переопред. метод получения значения. Для начала смотрим, есть ли у нас кэш, если нет, то обращаемся к предку с просьбой
                                this.isCached = true;            //                                                                                    вычислить значение по-старому
                                return this.cached;
                            } else {
                                System.out.println("Got frac value from cache");
                                return this.cached;
                            }

                        }

                        @Override
                        public void setChisl(int num) {
                            super.setChisl(num);
                            this.isCached = false;
                        }

                        // Переопределяем оба геттера. При изменении дроби нужно, чтобы менялся и кэщ.
                        @Override
                        public void setZnam(int num) {
                            super.setZnam(num);
                            this.isCached = false;
                        }
                    };

                    System.out.println(fr.getValue());  // 0,4   Тут еще кэша нет
                    System.out.println(fr.getValue()); // 0,4 но кэщ уже есть --  "Got frac value from cache"
                    fr.setChisl(3);                    // установили значение числителя на 3, кэш устарел
                    System.out.println(fr.getValue()); // 0.6 кэш старый, т.е по сути его нет
                    System.out.println(fr.getValue()); // 0.6, значение получено из кэша.

                } break;
                case 2: {  //maw
                    Gatito GalaxyDestroyer = new Gatito("Galaxy Destroyer") {
                        private int meowCount = 0;

                        @Override
                        public void meow() {
                            this.meowCount ++;
                            super.meow();
                        }

                        @Override
                        public String toString() {
                            return super.toString() + " was meowing " + this.meowCount + " times!";
                        }
                    };

                    Gatito dawg = new Gatito("Dawg") {
                        private int meowCount = 0;

                        @Override
                        public void meow() {
                            this.meowCount ++;
                            super.meow();
                        }

                        @Override
                        public String toString() {
                            return super.toString() + " was meowing " + this.meowCount + " times!";
                        }
                    };

                    MakeThemMeoow(GalaxyDestroyer);
                    System.out.println(GalaxyDestroyer);

                    MakeThemMeoow(dawg);
                    System.out.println(dawg);

                } break;
                case 3: {  // L в L если есть E в L, весь L после E, если E есть в L

                    ArrayList<Object> L = new ArrayList<Object>();
                    L.add("EE");
                    L.add(5);
                    L.add("meow");
                    L.add("Sequenceend");

                    ArrayList<Object> result = WeirdInsert(L, "meow");
                    for (Object i: result) {
                        System.out.println(i);
                    }
                } break;
                case 4: {
                    String filename = "input.txt";
                    try {

                        BufferedReader reader = new BufferedReader(new FileReader(filename));

                        HashMap<String, int[]> Abits = new HashMap<String, int[]>();

                        int N = Integer.parseInt(reader.readLine());




                        for (int i = 0; i < N; i++) {
                            String line = reader.readLine();
                            String[] parts = line.split(" ");


                            String lastName = parts[0];
                            String firstName = parts[1];
                            int score1 = Integer.parseInt(parts[2]);
                            int score2 = Integer.parseInt(parts[3]);
                            int[] scores = {score1, score2};
                            Abits.put(lastName + " " + firstName, scores);
                        }



                        Set keys = Abits.keySet();

                        for (Object i : keys) {
                            int[] scrs = Abits.get(i);
                            if (scrs[0] < 30 || scrs[1] < 30) {
                                System.out.println(i + " " + scrs[0] + " " + scrs[1]);
                            }
                        }

                    } catch (IOException e) {
                        System.out.println("А что с файлом друг? " + e.getMessage());
                    }
                } break;
                case 5 : {
                    String filename = "inputset.txt";
                    try {
                        BufferedReader reader = new BufferedReader(new FileReader(filename));
                        boolean last = false;
                        String line;
                        HashSet<String> Nechet = new HashSet<String>();
                        while ( (line = reader.readLine()) != null ) {
                            line = line.replaceAll("\\s+", " ");
                            String[] words = line.split(" ");
                            for (int i = (!last)  ? 0 : 1 ; i < words.length; i = i + 2) {  // Неизвестно, текст в 1 строке или нет, поэтому мы должны проверять
                                Nechet.add(words[i]);                                               // начинается ли следующая строка с чет/нечет слова.
                                //System.out.println(words[i]);
                            }
                            if (words.length % 2 == 0) {
                                last = false;
                            } else last = true;
                        }


                        //String deaf = "п ф к т ш с х ц ч щ";
                        String deaf = "g a r n i c w x o";
                        String[] deafList = deaf.split(" ");

                        TreeSet<String> chars = new TreeSet<String>(); // Используем TreeSet, т.к он поддерживает множество в натуральном порядке,
                                                                             //                для объектов, которые имплементируют интерфейс comparable
                        for (String i : deafList) {
                            boolean flag = true;
                            ArrayList<String> Nechets = new ArrayList<String>();
                            Nechets.addAll(Nechet);
                            for (String word : Nechets) {
                                //System.out.println(word);
                                //System.out.println(i);
                                if (!word.contains(i)) {
                                    flag = false;
                                    break;
                                }
                            }
                            if (flag == true) {
                                chars.add(i);

                            }

                        }

                        //System.out.println(chars.isEmpty());
                        for (String i: chars) {
                            System.out.println(i);
                        }
                    } catch (IOException e) {
                        System.out.println("А что с файлом?? " + e.getMessage());
                    }
                } break;
                case 6 : {
                    Queue<Integer> L1 = new ArrayDeque<Integer>();
                    L1.add(5);
                    L1.add(6);
                    L1.add(7);
                    L1.add(8);

                    Stack<Integer> st = new Stack<Integer>();
                    st.addAll(L1);

                    while (!st.isEmpty()) {
                        System.out.println(st.pop());
                    }

                    System.out.println();

                    ArrayList<Integer> L2 = new ArrayList<Integer>();
                    L2.add(1);
                    L2.add(2);
                    L2.add(3);
                    L2.add(4);

                    Queue<Integer> L2q = new ArrayDeque<Integer>();
                    for (int i : L2) {
                        L2q.add(i);
                    }

                    Stack<Integer> st2 = new Stack<Integer>();
                    st2.addAll(L2);
                    while(!st2.isEmpty()) {
                        L2q.add(st2.pop());
                    }

                    while (!L2q.isEmpty()) {
                        System.out.println(L2q.poll());
                    }

                } break;
                case 7 : {
                    List<Point> Points = Arrays.asList(
                            new Point(1, 2),
                            new Point(1, 2),
                            new Point(3, -4),
                            new Point(2, 5),
                            new Point(3, 4),
                            new Point(-2, -3)
                    );

                    Polyline poly = new Polyline(Points.stream()
                            .distinct()                                                         // убираем дубликаты
                            .sorted(Comparator.comparingInt(Point::getX))                       // сортируем по X
                            .map(point -> new Point(point.getX(), Math.abs(point.getY())))      // У нас не должно быть отрицательных Y
                            .collect(Collectors.toList()));                                     // собираем все в список


                    System.out.println(poly.toString());

                    List<String> Lines = Files.readAllLines(Paths.get("Stream.txt"));

                    Map<Integer, List<String>> result = Lines.stream()
                            .map(Line ->Line.split(":"))                                // Преобразуем каждую строку стрима, а именно разобьем каждую строку на ИМЯ : НОМЕР, после этого каждый элемент - массив [имя,номер]
                            .filter(splits -> splits.length == 2 && !splits[1].isEmpty())     // Должны получить 2 строки, имя и номер, номер не должен быть пустым. Отфильтруем все элементы, которые разделены не на 2 части и/или имеют пустой номер
                            .collect(
                                    Collectors.groupingBy(                                    // коллектор, который группирует элементы стрима по ключу (Создает мапу где ключем является результат классификатора ( в нашем случае - номер))
                                    splits -> Integer.parseInt(splits[1]),                    // Группируем по номеру. Номер - 2 часть элемента стрима, если я конечно все правильно сделал..
                                                               // groupingBy имеет 2 импл. одноарг. и двухаргументная, 2ух аргументная принемает некий Downstream - коллектор, определяющий способ обработки элементов группы.
                                    Collectors.mapping(
                                            splits -> FormtatName(splits[0]),                // Используем в качестве downstream вложенный коллектор mapping, он преобразует элементы с помощью метода, который я создал ранее.

                                            Collectors.toList()                             // Собираем преобразованные группы в список
                                    )
                            ));

                    Set keys = result.keySet();
                    for (Object i : keys) {
                        System.out.println(i + ": " + result.get(i));
                    }
                } break;


            }
        } catch (Exception e) {
            System.out.println(e.toString());
            main(args);
        }


        System.out.println("Want to proceed to another task? Enter 1 for yes, any other thing for no: ");
        int descision = sc.nextInt();
        if (descision == 1) {
            for (int i = 0; i < 50; i++) {
                System.out.println();
            }
            main(args);
        }
    }
}
