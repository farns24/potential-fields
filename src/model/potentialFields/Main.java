package model.potentialFields;

/**
 * Created by michael on 5/23/17.
 */
public class Main {
    public static void main(String[] args) {
        PotentialField field1 = new AttractionField(new int[] {5,5}, 20, 20);
        PotentialField field2 = new RepulsionField(new int[] {15,15}, 20, 20);
        PotentialField field3 = new RepulsionField(new int[] {1,1}, 20, 20);
        CompositeField field = new CompositeField(20, 20, field1, field2, field3);
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
