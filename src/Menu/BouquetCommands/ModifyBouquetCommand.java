package Menu.BouquetCommands;

import Bouquet.Bouquet;
import EmailSender.Email;
import Menu.Command;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Logger;

import static java.lang.System.err;
import static java.lang.System.out;

public class ModifyBouquetCommand implements Command {
    private final Bouquet bouquet;
    private final Scanner scanner;
    private final Logger logger;
    private final Email email = new Email();

    public ModifyBouquetCommand(Bouquet bouquet, Scanner scanner,Logger logger) {
        this.bouquet = bouquet;
        this.scanner = scanner;
        this.logger = logger;
    }
    @Override
    public void execute(){
        logger.info("Початок виконнання команди по модифікації букета.");
        out.println("""
                Зменшення рівеня свіжості в букеті на певне число (-1 рівень свіжості = -10% вартості квітки),
                коли рівень свіжості будь-яких квітів досягне 0, букет автоматично видалиться, як зів'ялий.
                """);
        out.println("Найменший рівень свіжості квітки в букеті: "+bouquet.findLowestFreshness());
        out.println("Найбільший рівень свіжості квітки в букеті: "+bouquet.findTheBiggestFreshness());
        out.println("Введіть число на яке зменшити рівень свіжості в букеті:");
        int reduceLevel;
        try {
            reduceLevel = scanner.nextInt();
            if (reduceLevel < 0){
                throw new IllegalArgumentException();
            }
        }
        catch (InputMismatchException | IllegalArgumentException exception){
            err.println("Введено неправильні дані.");
            logger.warning("Введено неправильні дані. "+exception);
            email.SendMessage("Введено неправильні дані.\n",exception);
            scanner.next();
            return;
        }
        bouquet.modifyBouquet(reduceLevel);
        logger.fine("Букет успішно модифіковано.");
    }

}
