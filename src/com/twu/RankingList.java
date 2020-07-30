package com.twu;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RankingList {
    private List<HotSearch> rankingList;
    private Map<Integer,Integer> buyRanking;

    public RankingList() {
        this.rankingList = new ArrayList<>();
        this.buyRanking = new HashMap<>();
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

        List<HotSearch> temp = new ArrayList<>();
        IntStream.range(0,rankingList.size()).forEach(i -> temp.add(null));
        List<HotSearch> buyRankHotSearch = rankingList.stream().filter(HotSearch::isBuyRank).collect(Collectors.toList());
        List<HotSearch> notBuyRankHotSearch = rankingList.stream().filter(e -> !e.isBuyRank()).collect(Collectors.toList());
        buyRankHotSearch.forEach(e -> temp.set(e.getRank(),e));
        notBuyRankHotSearch.forEach(e -> temp.set(temp.indexOf(null),e));
        rankingList = new ArrayList<>();
        rankingList.addAll(temp);
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
        int index = rank-1;
        if(buyRanking.containsKey(index)){
            if(buyRanking.get(index)>money){
                System.out.println("您输入的金额不足以购买此名次，购买当前名次的金额应大于："+buyRanking.get(index));
                return;
            }else {
                rankingList.remove(index);
            }
        }
        HotSearch hotSearch ;
        Optional<HotSearch> optionalHotSearch = rankingList
                .stream()
                .filter(e -> e.getDescription().equals(description))
                .findFirst();
        if(optionalHotSearch.isPresent()){
            hotSearch = optionalHotSearch.get();
            hotSearch.setRank(index);
        }else{
            System.out.println("此热搜不存在");
            return;
        }
        buyRanking.put(index,money);
        updateRanking();
    }

}
