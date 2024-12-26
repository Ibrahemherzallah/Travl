package com.example.travl.controllers;


import java.util.List;

public class RoleController {

    private int id;
    private String name;
    private String value;
    private List<PermissionController> permissions;

//copy constructor


    public List<PermissionController> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<PermissionController> permissions) {
        this.permissions = permissions;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void addRole(){}
    public void editRole(){}
    public void deleteRole(){}
    public void addPermission(PermissionController permission) {
        if (!permissions.contains(permission)) {
            permissions.add(permission);
        }
    }
    public void removePermission(PermissionController permission) {
        permissions.remove(permission);
    }
}
