package com.dio.publicando_em_nuvem.repository;

import com.dio.publicando_em_nuvem.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
