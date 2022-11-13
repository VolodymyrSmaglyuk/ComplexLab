package Menu;

import java.io.FileNotFoundException;

public class CommandMenu {
    private Command command;

    public CommandMenu() {
    }
    public void SetCommand(Command command){
        this.command=command;
    }
    public void RunCommand() throws FileNotFoundException {
        command.execute();
    }
    public void PrintCommandMenu(){
        System.out.println("\tСписок Доступних команд");
        System.out.println(
                """
                        0.Вивести меню.
                        1.Додати квітку.
                        2.Видалити квітку.
                        3.Модифікувати вже існуючу квітку.
                        4.Вивести список створених квітів.
                        5.Створити букет з раніше створених квітів.
                        6.Вибрати один з наявних букетів.
                        7.Вивести список наявних букетів.
                        8.Збереження у файл.
                        9.Завершити роботу.
                        """);
    }
}
