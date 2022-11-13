package Menu.BouquetListCommand;

import Bouquet.Bouquet;
import BouquetList.BouquetList;
import EmailSender.Email;
import Menu.BouquetCommands.*;
import Menu.Command;
import Menu.ExitMenuCommand;
import Menu.SelectedBouquetCommandMenu;

import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Logger;

public class SelectBouquetCommand implements Command {
    private final BouquetList list;
    private final Scanner scanner;
    private final Logger logger;
    private final Email email = new Email();

    public SelectBouquetCommand(BouquetList list, Scanner scanner, Logger logger) {
        this.list = list;
        this.scanner = scanner;
        this.logger=logger;
    }
    @Override
    public void execute() throws FileNotFoundException {
        logger.info("Початок виконання команди з вибору букета.");
        if(list.getBouquetList().size()==0){
            System.out.println("Список букетів порожній. Додайте букети, щоб виконати цю команду.");
            logger.info("Виконання команди завершено оскільки список букетів порожній.");
            return;
        }
        logger.info("Виведення списку букетів для вибору одного з них.");
        System.out.println("Список букетів:");
        list.printBouquetsList();
        int input;
        System.out.println("Виберіть букет, з яким бажаєте працювати: ");
        try {
            input = scanner.nextInt();
            if(input > list.size() || input < 1){
                throw new IllegalArgumentException();
            }
        }
        catch (InputMismatchException | IllegalArgumentException exception){
            System.err.println("Помилка введення диних або введено неіснуючий номер букета.");
            logger.warning("Помилка введення диних або введено неіснуючий номер букета. "+exception);
            email.SendMessage("Помилка введення диних або введено неіснуючий номер букета.\n", exception);
            scanner.next();
            return;
        }
        Bouquet bouquet = list.selectBouquet(input-1);
        SelectedBouquetCommandMenu menu = new SelectedBouquetCommandMenu();
        logger.fine("Вибір букета успішно завершений.");
        int select=0;
        menu.PrintCommandMenu();
        while (select!=7) {
            System.out.println("Оберіть команду: ");
            try {
                select = scanner.nextInt();
            }
            catch (InputMismatchException ime){
                System.err.println("Помилка введення команди для букета.");
                logger.warning("Помилка введення команди для букета. "+ime);
                email.SendMessage("Помилка введення команди для букета.",ime);
                scanner.next();
                continue;
            }
            logger.fine("Успішно обрано нову команду.");
            switch (select) {
                case 0 -> {
                    menu.PrintCommandMenu();
                    logger.fine("Виведено меню команд для букета.");
                    continue;
                }
                case 1 -> menu.SetCommand(new PrintBouquetCommand(bouquet,logger));
                case 2 -> menu.SetCommand(new PrintSortedFlowersCommand(bouquet,logger));
                case 3 -> menu.SetCommand(new PrintFlowersWithStemCommand(bouquet, scanner,logger));
                case 4 -> {
                    menu.SetCommand(new DeleteBouquetCommand(list, bouquet,logger));
                    menu.RunCommand();
                    menu.SetCommand(new ExitMenuCommand());
                    select=7;
                    logger.fine("Роботу з букетом завершено.");
                }
                case 5 -> {
                    menu.SetCommand(new ModifyBouquetCommand(bouquet, scanner,logger));
                    menu.RunCommand();
                    if(bouquet.findLowestFreshness()==0){
                        list.deleteBouquet(bouquet);
                        System.out.println("Букет було видалено, оскільки він зів'яв.");
                        logger.info("Букет було видалено, оскільки він зів'яв.");
                        menu.SetCommand(new ExitMenuCommand());
                        select=7;
                        logger.fine("Роботу з букетом завершено.");
                    }
                    else
                        continue;
                }
                case 6 -> menu.SetCommand(new SaveBouquetInFile(bouquet,logger));
                case 7 -> {
                    menu.SetCommand(new ExitMenuCommand());
                    logger.fine("Роботу з букетом завершено.");
                }
                default -> {
                    System.out.println("Неправильна команда, спробуйте ще раз.");
                    logger.warning("Обрано неіснуючу команду для букета");
                    continue;
                }
            }
            menu.RunCommand();
        }
    }
}
