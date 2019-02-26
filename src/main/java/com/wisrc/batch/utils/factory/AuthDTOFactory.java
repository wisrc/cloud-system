package com.wisrc.batch.utils.factory;

import com.wisrc.batch.dto.AuthDto;

/**
 * Created by hzwy23 on 2017/6/29.
 */
public class AuthDTOFactory {
    public static AuthDto getAuthDTO(Boolean status, String message) {
        return new AuthDto(status, message);
    }
}
