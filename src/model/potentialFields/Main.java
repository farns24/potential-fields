package model.potentialFields;

/**
 * Created by michael on 5/23/17.
 */
public class Main {
    public static void main(String[] args) {
        int height = 100;
        int width = 100;
        PotentialField field1 = new AttractionField(new int[] {20,42}, height, width);
        PotentialField field2 = new RepulsionField(new int[] {10,60}, height, width);
        PotentialField field3 = new RepulsionField(new int[] {41,49}, height, width);
        CompositeField field = new CompositeField(height, width, field1, field2, field3);
//        RandomField field = new RandomField(20, 20);
        field.printVectors();
        System.out.println();
        field.printMagnitudes();
        System.out.println();
        field.printSpeeds();
        System.out.println();
        field.printDistances();
        System.out.println();
        field.printArrows();
    }
}
