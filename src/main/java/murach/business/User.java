package murach.business;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class User implements Serializable {

    public User(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    private String firstName;
    private String lastName;
    private String email;
    private Date date;
    private String hear;
    private String[] noti;

    public User() {
    }
    public String getDate() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int month = cal.get(Calendar.MONTH) + 1; // Tháng bắt đầu từ 0 nên cần cộng thêm 1
        int year = cal.get(Calendar.YEAR);
        return day+"/"+month+"/"+year;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    public String[] getNoti() {
        return noti;
    }

    public void setNoti(String[] not) {
        this.noti = not;
    }

    public String getCon() {
        return con;
    }

    public void setCon(String con) {
        this.con = con;
    }
    private String con;
    public String getHear() {
        return hear;
    }

    public void setHear(String hear) {
        this.hear = hear;
    }

    public User(String firstName, String lastName, String email, Date date, String hear, String[] noti, String con) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.date= date;
        this.hear=hear;
        this.noti=noti;
        this.con=con;
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
