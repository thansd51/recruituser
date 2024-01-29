package dage.recruituser.DTO;

import lombok.Data;

import java.io.File;
import java.util.Date;

@Data
public class AppBoardDTO {
    private Long appNo;
    private String appTitle;
    private String appTitleSub;
    private Long appYear;
    private Long appDegree;
    private String appJob;
    private Date appStartDate;
    private Date appEndDate;
    private String appContent;
    private File appFile1;
    private File appFile2;
    private File appFile3;
    private File appFile4;
    private File appFile5;
}
