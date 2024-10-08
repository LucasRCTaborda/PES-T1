package com.PAS_T1.PAS.main;


import com.PAS_T1.PAS.application.gateways.UserGateway;
import com.PAS_T1.PAS.application.usecases.CreateUserInteractor;
import com.PAS_T1.PAS.infrastructure.controllers.UserDTOMapper;
import com.PAS_T1.PAS.infrastructure.gateways.UserEntityMapper;
import com.PAS_T1.PAS.infrastructure.gateways.UserRepositoryGateway;
import com.PAS_T1.PAS.infrastructure.persistence.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {
  @Bean
  CreateUserInteractor createUserCase(UserGateway userGateway) {
    return new CreateUserInteractor(userGateway);
  }

  @Bean
  UserGateway userGateway(UserRepository userRepository, UserEntityMapper userEntityMapper) {
    return new UserRepositoryGateway(userRepository, userEntityMapper);
  }

  @Bean
  UserEntityMapper userEntityMapper() {
    return new UserEntityMapper();
  }

  @Bean
  UserDTOMapper userDTOMapper() {
    return new UserDTOMapper();
  }
}
