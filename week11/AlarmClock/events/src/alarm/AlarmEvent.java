package alarm;

public class AlarmEvent {

    private int nrings; // 0 by default

    public AlarmEvent(int nrings) {
        setNrings(nrings);
    }

    public int getNrings() {
        return nrings;
    }

    public void setNrings(int nrings) {
        if (nrings < 0) {
            this.nrings = 0;
        } else {
            this.nrings = nrings;
        }
    }
}
