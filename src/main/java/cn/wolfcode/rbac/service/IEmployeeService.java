package cn.wolfcode.rbac.service;

import cn.wolfcode.rbac.common.PageQuery;
import cn.wolfcode.rbac.domain.Employee;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IEmployeeService {
    public PageInfo query(PageQuery pageQuery);
    public void delete(Long id);
    public void insert(Employee employee);
    public Employee queryById(Long id);
    public void update(Employee employee);


    public PageInfo queryByKeyWord(PageQuery pageQuery,String keyword);
}
