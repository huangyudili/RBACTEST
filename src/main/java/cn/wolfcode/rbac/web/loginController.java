package cn.wolfcode.rbac.web;

import cn.wolfcode.rbac.common.JsonResult;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class loginController {
    @RequestMapping("/emp/login")
    public JsonResult login(){
        JsonResult jsonResult=new JsonResult(true,"跳转成功");
        return jsonResult;
    }
}
