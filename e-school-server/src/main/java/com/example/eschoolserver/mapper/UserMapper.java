package com.example.eschoolserver.mapper;

import com.example.eschoolserver.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM myusers WHERE username=#{username}")
    User getUserByUsername(String username);

    @Insert("INSERT INTO myusers(username, password) VALUES (#{username}, #{password})")
    void addUser(User user);
}
