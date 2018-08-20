package com.tkrs.test.jdk8;

/**
 * @ClassName Employee
 * @Description TODO
 * @Author wangchenge
 * @Date 2018/8/9  19:38
 * @Version 1.0
 **/
public class Employee {
    /**
     * @Author wcg
     * @Description 员工ID
     * @Date 19:51 2018/8/9
     **/
    private String employeeId;

    /**
     * @Author wcg
     * @Description 员工部门
     * @Date 19:53 2018/8/9
     **/
    private String deptNo;

    /**
     * @Author wcg
     * @Description TODO
     * @Date 19:54 2018/8/9
     **/
    private Integer age;
    
    /**
     * @Author wcg
     * @Description 员工工资
     * @Date 19:54 2018/8/9
     **/
    private String salary;

    /**
     * @Author wcg
     * @Description 员工性别
     * @Date 19:55 2018/8/9
     **/
    private String sex;


    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(String deptNo) {
        this.deptNo = deptNo;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

}
