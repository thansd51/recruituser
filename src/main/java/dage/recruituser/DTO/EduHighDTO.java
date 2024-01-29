package dage.recruituser.DTO;

import lombok.Data;
import java.sql.Date;


@Data
public class UserInfoDTO {
    private Long userNo;
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
    private Date requestDate;
    private String userGender;
    private String userNation;
    private Long userZip;
    private String userAddr;
    private String userAddrDtl;
    private String userCp;
    private String userTel;
    private String userProfile;
    private String milServiceStatus;
    private String milType;
    private String milTypeDtl;
    private String milDischarge;
    private String milExemption;
    private String milStartDate;
    private String milEndDate;
    private String vtrServiceStatus; /* char */
    private String vtrRelation;
    private String vtrNumber;
    private String disServiceStatus; /* char */
    private String disClass;
    private String disRate;

}
