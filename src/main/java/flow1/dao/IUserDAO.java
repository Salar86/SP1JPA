package flow1.dao;

import flow1.dto.UserDTO;
import flow1.model.Users;

import java.util.List;

public interface IUserDAO {
    int createUser(Users user);
    Users findUser(int id);
    Users updateUser(Users user);
    void deleteUser(int id);

    List<UserDTO> getAllUserInfo(int id);


}
