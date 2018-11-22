import java.time.LocalDate;
import java.time.LocalTime;
import java.time.YearMonth;

public class SolarCalculations {

    LocalDate localDate;
    public static final double T_FAJR_OMANI = 18;
    private static final int JDN_FROM_2000 = 2451545;
    private static final int STARTING_YEAR = 2000;
    private double longitude;
    private double latitude;
    public static final double T_ISHA_OMANI = 18;
    public static final double T_FAJR_MUSLIM_WORLD = 18;
    public static final double T_ISHA_MUSLIM_WORLD = 17;
    public static final double T_FAJR_ISNA = 17.5;
    public static final double T_ISHA_ISNA = 15;
    public static final double T_FAJR_EGYPTIAN = 19.5;
    public static final double T_ISHA_EGYPTION = 17.5;
    public static final double T_FAJR_UMMALQURAH = 18.5;
    public static final long MINUTES_ISHA_UMMALGURAH = 90;
    public static final double T_FAJR_KARACHI = 18;
    public static final double T_ISHA_KARACHI = 18;
    public static final int HANAFI = 2;
    public static final int NOT_HANAFI = 1;
    LocalTime sunRiseTime, sunSetTime, solarNoonTime;
    private String school;
    private String asrSchool;

    // solar equations
    private double jdn;
    private double jc;
    private double ml;
    private double ma;
    private double ee;
    private double c;
    private double stl;
    private double sta;
    private double srv;
    private double sal;
    private double mo;
    private double oc;
    private double sd;
    private double v;
    private double et;
    private double ucl;
    private double ha;
    private double SolarNoon;
    private double sunRise;
    private double sus;
    private int solarNoonH;
    private int solarNoonM;
    private int sunRiseH;
    private int sunRiseM;
    private int sunSetH;
    private int sunSetM;

    public SolarCalculations(int ucl, double longitude, double latitude, LocalDate date, String school, String asrSchool) {
        this.longitude = longitude;
        this.latitude = latitude;
        localDate = date;
        this.school = school;
        this.asrSchool = asrSchool;
        jdn = 2458430.5;
        this.ucl = ucl;
        compute();
    }

