package cn.wolfcode.rbac.service.Impl;


import cn.wolfcode.rbac.common.PageQuery;
import cn.wolfcode.rbac.domain.Department;
import cn.wolfcode.rbac.domain.Role;
import cn.wolfcode.rbac.mapper.RoleMapper;
import cn.wolfcode.rbac.service.IRoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class RoleServiceImpl implements IRoleService {
    @Resource
    private RoleMapper roleMapper;
    @Override
    public PageInfo query(PageQuery pageQuery){
        PageHelper.startPage(pageQuery.getCurrentPage(),pageQuery.getPageSize());
        List<Role> roles=roleMapper.query();
        PageInfo page=new PageInfo((roles));
        return page;
    }

    @Override
    public void delete(Long id) {
        roleMapper.delete(id);
    }

    @Override
    public void insert(Role role) {
        roleMapper.insert(role);
    }

    @Override
    public Role queryById(Long id) {

        return roleMapper.queryById(id);
    }

    @Override
    public void update(Role role) {
        roleMapper.update(role);

    }


}
