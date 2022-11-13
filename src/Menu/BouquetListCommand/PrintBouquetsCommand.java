package Menu.BouquetListCommand;

import BouquetList.BouquetList;
import Menu.Command;

import java.io.FileNotFoundException;
import java.util.logging.Logger;

public class PrintBouquetsCommand implements Command {
    private final BouquetList list;
    private final Logger logger;

    public PrintBouquetsCommand(BouquetList list,Logger logger) {
        this.list = list;
        this.logger=logger;
    }
    @Override
    public void execute() throws FileNotFoundException {
        logger.info("Початок виведення списку букетів.");
        if(list.getBouquetList().size()==0) {
            System.out.println("Список букетів порожній.");
            logger.info("Завершено виконнання команди оскільки оскільки список букетів порожній.");
            return;
        }
        System.out.println("Список букетів:");
        list.printBouquetsList();
        logger.fine("Список букетів успішно виведено.");
    }
}
