package Command;

import TCPServer.CollectionManager;

import java.util.ArrayList;

/**
 * удалить элемент из коллекции по его id.
 */
public class RemoveById extends Command {
    private ArrayList<String> loginAndPassword;
    public RemoveById(CollectionManager manager, ArrayList<String> loginAndPassword) {
        super(manager);
        this.loginAndPassword = loginAndPassword;
        setDescription("удалить элемент из коллекции по его id.");
    }

    @Override
    public Object execute(Object args) { return getManager().removeById((Integer) args, loginAndPassword.get(0));}
}
