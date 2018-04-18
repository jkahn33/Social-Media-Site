package main.java.com.jkahn.social.objects;

import javax.xml.bind.annotation.XmlElement;

public class SentStatus {
    @XmlElement private String text;

    public SentStatus(){

    }
    public SentStatus (String text){
        this.text = text;
    }
    public String getText(){
        return text;
    }
}
