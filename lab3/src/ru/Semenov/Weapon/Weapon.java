package ru.Semenov.Weapon;

abstract public class Weapon {
    protected int Rounds;

    public Weapon(int ammo) {
        this.Rounds = ammo;
    }


    public int GetRounds() {
        return this.Rounds;
    }


    public int Reload(int ammo) {
        if (ammo < 0) throw new RuntimeException();
        int tmp = ammo;
        this.Rounds = ammo;
        return tmp;
    }

    @Override
    public String toString() {
        return Integer.toString(this.Rounds);
    }

    public abstract void Shoot();

}
