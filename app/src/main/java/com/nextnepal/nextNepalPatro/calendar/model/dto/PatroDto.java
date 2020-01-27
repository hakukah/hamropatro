package com.nextnepal.nextNepalPatro.calendar.model.dto;

import java.io.Serializable;

public class PatroDto implements Serializable {

    private int selectedNepaliYear;
    private int selectedNepaliMonth;
    private int selectedNepaliDay;
    private int selectedEnglishYear;
    private int selectedEnglishMonth;
    private int selectedEnglishDay;
    private String id;
    private int dayOfWeek;
    private int isHoliday;

    public PatroDto(int selectedNepaliYear,
                    int selectedNepaliMonth,
                    int selectedNepaliDay,
                    int selectedEnglishYear,
                    int selectedEnglishMonth,
                    int selectedEnglishDay,
                    String id,
                    int dayOfWeek,
                    int isHoliday) {
        this.selectedNepaliYear = selectedNepaliYear;
        this.selectedNepaliMonth = selectedNepaliMonth;
        this.selectedNepaliDay = selectedNepaliDay;
        this.selectedEnglishYear = selectedEnglishYear;
        this.selectedEnglishMonth = selectedEnglishMonth;
        this.selectedEnglishDay = selectedEnglishDay;
        this.id = id;
        this.dayOfWeek = dayOfWeek;
        this.isHoliday = isHoliday;
    }



    public int getSelectedNepaliYear() {
        return selectedNepaliYear;
    }

    public void setSelectedNepaliYear(int selectedNepaliYear) {
        this.selectedNepaliYear = selectedNepaliYear;
    }

    public int getSelectedNepaliMonth() {
        return selectedNepaliMonth;
    }

    public void setSelectedNepaliMonth(int selectedNepaliMonth) {
        this.selectedNepaliMonth = selectedNepaliMonth;
    }

    public int getSelectedNepaliDay() {
        return selectedNepaliDay;
    }

    public void setSelectedNepaliDay(int selectedNepaliDay) {
        this.selectedNepaliDay = selectedNepaliDay;
    }

    public int getSelectedEnglishYear() {
        return selectedEnglishYear;
    }

    public void setSelectedEnglishYear(int selectedEnglishYear) {
        this.selectedEnglishYear = selectedEnglishYear;
    }

    public int getSelectedEnglishMonth() {
        return selectedEnglishMonth;
    }

    public void setSelectedEnglishMonth(int selectedEnglishMonth) {
        this.selectedEnglishMonth = selectedEnglishMonth;
    }

    public int getSelectedEnglishDay() {
        return selectedEnglishDay;
    }

    public void setSelectedEnglishDay(int selectedEnglishDay) {
        this.selectedEnglishDay = selectedEnglishDay;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(int dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public int getIsHoliday() {
        return isHoliday;
    }

    public void setIsHoliday(int isHoliday) {
        this.isHoliday = isHoliday;
    }
}
