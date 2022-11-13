package Test;

import Flower.TropicalFlower;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TropicalFlowerTest {
    TropicalFlower tropicalFlower = new TropicalFlower("Орхідея","Червона",10,
            65,800,
            "Бразилія",false);
    @Test
    void testToStringTest() {
        String res = """
                Назва квітки: Орхідея
                Колір: Червона
                Рівень свіжості: 10
                Довжина стебла: 65
                Ціна за одиницю: 800
                Країна походження: Бразилія
                Сумісність з іншими квітами: false
                """;
        Assertions.assertEquals(res,tropicalFlower.toString());
    }
}