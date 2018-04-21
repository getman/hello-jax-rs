package ru.aparfenov.restful.pocket.restful.dao.multiple;

import javax.ejb.Local;

/**
 * Created by ArtemParfenov on 08.04.2018.
 */
@Local
public interface DbDaoMultiple {
    /**Executes the specified SQL query and returns a result*/
    public String executeQuery(String sqlQuery);
    public boolean executeUpdate(String sqlQuery);
}
