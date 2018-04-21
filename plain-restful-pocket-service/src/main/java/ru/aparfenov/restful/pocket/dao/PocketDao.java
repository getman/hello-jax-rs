package ru.aparfenov.restful.pocket.dao;

import ru.aparfenov.restful.pocket.model.PocketElement;

import javax.ejb.Local;
import java.util.List;

/**
 * Created by ArtemParfenov on 18.04.2018.
 */
@Local
public interface PocketDao {
    public List<PocketElement> getPockets();
    public void putIntoPocket(PocketElement newPocket);
}
