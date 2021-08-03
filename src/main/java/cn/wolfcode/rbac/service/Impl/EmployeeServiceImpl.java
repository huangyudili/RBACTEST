package cn.wolfcode.rbac.service.Impl;

import cn.wolfcode.rbac.common.PageQuery;
import cn.wolfcode.rbac.domain.Employee;
import cn.wolfcode.rbac.mapper.EmployeeMapper;
import cn.wolfcode.rbac.service.IEmployeeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements IEmployeeService {
    @Resource
    private EmployeeMapper employeeMapper;
    @Override
    public PageInfo query(PageQuery pageQuery) {
        PageHelper.startPage(pageQuery.getCurrentPage(),pageQuery.getPageSize());
        List<Employee> employees=employeeMapper.query();
        PageInfo pageInfo=new PageInfo(employees);
        return pageInfo;
    }

    @Override
    public void delete(Long id) {
        employeeMapper.delete(id);
    }

    @Override
    public void insert(Employee employee) {
        employeeMapper.insert(employee);
    }

    @Override
    public Employee queryById(Long id) {
        return employeeMapper.queryById(id);
    }

    @Override
    public void update(Employee employee) {
        employeeMapper.update(employee);
    }

    /**
     * 根据姓名查询（模糊查询）
     * @return
     */
    @Override
    public PageInfo queryByKeyWord(PageQuery pageQuery, String keyword) {
        PageHelper.startPage(pageQuery.getCurrentPage(),pageQuery.getPageSize());
        List<Employee> employees = employeeMapper.queryByKeyWord(keyword);
        PageInfo pageInfo = new PageInfo(employees);
        return pageInfo;
    }


}
