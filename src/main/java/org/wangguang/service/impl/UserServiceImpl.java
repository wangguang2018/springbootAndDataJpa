package org.wangguang.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wangguang.dao.UserJpaRepository;
import org.wangguang.dao.UserRepository;
import org.wangguang.entity.User;
import org.wangguang.service.UserService;

import javax.persistence.Cacheable;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService
{
    @Autowired
    private UserJpaRepository userJpaRepository;

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll()
    {
        return userJpaRepository.findAll();
    }

    public List<User> findByName(String name)
    {
        List<User> userList1 = userRepository.findByName1(name);
        List<User> userList2 = userRepository.findByName2(name);
        List<User> userList3 = userRepository.findByNameAndAddress(name, "3");
        System.out.println("userList1:" + userList1);
        System.out.println("userList2:" + userList2);
        System.out.println("userList3:" + userList3);
        return userRepository.findByName(name);
    }

    public void saveUser(User book)
    {
        userJpaRepository.save(book);
    }

    //@Cacheable("users")
    public User findOne(long id)
    {
        System.out.println("Cached Pages");
        return userJpaRepository.findOne(id);
    }

    public void delete(long id)
    {
        userJpaRepository.delete(id);
    }
}
