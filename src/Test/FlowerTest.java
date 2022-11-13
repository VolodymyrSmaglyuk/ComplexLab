package Test;

import Flower.Flower;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FlowerTest {
    Flower flower= new Flower("Троянда","Червона",10,70,100);
    @Test
    void reduceFreshnessLevelTest1() {
        flower.reduceFreshnessLevel(4);
        Assertions.assertEquals(6,flower.getFreshnessLevel());
        Assertions.assertEquals(60,flower.getPrice());
    }
    @Test
    void reduceFreshnessLevelTest2() {
        flower.reduceFreshnessLevel(15);
        Assertions.assertEquals(0,flower.getFreshnessLevel());
        Assertions.assertEquals(0,flower.getPrice());
    }
    @Test
    void toStringTest(){
        String res = """
                Назва квітки: Троянда
                Колір: Червона
                Рівень свіжості: 10
                Довжина стебла: 70
                Ціна за одиницю: 100
                """;
        Assertions.assertEquals(res,flower.toString());
    }

}