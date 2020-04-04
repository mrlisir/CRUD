package myitem1.item.entities;

public class Department {
    private Integer id;
    private String Departmentname;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartmentname() {
        return Departmentname;
    }

    public void setDepartmentname(String departmentname) {
        Departmentname = departmentname;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", Departmentname='" + Departmentname + '\'' +
                '}';
    }

    public Department(Integer id, String departmentname) {
        this.id = id;
        Departmentname = departmentname;
    }

    public Department(){

    }
}
