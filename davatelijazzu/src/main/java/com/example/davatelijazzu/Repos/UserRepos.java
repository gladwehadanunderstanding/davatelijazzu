package com.example.davatelijazzu.Repos;

import com.example.davatelijazzu.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepos extends JpaRepository<User, Long> {
    public User findByUsername(String username);

    public User findById(int theId);

    public User findByActivationCode(String code);

}
