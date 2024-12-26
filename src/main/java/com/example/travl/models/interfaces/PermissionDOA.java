package com.example.travl.models.interfaces;
import com.example.travl.models.Permission;
import java.util.List;

public interface PermissionDOA {
    public void insert(Permission permission);
    public void update(Permission permission);
    public void delete(Permission permission);
    public List<Permission> getAll();
    public Permission findPermission(int id);
}
