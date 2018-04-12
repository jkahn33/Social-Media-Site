package main.java.com.jkahn.social.objects;

import java.util.List;

public class HomepageData {
    private List<Status> statuses;
    private User user;

    public HomepageData(List<Status> statuses, User user){
        this.user = user;
        this.statuses = statuses;
    }

    public List<Status> getStatuses() {
        return statuses;
    }

    public User getUser() {
        return user;
    }
}
