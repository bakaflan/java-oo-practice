package com.twu;

public class User {
    private String username;
    private UserType userType;
    private int numOfVotes;

    public User(String username,UserType userType) {
        this.username = username;
        this.userType = userType;
        this.numOfVotes = 10;
    }

    public void setNumOfVotes(int numOfVotes) {
        this.numOfVotes = numOfVotes;
    }

    public String getUsername() {
        return username;
    }

    public int getNumOfVotes() {
        return numOfVotes;
    }

    public void vote(int numOfVote){
        this.numOfVotes -= numOfVote;
    }
}
