package main.java.com.jkahn.social.objects;

import javax.xml.bind.annotation.XmlElement;

public class SentUser {
    @XmlElement private String first;
    @XmlElement private String last;
    @XmlElement private String email;

    public SentUser(){

    }

    public SentUser(String first, String last, String email){
        this.first = first;
        this.last = last;
        this.email = email;
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
}
