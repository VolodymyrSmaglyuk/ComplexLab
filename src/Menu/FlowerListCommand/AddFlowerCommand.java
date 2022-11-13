package Menu.FlowerListCommand;

import EmailSender.Email;
import FlowerList.FlowersList;
import Menu.Command;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Logger;

public class AddFlowerCommand implements Command {
    private final FlowersList list;
    private final Scanner scanner;
    private final Logger logger;
    private final Email email = new Email();

    public AddFlowerCommand(FlowersList list, Scanner scanner, Logger logger) {
        this.list = list;
        this.scanner = scanner;
        this.logger = logger;
    }
    @Override
    public void execute(){
        logger.info("Початок виконнання команди по дадаванню квітів.");
        int input;
        System.out.println("1.Додати одну квітку.\n2.Додати декілька однакових квіток.");
        System.out.println("Оберіть команду:");
        try{
            input = scanner.nextInt();
            if(input <1 || input > 2){
                throw new IllegalArgumentException();
            }
        }catch(InputMismatchException | IllegalArgumentException exception){
            System.err.println("Помилка введення даних або введено неіснуючу команду.");
            logger.warning("Помилка введення даних або введено неіснуючу команду: "+exception);
            email.SendMessage("Помилка введення даних або введено неіснуючу квітку.\n",exception);
            scanner.next();
            return;
        }
        logger.info("Вибір команди завершено.");
        System.out.println("Зауважте, що рівень свіжості квітів знаходиться в діапазоні від 0 до 10, " +
                "де 0 квітка зів'яла, 10 - квітка найсвіжіша.");
        if (input==1) {
            if(list.addFlower(scanner)==1) {
                System.out.println("Квітку додано.");
                logger.fine("Додано нову квітку до списку квітів");
            }
        }
        else {
            int numbOfFlowers;
            try {
                System.out.println("Введіть квітку, яка має декілька екземплярів:");
                if(list.addFlower(scanner)==0){
                    return;
                }
                System.out.println("Введіть кількість екземплярів квітки:");
                numbOfFlowers = scanner.nextInt();
                if(numbOfFlowers<1){
                    list.deleteFlower(list.size()-1);
                    throw  new IllegalArgumentException();
                }
            }
            catch(InputMismatchException | IllegalArgumentException exception){
                System.err.println("Помилка введення ");
                logger.warning("Помилка введення: "+exception);
                email.SendMessage("Помилка введення:\n",exception);
                scanner.next();
                return;
            }
            int lastElement = list.size()-1;
            logger.info("Вибір квітки і кількості її екземплярів успішно завершено.");
            if(numbOfFlowers-1>1) {
                list.addMultipleFlowers(list.getFlowerList().get(lastElement), numbOfFlowers - 1);
            }
            System.out.println("Квіти додано.");
            logger.fine("Успішно додано декілька екземплярів квітів.");
        }

    }
}
