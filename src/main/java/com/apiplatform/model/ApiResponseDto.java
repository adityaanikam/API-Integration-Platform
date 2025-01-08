package com.apiplatform.model;

//package com.apiplatform.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ApiResponseDto {
    private String status;
    private String message;
    private Object data;

    public ApiResponseDto(String status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public ApiResponseDto(String message) {
        this.status = "success";
        this.message = message;
    }

    public ApiResponseDto(String message, Object data) {
        this.status = "success";
        this.message = message;
        this.data = data;
    }

    public static ApiResponseDto success(String message) {
        return new ApiResponseDto("success", message, null);
    }

    public static ApiResponseDto success(String message, Object data) {
        return new ApiResponseDto("success", message, data);
    }

    public static ApiResponseDto error(String message) {
        return new ApiResponseDto("error", message, null);
    }
}




/*import lombok.Data;

// src/main/java/com/apiplatform/model/LoginDto.java
// package com.apiplatform.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginDto {
    @NotBlank(message = "Email is required")
    @Email(message = "Please provide a valid email address")
    private String email;

    @NotBlank(message = "Password is required")
    private String password;
}
 */
// src/main/java/com/apiplatform/model/ApiResponseDto.java
//package com.apiplatform.model;