import com.zjx.Student;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;

/**
 * @author zhaojiaxing
 * @version 1.0
 * @Date 2019/12/30 10:06
 */
public class ListTest {
    public static void main(String[] args) {
//        LocalDateTime local = LocalDateTime.now();
        LocalDate date = LocalDate.now();
        LocalDate date1 = LocalDate.of(2020, 01, 02);
        LocalDateTime local = LocalDateTime.of(2020, 01, 02, 13, 34, 23);
        LocalDateTime local2 = local.plusDays(1);
        System.out.println(local.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

        Calendar ca = Calendar.getInstance();
        ca.add(Calendar.DATE,5);
        System.out.println(ca.getTime());

    }

}
