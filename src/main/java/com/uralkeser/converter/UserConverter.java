package com.uralkeser.converter;

import com.uralkeser.dto.UserDto;
import com.uralkeser.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserConverter {
    UserConverter INSTANCE = Mappers.getMapper(UserConverter.class);

    User convertUserDtoToUser(UserDto userDto);

    UserDto convertUserToUserDto(User user);

    List<UserDto> convertUserListToUserDtoList(List<User> userList);


}
