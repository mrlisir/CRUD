package myitem1.item.Controller;

import myitem1.item.Dao.DepartmentDao;
import myitem1.item.Dao.EmployeeDao;
import myitem1.item.entities.Department;
import myitem1.item.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.Collection;

@Controller
public class EmpController {
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;
    @GetMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps",employees);
       // System.out.println(employeeDao.getAll());
        return "list";
    }

    @GetMapping("/addPage")
    public String toAddpage(Model model){
        Collection<Department> department = departmentDao.getDepartment();
        Collection<Object> getPost = employeeDao.getPost();
        model.addAttribute("depts",department);
        model.addAttribute("posts",getPost);

        return "add";
    }
@PostMapping("/addPage")
public String addEmp(Employee employee,BindingResult bindingResult){
        employeeDao.save(employee);
    System.out.println("保存的员工信息: "+employee);
    return "redirect:/emps";

}
@GetMapping("/Edit/{id}")
public String Edit(@PathVariable("id") Integer id,Model model){
    Employee employee = employeeDao.get(id);
    model.addAttribute("emp",employee);


    Collection<Department> department = departmentDao.getDepartment();
    Collection<Object> getPost = employeeDao.getPost();
    model.addAttribute("depts",department);
    model.addAttribute("posts",getPost);


    return "add";
}
@PutMapping("/addPage")
public String upda(Employee employee){
    employeeDao.save(employee);
        return "redirect:/emps";
}

@PostMapping("/del{id}")
public String del(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
}

}
