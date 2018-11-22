import java.awt.*;

/**
 * Robot
 * Class represents blueprint of Robot.
 */
public class Robot {

    private Point location;
    private String direction;

    public Robot() {
        location = new Point(0, 0);
        direction = "N";
    }

    public void turnLeft() {
        if (direction.equals("N")) {
            direction = "W";
        } else if (direction.equals("W")) {
            direction = "S";
        } else if (direction.equals("S")) {
            direction = "E";
        } else if (direction.equals("E")) {
            direction = "N";
        }
    }

    public void turnRight() {
        if (direction.equals("N")) {
            direction = "E";
        } else if (direction.equals("W")) {
            direction = "N";
        } else if (direction.equals("S")) {
            direction = "W";
        } else if (direction.equals("E")) {
            direction = "S";
        }
    }

    public void move() {
        int x = location.x;
        int y = location.y;

        if (direction.equals("N")) {
            location.setLocation(x, y + 1);
        } else if (direction.equals("W")) {
            location.setLocation(x - 1, y);
        } else if (direction.equals("S")) {
            location.setLocation(x, y - 1);
        } else if (direction.equals("E")) {
            location.setLocation(x + 1, y);
        }
    }

    public Point getLocation() {
        return location;
    }

    public String getDirection() {
        return direction;
    }

    public String toString() {
        return String.format("%d %d %s", location.x, location.y, direction);
    }
}