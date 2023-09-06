package flow1.DAO;

import flow1.model.Address;
import flow1.model.Users;

public interface IAddressDAO {
    void createAddress(String address);

    Address getAddressOfUser(int id);

    Address updateAddress(Address address);

    void addAddressToUser(Address address, int userId);

    void deleteAddress(int id);


}
