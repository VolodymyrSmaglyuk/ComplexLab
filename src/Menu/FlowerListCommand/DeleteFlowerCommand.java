package Menu.FlowerListCommand;

import EmailSender.Email;
import FlowerList.FlowersList;
import Menu.Command;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Logger;

public class DeleteFlowerCommand implements Command {
    private final FlowersList list;
    private final Scanner scanner;
    private final Logger logger;
    private final Email email = new Email();

    public DeleteFlowerCommand(FlowersList list, Scanner scanner, Logger logger) {
        this.list = list;
        this.scanner = scanner;
        this.logger = logger;
    }
    @Override
    public void execute(){
        logger.info("Початок виконнання команди по видаленню квітки.");
        if(list.size()==0){
            System.out.println("Список квітів пустий.");
            logger.info("Завершено роботу команди остільки список квітів порожній.");
            return;
        }
        int input;
        System.out.println("Введіть номер квітки, яку бажаєте видалити: ");
        try{
            input = scanner.nextInt();
            if(input < 1|| input > list.size()){
                throw new IllegalArgumentException();
            }
        }
        catch(InputMismatchException | IllegalArgumentException exception){
            System.err.println("Помилка введення даних або такої квітки не існує.");
            logger.warning("Помилка введення даних або такої квітки не існує. "+exception);
            email.SendMessage("Помилка введення даних або такої квітки не існує.\n",exception);
            scanner.next();
            return;
        }
        list.deleteFlower(input-1);
        System.out.println("Квітку успішно видалено.");
        logger.fine("Квітку успішно видалено.");
    }
}
