package br.com.dio.bootcamp.dominio;

import java.time.LocalDate;

public class Mentoring extends Content {

    private LocalDate date;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Mentoring{" +
                "title='" + this.getTitle() + '\'' +
                ", description='" + this.getDescription() + '\'' +
                ", date=" + date +
                '}';
    }

    @Override
    public double calculateXp() {
        return DEFAULT_XP + 20d;
    }
}
