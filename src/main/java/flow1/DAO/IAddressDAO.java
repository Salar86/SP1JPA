package flow1.DAO;

import flow1.model.Address;
import flow1.model.Users;

public interface IAddressDAO {
    void addAddressToDatabase(String address);

    Address getAddress(int id);

    Address updateAddress(Address address);

    Address addAddressToUser(Users user);

    void deleteAddress(int id);


}
