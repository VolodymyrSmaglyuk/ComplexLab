package Menu.BouquetCommands;

import Bouquet.Bouquet;
import EmailSender.Email;
import Flower.Flower;
import Menu.Command;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

import static java.lang.System.out;

public class PrintFlowersWithStemCommand implements Command {
    private final Bouquet bouquet;
    private final Scanner scanner;
    private final Logger logger;
    private final Email email = new Email();

    public PrintFlowersWithStemCommand(Bouquet bouquet,Scanner scanner,Logger logger) {
        this.bouquet = bouquet;
        this.scanner = scanner;
        this.logger=logger;
    }
    @Override
    public void execute() {
        logger.info("Почато виконнання програми по виведенню квітв з букету," +
                " стебло яких знаходиться в певному діапазоні.");
        int start,end;
        out.println("Введіть початок і кінець проміжку на якому шукати довжину стебел квітів в букеті");
        try {
            out.println("Введіть початок проміжку: ");
            start = scanner.nextInt();
            out.println("Введіть кінець проміжку: ");
            end = scanner.nextInt();
            if (start <=0 || end<=0){
                throw new IllegalArgumentException();
            }
        }
        catch (InputMismatchException | IllegalArgumentException exception){
            System.err.println("Помилка введення даних.");
            logger.warning("Помилка введення даних. "+exception);
            email.SendMessage("Помилка введення даних.\n",exception);
            scanner.next();
            return;
        }
        List<Flower> flowersList =this.bouquet.findFlowers(start,end);
        for(Flower flower:flowersList){
            System.out.println(flower);
        }
        logger.fine("Необхідні квіти успішно знайдено і надруковано.");
    }
}
