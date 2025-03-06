package ru.Semenov.Persons;

import ru.Semenov.Weapon.*;

public class Shooter {
    private String name;
    private Weapon weapon = null;

    public Shooter(String name) {
            this.name = name;
    }

    public void SetName(String name) {
        this.name = name;
    }

    public void SetWeapon(Weapon w) {
        this.weapon = w;
    }

    public void Shoot() {
        if (this.weapon != null) {
            weapon.Shoot();
        } else System.out.println(this.name + ": i cant participate in shooting without a weapon");
    }

}
