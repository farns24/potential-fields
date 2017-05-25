package model.potentialFields;

import java.util.ArrayList;

/**
 * Created by michael on 5/23/17.
 */
public class Main {
    public static void main(String[] args) {
        int height = 10;
        int width = 10;
        PotentialField field = new AttractionField(new int[] {4,4}, height, width);
        //PotentialField field2 = new RepulsionField(new int[] {10,60}, height, width);
        //PotentialField field3 = new RepulsionField(new int[] {41,49}, height, width);
        //CompositeField field = new CompositeField(height, width, new ArrayList<PotentialField>(new PotentialField[]{field1}));
//        RandomField field = new RandomField(20, 20);
        field.printVectors();
        System.out.println();
//        field.printMagnitudes();
//        System.out.println();
//        field.printSpeeds();
//        System.out.println();
//        field.printDistances();
//        System.out.println();
//        field.printArrows();
        
        while (true)
        {
        	
        }
        
    }
}
