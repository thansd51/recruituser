package dage.recruituser.Services;

import dage.recruituser.DAO.UserDAO;
import dage.recruituser.DTO.UserDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    UserDAO userDao;

    /* 유저 정보 저장 */
    @Transactional
    public Long savePost(UserDTO user_info) {
        userDao.save(user_info);
        return user_info.getUserNo();
    }

    /* 유저 정보 조회 */
    @Transactional
    public UserDTO findById(Long user_no) {
        return userDao.findById(user_no);
    }

    /* 정보 변경 */
    @Transactional
    public Long updatePost(UserDTO user_info){
        userDao.update(user_info);
        return user_info.getUserNo();
    }

    public UserDTO selectService(String user_name){
        return userDao.select(user_name);
    }
}
