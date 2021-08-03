package cn.wolfcode.rbac.mapper;

import cn.wolfcode.rbac.domain.Department;
import cn.wolfcode.rbac.domain.Role;

import java.util.List;

public interface RoleMapper {
    public List<Role> query();
    public void delete(Long id);
    public void insert(Role role);
    public Role queryById(Long id);
    public void update(Role role);
}
