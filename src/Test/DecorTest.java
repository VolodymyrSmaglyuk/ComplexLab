package Test;

import Decor.Decor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DecorTest {
    Decor decor = new Decor("Обгортка з гафрованого паперу",
            "Листівка з привітанням",100);
    @Test
    void testToStringTest() {
        String res = "Тип обгортки: " + "Обгортка з гафрованого паперу" + '\n' +
                "Додаткові елементи: " + "Листівка з привітанням";
        Assertions.assertEquals(res,decor.toString());
    }
}