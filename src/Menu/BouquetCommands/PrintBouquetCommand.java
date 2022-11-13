package Menu.BouquetCommands;

import Bouquet.Bouquet;
import Menu.Command;

import java.util.logging.Logger;


public class PrintBouquetCommand implements Command {
    private final Bouquet bouquet;
    private final Logger logger;

    public PrintBouquetCommand(Bouquet bouquet,Logger logger) {
        this.bouquet = bouquet;
        this.logger = logger;
    }
    @Override
    public void execute(){
        bouquet.printInfo();
        logger.fine("Букет успішно виведено.");
    }
}
