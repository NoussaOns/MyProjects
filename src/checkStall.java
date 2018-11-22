import java.util.Scanner;

class StallLogic {
    public void printStalls(boolean[] b) {
        for (boolean s : b) {
            System.out.print((s ? "X" : "_") + " ");
        }
        System.out.print("\n");
    }

    public boolean giveFlag(boolean[] b) {
        for (boolean s : b) {
            if (!s) return false;
        }
        return true;
    }

    public int getLongest(boolean[] b) {
        int length = 0, temp = 0;
        int len = b.length;
        for (int i = 0; i < len; i++) {
            if (b[i] == false) {
                temp++;
            } else {
                temp = 0;
            }
            if (length < temp)
                length = temp;
        }
        return length;
    }

    public int checkIndex(boolean[] b) {
        int length = 0, temp = 0, ind = 0;
        int len = b.length;
        for (int i = 0; i < len; i++) {
            if (b[i] == false) {
                temp++;
            } else {
                temp = 0;
            }
            if (length < temp) {
                ind = i - length;
                length = temp;
            }
        }
        return ind;
    }

    public void findStalls(boolean[] b) {
        int loc = checkIndex(b);
        int len = getLongest(b);
        int ind = loc + len / 2;
        b[ind] = true;
    }
}

public class checkStall {
    public static void main(String[] args) {
        StallLogic stallin = new StallLogic();
        System.out.print("Enter number of stalls");
        Scanner in = new Scanner(System.in);
        int i = in.nextInt();
        boolean[] stalls = new boolean[i];
        while (!stallin.giveFlag(stalls)) {
            stallin.findStalls(stalls);
            stallin.printStalls(stalls);
        }

    }

}