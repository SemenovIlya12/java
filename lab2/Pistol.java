public class Pistol {
    private int Rounds;

    public Pistol(int rnds) {
        this.Rounds = rnds;
    }

    public Pistol() {
        this.Rounds = 5;
    }

    public void Shoot() {
        if (this.Rounds > 0) {
            System.out.println("Bah!");
            this.Rounds --;
        } else System.out.println("Click! Unlucky bro");
    }

}
