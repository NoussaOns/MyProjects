/**
 * To test Robot class for 2X2 square both clock-wise and anti-clockwise
 */
public class RobotTest {
    public static void main(String args[]) throws Exception {
        Robot robot = new Robot();

        //ClockWise movement

        //First initial corner 0,0 facing N
        System.out.println(robot.toString());

        robot.move();
        robot.move();
        robot.turnRight();

        //Second  corner 0,2 facing E
        System.out.println(robot.toString());

        robot.move();
        robot.move();
        robot.turnRight();

        //Third  corner 2,2 facing S
        System.out.println(robot.toString());

        robot.move();
        robot.move();
        robot.turnRight();

        //Fourth  corner 2,0 facing W
        System.out.println(robot.toString());

        robot.move();
        robot.move();
        robot.turnRight();

        //Again on First  corner 0,0 facing N
        System.out.println(robot.toString());


        //Anti-ClockWise movement
        System.out.println();
        robot.turnRight();
        //First initial corner 0,0 facing N
        System.out.println(robot.toString());

        robot.move();
        robot.move();
        robot.turnLeft();

        //Second  corner 2,0 facing E
        System.out.println(robot.toString());

        robot.move();
        robot.move();
        robot.turnLeft();

        //Third  corner 2,2 facing N
        System.out.println(robot.toString());

        robot.move();
        robot.move();
        robot.turnLeft();

        //Second  corner 0,2 facing W
        System.out.println(robot.toString());

        robot.move();
        robot.move();
        robot.turnLeft();

        //Intital  corner 0,0 facing S
        System.out.println(robot.toString());

        robot.move();
        robot.move();
        robot.turnLeft();
    }
}