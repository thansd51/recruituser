package dage.recruituser.DTO;

import lombok.Data;
import java.sql.Date;


@Data
public class UserDTO {
    private long formNo;
    private long appNo;
    private String userEmail;
    private String userPassword;
    private String userName;
    private String userBirth;
}
