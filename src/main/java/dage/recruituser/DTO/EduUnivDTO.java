package dage.recruituser.DTO;

import lombok.Data;

import java.sql.Date;


@Data
public class EduHighDTO {
    private Long userNo;
    private String highName;
    private String highLoc;
    private String highSer;
    private String highGrd;
    private String highStartDate;
    private String highEndDate;
    private String highFn;
}
