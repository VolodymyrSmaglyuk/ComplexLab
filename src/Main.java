import BouquetList.BouquetList;
import FlowerList.FlowersList;
import Menu.BouquetListCommand.CreateBouquetCommand;
import Menu.BouquetListCommand.PrintBouquetsCommand;
import Menu.BouquetListCommand.SelectBouquetCommand;
import Menu.CommandMenu;
import Menu.ExitMenuCommand;
import Menu.FlowerListCommand.AddFlowerCommand;
import Menu.FlowerListCommand.DeleteFlowerCommand;
import Menu.FlowerListCommand.ModifyFlowerCommand;
import Menu.FlowerListCommand.PrintFlowersListCommand;
import Menu.SaveInFileCommand;

import java.io.IOException;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.*;

public class Main {
    public static final Logger logger = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) throws IOException {
        SetupLogger();
        BouquetList bouquetList = new BouquetList();
        FlowersList flowersList = new FlowersList();
        CommandMenu menu = new CommandMenu();
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        int select=0;
        menu.PrintCommandMenu();
        while (select!=9){
            System.out.println("Оберіть команду: ");
            try {
                select = scanner.nextInt();
            }
            catch(InputMismatchException ime){
                System.err.println("Введено неправильний тип даних");
                logger.warning("Введено неправильний тип даних\n"+ime);
                scanner.next();
                continue;
            }
            logger.info("Вибір команди завершено.");
            switch (select) {
                case 0 -> {
                    menu.PrintCommandMenu();
                    continue;
                }
                case 1 -> menu.SetCommand(new AddFlowerCommand(flowersList, scanner,logger));
                case 2 -> menu.SetCommand(new DeleteFlowerCommand(flowersList, scanner,logger));
                case 3 -> menu.SetCommand(new ModifyFlowerCommand(flowersList, scanner,logger));
                case 4 -> menu.SetCommand(new PrintFlowersListCommand(flowersList,logger));
                case 5 -> menu.SetCommand(new CreateBouquetCommand(bouquetList, flowersList, scanner,logger));
                case 6 -> menu.SetCommand(new SelectBouquetCommand(bouquetList, scanner,logger));
                case 7 -> menu.SetCommand(new PrintBouquetsCommand(bouquetList,logger));
                case 8 -> menu.SetCommand(new SaveInFileCommand(scanner, flowersList, bouquetList,logger));
                case 9 -> {
                    menu.SetCommand(new ExitMenuCommand());
                    scanner.close();
                    logger.fine("Програму завершено.");
                }
                default -> {
                    System.out.println("Неправильна команда, спробуйте ще раз.");
                    logger.info("Введено помилкову команду.");
                    continue;
                }
            }
            menu.RunCommand();
        }
    }
    static void SetupLogger() throws IOException {
        Handler fileHandler = new FileHandler("C:\\LP\\ПП\\Lab4-8\\ComplexLab\\LogFile\\Logger.log");
        Main.logger.setUseParentHandlers(false);
        fileHandler.setFormatter(new MyFormatter());
        Main.logger.addHandler(fileHandler);
    }
    static class MyFormatter extends Formatter{
        @Override
        public String format(LogRecord record) {

            Date date = new Date(record.getMillis());//record.getMillis()
            return "\nDate: "+date+"\nLevel :"+record.getLevel()+"\nClass:" +record.getSourceClassName()+
                    " Method name: "+record.getSourceMethodName()+"\nMessage: "+record.getMessage()+"\n";
        }
    }

}