package cn.wolfcode.rbac.common;

public class JsonResult {
    private Boolean success;
    private String msg;

    public JsonResult(String sucess) {
    }

    public JsonResult(Boolean success) {
        this.success = success;
    }

    public JsonResult(Boolean success, String msg) {
        this.success = success;
        this.msg = msg;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
