package Menu.FlowerListCommand;

import FlowerList.FlowersList;
import Menu.Command;

import java.util.logging.Logger;

public class PrintFlowersListCommand implements Command {
    private final FlowersList list;
    private final Logger logger;

    public PrintFlowersListCommand(FlowersList list,Logger logger) {
        this.list = list;
        this.logger = logger;
    }
    @Override
    public void execute(){
        if(list.size()==0){
            System.out.println("Список квітів пустий.Додайте квіти, щоб виконати цю дію.");
            logger.info("Завершено роботу команди остільки список квітів порожній");
            return;
        }
        System.out.println("\tСписок квітів:");
        list.printFlowersList();
        logger.fine("Виведення успішно завершено.");
    }
}
