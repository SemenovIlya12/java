public class Human {
    private String name;
    private int Height;

    public Human(String name, int Height) {
        this.name = name;
        this.Height = Height;
    }

    @Override
    public String toString() {
        return this.name + ", Height: " + this.Height;
    }
}
