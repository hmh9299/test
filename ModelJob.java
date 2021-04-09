package com.example.lab1_bai2;

public class ModelJob {
    int image;
    String name;
    String salary;
    String dateCreated;

    public ModelJob(int image, String name, String salary, String dateCreated) {
        this.image = image;
        this.name = name;
        this.salary = salary;
        this.dateCreated = dateCreated;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public String toString() {
        return "ModelJob{" +
                "image=" + image +
                ", name='" + name + '\'' +
                ", salary='" + salary + '\'' +
                ", dateCreated='" + dateCreated + '\'' +
                '}';
    }
}
