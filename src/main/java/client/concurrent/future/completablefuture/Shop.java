package client.concurrent.future.completablefuture;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

/**
 * 商店
 */
public class Shop {

    /**
     * 这个商品名无意义
     */
    private String product;

    public Shop(String product) {
        this.product = product;
    }

    /**
     * 同步获取
     * @param product
     * @return
     */
    public double getPrice(String product){
           delay();
           return new Random().nextDouble();
    }

    /**
     * 异步获取
     * @param product
     * @return
     */
    public CompletableFuture<Double> getPriceAsync(String product){
       return CompletableFuture.supplyAsync(()->{delay();
           return new Random().nextDouble();
        });
    }



    public static  void delay(){
        try {
             Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public static void main(String[] args) {
        List<Shop> shops = Arrays.asList(new Shop("a"),new Shop("b"),new Shop("c"),new Shop("d"));
        Long time = System.currentTimeMillis();
        List<String> str =   shops.stream().map((shop)->{
           return shop.getProduct() + "\t" + shop.getPrice(shop.getProduct());
        }).collect(Collectors.toList());
        for(String s : str){
            System.out.println(s);
        }
        System.out.println("total consume : " + (System.currentTimeMillis() - time));
    }

}
