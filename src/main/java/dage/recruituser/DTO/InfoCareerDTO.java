package dage.recruituser.DTO;

import lombok.Data;

import java.sql.Date;


@Data
public class InfoUserDTO {
    private long formNo;
    private String userName;
    private Date userBirth;
    private Date requestDate;
    private String userGender;
    private String userNation;
    private String userZip;
    private String userAddr;
    private String userAddrDtl;
    private String userCp;
    private String userTel;
    private String userProfile;
}
