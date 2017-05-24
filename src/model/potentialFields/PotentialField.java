package model.potentialFields;

/**
 * Created by michael on 5/23/17.
 */
public abstract class PotentialField {
    /**
     * int[rows][columns][vectors]
     * vector = [xVal,yVal]
     */
    protected int[][][] field;
    protected int[] objectLocation;
    protected double safeArea = 2.0;
    protected double maxSpeed = 8.0;

    public PotentialField(int[] objectLocation, int height, int width) {
        field = new int[height][width][2];
        this.objectLocation = objectLocation;
        initialize();
    }

    public int[][][] getField() {
        return field;
    }

    public int[] getObjectLocation() {
        return objectLocation;
    }

    public void setObjectLocation(int[] objectLocation) {
        this.objectLocation = objectLocation;
    }

    public void printVectors() {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {
                System.out.printf("[%3d, %3d]  ", field[i][j][0], field[i][j][1]);
            }
            System.out.println();
        }
    }

    public void printMagnitudes() {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {
                System.out.printf("%6.2f  ", calcMagnitude(field[i][j]));
            }
            System.out.println();
        }
    }

    public void printSpeeds() {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {
                int value = calcSpeed(field[i][j]);
                System.out.printf("%2d ", value);
            }
            System.out.println();
        }
    }

    public void printSafeArea() {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {
                System.out.printf("%6.2f  ", calcDistance(i,j));
            }
            System.out.println();
        }
    }

    protected abstract void initialize();

    protected abstract int[] calcVector(int row, int col);

    protected abstract int calcSpeed(int[] vector);

    protected double calcMagnitude(int[] vector) {
        int adjustment = 0;
        if (vector[0] == 0 || vector[1] == 0) adjustment = 4;
        if (vector[0] == 0 && vector[1] == 0) adjustment = 0;
        double firstTerm = Math.pow((vector[0]),2);
        double secondTerm = Math.pow((vector[1]),2);
        return Math.sqrt(firstTerm+secondTerm) + adjustment;
    }

    protected double calcDistance(int row, int col) {
        double firstTerm = Math.pow((objectLocation[0] - col), 2);
        double secTerm = Math.pow((objectLocation[1] - row), 2);
        return Math.sqrt(firstTerm+secTerm);
    }
}
