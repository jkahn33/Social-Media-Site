package main.java.com.jkahn.social.objects;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name="status")
public class Status {
    @Id
    @Column(name="id_status")
    @GenericGenerator(name="generator", strategy="increment")
    @GeneratedValue(generator="generator")
    private int id;

    @Column(name="text")
    private String text;

    @ManyToOne
    @JoinColumn(name="creatorId", nullable=false)
    private User creator;
    @Column(name="month")
    private int month;
    @Column(name="day")
    private int day;
    @Column(name="year")
    private int year;
    @Column(name="day_of_week")
    private String dayOfWeek;

    public Status(String text, User creator, int month, int day, int year, String dayOfWeek){
        this.text = text;
        this.creator = creator;
        this.month = month;
        this.day = day;
        this.year = year;
        this.dayOfWeek = dayOfWeek;
    }
    public Status(){

    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public User getCreator() {
        return creator;
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

    public String getDayOfWeek() {
        return dayOfWeek;
    }
}
