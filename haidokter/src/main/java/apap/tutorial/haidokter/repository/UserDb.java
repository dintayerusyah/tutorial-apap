package apap.tutorial.haidokter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import apap.tutorial.haidokter.model.UserModel;

import java.util.Optional;

@Repository
public interface UserDb extends JpaRepository<UserModel, Long>{
    Optional<UserModel> findByUsername(String username);
}
