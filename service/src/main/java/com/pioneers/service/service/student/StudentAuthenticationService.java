package com.pioneers.service.service.student;

import com.pioneers.service.model.dto.StudentLoginDto;
import com.pioneers.service.model.dto.StudentSignUpDto;
import lombok.NonNull;

public interface StudentAuthenticationService {

    boolean isLoggedIn(@NonNull String id);

    void signUp(@NonNull final StudentSignUpDto studentSignUpDto);

    void login(@NonNull final StudentLoginDto studentLoginDto);

    void logout(String id);
}
