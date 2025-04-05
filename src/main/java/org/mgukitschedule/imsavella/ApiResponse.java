package org.mgukitschedule.imsavella;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class ApiResponse {
    private Data data;
    private int state;
    private String msg;
    private int time;

    // Геттеры и сеттеры
    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}

class Data {
    @JsonProperty("isCyclicalSchedule")
    private boolean isCyclicalSchedule;
    private List<Schedule> rasp;
    private Info info;

    // Геттеры и сеттеры
    public boolean isCyclicalSchedule() {
        return isCyclicalSchedule;
    }

    public void setCyclicalSchedule(boolean cyclicalSchedule) {
        isCyclicalSchedule = cyclicalSchedule;
    }

    public List<Schedule> getRasp() {
        return rasp;
    }

    public void setRasp(List<Schedule> rasp) {
        this.rasp = rasp;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }
}

class Info {
    private Group group;

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Prepod getPrepod() {
        return prepod;
    }

    public void setPrepod(Prepod prepod) {
        this.prepod = prepod;
    }

    public Kafedra getKafedra() {
        return kafedra;
    }

    public void setKafedra(Kafedra kafedra) {
        this.kafedra = kafedra;
    }

    public Aud getAud() {
        return aud;
    }

    public void setAud(Aud aud) {
        this.aud = aud;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int getCurWeekNumber() {
        return curWeekNumber;
    }

    public void setCurWeekNumber(int curWeekNumber) {
        this.curWeekNumber = curWeekNumber;
    }

    public int getCurNumNed() {
        return curNumNed;
    }

    public void setCurNumNed(int curNumNed) {
        this.curNumNed = curNumNed;
    }

    public int getSelectedNumNed() {
        return selectedNumNed;
    }

    public void setSelectedNumNed(int selectedNumNed) {
        this.selectedNumNed = selectedNumNed;
    }

    public int getCurSem() {
        return curSem;
    }

    public void setCurSem(int curSem) {
        this.curSem = curSem;
    }

    public List<TypeWeek> getTypesWeek() {
        return typesWeek;
    }

    public void setTypesWeek(List<TypeWeek> typesWeek) {
        this.typesWeek = typesWeek;
    }

    public boolean isFixedInCache() {
        return fixedInCache;
    }

    public void setFixedInCache(boolean fixedInCache) {
        this.fixedInCache = fixedInCache;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLastDate() {
        return lastDate;
    }

    public void setLastDate(String lastDate) {
        this.lastDate = lastDate;
    }

    public String getDateUploadingRasp() {
        return dateUploadingRasp;
    }

    public void setDateUploadingRasp(String dateUploadingRasp) {
        this.dateUploadingRasp = dateUploadingRasp;
    }

    private Prepod prepod;
    private Kafedra kafedra;
    private Aud aud;
    private String year;
    private int curWeekNumber;
    private int curNumNed;
    private int selectedNumNed;
    private int curSem;
    private List<TypeWeek> typesWeek;
    private boolean fixedInCache;
    private String date;
    private String lastDate;
    private String dateUploadingRasp;

}

class Group {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGroupID() {
        return groupID;
    }

    public void setGroupID(int groupID) {
        this.groupID = groupID;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    private String name;
    private int groupID;
    private String year;

}

class Prepod {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    private String name;
    private Integer userID;

}

class Kafedra {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

}

class Aud {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
}

class TypeWeek {
    private int typeWeekID;

    public int getTypeWeekID() {
        return typeWeekID;
    }

    public void setTypeWeekID(int typeWeekID) {
        this.typeWeekID = typeWeekID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    private String name;
    private String shortName;
}