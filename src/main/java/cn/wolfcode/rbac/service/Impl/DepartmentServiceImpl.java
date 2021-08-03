package cn.wolfcode.rbac.service.Impl;

import cn.wolfcode.rbac.common.PageQuery;
import cn.wolfcode.rbac.domain.Department;
import cn.wolfcode.rbac.mapper.DepartmentMapper;
import cn.wolfcode.rbac.service.IDepartmentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DepartmentServiceImpl implements IDepartmentService {
    @Resource
    private DepartmentMapper departmentMapper;
    @Override
    public PageInfo query(PageQuery pageQuery){
        PageHelper.startPage(pageQuery.getCurrentPage(),pageQuery.getPageSize());
        List<Department> departments=departmentMapper.query();
        PageInfo page=new PageInfo((departments));
        return page;
    }

    @Override
    public List<Department> queryAll() {
        return departmentMapper.query();
    }

    @Override
    public void delete(Long id) {
        departmentMapper.delete(id);
    }

    @Override
    public void insert(Department department) {
        departmentMapper.insert(department);
    }

    @Override
    public Department queryById(Long id) {
        return departmentMapper.queryById(id);
    }

    @Override
    public void update(Department department) {
        departmentMapper.update(department);

    }





}
