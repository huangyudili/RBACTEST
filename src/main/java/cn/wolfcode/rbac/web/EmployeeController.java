package cn.wolfcode.rbac.web;

import cn.wolfcode.rbac.common.JsonResult;
import cn.wolfcode.rbac.common.PageQuery;
import cn.wolfcode.rbac.domain.Department;
import cn.wolfcode.rbac.domain.Employee;
import cn.wolfcode.rbac.service.IDepartmentService;
import cn.wolfcode.rbac.service.IEmployeeService;
import com.fasterxml.jackson.databind.JsonNode;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class EmployeeController {
    @Resource
    private IEmployeeService employeeService;
    @Resource
    private IDepartmentService departmentService;
    @RequestMapping("employee/list")
    public ModelAndView list(PageQuery pageQuery,String keyword , Model model) {
        //查询所有部门信息并显示
        List<Department> departments = departmentService.queryAll();
        model.addAttribute("depts", departments);
        //判断搜索里面是否为空，空直接输出
        if (keyword == null || keyword == "") {
            //1 创建一个视图对象
            ModelAndView mav = new ModelAndView();
            PageInfo result = employeeService.query(pageQuery);
            mav.addObject("result", result);
            mav.setViewName("employee/list");
            return mav;
        } else {
            //不是返回搜索结果
            ModelAndView mav = new ModelAndView();
            PageInfo result = employeeService.queryByKeyWord(pageQuery, keyword);
            mav.addObject("result", result);
            mav.setViewName("employee/list");
            return mav;
        }
    }
    @RequestMapping("/employee/delete")
    @ResponseBody
    public JsonResult delete(Long id){
            employeeService.delete(id);
            JsonResult jsonResult=new JsonResult(true);
        /*JsonResult jsonResult=new JsonResult(true);*/
        return jsonResult;
    }
    @RequestMapping("/employee/input")
    public String input(Model model,Long id){
     List<Department> departments=departmentService.queryAll();
     model.addAttribute("depts",departments);
     if(id!=null){
         Employee employee=employeeService.queryById(id);
         model.addAttribute("entity",employee);
     }
     return "/employee/input";
    }
    @RequestMapping("employee/saveOrUpdate")
    public void saveOrUpdate(Employee employee, HttpServletResponse response) throws Exception{
        if (employee.getId()!=null){
             //修改操作
            employeeService.update(employee);
        }else{
            employeeService.insert(employee);
        }
        response.sendRedirect("list");
    }
    









}
