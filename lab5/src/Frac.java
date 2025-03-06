import java.util.Objects;

public class Frac implements FracInt {
    private int chisl;
    private int znam;

    @Override
    public double getValue() {
        return (double) chisl/znam;
    }

    @Override
    public void setChisl(int num) {
        this.chisl = num;
    }

    @Override
    public void setZnam(int num) {
        this.znam = num;
    }



    public Frac(int chisl, int znam) {
        if (znam == 0) throw new IllegalArgumentException("For real?");
        if (znam < 0) throw new IllegalArgumentException("Знаменатель не должен быть равным нулю.");
        this.chisl = chisl;
        this.znam = znam;


    }

    @Override
    public String toString() {
        return chisl + "/" + znam;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Frac FrObj = (Frac) o;
        return this.znam == FrObj.znam && this.chisl == FrObj.chisl;
    }

    @Override
    public int hashCode() {
        return Objects.hash(chisl, znam);
    }


}
