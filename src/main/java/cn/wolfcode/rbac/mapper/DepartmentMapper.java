package cn.wolfcode.rbac.mapper;

import cn.wolfcode.rbac.domain.Department;

import java.util.List;

public interface DepartmentMapper {
    /**
     * 查询部门信息
     */
    public List<Department> query();
    public List<Department> queryAll();
    public void delete(Long id);
    public void insert(Department department);
    public Department queryById(Long id);
    public void update(Department department);
}
