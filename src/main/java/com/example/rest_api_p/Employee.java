package com.example.rest_api_p;

public class Employee {
    String empId;
    String f_name;
    String l_name;
    int salary;

    String password;

    //---------- Getters ----------------
    public int getSalary() {
        return salary;
    }

    public String getEmpId() {
        return empId;
    }

    public String getF_name() {
        return f_name;
    }

    public String getL_name() {
        return l_name;
    }

    public String getPassword() {
        return password;
    }
    //---------- End of Getters ----------------

    //---------- Setters ----------------

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public void setL_name(String l_name) {
        this.l_name = l_name;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //---------- End of Setters ----------------
}
