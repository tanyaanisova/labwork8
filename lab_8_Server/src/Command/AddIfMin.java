package Command;

import TCPServer.CollectionManager;
import Object.*;
import java.util.ArrayList;

/**
 * добавить новый элемент.
 */
public class AddIfMin extends Command {
    private ArrayList<String> loginAndPassword;
    public AddIfMin(CollectionManager manager, ArrayList<String> loginAndPassword) {
        super(manager);
        this.loginAndPassword = loginAndPassword;
        setDescription("добавить новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции.");
    }

    @Override
    public Object execute(Object args) {
        return getManager().addIfMin((StudyGroup) args, loginAndPassword.get(0));
    }
}