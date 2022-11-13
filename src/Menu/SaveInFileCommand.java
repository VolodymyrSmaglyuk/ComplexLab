package Menu;

import BouquetList.BouquetList;
import EmailSender.Email;
import FlowerList.FlowersList;

import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Logger;

public class SaveInFileCommand implements Command{
    private final Scanner scanner;
    private final FlowersList flowersList;
    private final BouquetList bouquetList;
    private final Logger logger;
    private  final Email email = new Email();

    public SaveInFileCommand(Scanner scanner, FlowersList flowersList, BouquetList bouquetList,Logger logger) {
        this.scanner = scanner;
        this.flowersList = flowersList;
        this.bouquetList = bouquetList;
        this.logger=logger;
    }


    @Override
    public void execute() throws FileNotFoundException {
        logger.info("Початок роботи команди по запису даних у файл.");
        if(flowersList.getFlowerList().size()==0 && bouquetList.getBouquetList().size()==0){
            System.out.println("Обидва списки пусті.Для виконання операції, заповніть списки.");
            logger.info("Завершено роботу команди остільки обидва списки пусті.");
            return;
        }
        System.out.println(
                """
                        1.Зберегти список квітів в файл.
                        2.Зберегти список букетів у файл.
                        """);
        int input;
        System.out.println("Оберіть команду:");
        try{
            input = this.scanner.nextInt();
            if(input>2 || input <1){
                throw new IllegalArgumentException();
            }
        }catch(InputMismatchException | IllegalArgumentException exception){
            System.err.println("Помилка введення даних або такої команди немає.");
            logger.warning("Помилка введення даних або такої команди немає."+exception);
            email.SendMessage("Помилка введення даних або такої команди немає.\n",exception);
            scanner.next();
            return;
        }
        if(input ==1) {
            if(flowersList.saveFlowerListInFile()==1){
                System.out.println("Дані записано в файл.");
                logger.fine("Дані записано в файл.");
            }
            else{
                logger.warning("Не вдалося зберегти дані у файл.");
            }
        } else  {
            if(bouquetList.saveBouquetListInFile()==1){
                System.out.println("Дані записано в файл.");
                logger.fine("Дані записано в файл.");
            }
            else{
                logger.warning("Не вдалося зберегти дані у файл.");
            }
        }
    }
}
