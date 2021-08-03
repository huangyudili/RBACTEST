package cn.wolfcode.rbac.service.Impl;

import cn.wolfcode.rbac.common.PageQuery;
import cn.wolfcode.rbac.domain.Department;
import cn.wolfcode.rbac.domain.Permission;
import cn.wolfcode.rbac.mapper.PermissionMapper;
import cn.wolfcode.rbac.mapper.RoleMapper;
import cn.wolfcode.rbac.service.PermissionService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class PermissionServiceImpl implements PermissionService {
    @Resource
    private PermissionMapper permissionMapper;
    @Override
    public PageInfo query(PageQuery pageQuery) {
        PageHelper.startPage(pageQuery.getCurrentPage(),pageQuery.getPageSize());
        List<Permission> permissions=permissionMapper.query();
        PageInfo page=new PageInfo((permissions));
        return page;

    }

    @Override
    public void delete(Long id) {
        permissionMapper.delete(id);

    }
}
