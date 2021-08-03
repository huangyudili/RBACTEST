package cn.wolfcode.rbac.service;


import cn.wolfcode.rbac.common.PageQuery;
import cn.wolfcode.rbac.domain.Department;
import cn.wolfcode.rbac.domain.Role;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface IRoleService {
    public PageInfo query(PageQuery pageQuery);
    public void delete(Long id);
    public void insert(Role role);
    public Role queryById(Long id);
    public void update(Role role);
}
