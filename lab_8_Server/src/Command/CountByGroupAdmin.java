package Command;

import TCPServer.CollectionManager;
import Object.*;

/**
 * вывести количество элементов, значение поля groupAdmin которых равно заданному.
 */
public class CountByGroupAdmin extends Command {
    public CountByGroupAdmin(CollectionManager manager) {
        super(manager);
        setDescription("вывести количество элементов, значение поля groupAdmin которых равно заданному.");
    }

    @Override
    public Object execute(Object args) {
        return getManager().countByGroupAdmin((Person) args);
    }
}