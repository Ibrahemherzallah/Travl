package com.example.travl.models.interfaces;

import com.example.travl.models.Agent;

import java.util.List;

public interface AgentDOA {
    public void insert(Agent agent);
    public void update(Agent agent);
    public void delete(Agent agent);
    public List<Agent> getAll();
    public Agent findAdmin(int id);
}
