package Object;

import java.io.Serializable;
import java.text.DateFormat;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Objects;
import java.util.ResourceBundle;

public class LocalStudyGroup extends StudyGroup {

    String date;

    public LocalStudyGroup(StudyGroup group) {
        super(group.getId(),
                group.getName(),
                group.getCoordinates(),
                group.getCreationDate(),
                group.getStudentsCount(),
                group.getExpelledStudents(),
                group.getAverageMark(),
                group.getSemesterEnum(),
                group.getGroupAdmin(),
                group.getUserID(),
                group.getColor());
                date = getCreationDate().toLocalDateTime().toString();
    }

    public Float getCoordinatesX() {return getCoordinates().getX(); }
    public Long getCoordinatesY() {return getCoordinates().getY(); }
    public String getGroupAdminName() {return getGroupAdmin().getName(); }
    public Double getGroupAdminHeight() {return getGroupAdmin().getHeight(); }
    public Long getGroupAdminWeight() {return getGroupAdmin().getWeight(); }
    public String getLocationName() {return getGroupAdmin().getLocation().getName(); }
    public Double getLocationX() {return getGroupAdmin().getLocation().getX(); }
    public Long getLocationY() {return getGroupAdmin().getLocation().getY(); }
    public Integer getLocationZ() {return getGroupAdmin().getLocation().getZ(); }
    public String getLocalCreationDate() {
        return date;
    }

    public void setLocalCreationDate(ResourceBundle bundle) {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM, FormatStyle.MEDIUM).withLocale(bundle.getLocale());
        date = getCreationDate().format(dateFormat);
    }

}