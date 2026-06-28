package project.ec2session.domain.user.dto;

import jakarta.validation.constraints.NotBlank;
import project.ec2session.domain.user.entity.User;

import io.swagger.v3.oas.annotations.media.Schema;

public class UserReq {

    @Schema(description = "회원가입 요청")
    public record SignUpDto(
            @NotBlank(message = "아이디는 필수 입력 값입니다.")
            String username,
            @NotBlank(message = "비밀번호는 필수 입력 값입니다.")
            String password,
            @NotBlank(message = "닉네임은 필수 입력 값입니다.")
            String nickname
    ) {
        public User toEntity(String encodedPassword) {
            return User.builder()
                    .username(username)
                    .password(encodedPassword)
                    .nickname(nickname)
                    .build();
        }
    }

    @Schema(description = "로그인 요청")
    public record SignInDto(
            @NotBlank(message = "아이디는 필수 입력 값입니다.")
            String username,
            @NotBlank(message = "비밀번호는 필수 입력 값입니다.")
            String password
    ) { }

    @Schema(description = "사용자 정보 수정 요청")
    public record UpdateInfo(
            @NotBlank(message = "닉네임은 필수 입력 값입니다.")
            String nickname
    ) { }
}
