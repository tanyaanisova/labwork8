package controllers;

import java.util.*;
import java.util.stream.Collectors;

import Object.*;

public class Filter {

    private Integer userId;
    private Integer idFrom;
    private Integer idTo;
    private Float xFrom;
    private Float xTo;
    private Long yFrom;
    private Long yTo;
    private Integer studentsCountFrom;
    private Integer studentsCountTo;
    private Long expelledStudentsFrom;
    private Long expelledStudentsTo;
    private Float averageMarkFrom;
    private Float averageMarkTo;
    private Double heightFrom;
    private Double heightTo;
    private Long weightFrom;
    private Long weightTo;
    private Double localXFrom;
    private Double localXTo;
    private Long localYFrom;
    private Long localYTo;
    private Integer localZFrom;
    private Integer localZTo;
    private boolean showOnlyMyElement;
    private String semester;
    private ResourceBundle bundle;


    Filter(Integer userID, ResourceBundle bundle) {
        this.bundle = bundle;
        this.userId = userID;
        clearVars();
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public void setyFrom(Long yFrom) {
        this.yFrom = yFrom;
    }
    public void setyTo(Long yTo) {
        this.yTo = yTo;
    }
    public void setxTo(Float xTo) {
        this.xTo = xTo;
    }
    public void setxFrom(Float xFrom) {
        this.xFrom = xFrom;
    }
    public void setIdTo(Integer idTo) {
        this.idTo = idTo;
    }
    public void setIdFrom(Integer idFrom) {
        this.idFrom = idFrom;
    }
    public void setStudentsCountFrom(Integer studentsCountFrom) {
        this.studentsCountFrom = studentsCountFrom;
    }
    public void setShowOnlyMyElement(boolean showOnlyMyElement) {
        this.showOnlyMyElement = showOnlyMyElement;
    }
    public void setStudentsCountTo(Integer studentsCountTo) {
        this.studentsCountTo = studentsCountTo;
    }
    public void setAverageMarkFrom(Float averageMarkFrom) {
        this.averageMarkFrom = averageMarkFrom;
    }
    public void setAverageMarkTo(Float averageMarkTo) {
        this.averageMarkTo = averageMarkTo;
    }
    public void setExpelledStudentsFrom(Long expelledStudentsFrom) {
        this.expelledStudentsFrom = expelledStudentsFrom;
    }
    public void setExpelledStudentsTo(Long expelledStudentsTo) {
        this.expelledStudentsTo = expelledStudentsTo;
    }
    public void setHeightFrom(Double heightFrom) {
        this.heightFrom = heightFrom;
    }
    public void setHeightTo(Double heightTo) {
        this.heightTo = heightTo;
    }
    public void setLocalXFrom(Double localXFrom) {
        this.localXFrom = localXFrom;
    }
    public void setLocalXTo(Double localXTo) {
        this.localXTo = localXTo;
    }
    public void setLocalYFrom(Long localYFrom) {
        this.localYFrom = localYFrom;
    }
    public void setLocalYTo(Long localYTo) {
        this.localYTo = localYTo;
    }
    public void setLocalZFrom(Integer localZFrom) {
        this.localZFrom = localZFrom;
    }
    public void setLocalZTo(Integer localZTo) {
        this.localZTo = localZTo;
    }
    public void setSemester(String semester) {
        this.semester = semester;
    }
    public void setWeightFrom(Long weightFrom) {
        this.weightFrom = weightFrom;
    }
    public void setWeightTo(Long weightTo) {
        this.weightTo = weightTo;
    }

    public Float getxFrom() {
        return xFrom;
    }
    public Float getxTo() {
        return xTo;
    }
    public Integer getIdFrom() {
        return idFrom;
    }
    public Integer getIdTo() {
        return idTo;
    }
    public Integer getStudentsCountFrom() {
        return studentsCountFrom;
    }
    public Integer getUserId() {
        return userId;
    }
    public Integer getStudentsCountTo() {
        return studentsCountTo;
    }
    public Long getyFrom() {
        return yFrom;
    }
    public Long getExpelledStudentsFrom() {
        return expelledStudentsFrom;
    }
    public Long getyTo() {
        return yTo;
    }
    public Float getAverageMarkFrom() {
        return averageMarkFrom;
    }
    public Double getHeightFrom() {
        return heightFrom;
    }
    public Double getHeightTo() {
        return heightTo;
    }
    public Double getLocalXFrom() {
        return localXFrom;
    }
    public Double getLocalXTo() {
        return localXTo;
    }
    public Float getAverageMarkTo() {
        return averageMarkTo;
    }
    public Long getExpelledStudentsTo() {
        return expelledStudentsTo;
    }
    public Integer getLocalZFrom() {
        return localZFrom;
    }
    public Integer getLocalZTo() {
        return localZTo;
    }
    public Long getLocalYFrom() {
        return localYFrom;
    }
    public Long getLocalYTo() {
        return localYTo;
    }
    public Long getWeightFrom() {
        return weightFrom;
    }
    public Long getWeightTo() {
        return weightTo;
    }
    public String getSemester() {
        return semester;
    }
    public boolean isShowOnlyMyElement() {
        return showOnlyMyElement;
    }

    public void clearVars() {
        userId = null;
        idFrom = null;
        idTo = null;
        xFrom = null;
        xTo = null;
        yFrom = null;
        yTo = null;
        studentsCountFrom = null;
        studentsCountTo = null;
        expelledStudentsFrom = null;
        expelledStudentsTo = null;
        averageMarkFrom = null;
        averageMarkTo = null;
        heightFrom = null;
        heightTo = null;
        weightFrom = null;
        weightTo = null;
        localXFrom = null;
        localXTo = null;
        localYFrom = null;
        localYTo = null;
        localZFrom = null;
        localZTo = null;
        showOnlyMyElement = false;
        semester = "all";
    }

    public List<LocalStudyGroup> filter(TreeSet<StudyGroup> filteringCollection) {
        List<LocalStudyGroup> filteredKey = new ArrayList<LocalStudyGroup>();
        filteringCollection.forEach(t -> filteredKey.add(new LocalStudyGroup(t)));
        return filteredKey.stream().filter(group -> {
            if (showOnlyMyElement)
                if (!group.getUserID().equals(userId))
                    return false;
            if (idFrom != null && group.getId() < idFrom)
                return false;
            if (idTo != null && group.getId() > idTo)
                return false;
            if (xFrom != null && group.getCoordinatesX() < xFrom)
                return false;
            if (xTo != null && group.getCoordinatesX() > xTo)
                return false;
            if (yFrom != null && group.getCoordinatesY() < yFrom)
                return false;
            if (yTo != null && group.getCoordinatesY() > yTo)
                return false;
            if (studentsCountFrom != null && group.getStudentsCount() < studentsCountFrom)
                return false;
            if (studentsCountTo != null && group.getStudentsCount() > studentsCountTo)
                return false;
            if (expelledStudentsFrom != null && group.getExpelledStudents() < expelledStudentsFrom)
                return false;
            if (expelledStudentsTo != null && group.getExpelledStudents() > expelledStudentsTo)
                return false;
            if (averageMarkFrom != null && group.getAverageMark() < averageMarkFrom)
                return false;
            if (averageMarkTo != null && group.getAverageMark() > averageMarkTo)
                return false;
            if (heightFrom != null && group.getGroupAdminHeight() < heightFrom)
                return false;
            if (heightTo != null && group.getGroupAdminHeight() > heightTo)
                return false;
            if (weightFrom != null && group.getGroupAdminWeight() < weightFrom)
                return false;
            if (weightTo != null && group.getGroupAdminWeight() > weightTo)
                return false;
            if (localXFrom != null && group.getLocationX() < localXFrom)
                return false;
            if (localXTo != null && group.getLocationX() > localXTo)
                return false;
            if (localYFrom != null && group.getLocationY() < localYFrom)
                return false;
            if (localYTo != null && group.getLocationY() > localYTo)
                return false;
            if (localZFrom != null && group.getLocationZ() < localZFrom)
                return false;
            if (localZTo != null && group.getLocationZ() > localZTo)
                return false;
            if (!semester.equals("all") && !semester.equals(group.getSemesterEnum().toString()))
                    return false;
            group.setLocalCreationDate(bundle);
            return true;
        }).collect(Collectors.toList());
    }
}
