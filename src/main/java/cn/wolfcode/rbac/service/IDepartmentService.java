package cn.wolfcode.rbac.service;

import cn.wolfcode.rbac.common.PageQuery;
import cn.wolfcode.rbac.domain.Department;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface IDepartmentService {
    public PageInfo query(PageQuery pageQuery);
    public List<Department> queryAll();
    public void delete(Long id);
    public void insert(Department department);
    public Department queryById(Long id);
    public void update(Department department);
}
