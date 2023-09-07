package flow1.dao;

import flow1.model.Phone;

import java.util.List;

public interface IPhoneDAO {
    String createPhone(String phone);
    List<Phone> findPhoneByUserId(int id);
    Phone updatePhone(Phone phone);
    void deletePhone(String phone);


}
