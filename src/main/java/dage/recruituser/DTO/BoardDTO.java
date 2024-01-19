package dage.recruituser.DTO;

import lombok.Data;

import java.util.Date;
@Data
public class BoardDTO {

    private int app_no;
    private String app_title;
    private Date app_start_date;
    private Date app_end_date;
    private String app_content;
    private String app_file_1;
    private String app_file_2;
    private String app_file_3;
    private String app_file_4;
    private String app_file_5;
}
