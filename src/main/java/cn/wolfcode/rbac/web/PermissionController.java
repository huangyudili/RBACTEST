package cn.wolfcode.rbac.web;

import cn.wolfcode.rbac.common.JsonResult;
import cn.wolfcode.rbac.common.PageQuery;
import cn.wolfcode.rbac.service.PermissionService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
public class PermissionController {
    @Resource
    private PermissionService permissionService;
    @RequestMapping("permission/list")
    public ModelAndView list(PageQuery pageQuery){
        ModelAndView mav=new ModelAndView();
        PageInfo result=permissionService.query(pageQuery);
        mav.addObject("result",result);
        mav.setViewName("permission/list");
        return mav;
    }
    @RequestMapping("permission/delete")
    @ResponseBody
    public JsonResult delete(Long id){
        permissionService.delete(id);
        JsonResult jsonResult=new JsonResult(true);
        return jsonResult;

    }
}
