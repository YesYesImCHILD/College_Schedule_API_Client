package org.mgukitschedule.imsavella;

import java.util.List;

public class Schedule {
    private int код;

    public int getКод() {
        return код;
    }

    public void setКод(int код) {
        this.код = код;
    }

    public String getДата() {
        return дата;
    }

    public void setДата(String дата) {
        this.дата = дата;
    }

    public String getДатаНачала() {
        return датаНачала;
    }

    public void setДатаНачала(String датаНачала) {
        this.датаНачала = датаНачала;
    }

    public String getДатаОкончания() {
        return датаОкончания;
    }

    public void setДатаОкончания(String датаОкончания) {
        this.датаОкончания = датаОкончания;
    }

    public String getПерерыв() {
        return перерыв;
    }

    public void setПерерыв(String перерыв) {
        this.перерыв = перерыв;
    }

    public String getНачало() {
        return начало;
    }

    public void setНачало(String начало) {
        this.начало = начало;
    }

    public String getКонец() {
        return конец;
    }

    public void setКонец(String конец) {
        this.конец = конец;
    }

    public int getДеньНедели() {
        return деньНедели;
    }

    public void setДеньНедели(int деньНедели) {
        this.деньНедели = деньНедели;
    }

    public String getДень_недели() {
        return день_недели;
    }

    public void setДень_недели(String день_недели) {
        this.день_недели = день_недели;
    }

    public String getПочта() {
        return почта;
    }

    public void setПочта(String почта) {
        this.почта = почта;
    }

    public String getДень() {
        return день;
    }

    public void setДень(String день) {
        this.день = день;
    }

    public int getКод_Семестра() {
        return код_Семестра;
    }

    public void setКод_Семестра(int код_Семестра) {
        this.код_Семестра = код_Семестра;
    }

    public int getТипНедели() {
        return типНедели;
    }

    public void setТипНедели(int типНедели) {
        this.типНедели = типНедели;
    }

    public int getНомерПодгруппы() {
        return номерПодгруппы;
    }

    public void setНомерПодгруппы(int номерПодгруппы) {
        this.номерПодгруппы = номерПодгруппы;
    }

    public String getЧасов() {
        return часов;
    }

    public void setЧасов(String часов) {
        this.часов = часов;
    }

    public String getДисциплина() {
        return дисциплина;
    }

    public void setДисциплина(String дисциплина) {
        this.дисциплина = дисциплина;
    }

    public String getПреподаватель() {
        return преподаватель;
    }

    public void setПреподаватель(String преподаватель) {
        this.преподаватель = преподаватель;
    }

    public String getДолжность() {
        return должность;
    }

    public void setДолжность(String должность) {
        this.должность = должность;
    }

    public String getАудитория() {
        return аудитория;
    }

    public void setАудитория(String аудитория) {
        this.аудитория = аудитория;
    }

    public String getУчебныйГод() {
        return учебныйГод;
    }

    public void setУчебныйГод(String учебныйГод) {
        this.учебныйГод = учебныйГод;
    }

    public String getГруппа() {
        return группа;
    }

    public void setГруппа(String группа) {
        this.группа = группа;
    }

    public String getCustom1() {
        return custom1;
    }

    public void setCustom1(String custom1) {
        this.custom1 = custom1;
    }

    public String getЧасы() {
        return часы;
    }

    public void setЧасы(String часы) {
        this.часы = часы;
    }

    public int getНеделяНачала() {
        return неделяНачала;
    }

    public void setНеделяНачала(int неделяНачала) {
        this.неделяНачала = неделяНачала;
    }

    public int getНеделяОкончания() {
        return неделяОкончания;
    }

    public void setНеделяОкончания(int неделяОкончания) {
        this.неделяОкончания = неделяОкончания;
    }

    public boolean isЗамена() {
        return замена;
    }

    public void setЗамена(boolean замена) {
        this.замена = замена;
    }

