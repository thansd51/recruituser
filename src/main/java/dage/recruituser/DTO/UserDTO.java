package dage.recruituser.DTO;

import lombok.Data;

import java.util.Date;

@Data
public class UserDTO {
    private Long userNo;
    private String userEmail;
    private String userPassword;
    private String userName;
    private Date userBirth;
    private String userAgree1;
    private String userAgree2;
    private String userAgree3;
    private String userAgree4;
    private String userAgree5;
}
