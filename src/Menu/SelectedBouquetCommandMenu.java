package Menu;

import java.io.FileNotFoundException;

public class SelectedBouquetCommandMenu {
    private Command command;

    public SelectedBouquetCommandMenu() {
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
                        1.Вивести букет.
                        2.Вивести квіти з бекету посортовані за рівнем свіжості.
                        3.Вивести квіти з букету, довжина стебел яких, є в заданому діапазоні.
                        4.Видалити букет.
                        5.Змінити властивості квітів в букеті.
                        6.Зберегти букет в файл.
                        7.Завершити роботу з букетом.
                        """);
    }
}
