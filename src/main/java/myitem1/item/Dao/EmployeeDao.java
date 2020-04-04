package myitem1.item.Dao;


import myitem1.item.entities.Department;
import myitem1.item.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.security.PublicKey;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeDao {
    private static Map<Integer, Employee> employees = null;
    private static Map<Integer, Object> cc = null;

    @Autowired
    private DepartmentDao departmentDao;

    static {
        employees = new HashMap<Integer, Employee>();
        employees.put(1001, new Employee(1001, "张三", "程序员", new Department(101, "技术部"), 1001.0));
        employees.put(1002, new Employee(1002, "李四", "销售员", new Department(102, "销售部"), 2222));
        employees.put(1003, new Employee(1003, "王五", "总经理", new Department(103, "管理部"), 88888));
    }

    static {
        cc = new HashMap<Integer, Object>();
        cc.put(1, "程序员");
        cc.put(2, "销售");
        cc.put(3, "经理");
    }


    private static Integer initId = 1004;


    public void save(Employee employee) {
        if (employee.getId() == null) {
            employee.setId(initId++);
        }
        employee.setDepartment(departmentDao.getDepartment(employee.getDepartment().getId()));
        employees.put(employee.getId(), employee);
    }

    public Collection<Employee> getAll() {
        return employees.values();
    }

    public Collection<Object> getPost(){
        return cc.values();
    }

   public Employee get(Integer id) {
        return employees.get(id);
    }

    public void delete(Integer id) {
        employees.remove(id);
    }



}
