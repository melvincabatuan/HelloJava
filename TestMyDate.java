public class TestMyDate {
 public static void main(String[] args) {
 MyDate my_birth = new MyDate(13, 3, 1983);
 MyDate the_next_week = my_birth.addDays(8);

 System.out.println(the_next_week);
 }
}
