import java.util.Scanner;

public class ComboLockTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Combination: ");
//read combination
        int secret1 = sc.nextInt();
        int secret2 = sc.nextInt();
        int secret3 = sc.nextInt();


        ComboLock lock = new ComboLock(secret1, secret2, secret3);
        int c1 = 0;//for lock bloked or not
        boolean opened = false;
        boolean turningRight = true;
        while (!opened) {
            if (turningRight)
                System.out.print("Right: ");
            else
                System.out.print("Left: ");
            int ticks = sc.nextInt();//read ticks
            if (turningRight) {
                lock.turnRight(ticks);
            } else {
                lock.turnLeft(ticks);
            }
            turningRight = !turningRight;
            opened = lock.open();
            if (c1 >= 3)//more then three times means lock blocked
            {
                System.out.print("Lock blocked.");
                return;
            }
            c1++;
        }
        System.out.println("Locked Opened");
    }
}