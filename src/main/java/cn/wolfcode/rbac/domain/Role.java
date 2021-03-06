package cn.wolfcode.rbac.domain;

public class Role {
    private Long id;
    private String name;
    private String sn;

    public Role() {
    }

    public Role(Long id, String name, String sn) {
        this.id = id;
        this.name = name;
        this.sn = sn;
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

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }
}
