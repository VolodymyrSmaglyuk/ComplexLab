package Menu.BouquetCommands;

import Bouquet.Bouquet;
import BouquetList.BouquetList;
import Menu.Command;

import java.util.logging.Logger;


public class DeleteBouquetCommand implements Command {
    private final BouquetList list;
    private final Bouquet bouquet;
    private final Logger logger;
    public DeleteBouquetCommand(BouquetList list,Bouquet bouquet,Logger logger) {
        this.list = list;
        this.bouquet=bouquet;
        this.logger=logger;
    }

    @Override
    public void execute() {
        list.deleteBouquet(bouquet);
        System.out.println("Букет видалено.");
        logger.fine("Букет було видалено.");
    }
}
