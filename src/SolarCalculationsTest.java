import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class SolarCalculationsTest {
    public static void main(String[] args){


        // format dates to the given pattern of am and pm
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");
        LocalDate localDate = LocalDate.of(2017, 1, 28);
        SolarCalculations solarCalculations = new SolarCalculations(4,58.183,23.620,localDate);

//        //System.out.println(l.minusDays(1).getDayOfYear());
       solarCalculations.calculateSolarValues();
//      System.out.println(solarCalculations.getJdn());
//        //System.out.println(solarCalculations.isLeapYear());
//        System.out.println(solarCalculations.getJdn());
//        System.out.println(solarCalculations.getJc());
//        System.out.println(solarCalculations.getMa());
//        System.out.println(solarCalculations.getOc());
//       System.out.println(solarCalculations.toString());
////
////
////
////        System.out.println(solarCalculations.getJdn());
////

       System.out.println(formatter.format(solarCalculations.getSunRiseTime()));
       System.out.println(formatter.format(solarCalculations.getSolarNoonTime()));
       System.out.println(formatter.format(solarCalculations.getSunSetTime()));
    }
}
