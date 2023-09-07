package flow1.DAO;

import flow1.model.Hobby;

public interface IHobbyDAO {
    Hobby createHobby(Hobby hobby);

    Hobby getHobby(int id);

    void deleteHobby(int id);
}
