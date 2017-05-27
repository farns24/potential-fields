package model;

import java.util.Arrays;

import model.potentialFields.PotentialField;

public class RobotLocation {

	private double[][] corners;
	
	private double[] orientation;
	
	private double[] center;

	public double[][] getCorners() {
		return corners;
	}

	public void setCorners(double[][] corners) {
		this.corners = corners;
	}

	public double getOrientation() {
		return Math.atan2(orientation[1],orientation[0]* -1.0);//orientation;
	}

	public void setOrientation(double[] orientation) {
		this.orientation = orientation;
	}

	private int[] convertCoordToField(double[] pos) {
        //truncating intentionally
        int x = (int)pos[0]/10;
        int y = (int)pos[1]/10;
        return new int[] {x,y};
    }
	@Override
	public String toString() {
		return "RobotLocation [corners=" + Arrays.toString(corners)
				+ ", orientation=" + Arrays.toString(orientation) + ", center="
				+ Arrays.toString(center) + "]";
	}

	public int[] getCenter() {
		if (center==null)
		{
			return null;
		}
		return convertCoordToField(center);
	}

	public void setCenter(double[] center) {
		this.center = center;
	}

    public int[] getPFVector(PotentialField pF) {
        int[] pFLocation = getCenter();
        int row = pFLocation[1];
        int col = pFLocation[0];
        return pF.getField()[row][col];
    }
    
    public double getGoalTheta(int[] pos)
    {
    	double[] convert = new double[pos.length];
    	for (int i= 0; i<pos.length;i++)
    	{
    		convert[i] = pos[i];
    	}
    	
    	return Math.atan2(convert[1],convert[0]);
    }
}
