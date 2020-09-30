package controllers.Bundles;

import java.util.ListResourceBundle;

public class Resource_ru extends ListResourceBundle {

    @Override
    protected Object[][] getContents() {
        return contents;
    }

    private static final Object[][] contents = {
            {"dialog.error", "Ошибка"},
            {"dialog.warning", "Предупреждение"},
            {"dialog.info", "Информация"},
            {"connection", "Подключение"},
            {"sender.notfull", "Поля объекта введены неполностью. Команда не может быть выполнена. \n"},
            {"sender.uncorrect", "Команда некорректна. \n"},
            {"sender.notInt", "Аргумент не является значением типа Integer. Команда некорректна.\n"},
            {"sender.script1", "Файла с таким названием не существует. \n"},
            {"sender.script2", "Файл защищён от чтения. Невозможно выполнить скрипт.\n"},
            {"sender.script3", "Могло произойти зацикливание при исполнении скрипта: "},
            {"sender.script4", "\nКоманда не будет выполнена. Переход к следующей команде \n"},
            {"sender.script5", "Невозможно считать скрипт \n"},

            //главная страница
            {"sender.troubles", "Проблемы с передачей на сервер..."},
            {"filter", "фильтр"},
            {"name", "имя"},
            {"studentsCount", "количество студентов"},
            {"expelledStudents", "отчисленные студенты"},
            {"coordinates", "координаты"},
            {"averageMark", "средний балл"},
            {"semester", "семестр"},
            {"date", "дата создания"},
            {"person", "человек"},
            {"height", "рост"},
            {"weight", "вес"},
            {"location", "место"},
            {"map", "карта"},
            {"table", "таблица"},
            {"lang", "язык"},
            {"user", "пользователь"},
            {"commands", "команды"},
            {"more", "еще"},
            {"info", "информация"},
            {"help", "справка"},
            {"update", "изменить"},
            {"add", "добавить"},
            {"addMax", "добавить, если наибольший"},
            {"addMin", "добавить, если наименьший"},
            {"remove", "удалить элемент по id"},
            {"count", "количество админов с такими же параметрами"},
            {"countGreater", "количество админов с бОльшими параметрами"},
            {"average", "среднее количество студентов в группе"},
            {"execute", "выполнить скрипт"},
            {"chose_script", "выбрать файл для скрипта"},
            {"clear", "очистить коллекцию"},
            {"history", "история"},
            //filterPlus
            {"from", "от"},
            {"to", "до"},
            {"apply", "применить"},
            {"only.my", "Показать только мои элементы"},
            {"cl", "очистить фильтр"},

            // add
            {"question", "Заполнить поля по id?"},
            {"yes", "ДА"},
            {"incorrectInsert", "Неправильный формат введенных данных. Исправьте значения следующих полей:"},
            {"noId", "Элемента с таким Id в коллекции нет"},
            {"field1","Значение поля "},
            {"field2"," должно быть "},
            {"field3"," больше "},
            {"field4"," меньше "},
            {"field5"," не может быть пустым."},

            {"locationName"," имя места "},
            {"removeButton","удалить"},
    };
}
