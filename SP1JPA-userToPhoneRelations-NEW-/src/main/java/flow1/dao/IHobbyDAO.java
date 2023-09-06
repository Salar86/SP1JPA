package flow1.dao;

import flow1.model.Address;
import flow1.model.Hobby;
import flow1.model.Phone;
import flow1.model.Users;

import java.util.List;

public interface IHobbyDAO {

    Users getAllUsersInfo(int id, String firstName, String lastname , String email);

    Phone GetAllephone (int id , String phoneNumber, String users);

    List<Hobby> getAllePerson (int id , String users);

    long findTotalNumberOfUsersByHobby (Hobby hobby);
    Long findTotalNumberOfUsersByaddress (Address address);
}
