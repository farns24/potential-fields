package model.potentialFields;

/**
 * Created by michael on 5/23/17.
 */
public class RepulsionField extends PotentialField {

    private double cushion = 12.5;

    public RepulsionField(int[] objectLocation, int height, int width) {
        super(objectLocation, height, width);
    }

    @Override
    protected void initialize(PotentialField... fields) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {
                field[i][j] = calcVector(i,j);
            }
        }
    }

    @Override
    protected int[] calcVector(int row, int col) {
        if (row == objectLocation[1] && col == objectLocation[0]) return new int[] {0,0};
        int xValue = objectLocation[0] - col;
        int yValue = row - objectLocation[1];

        if (calcDistance(row, col) > 10) return new int[] {0, 0};

        return invert(xValue,yValue);
    }

    @Override
    protected int calcSpeed(int[] vector) {
        double mag = calcMagnitude(vector);
        if (mag == 0) return 0;
        int value;
        if (mag >= maxSpeed) {
            value = (int)Math.round(maxSpeed);
        } else {
            value = (int)Math.round(mag-2);
        }

        return value;
    }

    private int[] invert(int xValue, int yValue) {
        int newX = 10 - Math.abs(xValue);
        int newY = 10 - Math.abs(yValue);

        if (xValue > 0) newX = -newX;
        if (yValue > 0) newY = -newY;

        if (xValue == 0) newX = 0;
        if (yValue == 0) newY = 0;

        return new int[] {newX, newY};
    }
}
