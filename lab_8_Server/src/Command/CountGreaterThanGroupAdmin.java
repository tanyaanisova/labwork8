package Command;

import TCPServer.CollectionManager;
import Object.*;

/**
 * вывести количество элементов, значение поля groupAdmin которых больше заданного.
 */
public class CountGreaterThanGroupAdmin extends Command {
    public CountGreaterThanGroupAdmin(CollectionManager manager) {
        super(manager);
        setDescription("вывести количество элементов, значение поля groupAdmin которых больше заданного.");
    }

    @Override
    public Object execute(Object args) {
        return getManager().countGreaterThanGroupAdmin((Person) args);
    }
}
