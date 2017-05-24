package model.potentialFields;

/**
 * Created by michael on 5/23/17.
 */
public class Main {
    public static void main(String[] args) {
        model.potentialFields.PotentialField field = new model.potentialFields.AttractionField(new int[] {3,3}, 10, 10);
//        PotentialField field = new RepulsionField(new int[] {3,3}, 100, 100);
        field.printVectors();
        System.out.println();
        field.printMagnitudes();
        System.out.println();
        field.printSpeeds();
        System.out.println();
        field.printSafeArea();
    }
}
