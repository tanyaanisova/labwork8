package controllers.Bundles;

import java.util.ListResourceBundle;

public class Resource_no extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        return contents;
    }
    private static final Object[][] contents = {
            {"dialog.error", "Feil"},
            {"dialog.warning", "Advarsel"},
            {"dialog.info", "Informasjon"},
            {"connection", "Forbindelse"},
            {"sender.notfull", "Felt på objektet er ikke lagt inn helt. Kommandoen kunne ikke utføres.\n"},
            {"sender.uncorrect", "Kommandoen er feil. \n"},
            {"sender.notInt", "Argumentet er ikke en heltallverdi. Kommandoen er feil.\n"},
            {"sender.script1", "En fil med dette navnet eksisterer ikke. \n"},
            {"sender.script2", "Filen er lesbeskyttet. Kan ikke utføre skript\n"},
            {"sender.script3", "Looping kan oppstå under kjøring av skript: "},
            {"sender.script4", "\nKommandoen blir ikke utført. Gå til neste lag \n"},
            {"sender.script5", "Kan ikke lese skript \n"},
            //главная страница
            {"sender.troubles", "Problemer med overføring til serveren..."},
            {"filter", "filter"},
            {"name", "Navn"},
            {"studentsCount", "studenter teller"},
            {"expelledStudents", "utvist studenter"},
            {"coordinates", "koordinater"},
            {"averageMark", "gjennomsnittlig karakter"},
            {"semester", "semester"},
            {"date", "opprettelsesdato"},
            {"person", "person"},
            {"height", "høyde"},
            {"weight", "vekt"},
            {"location", "plassering"},
            {"map", "kart"},
            {"table", "bord"},
            {"lang", "Språk"},
            {"user", "brukernavn"},
            {"commands", "kommandoer"},
            {"more", "mer"},
            {"info", "info"},
            {"help", "hjelp"},
            {"update", "Oppdater"},
            {"add", "legge til"},
            {"addMax", "legg til hvis maks"},
            {"addMin", "legg til hvis min"},
            {"remove", "fjern etter id"},
            {"count", "telle gruppeadministrator"},
            {"countGreater", "teller større enn gruppeadministrator"},
            {"average", "gjennomsnittlige studenter teller"},
            {"execute", "utføre skript"},
            {"chose_script", "velg manus"},
            {"clear", "tydelig samling"},
            {"history", "historie"},
            //filterPlus
            {"from", "fra"},
            {"to", "til"},
            {"apply", "søke om"},
            {"only.my", "Vis bare elementene mine"},
            {"cl", "tøm filter"},

            // add
            {"question", "Fyll ut feltene med Id?"},
            {"yes", "JA"},
            {"incorrectInsert", "Ugyldig inndataformat. Korriger verdiene for følgende felt:"},
            {"noId", "Det er ingen ting med denne IDen i samlingen"},
            {"field1","Verdien på "},
            {"field2"," være "},
            {"field3"," større "},
            {"field4"," mindre "},
            {"field5"," kan ikke være tom."},

            {"locationName"," stedsnavn "},
            {"removeButton","fjern"},
    };
}
