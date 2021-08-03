package cn.wolfcode.rbac.service;

import cn.wolfcode.rbac.common.PageQuery;
import cn.wolfcode.rbac.domain.Permission;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface PermissionService {
    public PageInfo query(PageQuery pageQuery);
    public void delete(Long id);

}
