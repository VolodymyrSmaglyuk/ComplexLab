package BouquetList;

import Bouquet.Bouquet;
import Decor.Decor;
import Flower.Flower;
import Flower.SeasonFlower;
import Flower.TropicalFlower;

import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.*;

public class BouquetList {
    public List<Bouquet> list;

    public BouquetList() {
        this.list = new ArrayList<>();
    }

    public void createBouquetFromFlowersArray(int []arr,List<Flower> flowersList,Decor decor){
        List<Flower> listOfFlowersInBouquet= new ArrayList<>();
        Flower flower;
        int index;
        for (int i=0;i<arr.length;i++){
            index = arr[i]-1;
            if (flowersList.get(i) instanceof TropicalFlower){
                flower = new TropicalFlower((TropicalFlower)flowersList.get(index));
            }
            else{
                flower = new SeasonFlower((SeasonFlower) flowersList.get(index));
            }
            listOfFlowersInBouquet.add(flower);
        }
        if(canCreateBouquet(listOfFlowersInBouquet) && hasNeededFreshness(listOfFlowersInBouquet)) {
            Arrays.sort(arr);
            for (int i =arr.length-1 ; i>=0; i--) {
                flowersList.remove(arr[i]-1);
            }
        }
        else{
            return ;
        }
        list.add(new Bouquet(listOfFlowersInBouquet,decor));
    }
    public void createBouquetOnInterval(int start,int end,List<Flower> flowersList,Decor decor){
        List<Flower> listOfFlowersInBouquet= new ArrayList<>();
        Flower flower;
        for (int i=start-1;i<end;i++){
            if (flowersList.get(i) instanceof TropicalFlower){
                flower = new TropicalFlower((TropicalFlower)flowersList.get(i));
            }
            else{
                flower = new SeasonFlower((SeasonFlower) flowersList.get(i));
            }
            listOfFlowersInBouquet.add(flower);
        }
        if(canCreateBouquet(listOfFlowersInBouquet) && hasNeededFreshness(listOfFlowersInBouquet)) {
            if (end >= start) {
                flowersList.subList(start - 1, end).clear();
            }
        }
        else{
            return;
        }
        list.add(new Bouquet(listOfFlowersInBouquet,decor));
    }
    private boolean hasNeededFreshness(List<Flower> list){

        int comparator = list.get(0).getFreshnessLevel();
        for (int i=1;i<list.size();i++){
            if(Math.abs(comparator-list.get(i).getFreshnessLevel())>2) {
                return false;
            }
        }
        return true;
    }
    private boolean canCreateBouquet( List<Flower> list){
        if (isAllSeasonFlowers(list)){
            return true;
        } else if (isAllTropicalFlowers(list)) {
            if(isAllTropicalFlowersCompatible(list)){
                return true;
            }
            else{
                System.err.println("Знайдено в букеті несумісні тропічні квіти." +
                        "\nНеможливо створити букет з такого набору");
                return false;
            }
        } else {
            System.err.println("""
                    В букеті знайдено несумісні квіти.
                    Неможливо поєднувати сезонні і тропічні квіти.
                    Будь ласка, зберіть букет повторно.""");
            return false;
        }
    }
    private boolean isAllSeasonFlowers( List<Flower> list){
        int k=0;
        for (Flower flower : list) {
            if (flower instanceof SeasonFlower) {
                k++;
            }
        }
        return k == list.size();
    }
    private boolean isAllTropicalFlowers( List<Flower> list){
        int k=0;
        for (Flower flower : list) {
            if (flower instanceof  TropicalFlower) {
                k++;
            }
        }
        return k == list.size();
    }
    private boolean isAllTropicalFlowersCompatible(List<Flower> list){
        int compatible=0,nonCompatible=0;
        for (Flower flower : list) {
            if (((TropicalFlower)flower).isCompatibleWithOthers()) {
                compatible++;
            }
            else{
                nonCompatible++;
            }
        }
        if (compatible== list.size()){
            return true;
        } else return nonCompatible == list.size();
    }
    public Decor addDecor(Scanner scanner) {
        System.out.println("Введіть дані про оформлення букета");
        String wrapperType,extraElements;
        int totalPrice;
        try {
            System.out.println("Обгортка: ");
            wrapperType = scanner.next();
            System.out.println("Додаткові елементи: ");
            extraElements = scanner.next();
            System.out.println("Вартість обгортки і додаткових елементів: ");
            totalPrice = scanner.nextInt();
        } catch (InputMismatchException ime) {
            System.err.println("Помилка введення.");
            scanner.next();
            return new Decor("", "",0);
        }
        return new Decor(wrapperType, extraElements, totalPrice);
    }
    public void printBouquetsList(){
        int i=1;
        for (Bouquet bouquet : list) {
            System.out.println(i+")\n");
            bouquet.printInfo();
            i++;
        }
    }
    public void deleteBouquet(Bouquet bouquet){
        list.remove(bouquet);
    }

    public Bouquet selectBouquet(int input){
            return list.get(input);
    }

    public int saveBouquetListInFile() {
        try {
            PrintStream out = new PrintStream(new FileOutputStream("C:\\LP\\BouquetList.txt"));
            System.setOut(out);
        }
        catch(FileNotFoundException fife){
            System.err.println("Не вдалося відкрити файл для запису.");
            return 0;
        }
        printBouquetsList();
        PrintStream console = new PrintStream(new FileOutputStream(FileDescriptor.out));
        System.setOut(console);
        return 1;
    }

    public List<Bouquet> getBouquetList() {
        return list;
    }

    public int size() {
        return list.size();
    }
}
