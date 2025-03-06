public class Time {
    private int ss = 0;
    private int mm = 0;
    private int hh = 0;

    public Time(int seconds) {
        while (seconds >= 86400) {
            seconds -= 86400;
        }

        this.hh = seconds / 3600;
        seconds -= this.hh * 3600;
        this.mm = seconds/60;
        seconds -= this.mm*60;
        this.ss = seconds;
    }


    @Override
    public String toString() {
        return (this.hh < 9 ? "0" + this.hh : this.hh) + "." + (this.mm < 9 ? "0" + this.mm : this.mm) + "." + (this.ss < 9 ? "0" + this.ss : this.ss);
    }
}
