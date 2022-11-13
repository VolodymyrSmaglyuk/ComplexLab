package Test;

import Flower.SeasonFlower;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SeasonFlowerTest {
    SeasonFlower seasonFlower = new SeasonFlower("Троянда","Червона",8,40,80,
            "Осінь","Україна");
    @Test
    void testToStringTest() {
        String res = """
                Назва квітки: Троянда
                Колір: Червона
                Рівень свіжості: 8
                Довжина стебла: 40
                Ціна за одиницю: 80
                Сезон квітки: Осінь
                Країна походження: Україна
                """;
        Assertions.assertEquals(res,seasonFlower.toString());
    }
}