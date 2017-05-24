package model.potentialFields;

import java.util.ArrayList;

/**
 * Created by michael on 5/23/17.
 */
public class CompositeField extends PotentialField {
    ArrayList<PotentialField> fields;

    public CompositeField(int height, int width, PotentialField... fields) {
        super(null, height, width, fields);
    }

    @Override
    protected void initialize(PotentialField... fields) {
        this.fields = new ArrayList<PotentialField>();
        for (PotentialField pF: fields) {
            this.fields.add(pF);
            if (pF.getClass() == AttractionField.class) {
                objectLocation = pF.getObjectLocation();
            }
        }
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {
                field[i][j] = calcVector(i,j);
            }
        }
    }

    @Override
    protected int[] calcVector(int row, int col) {
        int xValue = 0;
        int yValue = 0;
        for (PotentialField pF : fields) {
            if (!(row == pF.getObjectLocation()[0] && col == pF.getObjectLocation()[1])) {
                xValue += pF.getField()[row][col][0];
                yValue += pF.getField()[row][col][1];
            } else {
                xValue = 0;
                yValue = 0;
                break;
            }
        }
        if (calcDistance(row, col) <= safeArea) {
            xValue = 0;
            yValue = 0;
        }
        return new int[] {xValue, yValue};
    }

    @Override
    protected int calcSpeed(int[] vector) {
        double mag = calcMagnitude(vector);
        int value;
        if (mag <= safeArea) value = 0;
        else if (mag >= maxSpeed) value = (int)Math.round(maxSpeed);
        else value = (int)Math.round(mag);
        return value;
    }
}
