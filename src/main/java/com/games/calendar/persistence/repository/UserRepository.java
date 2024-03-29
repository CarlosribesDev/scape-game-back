package com.games.calendar.persistence.repository;

import com.games.calendar.persistence.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserEntity,Long>{


    boolean existsByEmail(final String email);

}
