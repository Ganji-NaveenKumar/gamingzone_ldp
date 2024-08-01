package assignment4;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;
import java.util.Calendar;
public class ProgramExample {
    public static String findRange(Date signUpDate,Date currentDate){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(signUpDate);

        // Add 30 days to the signUpDate
        calendar.add(Calendar.DAY_OF_MONTH, 30);
        Date endDate = calendar.getTime(); // This is signUpDate + 30 days

        // Reset the calendar back to signUpDate
        calendar.setTime(signUpDate);

        // Subtract 30 days from the signUpDate
        calendar.add(Calendar.DAY_OF_MONTH, -30);
        Date startDate = calendar.getTime(); // This is signUpDate - 30 days

        if(startDate.after(currentDate) || startDate.equals(currentDate)){
            return "No range";
        }
        if(endDate.after(currentDate)){
            endDate=currentDate;
        }
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        String start=formatter.format(startDate);
        String end=formatter.format(endDate);
        return start+" "+end;
    }
    public static String findDate(Date pastSignUpDate,Date currentDate){
        Calendar todayCalendar = Calendar.getInstance();
        todayCalendar.setTime(currentDate);
        //the current year
        int currentYear = todayCalendar.get(Calendar.YEAR);

        // Create a Calendar instance for the given past date
        Calendar dateCalendar = Calendar.getInstance();
        dateCalendar.setTime(pastSignUpDate);

        // Extract the month and day from the past date
        int month = dateCalendar.get(Calendar.MONTH);
        int day = dateCalendar.get(Calendar.DAY_OF_MONTH);

        // Set the date in the current year
        todayCalendar.set(Calendar.YEAR, currentYear);
        todayCalendar.set(Calendar.MONTH, month);
        todayCalendar.set(Calendar.DAY_OF_MONTH, day);

        // Get the resulting date in the current year
        Date resultDate = todayCalendar.getTime();

        return findRange(resultDate,currentDate);
    }
    public static void main(String[] args) throws ParseException {
        Scanner sc=new Scanner(System.in);
        SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
        int n =Integer.parseInt(sc.nextLine());
        for(int i=0;i<n;i++){
            String str=sc.nextLine();
            String[] dates=str.split(" ");
            Date date=sdf.parse(dates[0]);
            Date todayDate=sdf.parse(dates[1]);
            System.out.println(findDate(date,todayDate));
        }
    }
}
