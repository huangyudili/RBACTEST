package cn.wolfcode.rbac.mapper;


import cn.wolfcode.rbac.domain.Permission;

import java.util.List;

public interface PermissionMapper {
    public List<Permission> query();
    public void delete(Long id);
}
