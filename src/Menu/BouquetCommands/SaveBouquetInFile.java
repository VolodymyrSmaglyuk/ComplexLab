package Menu.BouquetCommands;

import Bouquet.Bouquet;
import Menu.Command;

import java.io.FileNotFoundException;
import java.util.logging.Logger;

public class SaveBouquetInFile implements Command {
    private final Bouquet bouquet;
    private final Logger logger;

    public SaveBouquetInFile(Bouquet bouquet, Logger logger) {
        this.bouquet = bouquet;
        this.logger = logger;
    }

    @Override
    public void execute() throws FileNotFoundException {
        if(bouquet.saveBouquetInFile()==1){
            System.out.println("Букет збережено в файл.");
        }
        else{
            logger.warning("Не вдалося зберегти дані у файл.");
        }
    }
}