package TCPServer;

import Object.*;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.logging.*;
import java.util.*;
import java.util.stream.Collectors;

public class CollectionManager {
    private final TreeSet<StudyGroup> groups = new TreeSet<>();
    private Date initDate;
    private InteractionBD interactionBD;
    private Logger LOGGER;
    {
        LOGGER = Logger.getLogger(CollectionManager.class.getName());
    }

    public CollectionManager(InteractionBD interactionBD) {
        this.interactionBD = interactionBD;
        this.initDate = new Date();
        this.load();
    }

    /**
     *  Полуение элементов коллекции из БД в локальную коллекцию.
     */

    public void load() {
        int beginSize = groups.size();
        LOGGER.log(Level.INFO, "Идёт загрузка коллекции ");
        groups.addAll(interactionBD.load());
        LOGGER.log(Level.INFO, "Коллекция успешно загружена. Добавлено " + (groups.size() - beginSize) + " элементов.");
    }

    /**
     * Методы для выполнеия команд
     */

    public String averageOfStudentsCount() {
        synchronized (groups) {
            if (groups.size() != 0) {
                return "Среднее значение поля studentsCount для всех элементов коллекции: " + groups.stream()
                        .mapToInt(element -> element.getStudentsCount())
                        .average().getAsDouble();
            } return "В коллекции отсутствуют элементы. Выполнение команды не возможно.";
        }
    }

    public String clear(String login) {
        try {
            ArrayList<Integer> ids = interactionBD.clear(login);
            synchronized (groups) {
                groups.stream()
                        .filter(element -> ids.contains(element.getId()))
                        .collect(Collectors.toList())
                        .forEach(groups::remove);
            }
            return "Команда успешно выполнена. ";
        } catch (SQLException e) {
            return ("В коллекции не найдено вашей недвижимости.");
        }
    }

    public String countByGroupAdmin(Person groupAdmin) {
        synchronized (groups) {
            if (groups.size() != 0) {
                return "Количество элементов, значение поля groupAdmin которых равно " + groupAdmin.toString() + ": " +
                        groups.stream()
                                .filter(element -> element.getGroupAdmin().compareTo(groupAdmin) == 0)
                                .count();
            }
            return "В коллекции отсутствуют элементы. Выполнение команды не возможно.";
        }
    }

    public String countGreaterThanGroupAdmin(Person groupAdmin) {
        synchronized (groups) {
            if (groups.size() != 0) {
                return "Количество элементов, значение поля groupAdmin которых равно " + groupAdmin.toString() + ": " +
                        groups.stream()
                                .filter(element -> element.getGroupAdmin().compareTo(groupAdmin) > 0)
                                .count();
            }
            return "В коллекции отсутствуют элементы. Выполнение команды не возможно.";
        }
    }

    public String add(StudyGroup studyGroup, String login) {
        try {
            synchronized (groups) {
                groups.add( studyGroup);
            }
            interactionBD.add(studyGroup, login);
            return "Элемент добавлен.";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Чё-то не получилось, чё-то не считалось... Сорян, ну чё";
        }
    }

    public String addIfMax(StudyGroup studyGroup, String login) {
        if (groups.higher(studyGroup) == null) {
            return add(studyGroup,login);
        }
        return "Элемент не превосходит максимальный";
    }

    public String addIfMin(StudyGroup studyGroup, String login) {
        if (groups.lower(studyGroup) == null) {
            return add(studyGroup,login);
        }
        return "Элемент не меньше минимального";
    }

    public String removeById(Integer id, String login) {
        if (groups.size() != 0) {
            try {
                ArrayList<Integer> ids = new ArrayList<>(interactionBD.selectYourObjects(login));
                if (ids.contains(id)) {
                    interactionBD.remove(id);
                    synchronized (groups) {
                        groups.stream()
                                .filter(element -> element.getId() == id)
                                .collect(Collectors.toList())
                                .forEach(groups::remove);
                        return "Команда успешно выполнена.";
                    }
                } else return "Такого элемента не существует или он не принадлежит вам.";
            } catch (SQLException e) {
                return "Упс...";
            }
        } else return ("В коллекции отсутствуют элементы. Выполнение команды не возможно.");
    }

    public TreeSet<StudyGroup> show(){
        synchronized (groups) {
            return groups;
        }
    }

    public String update(Integer id, StudyGroup studyGroup, String login) {
        if (groups.size() != 0) {
            try {
                ArrayList<Integer> ids = new ArrayList<>(interactionBD.selectYourObjects(login));
                try {
                    if (ids.contains(id)) {
                        interactionBD.update(id, studyGroup, login);
                        synchronized (groups) {
                            studyGroup.setId(id);

                            groups.stream()
                                    .filter(group -> group.getId() == id)
                                    .collect(Collectors.toList())
                                    .forEach(group -> {
                                        studyGroup.setColor(group.getColor());
                                        groups.remove(group);
                                        groups.add(studyGroup);
                                    });
                            return "Команда успешно выполнена.";
                        }
                    } else return "Элемент не принадлежит вам! Фу как не культурно изменять объекты других!!";
                } catch (SQLException e) {
                    e.printStackTrace();
                    return "Проблемы с подключением";
                }
            } catch (SQLException e) {
                return "В коллекции нет элементов с соответствующими ай-ди";
            }
        } else return ("В коллекции отсутствуют элементы. Выполнение команды не возможно.");
    }
    /**
     * Выводит информацию о коллекции.
     */
    @Override
    public String toString() {
        return "Тип коллекции: " + groups.getClass() +
                "\nДата инициализации: " + initDate +
                "\nКоличество элементов: " + groups.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CollectionManager)) return false;
        CollectionManager manager = (CollectionManager) o;
        return groups.equals(manager.groups) &&
                initDate.equals(manager.initDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groups, initDate);
    }
}