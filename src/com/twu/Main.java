package com.twu;

import java.util.Scanner;

public class Main {

    private static Scanner input;
    private static RankingList rankingList;
    private static User user;
    private static String termianlInput;

    public static void main(String[] args) {
        input = new Scanner(System.in);
        rankingList = new RankingList();
        while(true){
            menu();
            termianlInput = input.next();
            switch (termianlInput){
                case "1": guest();break;
                case "2": admin();break;
                case "3": return;
            }
        }

    }


    private static void guest(){
        System.out.println("请输入您的昵称");
        String username = input.next();
        user = new User(username,UserType.Guest);
        while(true){
            guestMenu();
            termianlInput = input.next();
            switch (termianlInput){
                case "1": rankingList.getRanking().forEach(System.out::println);break;
                case "2":
                    System.out.println("请输入需要投票的热搜事件描述");
                    termianlInput = input.next();
                    String description = termianlInput;
                    boolean isHotSearch =rankingList.hasHotSearch(termianlInput);
                    if(!isHotSearch){
                        System.out.println("输入的热搜事件描述不正确\n");
                        break;
                    }
                    System.out.println("请输入需要投票的数量，你的票数剩余为："+user.getNumOfVotes());
                    termianlInput = input.next();
                    int numOfVote = Integer.valueOf(termianlInput);
                    rankingList.voteHotSearch(user, numOfVote,description);
                    System.out.println("投票已完成");
                    break;
                case "3":
                    System.out.println("请输入需要投票的热搜事件描述");
                    termianlInput = input.next();
                    String superDescription = termianlInput;
                    System.out.println("请输入需要购买的名次");
                    termianlInput = input.next();
                    int rank = Integer.valueOf(termianlInput);
                    System.out.println("请输入购买的金额");
                    termianlInput = input.next();
                    int money = Integer.valueOf(termianlInput);
                    rankingList.buyHotSearch(superDescription, rank ,money);
                    break;
                case "4":
                    System.out.println("请输入热搜事件描述");
                    termianlInput = input.next();
                    rankingList.addHotSearch(new HotSearch(termianlInput));
                    break;
                case "5": return;
            }
        }
    }

    private static void admin(){
        System.out.println("请输入您的昵称");
        String username = input.next();
        user = new User(username,UserType.Admin);
        while(true){
            adminMenu();
            termianlInput = input.next();
            switch (termianlInput){
                case "1": ;
                    rankingList.getRanking().forEach(System.out::println);
                    break;
                case "2":
                    System.out.println("请输入热搜事件描述");
                    termianlInput = input.next();
                    rankingList.addHotSearch(new HotSearch(termianlInput));
                    break;
                case "3":
                    System.out.println("请输入超级热搜事件描述");
                    termianlInput = input.next();
                    rankingList.addHotSearch(new HotSearch(termianlInput,true));
                    break;
                case "4": return;
            }
        }

    }


    private static void menu(){
        System.out.println("欢迎来到热搜排行榜，你是？\n"+
                "1.用户\n" +
                "2.管理员\n" +
                "3.退出");
    }

    private static void guestMenu(){
        System.out.println("你好, "+user.getUsername()+",你可以\n"+
                "1.查看热搜排行榜\n" +
                "2.给热搜事件投票\n" +
                "3.购买热搜\n" +
                "4.添加热搜\n" +
                "5.退出");
    }

    private static void adminMenu() {
        System.out.println("你好, "+user.getUsername()+",你可以\n"+
                "1.查看热搜排行榜\n" +
                "2.添加热搜\n" +
                "3.添加超级热搜\n" +
                "4.退出");
    }

}
