package com.twu;

import java.util.*;

public class RankingList {
    private List<HotSearch> rankingList;
    private Map<Integer,Integer> bugRanking;

    public RankingList() {
        this.rankingList = new ArrayList<>();
    }

    public void addHotSearch(HotSearch hotSearch){
        Optional<HotSearch> optionalHotSearch = rankingList.stream()
                .filter(e -> e.getDescription().equals(hotSearch.getDescription()))
                .findFirst();
        if(optionalHotSearch.isPresent()){
            System.out.println("该热搜已经被添加");
        }else{
            rankingList.add(hotSearch);
            System.out.println("已添加新热搜");
        }
        updateRanking();
    }

    public List<String> getRanking(){
        List<String> ranking = new ArrayList<>();
        rankingList.forEach(e -> ranking.add((rankingList.indexOf(e)+1)+" "+e.getDescription()+" "+e.getHot()));
        return ranking;
    }

    public void updateRanking(){
        rankingList.sort(Comparator.comparingInt(HotSearch::getHot).reversed());
    }

    public boolean hasHotSearch(String description) {
        return rankingList.stream().anyMatch(e -> e.getDescription().equals(description));
    }

    public void voteHotSearch(User user, int numOfVote, String description){
        rankingList.stream().filter(e -> e.getDescription().equals(description)).findFirst().get().vote(numOfVote);
        user.vote(numOfVote);
        updateRanking();
    }

    public void buyHotSearch(String description,int rank,int money){

    }

}
