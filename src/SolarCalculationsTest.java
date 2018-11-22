import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class SolarCalculationsTest {
    public static void main(String[] args){


        // format dates to the given pattern of am and pm
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");
        LocalDate localDate = LocalDate.of(2018, 11, 7);
        SolarCalculations solarCalculations = new SolarCalculations(1, 22.933, 57.533, localDate, "omani".trim(), "not hanafi");

//        //System.out.println(l.minusDays(1).getDayOfYear());


        System.out.println("Sun Rise: " + formatter.format(solarCalculations.getSunRiseTime()));
        System.out.println("Solar Noon: " + formatter.format(solarCalculations.getSolarNoonTime()));
        System.out.println("Sun Set: " + formatter.format(solarCalculations.getSunSetTime()));
        System.out.println("Fajr: " + formatter.format(solarCalculations.getFajrTime()));
        System.out.println("Dhuhur: " + formatter.format(solarCalculations.getDhuhurTime()));
        System.out.println("Asr: " + formatter.format(solarCalculations.getAsrTime()));
        System.out.println("Maghrib: " + formatter.format(solarCalculations.getMaghribTime()));
        System.out.println("Isha: " + formatter.format(solarCalculations.getIshaTime()));
        System.out.println("Mid Night: " + formatter.format(solarCalculations.getMidNight()));
        System.out.println(solarCalculations);

    }
}
