import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {

            System.out.println("Enter number of a task: ");

            int id = sc.nextInt();

            switch (id) {
                case 1: {
                    A a = new A();

                    System.out.println(a);
                }
                break;
                case 2: {
                    System.out.println("2.1: ");
                    InvokeExmpl exmpl1 = new InvokeExmpl();

                    exmpl1.Test();

                    System.out.println();

                    System.out.println("2.2: ");
                    DefaultExmpl exmpl2 = new DefaultExmpl();
                    exmpl2.Test();

                    System.out.println();

                    System.out.println("2.3: ");
                    ToStringExmpl exmpl3 = new ToStringExmpl();
                    exmpl3.Test();

                    System.out.println();

                    System.out.println("2.4: ");
                    ValidateExmpl exmpl4 = new ValidateExmpl();
                    exmpl4.Test();

                    System.out.println();

                    System.out.println("2.5: ");
                    TwoExmpl exmpl5 = new TwoExmpl();
                    exmpl5.Test();

                    System.out.println();

                    System.out.println("2.6: ");
                    CacheExmpl exmpl6 = new CacheExmpl();
                    exmpl6.Test();

                } break;
                case 3: {
                    B b = new B();
                    System.out.println(b);

                    C c = new C();
                    System.out.println(c);

                    D d = new D();
                    System.out.println(d);
                }
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
