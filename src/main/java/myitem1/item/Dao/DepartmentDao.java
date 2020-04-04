package myitem1.item.Dao;


import myitem1.item.entities.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class DepartmentDao {

    private static Map<Integer, Department> departments = null;

    static {
        departments = new HashMap<Integer, Department>();
        departments.put(101, new Department(101, "技术部"));
        departments.put(102, new Department(102, "销售部"));
        departments.put(103, new Department(103, "管理部"));

    }

    public Collection<Department> getDepartment() {
        return departments.values();
    }

    public Department getDepartment(Integer id) {
        return departments.get(id);
    }
}
