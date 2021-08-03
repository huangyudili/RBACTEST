package cn.wolfcode.rbac.mapper;

import cn.wolfcode.rbac.domain.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeMapper {
    public List<Employee> query();
    public void delete(Long id);
    public void insert(Employee employee);
    public Employee queryById(Long id);
    public void update(Employee employee);
    //定义的类型
    public List<Employee> queryByKeyWord(String keyword);

}
