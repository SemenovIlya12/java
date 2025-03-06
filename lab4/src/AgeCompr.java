public class AgeCompr implements Comparable<AgeCompr> {
    private int age;

    public AgeCompr(int age) {
        this.age = age;
    }

    @Override
    public int compare(AgeCompr age) {
        return this.age - age.age;
    }

}
