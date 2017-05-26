package model.potentialFields;

import java.util.ArrayList;

/**
 * Created by michael on 5/23/17.
 */
public class Main {
    public static void main(String[] args) {
        int height = 50;
        int width = 50;

        ArrayList<PotentialField> fields = new ArrayList<>();
        fields.add(new AttractionField(new int[] {5,5}, height, width));
//        fields.add(new RepulsionField(new int[] {20,30}, height, width));
//        fields.add(new RepulsionField(new int[] {30,20}, height, width));
//        fields.add(new TangentialField(new int[] {30,20}, height, width));
        fields.add(new TangentialField(new int[] {30,20}, height, width));
        CompositeField field = new CompositeField(height, width, fields);
//        RandomField field = new RandomField(20, 20);
//        field.printVectors();
//        System.out.println();
//        field.printMagnitudes();
//        System.out.println();
//        field.printSpeeds();
//        System.out.println();
//        field.printDistances();
//        System.out.println();
        field.printArrows();
        
    }
}
