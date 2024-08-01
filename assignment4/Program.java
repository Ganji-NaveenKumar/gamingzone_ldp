package assignment4;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.*;
import java.util.Calendar;
public class Program {
    public static String printRange(Date start, Date end,Date today){
        if(end.after(today)){
            end=today;
        }
        if(start.after(today) || start.equals(today)){
            return "No range";
        }
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        String startDate=formatter.format(start);
        String endDate=formatter.format(end);
        return startDate+" "+endDate;
    }
    public static  String getRange(String signUpDate,String currentDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date kycStartDate;
        Date todayDate;
        try {
            kycStartDate = sdf.parse(signUpDate);
            todayDate = sdf.parse(currentDate);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        Calendar startCalendar = Calendar.getInstance();
        startCalendar.setTime(kycStartDate);

        Calendar todayCalendar = Calendar.getInstance();
        todayCalendar.setTime(todayDate);
        int yearDiff = todayCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR);
        startCalendar.add(Calendar.DAY_OF_MONTH, -30);
        startCalendar.add(Calendar.YEAR, yearDiff); // Add year difference
        Date previousDate = startCalendar.getTime();
        startCalendar.setTime(kycStartDate);
        startCalendar.add(Calendar.DAY_OF_MONTH, 30);
        startCalendar.add(Calendar.YEAR, yearDiff); // Add year difference
        Date futureDate = startCalendar.getTime();
        return printRange(previousDate,futureDate,todayDate);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n =Integer.parseInt(sc.nextLine());
        ArrayList<String> results=new ArrayList<>();

        for (int i=0;i<n;i++) {
            String inputLine=sc.nextLine();
            String[] dates=inputLine.split(" ");
            String signupDateStr=dates[0];
            String currentDateStr=dates[1];
            String result=getRange(signupDateStr, currentDateStr);
            results.add(result);
        }

        for (String result : results) {
            System.out.println(result);
        }

        sc.close();
    }
}
