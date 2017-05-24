package model.potentialFields;

/**
 * Created by michael on 5/23/17.
 */
public class CompositeField extends PotentialField {
    PotentialField field1;
    PotentialField field2;

    public CompositeField(int height, int width, PotentialField field1, PotentialField field2) {
        super(null, height, width);
        this.field1 = field1;
        this.field2 = field2;
    }

    @Override
    protected void initialize() {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {
                field[i][j] = calcVector(i,j);
            }
        }
    }

    @Override
    protected int[] calcVector(int row, int col) {
        int xValue = field1.getField()[row][col][0] + field2.getField()[row][col][0];
        int yValue = field1.getField()[row][col][1] + field2.getField()[row][col][1];
        return new int[] {xValue, yValue};
    }

    @Override
    protected int calcSpeed(int[] vector) {
//        double mag = calcMagnitude(vector);
//        int value;
//        if (mag <= safeArea) value = 0;
//        else if (mag >= maxSpeed) value = (int)Math.round(maxSpeed);
//        else value = (int)Math.round(mag);
//        return value;
        return 0;
    }
}
