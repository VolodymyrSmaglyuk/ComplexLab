package Test;

import Bouquet.Bouquet;
import Decor.Decor;
import Flower.Flower;
import Flower.SeasonFlower;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class BouquetTest {

    @Test
    void modifyBouquetTest() {
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
        bouquet.modifyBouquet(2);
        Assertions.assertEquals(6,flowerList.get(0).getFreshnessLevel());
        Assertions.assertEquals(4,flowerList.get(1).getFreshnessLevel());
        Assertions.assertEquals(5,flowerList.get(2).getFreshnessLevel());
        Assertions.assertEquals(64,flowerList.get(0).getPrice());
        Assertions.assertEquals(64,flowerList.get(0).getPrice());
        Assertions.assertEquals(64,flowerList.get(0).getPrice());

    }

    @Test
    void findLowestFreshnessTest() {
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
        Assertions.assertEquals(6,bouquet.findLowestFreshness());
    }

    @Test
    void findTheBiggestFreshnessTest() {
        List<Flower> flowerList = new ArrayList<>();
        flowerList.add(new SeasonFlower("Троянда","Червона",7,40,80,
                "Осінь","Україна"));
        flowerList.add(new SeasonFlower("Троянда","Червона",6,42,80,
                "Осінь","Україна"));
        flowerList.add(new SeasonFlower("Троянда","Червона",8,45,80,
                "Осінь","Україна"));
        Decor decor = new Decor("Обгортка з гафрованого паперу",
                "Листівка з привітанням",120);
        Bouquet bouquet = new Bouquet(flowerList,decor);
        Assertions.assertEquals(8,bouquet.findTheBiggestFreshness());
    }


    @Test
    void sortFreshnessTest() {
        List<Flower> flowerList = new ArrayList<>();
        flowerList.add(new SeasonFlower("Троянда","Червона",7,40,80,
                "Осінь","Україна"));
        flowerList.add(new SeasonFlower("Троянда","Червона",6,42,80,
                "Осінь","Україна"));
        flowerList.add(new SeasonFlower("Троянда","Червона",8,45,80,
                "Осінь","Україна"));
        Decor decor = new Decor("Обгортка з гафрованого паперу",
                "Листівка з привітанням",120);
        Bouquet bouquet = new Bouquet(flowerList,decor);
        bouquet.sortFreshness();
        List<Flower> flowerList2 = new ArrayList<>();
        flowerList2.add(new SeasonFlower("Троянда","Червона",6,42,80,
                "Осінь","Україна"));
        flowerList2.add(new SeasonFlower("Троянда","Червона",7,40,80,
                "Осінь","Україна"));
        flowerList2.add(new SeasonFlower("Троянда","Червона",8,45,80,
                "Осінь","Україна"));
        Assertions.assertEquals(flowerList2.toString(),flowerList.toString());
    }

    @Test
    void findFlowersTest() {
        List<Flower> flowerList = new ArrayList<>();
        flowerList.add(new SeasonFlower("Троянда","Червона",7,45,80,
                "Осінь","Україна"));
        flowerList.add(new SeasonFlower("Троянда","Червона",6,51,80,
                "Осінь","Україна"));
        flowerList.add(new SeasonFlower("Троянда","Червона",8,33,80,
                "Осінь","Україна"));
        Decor decor = new Decor("Обгортка з гафрованого паперу",
                "Листівка з привітанням",120);
        Bouquet bouquet = new Bouquet(flowerList,decor);
        List<Flower> flowerList2 = new ArrayList<>();
        flowerList2.add(new SeasonFlower("Троянда","Червона",7,45,80,
                "Осінь","Україна"));
        Assertions.assertEquals(flowerList2.toString(),bouquet.findFlowers(35,50).toString());

    }
}