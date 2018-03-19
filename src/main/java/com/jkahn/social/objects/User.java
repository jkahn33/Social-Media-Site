package main.java.com.jkahn.social.objects;

import javax.persistence.*;

@Entity
@Table (name="\"user\"")
public class User {

    @Id
    @Column(name="id_user")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(name="first")
    private String first;
    @Column(name="last")
    private String last;
    @Column(name="email")
    private String email;
    @Column(name="month")
    private int month;
    @Column(name="day")
    private int day;
    @Column(name="year")
    private int year;

    public User(){

    }

    public User(String first, String last, String email, int month, int day, int year){
        this.first = first;
        this.last = last;
        this.email = email;
        this.month = month;
        this.day = day;
        this.year = year;
    }

    public String getFirst() {
        return first;
    }

    public String getLast() {
        return last;
    }

    public String getEmail() {
        return email;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public int getYear() {
        return year;
    }
}
