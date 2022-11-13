package Menu;

import java.io.FileNotFoundException;

public interface Command {
    public void execute() throws FileNotFoundException;
}
