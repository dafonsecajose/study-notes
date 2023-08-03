package br.com.dio.bootcamp.dominio;

public class Course extends Content {

    private int workload;

    public int getWorkload() {
        return workload;
    }

    public void setWorkload(int workload) {
        this.workload = workload;
    }

    @Override
    public String toString() {
        return "Course{" +
                "title='" + this.getTitle() + '\'' +
                ", description='" + this.getTitle() + '\'' +
                ", workload=" + workload +
                '}';
    }

    @Override
    public double calculateXp() {
        return DEFAULT_XP * workload;
    }
}
