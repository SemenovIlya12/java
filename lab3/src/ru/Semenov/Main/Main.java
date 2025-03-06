package ru.Semenov.Main;

import ru.Semenov.Geometry.*;
import ru.Semenov.Persons.*;
import ru.Semenov.Weapon.*;

import java.security.spec.ECField;
import java.util.Scanner;

public class Main {

    public static double power(String x, String y ){
        return Math.pow(Integer.parseInt(x), Integer.parseInt(y));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Write number of a task: ");
        try {
            int id = sc.nextInt();

            switch (id) {
                case 1: {
                    Pistol p = new Pistol(0, 7);
                    p.Reload(3);
                    p.Shoot(5);
                    p.Reload(8);
                    p.Shoot(2);
                    p.Discharge();
                    p.Shoot();
                } break;
                case 2: {
                    Name normal = new Name("Vladimir");
                    Name normal2 = new Name("Vladimir", "Mayakovski");
                    Name normal3 = new Name("Segey", "Sergeyevich", "Sergeev");

                    System.out.println(normal);
                    System.out.println(normal2);
                    System.out.println(normal3);

                    Thread.sleep(3000);
                    //Name Abnormal = new Name(" ");
                    Name Abnormal2 = new Name(null);  // Выкидывает ошибку.
                } break;
                case 3: {
                    PhoneVocab vb = new PhoneVocab();
                    System.out.println(vb);

                    vb.Add("11-11", "Ivan");
                    vb.Add("12-12", "Ian");
                    System.out.println(vb.GetNumber("Ben"));
                    System.out.println(vb.GetNumber("Ben2"));

                    System.out.println(vb.IsInVocab("11-11"));
                    vb.Remove("Volodimir");

                    System.out.println(vb.GetSize());

                    System.out.println(vb);
                    System.out.println("");

                    System.out.println(vb.GetNamesBySubstring("I"));
                    System.out.println("");
                    System.out.println(vb.GetAllNames());
                    System.out.println("");
                    System.out.println(vb.GetAllNumbers());
                    System.out.println("");
                    System.out.println(vb.GetAllPairs());


                } break;
                case 4: {
                    //Gun g = new Gun();   // 30/30
                    //Gun g = new Gun(4);
                    Gun g = new Gun(4, 2);
                    //g.Reload(5);
                    System.out.println(g.GetRounds());
                    //g.Shoot(2);
                    g.Shoot(3);
                } break;
                case 5: {
                    Shooter s1 = new Shooter("Mike");


                    Shooter s2 = new Shooter("2");
                    Pistol g2 = new Pistol(3,5);
                    s2.SetWeapon(g2);

                    Shooter s3 = new Shooter("3");
                    Gun g3 = new Gun(10,2);
                    s3.SetWeapon(g3);

                    s1.Shoot();
                    s2.Shoot();
                    s3.Shoot();

                } break;
                case 6: {
                    Point p1 = new Point(2,4);
                    Point p2 = new Point(2, 4);
                    Point p3 = new Point(2, 8);

                    System.out.println("Does point "+ p1 + " equals to " + p2 + "?: " + p1.equals(p2));
                    System.out.println("Does point "+ p1 + " equals to " + p3 + "?: " + p1.equals(p3));
                } break;
                case 7 : {
                    if (args.length < 2) throw new IllegalArgumentException();

                    System.out.println(power(args[0], args[1]));

                } break;

            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}

// 89091054350