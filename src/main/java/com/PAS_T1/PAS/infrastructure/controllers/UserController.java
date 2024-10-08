package com.PAS_T1.PAS.infrastructure.controllers;


import com.PAS_T1.PAS.application.usecases.CreateUserInteractor;
import com.PAS_T1.PAS.domain.entity.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UserController {
  private final CreateUserInteractor createUserUseCase;
  private final UserDTOMapper userDTOMapper;

  public UserController(CreateUserInteractor createUserUseCase,
      UserDTOMapper userDTOMapper) {
    this.createUserUseCase = createUserUseCase;
    this.userDTOMapper = userDTOMapper;
  }

  @PostMapping
  public CreateUserResponse createUser(@RequestBody CreateUserRequest request) {
    User userBusinessObj = userDTOMapper.toUser(request);
    User user = createUserUseCase.createUser(userBusinessObj);
    return userDTOMapper.toResponse(user);
  }
}
