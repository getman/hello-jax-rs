package ru.aparfenov.restful.pocket.restful.dao.multiple;

import javax.ejb.Stateless;

/**
 * Created by ArtemParfenov on 08.04.2018.
 */
@Stateless
public class Db2DbDaoMultipleBean implements DbDaoMultiple{
    @Override
    public String executeQuery(String sqlQuery) {
        return "Db2DbDaoMultipleBean ...";
    }

    @Override
    public boolean executeUpdate(String sqlQuery) {
        return false;
    }
}
