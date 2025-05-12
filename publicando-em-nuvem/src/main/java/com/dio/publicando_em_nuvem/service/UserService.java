package com.dio.publicando_em_nuvem.service;

import com.dio.publicando_em_nuvem.domain.User;

public interface UserService {

    User findById(Long id);

    User create(User userToCreate);
}
