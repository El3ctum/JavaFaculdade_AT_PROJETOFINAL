package br.infnet.at.user.workerUser;

import br.infnet.at.user.User;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class WorkerUser extends User {

    private int workerCode;
    private String jobRole;
    private Double salary;
    private LocalDate admissionDay;

    public WorkerUser() {
        super();
        this.workerCode = 1;
        this.jobRole = "gerente";
        this.salary = 1500.90;
        this.admissionDay = LocalDate.of(2024, 4, 2);
    }

    public WorkerUser(Integer workerCode, String jobRole, Double salary, LocalDate admissionDay) {
        super();
        this.workerCode = workerCode;
        this.jobRole = jobRole;
        this.salary = salary;
        this.admissionDay = admissionDay;
    }

    public WorkerUser(String firstName, String lastName, Integer age, String email, int workerCode, String jobRole, Double salary, LocalDate admissionDay) {
        super(firstName, lastName, age, email);
        this.workerCode = workerCode;
        this.jobRole = jobRole;
        this.salary = salary;
        this.admissionDay = admissionDay;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedAdmissionDay = admissionDay.format(formatter);
        return "WorkerUser{" +
                "firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", age=" + getAge() +
                ", email='" + getEmail() + '\'' +
                ", workerCode=" + workerCode +
                ", jobRole='" + jobRole + '\'' +
                ", salary=" + salary +
                ", admissionDay=" + formattedAdmissionDay +
                '}';
    }


    public int getWorkerCode() {
        return workerCode;
    }

    public void setWorkerCode(int workerCode) {
        this.workerCode = workerCode;
    }

    public String getJobRole() {
        return jobRole;
    }

    public void setJobRole(String jobRole) {
        this.jobRole = jobRole;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public LocalDate getAdmissionDay() {
        return admissionDay;
    }

    public void setAdmissionDay(LocalDate admissionDay) {
        this.admissionDay = admissionDay;
    }
}
