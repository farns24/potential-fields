package model;

import model.potentialFields.PotentialField;

import java.util.ArrayList;

/**
 * Created by michael on 5/24/17.
 */
public class Arena {
    double maxX;
    double maxY;

    double[] goalPosition;
    ArrayList<double[]> obstaclePositions;
    PotentialField pF;
    Robot robot;

    public Arena(double maxX, double maxY) {
        this.maxX = maxX;
        this.maxY = maxY;
    }

    public void initPF() {
        //AttractiveField out of goalPosition
        //RepulsiveFields out of obstaclePositions
        //Set pF to CompositeField composed from ^
    }

    public void initRobot(double[] pos, double[] orientation) {
        robot = new Robot(pos, orientation);
    }

    public double getMaxX() {
        return maxX;
    }

    public double getMaxY() {
        return maxY;
    }

    public double[] getGoalPosition() {
        return goalPosition;
    }

    public void setGoalPosition(double[] goalPosition) {
        this.goalPosition = goalPosition;
    }

    public ArrayList<double[]> getObstaclePositions() {
        return obstaclePositions;
    }

    public void addObstaclePosition(double[] obstaclePosition) {
        this.obstaclePositions.add(obstaclePosition);
    }

    public int[] getPFVector(double[] location) {
        int[] pFLocation = convertCoordToField(location);
        int row = pFLocation[1];
        int col = pFLocation[0];
        return pF.getField()[row][col];
    }

    private int[] convertCoordToField(double[] pos) {
        //truncating intentionally
        int x = (int)pos[0]/10;
        int y = (int)pos[1]/10;
        return new int[] {x,y};
    }
}
