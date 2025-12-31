package model;

public class ClientProject extends Project {
    private String clientName;

    public ClientProject(String id, String name, String requiredSkill, int requiredHours, String clientName) {
        super(id, name, requiredSkill, requiredHours);
        this.clientName = clientName;
    }

    public String getClientName() {
        return clientName;
    }

    @Override
    public String toString() {
        return getName() + " (Client: " + clientName +
               ", Skill: " + getRequiredSkill() +
               ", Hours: " + getRequiredHours() +
               ", Employees Allocated: " + getAllocatedEmployees().size() + ")";
    }
}
