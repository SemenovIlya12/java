package ru.Semenov.Weapon;

public class Gun extends Pistol{

    private final int Speed;

    public Gun() {
        super(30);
        this.Speed = 30;
    }

    public Gun(int max) {
        super(max);
        this.Speed = max/2;
    }

    public Gun(int max, int Speed) {
        super(max);
        this.Speed = Speed;
    }


    @Override
    public void Shoot() {
        for (int i = 1; i <= this.Speed; i++) {
            if (this.Rounds > 0) {
                System.out.println("Bah!");
                this.Rounds --;
            } else System.out.println("Click! Unlucky bro");

        }
    }

    @Override
    public void Shoot(int Time) {
        for (int i = 1; i <= this.Speed*Time; i++) {
            if (this.Rounds > 0) {
                System.out.println("Bah!");
                this.Rounds --;
            } else System.out.println("Click! Unlucky bro");
        }
    }
}
