package dage.recruituser.DTO;

import lombok.Data;


@Data
public class FormDTO {
    private long formNo;
    private long appNo;
    private String userEmail;
    private String userPassword;
    private String userName;
    private String userBirth;
}
