public class ComboLock {

    int secret1, secret2, secret3;

    int dial = 0;

    int number1, number2, number3;

    int count = 0;

    boolean turnRight = true;

    public ComboLock(int secret1, int secret2, int secret3) {

        this.secret1 = secret1;

        this.secret2 = secret2;

        this.secret3 = secret3;

    }

    public void reset() {

//reset all values

        this.dial = 0;

        this.number1 = 0;

        this.number2 = 0;

        this.number3 = 0;

    }

    public void turnRight(int ticks) {

        if (count == 0) {

            int tempdial = this.dial + ticks;

            if (tempdial > 40) {

                this.dial = tempdial - 40;//for set value to less then 39 and greater then 0

            } else

                this.dial = tempdial;

            number1 = this.dial;

        }

        if (count == 2) {

            int tempdial = this.dial + ticks;

            if (tempdial > 40) {

                this.dial = tempdial - 40;//for set value to less then 39 and greater then 0

            } else

                this.dial = tempdial;

            number3 = this.dial;

        }

    }

    public void turnLeft(int ticks) {

        if (count == 1) {

            int tempdial = this.dial - ticks;

            if (tempdial < 0) {

                this.dial = 40 + tempdial;//for set value to less then 39 and greater then 0

            } else

                this.dial = tempdial;

        }

        number2 = this.dial;

    }

    public boolean open() {

        if (number1 == secret1) {

            if (number2 == secret2)

                if (number3 == secret3)

                    return true;

                else

                    count = 2;

            else

                count = 1;

        } else

            count = 0;

        return false;

    }

}