//Import required packages

import java.awt.*;

import java.util.ArrayList;

//Declare class

public class Cannonball {

    //Declare variables

    private double xPosition;

    private double yPosition;

    private double xVelocity;

    private double yVelocity;

    //Constructor for Cannonball

    public Cannonball(double xPosition) {

        this.xPosition = xPosition;

        yPosition = 0;

        xVelocity = 0;

        yVelocity = 0;

    }


    //Implement the method move

    public void move(double deltaSec) {

        //Compute the distance travelled

        double xDistTraveled = xVelocity * deltaSec;

        double yDistTraveled = yVelocity * deltaSec + (1 / 2)

                * -9.81 * deltaSec * deltaSec;

        xPosition = xPosition + xDistTraveled;

        yPosition = yPosition + yDistTraveled;

        yVelocity = yVelocity + -9.81 * deltaSec;

    }

    // The getLocation() gets the current location of the cannonball

    public Point getLocation() {

        Point point = new Point((int) xPosition, (int) yPosition);

        return point;

    }

    //shoot method for the cannon ball.

    public ArrayList<Point> shoot(double alpha, double v, double deltaSec) {

        ArrayList<Point> points = new ArrayList<Point>();

        xVelocity = v * Math.cos(Math.toRadians(alpha));

        yVelocity = v * Math.sin(Math.toRadians(alpha));

        points.add(getLocation());

        move(deltaSec);

        points.add(getLocation());

        while (yPosition > 0) {

            move(deltaSec);

            points.add(getLocation());

        }

        return points;

    }

}