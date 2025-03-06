public class Name {
    private String Name;
    private String Surname;
    private String Otche;

    public Name(String name, String surname, String otche) {
        this.Name = name;
        this.Surname = surname;
        this.Otche = otche;
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
