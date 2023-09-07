package flow1.dao;

import flow1.model.Hobby;

public interface IHobbyDAO {
    Hobby createHobby(Hobby hobby);

    Hobby getHobby(int id);

    void deleteHobby(int id);
}
