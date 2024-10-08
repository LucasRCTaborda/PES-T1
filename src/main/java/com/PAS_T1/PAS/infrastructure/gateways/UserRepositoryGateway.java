package com.PAS_T1.PAS.infrastructure.gateways;


import com.PAS_T1.PAS.application.gateways.UserGateway;
import com.PAS_T1.PAS.domain.entity.User;
import com.PAS_T1.PAS.infrastructure.persistence.UserEntity;
import com.PAS_T1.PAS.infrastructure.persistence.UserRepository;

public class UserRepositoryGateway implements UserGateway {
    private final UserRepository userRepository;
    private final UserEntityMapper userEntityMapper;

    public UserRepositoryGateway(UserRepository userRepository, UserEntityMapper userEntityMapper) {
        this.userRepository = userRepository;
        this.userEntityMapper = userEntityMapper;
    }

    @Override
    public User createUser(User userDomainObj) {
        UserEntity userEntity = userEntityMapper.toEntity(userDomainObj);
        UserEntity savedEntity = userRepository.save(userEntity);

        return userEntityMapper.toDomainObj(savedEntity);
    }

}
