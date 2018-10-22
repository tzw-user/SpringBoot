package com.example.firstappdemo.repositosy;

import com.example.firstappdemo.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by 谭志为 on 2018/8/31.
 */

/**
 * {@link   User} {@link Repository}
 */
@Repository
public class UserRepository {
    /**
     * 采用内存型的存储方式->Map
     */
    private final ConcurrentMap<Integer,User> map=new ConcurrentHashMap<>();

    /**
     * id自增长
     */
    private final static AtomicInteger idGenerator=new AtomicInteger();

    /**
     * 保存用户对象
     * @param user {@link User} 对象
     * @return if save Success return true
     */
  public  boolean save(User user){
      Integer id=idGenerator.incrementAndGet();
      user.setId(id);
      map.put(id,user);

      return map.put(id,user)==null;
  }

    /**
     *
     * @return
     */

  public Collection<User> findAll(){

      return map.values();
  }
}
