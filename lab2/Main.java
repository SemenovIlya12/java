import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter task number: !");


        try {
            int id = sc.nextInt();

            switch (id) {
                case 1: {
                    Human cleo = new Human("Cleopatra", 152);
                    Human Pushkin = new Human("Pushkin", 167);
                    Human Mayakovski = new Human("Vladimir", 189);

                    System.out.println(cleo);
                    System.out.println(Pushkin);
                    System.out.println(Mayakovski);

                } break;
                case 2: {
                    Name cleo = new Name("Клеопатра");
                    Name Pushkin = new Name("Александр", "Пушкин", "Сергеевич");
                    Name Mayakovski = new Name("Владимир", "Маяковский");
                    Name t1 = new Name("T T T");
                    Name t2 = new Name("T T");
                    Name t3 = new Name("T");
                    System.out.println(cleo);
                    System.out.println(Pushkin);
                    System.out.println(Mayakovski);

                    System.out.println(t1);
                    System.out.println(t2);
                    System.out.println(t3);
                } break;
                /*case 3: {
                    Time t1 = new Time(10);
                    Time t2 = new Time(10000);
                    Time t3 = new Time(100000);
                    System.out.println(t1);
                    System.out.println(t2);
                    System.out.println(t3);
                } break;*/
                case 3: {  // А ТАКЖЕ НОМЕР 3.4
                    //ArrayList<Human>  humans = new ArrayList<Human>();
                    department IT = new department("IT depatment");

                    employee Petrov = new employee("Petrov", IT);
                    employee Kozlov = new employee("Kozlov", IT);
                    employee Sidorov = new employee("Sidorov", IT);

                    IT.SetCEO(Kozlov);

                    System.out.println(Petrov);
                    System.out.println(Kozlov);
                    System.out.println(Sidorov);


                    /*System.out.println("Getting whole department");
                    ArrayList<employee> emps = Kozlov.GetDepartment().GetEmployees();

                    for (int i = 0; i < emps.size(); i++) {
                        System.out.println(emps.get(i));
                    }*/

                } break;
                case 4: {
                    department IT = new department("IT depatment");

                    employee Petrov = new employee("Petrov", IT);
                    employee Kozlov = new employee("Kozlov", IT);
                    employee Sidorov = new employee("Sidorov", IT);

                    IT.SetCEO(Kozlov);

                    ArrayList<employee> emps = Kozlov.GetDepartment().GetEmployees();

                    for (int i = 0; i < emps.size(); i++) {
                        System.out.println(emps.get(i));
                    }
                } break;
                case 5: {
                    System.out.println("How many rounds ya want in ya shooter?( -1, if you dont care, why even bother uknow) ");
                    int r = sc.nextInt();
                    System.out.println("How many times you want to pull the trigger? ");
                    int s = sc.nextInt();
                    Pistol p;
                    if (r == -1) {
                        p = new Pistol();
                    } else {
                        p = new Pistol(r);
                    }

                    for (int i = 1; i <= s; i++) {
                        p.Shoot();
                    }
                } break;
            }
        } catch (Exception e) {
            System.out.println("Wrong input "+e.toString());
        }
    }
}
