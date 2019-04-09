
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateQ {


       public static String  timeScreenShot(){
           SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH.mm.ss");

           String dateString = format.format( new Date());
           //System.out.println(dateString);
           return dateString;

       }


    public static void main(String[] args) {
        timeScreenShot();
    }



}
