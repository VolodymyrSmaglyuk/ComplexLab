package Bouquet;

import Decor.Decor;
import Flower.Flower;

import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.*;

import static java.lang.System.out;

public class Bouquet {
    private final List<Flower> list;
    private int price;
    private final Decor decor;

    public Bouquet(List<Flower> list,Decor decor) {
        this.list = list;
        this.decor=decor;
        this.price = decor.getTotalPrice();
        for (Flower flower : list) {
            this.price += flower.getPrice();
        }
    }

    public void setPrice() {
        this.price = decor.getTotalPrice();
        for (Flower flower : list) {
            this.price += flower.getPrice();
        }
    }

    public void modifyBouquet(int reduceLevel){
        for (Flower flower : list) {
            flower.reduceFreshnessLevel(reduceLevel);
        }
        setPrice();
    }
    public int findLowestFreshness(){
        int freshnessLevel = list.get(0).getFreshnessLevel();
        int k;
        for(int i=1;i<list.size();i++) {
            k = list.get(i).getFreshnessLevel();
            if (freshnessLevel > k) {
                freshnessLevel = k;
            }
        }
        return freshnessLevel;
    }
    public int findTheBiggestFreshness(){
        int freshnessLevel = list.get(0).getFreshnessLevel();
        int k;
        for(int i=1;i<list.size();i++){
            k = list.get(i).getFreshnessLevel();
            if(freshnessLevel < k){
                freshnessLevel = k;
            }
        }
        return freshnessLevel;
    }
    public void printInfo(){
        out.println("Вартість букета: "+price);
        out.println("Інформація про оформлення:\n");
        out.println(decor);
        out.println("Список квітів у букеті:\n");
        for (Flower flower : list) {
            out.println(flower);
        }
    }
    public void sortFreshness(){
        list.sort(Comparator.comparing(Flower::getFreshnessLevel));
    }

    public List<Flower> findFlowers(int start,int end){
        List<Flower>  flowersList = new ArrayList<>();
        for (Flower flower :list){
            if(flower.getStemLength() >= start && flower.getStemLength() <= end){
                flowersList.add(flower);
            }
        }
        return flowersList;
    }
    public int saveBouquetInFile() {
        try {
            PrintStream out = new PrintStream(new FileOutputStream("C:\\LP\\Bouquet.txt"));
            System.setOut(out);
        }
        catch(FileNotFoundException fife){
            System.err.println("Не вдалося відкрити файл для запису.");
            return 0;
        }
        printInfo();
        PrintStream console = new PrintStream(new FileOutputStream(FileDescriptor.out));
        System.setOut(console);
        return 1;
    }
}
