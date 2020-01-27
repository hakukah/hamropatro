package com.nextnepal.nextNepalPatro.calendar.model.dto;

public class SelectedMonthDto {
    private int id;
    private int selectedNepaliYear;
    private int selectedNepaliMonth;
    private int selectedNepaliDay;
    private int selectedEnglishYear;
    private int selectedEnglishMonth;
    private int selectedEnglishDay;
    private int dayOfWeek;

    public SelectedMonthDto(int selectedNepaliYear, int selectedNepaliMonth, int selectedNepaliDay, int selectedEnglishYear, int selectedEnglishMonth, int selectedEnglishDay) {
        this.selectedNepaliYear = selectedNepaliYear;
        this.selectedNepaliMonth = selectedNepaliMonth;
        this.selectedNepaliDay = selectedNepaliDay;
        this.selectedEnglishYear = selectedEnglishYear;
        this.selectedEnglishMonth = selectedEnglishMonth;
        this.selectedEnglishDay = selectedEnglishDay;
    }

    public SelectedMonthDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
