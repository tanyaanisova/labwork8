package controllers.Bundles;

import java.util.ListResourceBundle;

public class Resource_hu extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        return contents;
    }
    private static final Object[][] contents = {
            {"dialog.error", "Hiba"},
            {"dialog.warning", "Figyelem"},
            {"dialog.info", "Információ"},
            {"connection", "Kapcsolat"},
            {"sender.notfull", "Az objektum mezői nincsenek teljesen megadva. A parancsot nem sikerült végrehajtani.\n"},
            {"sender.uncorrect", "A parancs helytelen. \n"},
            {"sender.notInt", "Az argumentum nem egész szám. A parancs helytelen.\n"},
            {"sender.script1", "Az ilyen névű fájl nem létezik. \n"},
            {"sender.script2", "A fájl olvasásvédett. Nem lehet végrehajtani a szkriptet.\n"},
            {"sender.script3", "Hurok fordulhat elő a szkript végrehajtása során:"},
            {"sender.script4", "\nA parancs nem kerül végrehajtásra. Ugrás a következő csapatra\n"},
            {"sender.script5", "Nem lehet olvasni a szkriptet\n"},
            //главная страница
            {"sender.troubles", "Problémák a kiszolgálóra történő átvitel során..."},
            {"filter", "szűrő"},
            {"key", "kulcs"},
            {"name", "név"},
            {"studentsCount", "diákok gróf"},
            {"expelledStudents", "kizárt hallgatók"},
            {"coordinates", "koordináták"},
            {"averageMark", "átlagos jegyek"},
            {"semester", "szemeszter"},
            {"date", "dátum"},
            {"person", "személy"},
            {"height", "magasság"},
            {"weight", "súly"},
            {"location", "elhelyezkedés"},
            {"map", "térkép"},
            {"table", "asztal"},
            {"lang", "nyelv"},
            {"user", "felhasználó"},
            {"commands", "parancsokat"},
            {"more", "több"},
            {"info", "információ"},
            {"help", "Segítség"},
            {"update", "frissítés"},
            {"add", "hozzá"},
            {"addMax", "add, ha max"},
            {"addMin", "add hozzá, ha min"},
            {"remove", "eltávolítás id-vel"},
            {"count", "gróf csoport admin"},
            {"countGreater", "nagyobb, mint a csoport admin"},
            {"average", "átlagos diákok számítanak"},
            {"execute", "futtassa a szkriptet"},
            {"chose_script", "választotta a forgatókönyvet"},
            {"clear", "tiszta gyűjtemény"},
            {"history", "történelem"},
            //filterPlus
            {"from", "tól től"},
            {"to", "nak nek"},
            {"apply", "alkalmaz"},
            {"only.my", "Csak az elemeimet mutassa meg"},
            {"cl", "tiszta szűrő"},

            // add
            {"question", "Töltse ki a mezőket id?"},
            {"yes", "IGEN"},
            {"incorrectInsert", "Érvénytelen bemeneti formátum. Javítsa ki a következő mezők értékeit:"},
            {"noId", "Id nincs ilyen azonosító elem"},
            {"field1","A mező értéké "},
            {"field2"," kell lennie "},
            {"field3"," nagyobbnak "},
            {"field4"," kevesebbnek "},
            {"field5"," nem lehet üres."},

            {"locationName"," a helyszín neve "},
            {"removeButton","eltávolítás"},
    };
}
