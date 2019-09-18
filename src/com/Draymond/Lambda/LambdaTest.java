package com.Draymond.Lambda;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaTest {

    List<Transaction> transactions =null;
    Trader raoul=null;
    Trader mario=null;
    Trader alan=null;
    Trader brian=null;

    @Before
    public  void init(){
         raoul = new Trader("Raoul", "Cambridge");
         mario = new Trader("Mario","Milan");
         alan = new Trader("Alan","Cambridge");
         brian = new Trader("Brian","Cambridge");

      transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );
    }


    //找出2011年发生的所有交易，并按交易额排序
    @Test
    public  void Test01(){
        //关注点在sorted上的Transaction::getValue,comparing参数上的函数接口是Function的apply
        //Function的apply就是接收T对象，返回R对象
        //这里是接受了Transaction对象的getValue方法，然后返回一个排序对象
        transactions.stream().filter(transaction -> transaction.getYear() == 2011)
                             .sorted(Comparator.comparing(Transaction::getValue))
                             .collect(Collectors.toList())
                             .forEach(System.out::println);
    }
    //交易员在哪些不同的城市工作过
    @Test
    public  void Test02(){
        transactions.stream().map(transaction -> transaction.getTrader().getCity())
                             .distinct()
                             .collect(Collectors.toList())
                             .forEach(System.out::println);
    }
    //查找所有来自剑桥的交易员，并按姓名排序
    @Test
    public  void Test03(){
        transactions.stream().filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                             .distinct()
                             //.sorted(Comparator.comparing(Trader::getName))
                             .collect(Collectors.toList())
                             .forEach(System.out::println);

    }
    //返回所有交易员的姓名字符串，并按字母顺序排序
    @Test
    public  void Test04(){
        transactions.stream().map(transaction -> transaction.getTrader().getName())
                             .distinct()
                             .sorted()
                             .forEach(System.out::println);

    }
    //有没有交易员在米兰工作的？
    @Test
    public  void Test05(){
        boolean milan = transactions.stream().anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));
        System.out.println(milan);
    }
    //打印生活在剑桥的交易员的所有交易额
    @Test
    public  void Test06(){
        int cambridge = transactions.stream().filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                                            .map(transaction -> transaction.getValue())
                                            .reduce(Integer::sum).get();
        System.out.println(cambridge);
    }
    //所有交易中，最高的交易额是多少
    @Test
    public  void Test07(){
        //reduce的第一个参数identity是初始值的意思
        Integer reduce = transactions.stream().map(Transaction::getValue).reduce(0, Integer::max);
        System.out.println(reduce);

    }
    //找到交易额最小的交易
    @Test
    public  void Test08(){
        Integer reduce = transactions.stream().map(Transaction::getValue).reduce(Integer.MAX_VALUE,Integer::min);
        System.out.println(reduce);
    }
}
