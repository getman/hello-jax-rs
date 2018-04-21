package ru.aparfenov.restful.pocket.restful.dao.single;

import javax.ejb.Local;

@Local
public interface DbDaoSingle {
    /**Executes the specified SQL query and returns a result*/
    public String executeQuery(String sqlQuery);
    public boolean executeUpdate(String sqlQuery);
}
