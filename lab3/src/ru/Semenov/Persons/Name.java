package ru.Semenov.Persons;

public class Name {
    private final String Name;
    private String Surname;
    private String Otche;

    public Name(String name, String surname, String otche) {
        if ((name != null && !name.trim().isEmpty()) || ( surname != null && !surname.trim().isEmpty()) || ( otche != null && !otche.trim().isEmpty() )) {
            this.Name = name;
            this.Surname = surname;
            this.Otche = otche;
        } else {
            //this.Name = "Undefined";
            throw new IllegalArgumentException("Cant invoke name without having a name, surname or OTCHESTVO!!");
        }
    }

    public Name(String Name, String Surname) {
        this(Name, Surname, null);
    }

    public Name(String name) {
        this(name, null, null);
    }


    @Override
    public String toString() {
        return (this.Name != null ? this.Name + " " : "") + (this.Surname != null ? this.Surname + " " : "") + (this.Otche != null ? this.Otche + " " : "");
    }

}
