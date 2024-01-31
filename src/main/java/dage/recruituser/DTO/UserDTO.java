package dage.recruituser.DTO;

import lombok.Data;
import java.sql.Date;


@Data
public class UserInfoDTO {
    private Long formNo;
    private Long appNo;
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
