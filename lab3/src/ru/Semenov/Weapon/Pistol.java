package ru.Semenov.Weapon;

public class Pistol extends Weapon {
    //protected int Rounds;
    protected int MaxRounds;


    public Pistol(int rnds, int max) {
        //this.Rounds = rnds;
        super(rnds);
        this.MaxRounds = max;
    }

    public Pistol(int max) {
        //this.Rounds = 5;
        super(5);
        this.MaxRounds = max;
    }


    public int GetMax() {
        return this.MaxRounds;
    }

    @Override
    public int Reload(int count) {
        if (count < 0) {
            throw new IllegalArgumentException("Count of rounds to reload can`t be negative.");
        }

        if (this.Rounds + count > this.MaxRounds) {
            int overcap = Math.abs(this.MaxRounds - this.Rounds - count);
            this.Rounds = this.MaxRounds;
            return overcap;
        }

        this.Rounds += count;
        return count;
    }

    public String Discharge() {
        int Ds = this.Rounds;
        this.Rounds = 0;
        return "Discharged " + Ds + " rounds from pistol";
    }


    public boolean IsCharged() {
        return this.Rounds > 0 ? true : false;
    }

    @Override
    public void Shoot() {
        if (this.Rounds > 0) {
            System.out.println("Bah! ");
            this.Rounds --;
        } else System.out.println("Click! Unlucky bro");
    }

    public void Shoot(int triggers) {
        for (int i = 1; i <= triggers; i++) {
            this.Shoot();
        }
    }


}
