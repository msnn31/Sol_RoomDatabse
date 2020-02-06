package com.example.roomeg;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface MyDao {

    @Insert
    public void addUser(User user);

    @Query("select * from users")
    public List<User> getUsers();

    @Delete
    public void deleteUser(User user);

    @Update
    public void updateUser(User user);

    @Ignore
    @Query("select id,user_name,user_email,user_mobile,user_password from users")
    public User ViewUser();

    @Ignore
    @Query("select * from users where user_email = :email")
    public User SpecificUser(String email);
}