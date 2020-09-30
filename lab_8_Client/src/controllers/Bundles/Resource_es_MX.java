package controllers.Bundles;

import java.util.ListResourceBundle;

public class Resource_es_MX extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        return contents;
    }
    private static final Object[][] contents = {
            {"dialog.error", "Error"},
            {"dialog.warning", "Advertencia"},
            {"dialog.info", "Información"},
            {"connection", "conexión"},
            {"sender.notfull", "Los campos del objeto no se ingresan completamente. El comando no se pudo ejecutar. \n"},
            {"sender.uncorrect", "El comando es incorrecto. \n"},
            {"sender.notInt", "El argumento no es un valor Integer. El comando es incorrecto.\n"},
            {"sender.script1", "Un archivo con este nombre no existe.\n"},
            {"sender.script2", "El archivo está protegido contra lectura. No se puede ejecutar el script.\n"},
            {"sender.script3", "Un bucle podría ocurrir durante la ejecución del script:"},
            {"sender.script4", "\nEl comando no se ejecutará. Ir al siguiente equipo \n"},
            {"sender.script5", "No se puede leer el guión \n"},
            //главная страница
            {"sender.troubles", "Problemas al transferir al servidor..."},
            {"filter", "filtrar"},
            {"name", "nombre"},
            {"studentsCount", "estudiantes cuentan"},
            {"expelledStudents", "estudiantes expulsados"},
            {"coordinates", "coordenadas"},
            {"averageMark", "marca promedio"},
            {"semester", "semestre"},
            {"date", "fecha de creación"},
            {"person", "persona"},
            {"height", "altura"},
            {"weight", "peso"},
            {"location", "ubicación"},
            {"map", "mapa"},
            {"table", "mesa"},
            {"lang", "idioma"},
            {"user", "nombre de usuario"},
            {"commands", "comandos"},
            {"more", "más"},
            {"info", "información"},
            {"help", "ayuda"},
            {"update", "actualizar"},
            {"add", "añadir"},
            {"addMax", "agregar si max"},
            {"addMin", "agregar si min"},
            {"remove", "eliminar por id"},
            {"count", "cuenta administrador del grupo"},
            {"countGreater", "contar más que el administrador del grupo"},
            {"average", "los estudiantes promedio cuentan"},
            {"execute", "ejecutar script"},
            {"chose_script", "elegir guion"},
            {"clear", "colección clara"},
            {"history", "historia"},
            //filterPlus
            {"from", "de"},
            {"to", "a"},
            {"apply", "aplicar"},
            {"only.my", "Mostrar solo mis elementos"},
            {"cl", "filtro claro"},

            // add
            {"question", "Rellene los campos por id?"},
            {"yes", "SI"},
            {"incorrectInsert","Formato de entrada inválido. Corrija los valores de los siguientes campos:"},
            {"noId", "No hay ningún elemento con este Id en la colección."},
            {"field1","El valor del campo "},
            {"field2"," debe ser "},
            {"field3"," mayor "},
            {"field4"," menor "},
            {"field5"," no puede estar vacío."},

            {"locationName"," nombre del lugar "},
            {"removeButton","eliminar"},
    };
}
