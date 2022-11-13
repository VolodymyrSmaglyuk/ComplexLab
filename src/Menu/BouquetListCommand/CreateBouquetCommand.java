package Menu.BouquetListCommand;

import BouquetList.BouquetList;
import Decor.Decor;
import EmailSender.Email;
import FlowerList.FlowersList;
import Menu.Command;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Logger;

public class CreateBouquetCommand implements Command {
    private final BouquetList list;
    private final FlowersList flowersList;
    private final Scanner scanner;
    private final Logger logger;
    private final Email email = new Email();

    public CreateBouquetCommand(BouquetList list,FlowersList flowersList,Scanner scanner,Logger logger) {
        this.list = list;
        this.scanner = scanner;
        this.flowersList=flowersList;
        this.logger=logger;
    }
    @Override
    public void execute(){
        logger.info("Початок виклнання програми по створенню букета.");
        if (flowersList.getFlowerList().size()==0){
            System.out.println("Немає квітів, додайте квіти для подальшого створення букета.");
            logger.info("Завершено роботу команди остільки список квітів пустий.");
            return;
        }
        logger.info("Виведено список квітів.");
        System.out.println("\tСписок квітів:");
        flowersList.printFlowersList();
        System.out.println("Букет можна сформувати лиже із сумісних квітів " +
                "(або тропічних, або сезонних,не всі тропічні квіти сумісні між собою),\n" +
                "рівень свіжості яких не відрізняється більше ніж на 2.");
        System.out.println("1.Сформувати букет з квітів за їх номерами.\n2.Сформувати букет з квітів на проміжку.");
        int input;
        System.out.println("Оберіть команду:");
        try{
            input = scanner.nextInt();
            if(input <1 || input >2){
                throw new IllegalArgumentException();
            }
        }
        catch (InputMismatchException | IllegalArgumentException exception){
            System.err.println("Неправильне введення.");
            logger.warning("Помилка введення даних або введено неіснуючу команду. "+exception);
            email.SendMessage("Помилка введення даних або введено неіснуючу команду.\n",exception);
            scanner.next();
            return;
        }
        logger.info("Вибір команди завершено.");
        int size;
        int []arr;
        Decor decor;
        if(input == 1) {
            logger.info("Початок формування букету з вибраних немерів квітів.");
            System.out.println("Введіть кількість квітів, з яких бажаєте сформувати букет: ");
            try {
                size = scanner.nextInt();
                if(size> flowersList.size()){
                    System.err.println("Немає такої кількості квітів у списку.");
                    throw new IllegalArgumentException();
                }
                arr = new int[size];
                System.out.println("Введіть номери квітів, з яких бажаєте сформувати букет: ");
                for (int i = 0; i < size; i++) {
                    arr[i] = scanner.nextInt();
                    if(arr[i]> flowersList.size()){
                        System.err.println("Введено неіснуючу квітку.");
                        throw new IllegalArgumentException();
                    }
                    for (int j = 0; j < i; j++) {
                        if (arr[i] == arr[j] ) {
                            System.out.println("Знайдено дублікат квітки номер: " + arr[i] +
                                    "\nВведіть нове значення, яке не повторюєтьсяю:");
                            arr[i] = scanner.nextInt();
                            if(arr[i]> flowersList.size()){
                                System.err.println("Введено неіснуючу квітку.");
                                throw new IllegalArgumentException();
                            }
                        }
                    }
                }
            }
            catch(InputMismatchException | IllegalArgumentException exception){
                System.err.println("Помилка введення, повторіть спробу. "+exception);
                email.SendMessage("Помилка введення даних\n",exception);
                scanner.next();
                return;
            }
            decor = list.addDecor(scanner);
            if(decor.getTotalPrice()==0){
                logger.warning("Не вдалося створити обгортку, через неправильний ввід даних");
                return;
            }
            else{
                logger.fine("Обгортку для букета успішно створено.");
            }
            list.createBouquetFromFlowersArray(arr,flowersList.getFlowerList(),decor);

        }
        else {
            logger.info("Початок формування букету з вибраних  квітів на проміжку.");
            int start, end;
            try {
                System.out.println("Введіть початок проміжку: ");
                start = scanner.nextInt();
                System.out.println("Введіть кінець проміжку: ");
                end = scanner.nextInt();
                if(start<1|| end> flowersList.size()){
                    throw new IllegalArgumentException();
                }
            } catch (InputMismatchException | IllegalArgumentException exception) {
                System.err.println("Помилка введення проміжку для створення букета.");
                logger.warning("Помилка введення проміжку для створення букета. "+exception);
                email.SendMessage("Помилка введення проміжку для створення букета.\n",exception);
                scanner.next();
                return;
            }
            decor = list.addDecor(scanner);
            if(decor.getTotalPrice()==0){
                logger.warning("Не вдалося створити обгортку, через неправильний ввід даних");
                return;
            }
            else{
                logger.fine("Обгортку для букета успішно створено.");
            }
            list.createBouquetOnInterval(start,end,flowersList.getFlowerList(),decor);
        }
        System.out.println("Букет успішно створено і додано до списку букетів.");
        logger.fine("Букет успішно створено і додано до списку букетів.");
    }

}
