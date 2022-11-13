package Menu.FlowerListCommand;

import EmailSender.Email;
import FlowerList.FlowersList;
import Menu.Command;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Logger;

public class ModifyFlowerCommand implements Command {
    private final FlowersList list;
    private final Scanner scanner;
    private final Logger logger;
    private final Email email = new Email();
    public ModifyFlowerCommand(FlowersList list, Scanner scanner, Logger logger) {
        this.list = list;
        this.scanner=scanner;
        this.logger=logger;

    }
    @Override
    public void execute() {
        logger.info("Початок виконнання команди по зміні властивостей квітки.");
        if (list.size() == 0) {
            System.out.println("Список квітів пустий.Додайте квіти, щоб виконати цю дію.");
            logger.info("Завершено роботу команди остільки список квітів порожній.");
            return;
        }
        System.out.println("\tСписок квітів:");
        list.printFlowersList();
        logger.info("Виведено список квітів для вибору однієї для модифікації.");
        int flowerIndex;
        System.out.println("Введіть номер квітки, дані якої бажаєте модифікувати: ");
        try{
            flowerIndex = scanner.nextInt();
            if(flowerIndex < 1 || flowerIndex > list.size()){
                throw  new IllegalArgumentException();
            }
        }
        catch (IllegalArgumentException | InputMismatchException exception) {
            System.err.println("Помилка введення даних або такого номера квітки не існує.");
            logger.warning("Помилка введення даних або такого номера квітки не існує."+exception);
            email.SendMessage("Помилка введення даних або такого номера квітки не існує.\n",exception);
            scanner.next();
            return;
        }
        logger.info("Квітку для модифікації успішно вибрано.");
        flowerIndex--;
        System.out.println("""
                Зменшення рівеня свіжості в букеті на певне число (-1 рівень свіжості = -10% вартості квітки),
                коли рівень свіжості будь-якої квітки досягне 0, вона автоматично видалиться, як зів'яла.
                """);
        System.out.println("Поточний рівень свіжості: " + list.getFlowerList().get(flowerIndex).getFreshnessLevel());
        System.out.println("Введіть число, на яке зменшити рівень свіжості квітки: ");
        int reduceLevel;
        try {
            reduceLevel = scanner.nextInt();
            if (reduceLevel < 0) {
                throw new IllegalArgumentException();
            }
        } catch (InputMismatchException | IllegalArgumentException exception) {
            System.err.println("Помилка введення даних або введено від'ємне число.");
            logger.warning("Помилка введення даних або введено від'ємне число."+exception);
            email.SendMessage("Помилка введення даних або введено від'ємне число.\n",exception);
            scanner.next();
            return;
        }
        list.modifyFlower(flowerIndex, reduceLevel);
        System.out.println("Зміни успішно внесено.");
        logger.fine("Зміни успішно внесено.");
        if (list.getFlowerList().get(flowerIndex).getFreshnessLevel() == 0) {
            list.deleteFlower(flowerIndex);
            logger.info("Квітку було видалено оскільки рівень свіжості досягнув 0.");
        }
    }
}
