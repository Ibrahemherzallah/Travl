package com.example.travl.models.services;

import com.example.travl.models.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AuthorizationService {

    private static final Map<String, List<String>> rolePermissions = new HashMap<>();

    static {
        rolePermissions.put("Admin", List.of("View Dashboard", "Edit Users", "Manage Hotels", "Manage Flights"));
        rolePermissions.put("User", List.of("View Dashboard"));
    }

    public boolean hasPermission(User user, String permission) {
        if (user.getRole() != null) {
            String roleName = user.getRole().getName();
            List<String> permissions = rolePermissions.get(roleName);
            return permissions != null && permissions.contains(permission);
        }
        return false;
    }
}
