package com.PAS_T1.PAS.application.usecases;


import com.PAS_T1.PAS.application.gateways.UserGateway;
import com.PAS_T1.PAS.domain.entity.User;

public class CreateUserInteractor {
  private final UserGateway userGateway;

  public CreateUserInteractor(UserGateway createUser) {
    this.userGateway = createUser;
  }

  public User createUser(User user) {
    return userGateway.createUser(user);
  }
}
