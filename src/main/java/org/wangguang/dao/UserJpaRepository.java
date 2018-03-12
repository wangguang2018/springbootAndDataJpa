package org.wangguang.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.wangguang.entity.User;

public interface UserJpaRepository extends JpaRepository<User,Long> {

}
