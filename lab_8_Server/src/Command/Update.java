package Command;

import TCPServer.CollectionManager;
import Object.*;
import java.util.ArrayList;

/**
 * обновить значение элемента коллекции, id которого равен заданному.
 */
public class Update extends Command{
    private int id;
    private ArrayList<String> loginAndPassword;
    public Update(CollectionManager manager, Integer id, ArrayList<String> loginAndPassword) {
        super(manager);
        this.loginAndPassword = loginAndPassword;
        this.id = id;
        setDescription("обновить значение элемента коллекции, id которого равен заданному.");
    }

    @Override
    public Object execute(Object args) {return getManager().update(id, (StudyGroup) args, loginAndPassword.get(0));}
}