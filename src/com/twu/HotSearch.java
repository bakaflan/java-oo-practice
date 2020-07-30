package com.twu;

public class HotSearch {
    private int rank;
    private boolean isBuyRank;
    private String description;
    private int hot;
    private boolean isSuperHotSearch;

    public HotSearch(String description) {
        this.rank = -1;
        this.description = description;
    }

    public HotSearch(String description, boolean isSuperHotSearch) {
        this.rank = -1;
        this.description = description;
        this.isSuperHotSearch = isSuperHotSearch;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
        this.isBuyRank = true;
    }

    public boolean isBuyRank() {
        return isBuyRank;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getHot() {
        return hot;
    }

    public void setHot(int hot) {
        this.hot = hot;
    }

    public void vote(int num){
        if(isSuperHotSearch){
            this.hot += num*2;
        }else {
            this.hot += num;
        }
    }
}
