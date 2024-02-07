package dage.recruituser.DTO;

import lombok.Data;


@Data
public class InfoSurvDTO {
    private Long formNo;
    private Long appNo;
    private Long questNo;
    private String question;
    private String answer;
}
