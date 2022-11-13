package Test;

import Flower.*;
import Flower.SeasonFlower;
import FlowerList.FlowersList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FlowersListTest {
    FlowersList flowers = new FlowersList();

    @Test
    void addMultipleFlowersTest1() {
        Flower flower = new SeasonFlower("Троянда", "Червона", 8, 40, 80,
                "Осінь", "Україна");
        flowers.addMultipleFlowers(flower, 10);
        Assertions.assertEquals(10, flowers.size());
    }

    @Test
    void addMultipleFlowersTest2() {
        Flower flower = new TropicalFlower("Орхідея", "Червона", 10, 65, 800,
                "Бразилія", false);
        flowers.addMultipleFlowers(flower, 10);
        Assertions.assertEquals(10, flowers.size());
    }

    @Test
    void deleteFlowerTest() {
        flowers.getFlowerList().add(new SeasonFlower("Троянда", "Червона", 8, 40, 80,
                "Осінь", "Україна"));
        flowers.getFlowerList().add(new SeasonFlower("Троянда", "Червона", 8, 40, 80,
                "Осінь", "Україна"));
        flowers.deleteFlower(1);
        Assertions.assertEquals(1, flowers.size());
    }

    @Test
    void modifyFlowerTest() {
        flowers.getFlowerList().add(new SeasonFlower("Троянда", "Червона", 8, 40, 80,
                "Осінь", "Україна"));
        flowers.getFlowerList().add(new SeasonFlower("Троянда", "Червона", 8, 40, 80,
                "Осінь", "Україна"));
        flowers.getFlowerList().add(new SeasonFlower("Троянда", "Червона", 8, 40, 80,
                "Осінь", "Україна"));
        flowers.modifyFlower(1, 2);
        Assertions.assertEquals(6, flowers.getFlowerList().get(1).getFreshnessLevel());
        Assertions.assertEquals(64, flowers.getFlowerList().get(1).getPrice());

    }

    @Test
    void modifyFlowerTest2() {
        flowers.getFlowerList().add(new SeasonFlower("Троянда", "Червона", 8, 40, 80,
                "Осінь", "Україна"));
        flowers.modifyFlower(0, 10);
        Assertions.assertEquals(0, flowers.getFlowerList().get(0).getFreshnessLevel());
        Assertions.assertEquals(0, flowers.getFlowerList().get(0).getPrice());
    }

}