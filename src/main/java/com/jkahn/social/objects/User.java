package main.java.com.jkahn.social.objects;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name="\"user\"")
@Component
@Indexed
@Scope("session")
public class User {

    @Id
    @Column(name="id_user")
    @GenericGenerator(name="generator", strategy="increment")
    @GeneratedValue(generator="generator")
    private int id;

    @Column(name="first")
    private String first;
    @Column(name="last")
    private String last;
    @Column(name="email")
    @Field
    private String email;
    @Column(name="month")
    private int month;
    @Column(name="day")
    private int day;
    @Column(name="year")
    private int year;
    @Column
    private int totalDate;
    @OneToMany(mappedBy = "creator")
    private List<Status> statuses;

    public User(){

    }

    public User(String first, String last, String email, int month, int day, int year, int totalDate){
        this.first = first;
        this.last = last;
        this.email = email;
        this.month = month;
        this.day = day;
        this.year = year;
        this.totalDate = totalDate;
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

    public int getTotalDate(){
        return totalDate;
    }
}
