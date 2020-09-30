package Command;

import TCPServer.CollectionManager;

/**
 *  вывести среднее значение поля studentsCount для всех элементов коллекции.
 */
public class AverageOfStudentsCount extends Command {
    public AverageOfStudentsCount(CollectionManager manager) {
        super(manager);
        setDescription("вывести среднее значение поля studentsCount для всех элементов коллекции.");
    }

    @Override
    public Object execute(Object args) { return getManager().averageOfStudentsCount(); }
}
