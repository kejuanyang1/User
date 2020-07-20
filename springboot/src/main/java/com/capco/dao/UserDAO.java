package com.capco.dao;
import com.capco.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper //创建dao对象
public interface UserDAO {
    void save(User user);

    User findByUserName(String name);

}
