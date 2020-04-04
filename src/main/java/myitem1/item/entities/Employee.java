package myitem1.item.entities;

public class Employee {
    private Integer id;
    private String Name;
    private String postion;
    private Department Department;
    private double sale;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPostion() {
        return postion;
    }

    public void setPostion(String postion) {
        this.postion = postion;
    }

    public myitem1.item.entities.Department getDepartment() {
        return Department;
    }

    public void setDepartment(myitem1.item.entities.Department department) {
        Department = department;
    }

    public double getSale() {
        return sale;
    }

    public void setSale(double sale) {
        this.sale = sale;
    }

    public Employee(Integer id, String name, String postion, myitem1.item.entities.Department department, double sale) {
        this.id = id;
        Name = name;
        this.postion = postion;
        Department = department;
        this.sale = sale;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                ", postion='" + postion + '\'' +
                ", Department=" + Department +
                ", sale=" + sale +
                '}';
    }
}
