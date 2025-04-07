package com.joazao.phoneaula2003.dto;

import java.util.List;

public record UserDto(String name, String email, List<PhoneDto> phones) {
}
