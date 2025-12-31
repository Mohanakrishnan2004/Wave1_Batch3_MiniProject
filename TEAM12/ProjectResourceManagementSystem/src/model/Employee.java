package model;

import java.util.List;

public class Employee {
    private String id;
    private String name;
    private List<String> skills;
    private int availableHours;
    private int utilizedHours;
    private double hourlyRate;

    public Employee(String id, String name, List<String> skills, int availableHours, double hourlyRate) {
        this.id = id;
        this.name = name;
        this.skills = skills;
        this.availableHours = availableHours;
        this.hourlyRate = hourlyRate;
        this.utilizedHours = 0;
    }

    public boolean allocateHours(int hours) {
        if (availableHours >= hours) {
            availableHours -= hours;
            utilizedHours += hours;
            return true;
        }
        return false;
    }

    public boolean hasSkill(String skill) {
        return skills.contains(skill);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAvailableHours() {
        return availableHours;
    }

    public int getUtilizedHours() {
        return utilizedHours;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }
}