    public int getКодПреподавателя() {
        return кодПреподавателя;
    }

    public void setКодПреподавателя(int кодПреподавателя) {
        this.кодПреподавателя = кодПреподавателя;
    }

    public int getКодГруппы() {
        return кодГруппы;
    }

    public void setКодГруппы(int кодГруппы) {
        this.кодГруппы = кодГруппы;
    }

    public String getФиоПреподавателя() {
        return фиоПреподавателя;
    }

    public void setФиоПреподавателя(String фиоПреподавателя) {
        this.фиоПреподавателя = фиоПреподавателя;
    }

    public int getКодПользователя() {
        return кодПользователя;
    }

    public void setКодПользователя(int кодПользователя) {
        this.кодПользователя = кодПользователя;
    }

    public boolean isЭлементЦиклРасписания() {
        return элементЦиклРасписания;
    }

    public void setЭлементЦиклРасписания(boolean элементЦиклРасписания) {
        this.элементЦиклРасписания = элементЦиклРасписания;
    }

    public boolean isЭлементГрафика() {
        return элементГрафика;
    }

    public void setЭлементГрафика(boolean элементГрафика) {
        this.элементГрафика = элементГрафика;
    }

    public String getТема() {
        return тема;
    }

    public void setТема(String тема) {
        this.тема = тема;
    }

    public int getНомерЗанятия() {
        return номерЗанятия;
    }

    public void setНомерЗанятия(int номерЗанятия) {
        this.номерЗанятия = номерЗанятия;
    }

    public String getСсылка() {
        return ссылка;
    }

    public void setСсылка(String ссылка) {
        this.ссылка = ссылка;
    }

    public boolean isСозданиеВебинара() {
        return созданиеВебинара;
    }

    public void setСозданиеВебинара(boolean созданиеВебинара) {
        this.созданиеВебинара = созданиеВебинара;
    }

    public String getКодВебинара() {
        return кодВебинара;
    }

    public void setКодВебинара(String кодВебинара) {
        this.кодВебинара = кодВебинара;
    }

    public boolean isВебинарЗапущен() {
        return вебинарЗапущен;
    }

    public void setВебинарЗапущен(boolean вебинарЗапущен) {
        this.вебинарЗапущен = вебинарЗапущен;
    }

    public boolean isПоказатьЖурнал() {
        return показатьЖурнал;
    }

    public void setПоказатьЖурнал(boolean показатьЖурнал) {
        this.показатьЖурнал = показатьЖурнал;
    }

    public List<Integer> getКодыСтрок() {
        return кодыСтрок;
    }

    public void setКодыСтрок(List<Integer> кодыСтрок) {
        this.кодыСтрок = кодыСтрок;
    }

    public String getЦвет() {
        return цвет;
    }

    public void setЦвет(String цвет) {
        this.цвет = цвет;
    }

    private String дата;
    private String датаНачала;
    private String датаОкончания;
    private String перерыв;
    private String начало;
    private String конец;
    private int деньНедели;
    private String день_недели;
    private String почта;
    private String день;
    private int код_Семестра;
    private int типНедели;
    private int номерПодгруппы;
    private String часов;
    private String дисциплина;
    private String преподаватель;
    private String должность;
    private String аудитория;
    private String учебныйГод;
    private String группа;
    private String custom1;
    private String часы;
    private int неделяНачала;
    private int неделяОкончания;
    private boolean замена;
    private int кодПреподавателя;
    private int кодГруппы;
    private String фиоПреподавателя;
    private int кодПользователя;
    private boolean элементЦиклРасписания;
    private boolean элементГрафика;
    private String тема;
    private int номерЗанятия;
    private String ссылка;
    private boolean созданиеВебинара;
    private String кодВебинара;
    private boolean вебинарЗапущен;
    private boolean показатьЖурнал;
    private List<Integer> кодыСтрок;
    private String цвет;
}