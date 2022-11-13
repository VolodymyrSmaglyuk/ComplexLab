package Menu.BouquetCommands;

import Bouquet.Bouquet;
import Menu.Command;

import java.util.logging.Logger;

public class PrintSortedFlowersCommand implements Command {
    private final Bouquet bouquet;
    private final Logger logger;

    public PrintSortedFlowersCommand(Bouquet bouquet, Logger logger) {
        this.bouquet = bouquet;
        this.logger=logger;
    }
    @Override
    public void execute(){
        logger.info("Сортується букет за рівнем свіжості квітів.");
        bouquet.sortFreshness();
        System.out.println("Відсортований за рівнем свіжості квітів в букеті масив квітів.");
        bouquet.printInfo();
        logger.fine("Відсортований букет було успішно виведено.");
    }
}
