package FlowerList;

import Flower.*;

import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class FlowersList {
    List<Flower> flowerList;

    public FlowersList() {
        this.flowerList = new ArrayList<>();
    }
    public List<Flower> getFlowerList() {
       return flowerList;
    }

    public int addFlower(Scanner scanner){
        int input;
        System.out.println("Оберіть клас квітки: 1 - тропічна, 2 - сезонна:");
        try{
            input = scanner.nextInt();
            if(input>2 || input <1){
                throw new InputMismatchException();
            }
        }catch(InputMismatchException ime){
            System.err.println("Помилка введення типу квітки.");
            scanner.next();
            return 0;
        }
        String name,color,countryOfOrigin;
        int freshnessLevel,stemLength,price;
        try {
            System.out.println("Ім'я квітки: ");
            name = scanner.next();
            System.out.println("Колір: ");
            color = scanner.next();
            System.out.println("Рівень свіжості: ");
            System.out.println("Введіть рівень від 1 до 10:");
            freshnessLevel = scanner.nextInt();
             if (freshnessLevel < 1 || freshnessLevel > 10){
                 throw new IllegalArgumentException();
             }
            System.out.println("Довжина стебла: ");
            stemLength = scanner.nextInt();
            System.out.println("Ціна за одиницю: ");
            price = scanner.nextInt();
            System.out.println("Країна її походження: ");
            countryOfOrigin = scanner.next();
        }
        catch(InputMismatchException | IllegalArgumentException ime){
            System.err.println("Помилка введення даних про квітку.");
            scanner.next();
            return 0;
        }
        if (input == 1){
            System.out.println("Чи квітка сумісна з іншими квітками свого класу (True/False): ");
            boolean compatibleWithOthers;
            try {
                compatibleWithOthers = scanner.nextBoolean();
            }
            catch(InputMismatchException ime){
                System.err.println("Помилка введення інформації про квітку");
                scanner.next();
                return 0;
            }
            TropicalFlower flower = new TropicalFlower(name,color,freshnessLevel,stemLength,price
                    ,countryOfOrigin,compatibleWithOthers);
            flowerList.add(flower);
        }
        else {
            System.out.println("Сезон квітки: ");
            String flowerSeason;
            try {
                flowerSeason = scanner.next();
            }
            catch(InputMismatchException ime){
                System.err.println("Помилка введення інформації про квітку");
                scanner.next();
                return 0;
            }
            SeasonFlower flower = new SeasonFlower(name,color,freshnessLevel,stemLength,price,
                    flowerSeason,countryOfOrigin);
            flowerList.add(flower);
        }
        return 1;
    }

    public void addMultipleFlowers(Flower flower,int numbOfFlowers){
        if (flower instanceof TropicalFlower) {
            for (int i = 0; i < numbOfFlowers; i++) {
                flowerList.add(new TropicalFlower((TropicalFlower)flower));
            }
        }
        else{
            for (int i = 0; i < numbOfFlowers; i++) {
                flowerList.add(new SeasonFlower((SeasonFlower)flower));
            }
        }
    }
    public void printFlowersList(){
        int i=1;
        for(Flower flower:flowerList){
            System.out.println(i+")\n"+flower);
            i++;
        }
    }
    public void deleteFlower(int input){
        flowerList.remove(input);
    }

    public void modifyFlower(int flowerIndex,int reduceLevel){
                flowerList.get(flowerIndex).reduceFreshnessLevel(reduceLevel);
    }
    public int saveFlowerListInFile() {
        try {
            PrintStream out = new PrintStream(new FileOutputStream("C:\\LP\\FlowerList.txt"));
            System.setOut(out);
        }
        catch(FileNotFoundException fife){
            System.err.println("Не вдалося відкрити файл для запису.");
            return 0;
        }
        printFlowersList();
        PrintStream console = new PrintStream(new FileOutputStream(FileDescriptor.out));
        System.setOut(console);
        return 1;
    }

    public int size() {
        return flowerList.size();
    }
}