    private void compute() {
        //solar calculations
        jc = (jdn - 2451545) / 36525.0;
        ml = (280.46646 + jc * (36000.76983) + jc * 0.0003032) % 360;
        ma = 357.52911 + jc * (35999.05029 - 0.0001537 * jc);
        ee = 0.016708634 - jc * (0.000042037 + 0.0000001267 * jc);
        c = Math.sin(Math.toRadians(ma)) * (1.914602 - jc * (0.004817 + 0.000014 * jc)) + Math.sin(Math.toRadians(2 * ma)) * (0.019993 - 0.000101 * jc) + Math.sin(Math.toRadians(3 * ma)) * 0.000289;
        stl = ml + c;
        sta = ma + c;
        srv = (1.000001018 * (1 - Math.pow(ee, 2)) / (1 + ee * Math.cos(Math.toRadians(sta))));
        sal = stl - 0.00569 - 0.00478 * Math.sin(Math.toRadians(125.04 - 1934.136 * jc));
        mo = 23 + (26 + ((21.448 - jc * (46.815 + jc * (0.00059 - jc * 0.001813)))) / 60) / 60;
        oc = mo + 0.00256 * Math.cos(Math.toRadians(125.04 - 1934.136 * jc));
        sd = Math.toDegrees(Math.asin(Math.sin(Math.toRadians(oc)) * Math.sin(Math.toRadians(stl))));
        v = Math.pow(Math.tan(Math.toRadians(oc / 2)), 2);
        et = 4 * Math.toDegrees(v * Math.sin(Math.toRadians(2 * ml)) - 2 * ee * Math.sin(Math.toRadians(ma)) + 4 * ee * v * Math.sin(Math.toRadians(ma)) * Math.cos(Math.toRadians(2 * ml)) - 0.5 * v * v * Math.sin(Math.toRadians(4 * ml)) - 1.25 * ee * ee * Math.sin(Math.toRadians(2 * ma)));


        //Calculate sun rise time hour angle
        ha = Math.toDegrees((Math.acos(-Math.sin(Math.toRadians(0.833)) / (Math.cos(Math.toRadians(latitude)) * Math.cos(Math.toRadians(sd))) - Math.tan(Math.toRadians(latitude)) * Math.tan(Math.toRadians(sd)))));

        SolarNoon = (720 - 4 * longitude - et + ucl * 60) / 60.0;
        sunRise = SolarNoon - ha / 15.0;
        sus = SolarNoon + ha / 15.0;

        solarNoonH = (int) Math.floor(SolarNoon);
        solarNoonM = (int) Math.round((SolarNoon - solarNoonH) * 60);
        solarNoonTime = LocalTime.of(solarNoonH, solarNoonM);

        sunRiseH = (int) Math.floor(sunRise);
        sunRiseM = (int) Math.round((sunRise - sunRiseH) * 60);
        sunRiseTime = LocalTime.of(sunRiseH, sunRiseM);

        sunSetH = (int) Math.floor(sus);
        sunSetM = (int) Math.round((sus - sunSetH) * 60);
        sunSetTime = LocalTime.of(sunSetH, sunSetM);
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    /**
     * Calculate the julian date for the current date
     * @return the julian date of the current date
     */
    public double getJdn() {
        jdn = JDN_FROM_2000;

        //for each year greater than the year 2000 (defined in constants)
        for (int currentYear = localDate.getYear(); currentYear > STARTING_YEAR; currentYear--){

            //if the current year is a leap year (Arbitrarily any day and month)
            if(LocalDate.of(currentYear,5,5).isLeapYear()){
                jdn += 366;
            } else {
                jdn += 365;
            }
        }

        jdn += localDate.minusDays(1).getDayOfYear();

        jdn += 1/3.0;
        return jdn;
    }



    public double getJc() {
        return jc;
    }

    public double getMl() {
        return ml;
    }

    public double getMa() {
        return ma;
    }

    public double getEe() {
        return ee;
    }

    public double getC() {
        return c;
    }

    public double getStl() {
        return stl;
    }

    public double getSta() {
        return sta;
    }

    public double getSrv() {
        return srv;
    }

    public double getSal() {
        return sal;
    }

    public double getMo() {
        return mo;
    }

    public double getOc() {
        return oc;
    }

    public double getSd() {
        return sd;
    }

    public double getV() {
        return v;
    }

    public double getEt() {
        return et;
    }

    public double getHa() {
        return ha;
    }

    public double getUcl() {
        return ucl;
    }

    public double getSon() {
        return SolarNoon;
    }

    public double getSur() {
        return sunRise;
    }

    public double getSus() {
        return sus;
    }

    public LocalTime getSunRiseTime() {
        return sunRiseTime;
    }

    public LocalTime getSunSetTime() {
        return sunSetTime;
    }

    public LocalTime getSolarNoonTime() {
        return solarNoonTime;
    }

    public LocalTime getDhuhurTime() {
        return solarNoonTime.plusMinutes(5);
    }

    /**
     * Calculates and returns Maghrib Time
     * @return Maghrib Time
     */
    public LocalTime getMaghribTime() {
        return sunSetTime.plusMinutes(5);
    }

    /**
     * Calculates and returns Fajr Time depending on the islamic school
     *
     * @return Fajr Time
     */
    public LocalTime getFajrTime() {
        int fajrTimeH = (int) Math.floor(getFajtHour());
        int fajrTimeM = (int) Math.round((getFajtHour() - fajrTimeH) * 60);
        return LocalTime.of(fajrTimeH, fajrTimeM);
    }

    private double getFajtHour() {
        double T = 0;
        if (school.toLowerCase().equals("omani")) {
            T = T_FAJR_OMANI;
        } else if (school.toLowerCase().equals("muslim world league")) {
            T = T_FAJR_MUSLIM_WORLD;
        } else if (school.toLowerCase().equals("isna")) {
            T = T_FAJR_ISNA;
        } else if (school.toLowerCase().equals("egypt")) {
            T = T_FAJR_EGYPTIAN;
        } else if (school.toLowerCase().equals("umm alqura")) {
            T = T_FAJR_UMMALQURAH;
        } else if (school.toLowerCase().equals("karachi")) {
            T = T_FAJR_KARACHI;
        }

        double ho = Math.toDegrees(Math.acos((-Math.sin(Math.toRadians(T))) / (Math.cos(Math.toRadians(latitude)) * Math.cos(Math.toRadians(sd))) - Math.tan(Math.toRadians(latitude)) * Math.tan(Math.toRadians(sd))));
        double fajrHour = SolarNoon - ho / 15;
        return fajrHour;
    }

    /**
     * Calculates and returns Isha Time depending on the islamic school
     *
     * @return Isha Time
     */
    public LocalTime getIshaTime() {
        double T = 0;
        if (!school.equals("umm alqura")) {
            if (school.toLowerCase().equals("omani")) {
                T = T_ISHA_OMANI;
            } else if (school.toLowerCase().equals("muslim world league")) {
                T = T_ISHA_MUSLIM_WORLD;
            } else if (school.toLowerCase().equals("isna")) {
                T = T_ISHA_ISNA;
            } else if (school.toLowerCase().equals("egypt")) {
                T = T_ISHA_EGYPTION;
            } else if (school.toLowerCase().equals("karachi")) {
                T = T_ISHA_KARACHI;
            }
            double ho = Math.toDegrees(Math.acos((-Math.sin(Math.toRadians(T))) / (Math.cos(Math.toRadians(latitude)) * Math.cos(Math.toRadians(sd))) - Math.tan(Math.toRadians(latitude)) * Math.tan(Math.toRadians(sd))));
            double ishaTime = SolarNoon + ho / 15;
            int ishaTimeH = (int) Math.floor(ishaTime);
            int ishaTimeM = (int) Math.round((ishaTime - ishaTimeH) * 60);
            return LocalTime.of(ishaTimeH, ishaTimeM);
        } else {
            return getMaghribTime().plusMinutes(MINUTES_ISHA_UMMALGURAH);
        }

    }

    /**
     * Calculates and returns Asr Time depending on the islamic school hanafi or else
     *
     * @return Asr Time
     */
    public LocalTime getAsrTime() {
        double T = 0;
        if (asrSchool.toLowerCase().equals("hanafi")) {
            T = Math.toDegrees(Math.atan(1 / (HANAFI + Math.tan(Math.toRadians(latitude - sd)))));
        } else {
            T = Math.toDegrees(Math.atan(1 / (NOT_HANAFI + Math.tan(Math.toRadians(latitude - sd)))));
        }

        double ho = Math.toDegrees(Math.acos((Math.sin(Math.toRadians(T))) / (Math.cos(Math.toRadians(latitude)) * Math.cos(Math.toRadians(sd))) - Math.tan(Math.toRadians(latitude)) * Math.tan(Math.toRadians(sd))));
        double asrTime = SolarNoon + ho / 15;
        int asrTimeH = (int) Math.floor(asrTime);
        System.out.print(asrTime);
        System.out.print(asrTimeH);
        int asrTimeM = (int) Math.round((asrTime - asrTimeH - 0.01) * 60);
        return LocalTime.of(asrTimeH, asrTimeM).plusMinutes(5);
    }

    //للتحقق
    public LocalTime getMidNight() {
        int midH = getFajrTime().plusHours(sunSetTime.minusHours(getFajrTime().getHour() / 2).getHour()).getHour();
        int midM = getFajrTime().plusMinutes(sunSetTime.minusMinutes(getFajrTime().getMinute() / 2).getMinute()).getMinute();
        return LocalTime.of(midH, midM);
    }

    @Override
    public String toString() {
        return "SolarCalculations{" +
                "jdn=" + getJdn() +
                ", jc=" + getJc() +
                ", ml=" + getMl() +
                ", ma=" + getMa() +
                ", ee=" + getEe() +
                ", c=" + getC() +
                ", stl=" + getStl() +
                ", sta=" + getSta()+
                ", srv=" + getSrv() +
                ", sal=" + getSal() +
                ", mo=" + getMo() +
                ", oc=" + getOc() +
                ", sd=" + getSd() +
                ", v=" + getV() +
                ", et=" + getEt() +
                ", ha=" + getHa() +
                ", ucl=" + ucl +
                ", son=" + getSon() +
                ", sur=" + getSur() +
                ", sus=" + getSus() +
                '}';
    }
}
