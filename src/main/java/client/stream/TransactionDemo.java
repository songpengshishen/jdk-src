package client.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 一个交易业务的实践
 *
 * @author wsp
 * @date 2018/05/09
 */
public class TransactionDemo {


    public static void main(String[] args) {
        List<Transaction> trans = initTranList();
        List<Transaction> transactionList1 = trans.stream().filter((Transaction t)->{return t.getYear() == 2001;}).sorted(Comparator.comparing(Transaction::getValue)).collect(Collectors.toList());
        System.out.println(transactionList1);


        List<Trader> traders = trans.stream().map(Transaction::getTrader).filter((Trader t)->{return  t.getCity().equals("bj");}).distinct().sorted(Comparator.comparing(Trader::getName)).collect(Collectors.toList());
        System.out.println(traders );

        Map<Integer,List<Transaction>> transactionGroup = trans.stream().collect(Collectors.groupingBy(Transaction::getYear));
        System.out.println(transactionGroup);

    }


    public static List<Transaction> initTranList(){
        List<Transaction> trans = new ArrayList<Transaction>();
        Trader trader1 = new Trader("wsp","bj");
        Trader trader2 = new Trader("ty","bj");
        Trader trader3 = new Trader("zhangsan","henan");
        Trader trader4 = new Trader("lisi","hebei");
        Trader trader5 = new Trader("wangwu","tj");
        Transaction t1 = new Transaction(trader1,2001,100);
        Transaction t2 = new Transaction(trader2,2001,300);
        Transaction t3 = new Transaction(trader3,2002,200);
        Transaction t4 = new Transaction(trader4,2003,500);
        Transaction t5 = new Transaction(trader5,2004,400);
        trans.add(t1);
        trans.add(t2);
        trans.add(t3);
        trans.add(t4);
        trans.add(t5);
        return trans;
    }




    /**
     * 交易实体
     */
    static class Transaction{

        private Trader trader;
        private int year;
        private int value;

        public Transaction(Trader trader, int year, int value) {
            this.trader = trader;
            this.year = year;
            this.value = value;
        }

        public Trader getTrader() {
            return trader;
        }

        public void setTrader(Trader trader) {
            this.trader = trader;
        }

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "TransactionDemo{" +
                    "trader=" + trader +
                    ", year=" + year +
                    ", value=" + value +
                    '}';
        }
    }


    /**
     * 交易员
     */
    static class Trader {
        private String name;
        private String city;

        public Trader(String name, String city) {
            this.name = name;
            this.city = city;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        @Override
        public String toString() {
            return "Trader{" +
                    "name='" + name + '\'' +
                    ", city='" + city + '\'' +
                    '}';
        }
    }
}
