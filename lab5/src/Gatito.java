public class Gatito implements Meowing {
    private String name;


    public Gatito(String name) {
        if (name.isEmpty()) throw new IllegalArgumentException("НАЗОВИ КОТЕНКА, ПОЧЕМУ ОН ОБЯЗАН БЫТЬ БЕЗ ИМЕНИ??? ");
        this.name = name;
    }

    @Override
    public String toString() {
        return "Gatitoo!: " + this.name;
    }

    @Override
    public void meow(){
        System.out.println(this.name + ": MEOOOOW");
    }
}
