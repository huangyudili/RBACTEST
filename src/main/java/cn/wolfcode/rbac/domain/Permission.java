package cn.wolfcode.rbac.domain;

public class Permission {
    private Long id;
    private String name;
    private String expression;

    public Permission() {
    }

    public Permission(Long id, String name, String expression) {
        this.id = id;
        this.name = name;
        this.expression = expression;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }
}
