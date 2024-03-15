package dage.recruituser.DTO;

import lombok.Data;

import java.io.File;


@Data
public class InfoUserDTO {
    private Long formNo;
    private String userName;
    private String userBirth;
    private String requestDate;
    private String userGender;
    private String userNation;
    private String userZip;
    private String userAddr;
    private String userAddrDtl;
    private String userCp;
    private String userTel;
    private String userProfile;
}
