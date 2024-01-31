package dage.recruituser.DTO;

import lombok.Data;

import java.sql.Date;


@Data
public class InfoPersonDTO {
    private Long formNo;
    private String milServiceStatus;
    private String milType;
    private String milTypeDtl;
    private String milDischarge;
    private String milExemption;
    private String milStartDate;
    private String milEndDate;
    private String vtrServiceStatus;
    private String vtrRelation;
    private String vtrNumber;
    private String disServiceStatus;
    private String disClass;
    private String disRate;
}
