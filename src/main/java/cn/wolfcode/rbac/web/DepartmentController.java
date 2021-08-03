package cn.wolfcode.rbac.web;

import cn.wolfcode.rbac.common.JsonResult;
import cn.wolfcode.rbac.common.PageQuery;
import cn.wolfcode.rbac.domain.Department;
import cn.wolfcode.rbac.service.IDepartmentService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
public class DepartmentController {
    @Resource
    private IDepartmentService departmentService;
    @RequestMapping("/department/list")
    public ModelAndView list(PageQuery pageQuery){
        ModelAndView mav=new ModelAndView();
        PageInfo result=departmentService.query(pageQuery);
        System.out.println("业务数据："+result.getList());
        System.out.println("总数量:"+result.getTotal());
        //List<Department> departments=departmentService.query();
        mav.addObject("result",result);
        mav.setViewName("department/list");
        return mav;
    }



    @RequestMapping("/department/delete")
    @ResponseBody
    public JsonResult delete(Long id){
        departmentService.delete(id);
        JsonResult jsonResult=new JsonResult(true);
        return jsonResult;
    }
    @RequestMapping("/department/input")
    public String input(Long id, Model model){
        if(id!=null){
            Department dept=departmentService.queryById(id);
            model.addAttribute("entity",dept);
        }
        return "department/input";
    }



    @RequestMapping("/department/saveOrUpdate")
    public void saveOrUpdate(Department department, HttpServletResponse response) throws Exception{
        System.out.println("名字："+department.getName());
        if (department.getId()!=null){
            departmentService.update(department);
        }else{
            departmentService.insert(department);
        }
        response.sendRedirect("/department/list");

    }
    //失败方法
   /* public ModelAndView test(){
        ModelAndView test=new ModelAndView();
        List<Department> departments=new ArrayList<Department>();
        Department test1=new Department(1l,"测试部","ceshi");
        departments.add(test1);
        test.addObject("test",departments);
        test.setViewName("employee/input");
        return  test;

    }*/


}
