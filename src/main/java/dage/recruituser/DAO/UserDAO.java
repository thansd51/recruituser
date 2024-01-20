package dage.recruituser.DAO;

import dage.recruituser.DTO.UserDTO;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO {
    void save(UserDTO user_info);

    public UserDTO findById(Long user_no);

    void update(UserDTO user_info);

    public UserDTO select(String user_name);

    //void deleteById(@Param("user_no") Long user_no);


}
