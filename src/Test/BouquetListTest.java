package Test;

import Bouquet.Bouquet;
import BouquetList.BouquetList;
import Decor.Decor;
import Flower.Flower;
import Flower.SeasonFlower;
import Flower.TropicalFlower;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class BouquetListTest {
    BouquetList bouquetList =new BouquetList();
    @Test
    void createBouquetFromFlowersArrayTest1() {
        List<Flower> flowerList = new ArrayList<>();
        flowerList.add(new SeasonFlower("Троянда","Червона",8,40,80,
                "Осінь","Україна"));
        flowerList.add(new SeasonFlower("Троянда","Червона",6,42,80,
                "Осінь","Україна"));
        flowerList.add(new SeasonFlower("Троянда","Червона",7,45,80,
                "Осінь","Україна"));
        Decor decor = new Decor("Обгортка з гафрованого паперу",
                "Листівка з привітанням",120);
        int []arr = {1,2,3};
        bouquetList.createBouquetFromFlowersArray(arr,flowerList,decor);
        Assertions.assertEquals(1,bouquetList.list.size());
    }
    @Test
    void createBouquetFromFlowersArrayTest2() {
        List<Flower> flowerList = new ArrayList<>();
        flowerList.add(new TropicalFlower("Орхідея","Червона",10,
                65,800,
                "Бразилія",false));
        flowerList.add(new TropicalFlower("Орхідея","Червона",10,
                65,800,
                "Бразилія",false));
        flowerList.add(new SeasonFlower("Троянда","Червона",8,45,80,
                "Осінь","Україна"));
        Decor decor = new Decor("Обгортка з гафрованого паперу",
                "Листівка з привітанням",120);
        int []arr = {1,2,3};
        bouquetList.createBouquetFromFlowersArray(arr,flowerList,decor);
        Assertions.assertEquals(0,bouquetList.list.size());
    }
    @Test
    void createBouquetOnIntervalTest1() {
        List<Flower> flowerList = new ArrayList<>();
        flowerList.add(new TropicalFlower("Орхідея","Червона",8,
                65,800,
                "Бразилія",false));
        flowerList.add(new TropicalFlower("Орхідея","Червона",10,
                65,800,
                "Бразилія",false));
        flowerList.add(new TropicalFlower("Орхідея","Червона",9,
                65,800,
                "Бразилія",false));
        flowerList.add(new TropicalFlower("Орхідея","Червона",10,
                65,800,
                "Бразилія",false));
        flowerList.add(new SeasonFlower("Троянда","Червона",7,45,80,
                "Осінь","Україна"));
        Decor decor = new Decor("Обгортка з гафрованого паперу",
                "Листівка з привітанням",120);
        bouquetList.createBouquetOnInterval(1,5,flowerList,decor);
        Assertions.assertEquals(0,bouquetList.list.size());
    }
    @Test
    void createBouquetOnIntervalTest2() {
        List<Flower> flowerList = new ArrayList<>();
        flowerList.add(new TropicalFlower("Орхідея","Червона",8,
                65,800,
                "Бразилія",false));
        flowerList.add(new TropicalFlower("Орхідея","Червона",9,
                65,800,
                "Бразилія",false));
        flowerList.add(new TropicalFlower("Орхідея","Червона",7,
                65,800,
                "Бразилія",false));
        flowerList.add(new TropicalFlower("Орхідея","Червона",11,
                65,800,
                "Бразилія",false));
        Decor decor = new Decor("Обгортка з гафрованого паперу",
                "Листівка з привітанням",120);
        bouquetList.createBouquetOnInterval(1,4,flowerList,decor);
        Assertions.assertEquals(0,bouquetList.list.size());
    }
    @Test
    void createBouquetOnIntervalTest3() {
        List<Flower> flowerList = new ArrayList<>();
        flowerList.add(new TropicalFlower("Орхідея","Червона",8,
                65,800,
                "Бразилія",false));
        flowerList.add(new TropicalFlower("Орхідея","Червона",9,
                65,800,
                "Бразилія",false));
        flowerList.add(new TropicalFlower("Алое","Червона",8,
                60,650,
                "Бразилія",true));
        flowerList.add(new TropicalFlower("Орхідея","Червона",10,
                65,800,
                "Бразилія",false));
        Decor decor = new Decor("Обгортка з гафрованого паперу",
                "Листівка з привітанням",120);
        bouquetList.createBouquetOnInterval(1,4,flowerList,decor);
        Assertions.assertEquals(0,bouquetList.list.size());
    }
    @Test
    void createBouquetOnIntervalTest4() {
        List<Flower> flowerList = new ArrayList<>();
        flowerList.add(new TropicalFlower("Орхідея","Червона",8,
                65,800,
                "Бразилія",false));
        flowerList.add(new TropicalFlower("Орхідея","Червона",9,
                65,800,
                "Бразилія",false));
        flowerList.add(new TropicalFlower("Орхідея","Червона",8,
                60,750,
                "Бразилія",false));
        flowerList.add(new TropicalFlower("Орхідея","Червона",10,
                65,800,
                "Бразилія",false));
        Decor decor = new Decor("Обгортка з гафрованого паперу",
                "Листівка з привітанням",120);
        bouquetList.createBouquetOnInterval(1,4,flowerList,decor);
        Assertions.assertEquals(1,bouquetList.list.size());
    }

    @Test
    void deleteBouquetTest() {
        List<Flower> flowerList = new ArrayList<>();
        flowerList.add(new SeasonFlower("Троянда","Червона",8,40,80,
                "Осінь","Україна"));
        flowerList.add(new SeasonFlower("Троянда","Червона",6,42,80,
                "Осінь","Україна"));
        flowerList.add(new SeasonFlower("Троянда","Червона",7,45,80,
                "Осінь","Україна"));
        Decor decor = new Decor("Обгортка з гафрованого паперу",
                "Листівка з привітанням",120);
        Bouquet bouquet = new Bouquet(flowerList,decor);
        bouquetList.list.add(bouquet);
        bouquetList.deleteBouquet(bouquet);
        Assertions.assertEquals(0,bouquetList.size());
    }

    @Test
    void selectBouquetTest() {
        List<Flower> flowerList = new ArrayList<>();
        flowerList.add(new SeasonFlower("Троянда","Червона",8,40,80,
                "Осінь","Україна"));
        flowerList.add(new SeasonFlower("Троянда","Червона",6,42,80,
                "Осінь","Україна"));
        flowerList.add(new SeasonFlower("Троянда","Червона",7,45,80,
                "Осінь","Україна"));
        Decor decor = new Decor("Обгортка з гафрованого паперу",
                "Листівка з привітанням",120);
        Bouquet bouquet = new Bouquet(flowerList,decor);
        bouquetList.list.add(bouquet);
        Assertions.assertEquals(bouquet.toString(),bouquetList.selectBouquet(0).toString());
    }

    @Test
    void getBouquetListTest() {
        List<Flower> flowerList = new ArrayList<>();
        flowerList.add(new SeasonFlower("Троянда","Червона",8,40,80,
                "Осінь","Україна"));
        flowerList.add(new SeasonFlower("Троянда","Червона",6,42,80,
                "Осінь","Україна"));
        flowerList.add(new SeasonFlower("Троянда","Червона",7,45,80,
                "Осінь","Україна"));
        Decor decor = new Decor("Обгортка з гафрованого паперу",
                "Листівка з привітанням",120);
        Bouquet bouquet = new Bouquet(flowerList,decor);
        bouquetList.list.add(bouquet);
        Assertions.assertEquals(bouquetList.list.toString(),bouquetList.getBouquetList().toString());
    }
}