package Menu;

public class ExitMenuCommand implements Command{

    public ExitMenuCommand() {

    }

    @Override
    public void execute() {
        System.out.println("Робота з меню завершена.");
    }
}
