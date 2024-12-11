package com.example;
import java.util.List;

public interface studentDao {
    void addUser(student std );
    student getUserById(int id);
    List<student> getAllUsers();
    void updateUser(student user);
    void deleteUser(int id);
}

