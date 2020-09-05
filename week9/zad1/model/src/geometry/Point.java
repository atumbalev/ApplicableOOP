package geometry;

public class Point {
    private int[] coords; //the x and y coordinates

    public Point(int[] coords) {
        setCoords(coords);
    }

    public Point() {
        this(new int[2]); //point with coords 0;0
    }

    public Point(Point p) {
        this(p.getCoords());
    }

    public int[] getCoords() {
        int[] copy = new int[coords.length];
        for (int i = 0; i < coords.length; i++){
            copy[i] = coords[i];
        }
        return copy;
    }

    public void setCoords(int[] coords) {
        if (coords != null && coords.length == 2){
            this.coords = new int[2];
            for (int i = 0; i < coords.length; i++){
                this.coords[i] = coords[i];
            }
        }
        else {
            this.coords = new int[]{0, 0}; // point with coords 0; 0
        }
    }

    @Override
    public String toString() {
        return String.format("(%d; %d)", coords[0], coords[1]);

    }
}
