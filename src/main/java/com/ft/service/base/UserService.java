package com.ft.service.base;

import com.ft.dto.UserDto;

import org.springframework.data.domain.Page;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    UserDto findByUsername(String username);

    Page<UserDto> searchByUsernamePaginated(String username, Integer pageNo, Integer pageSize, String sortBy);

    Page<UserDto> getAllPaginated(Integer pageNo, Integer pageSize, String sortBy);
}
