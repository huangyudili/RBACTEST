package cn.wolfcode.rbac.web;

import cn.wolfcode.rbac.common.JsonResult;
import cn.wolfcode.rbac.common.PageQuery;
import cn.wolfcode.rbac.domain.Department;
import cn.wolfcode.rbac.domain.Role;
import cn.wolfcode.rbac.service.IRoleService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

@Controller
public class RoleController {
    @Resource
    private IRoleService roleService;
    @RequestMapping("role/list")
    public ModelAndView list(PageQuery pageQuery){
        ModelAndView mav=new ModelAndView();
        PageInfo result=roleService.query(pageQuery);
        mav.addObject("result",result);
        mav.setViewName("role/list");
        return mav;
    }
    @RequestMapping("role/delete")
    @ResponseBody
    public JsonResult delete(Long id){
        roleService.delete(id);
        JsonResult jsonResult=new JsonResult(true);
        return jsonResult;

    }
    @RequestMapping("/role/input")
    public String input(Long id, Model model){
        //id:新增操作:null  编辑操作:具体的id值
        if (id!=null){ //编辑
            Role ro = roleService.queryById(id);
            model.addAttribute("entity",ro);//entity 页面获取数据的key
        }
        return "role/input";//跳转到input.jsp文件中
    }

    @RequestMapping("/role/saveOrUpdate")
    public void saveOrUpdate(Role role, HttpServletResponse response) throws Exception{
        System.out.println("名字:"+role.getName());
        if (role.getId()!=null){//编辑操作
            roleService.update(role);//编辑操作
        }else {
            roleService.insert(role);//新增
        }
        //插入完成数据,--> 列表页面才可以
        //重定向查询数据的请求
        response.sendRedirect("/role/list");
    }




}
