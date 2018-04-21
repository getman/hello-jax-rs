package ru.aparfenov.restful.pocket.restful;


import ru.aparfenov.restful.pocket.restful.dao.multiple.DbDaoMultiple;
import ru.aparfenov.restful.pocket.restful.dao.single.DbDaoSingle;

import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**Сервис возвращает дату и время сервера */
@WebServlet("/db")
public class DbRequestService extends HttpServlet {
    @EJB
    private DbDaoSingle dbDaoRef;
    @EJB
    private DbDaoMultiple dbDaoMultipleRef1;
    @EJB
    private DbDaoMultiple dbDaoMultipleRef2;
    @EJB(beanName = "Db2DbDaoMultipleBean")
    private DbDaoMultiple dbDaoMultipleRef3;

    /**Receives SQL requests from clients to pass them to the database and returns dataset or error*/
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        resp.setContentType("text/html; charset=utf-8");
//        resp.getWriter().write(new SimpleDateFormat("dd-MM-YY HH:mm:ss").format(new Date()));

        String query=req.getParameter("sql-query");
        log("query param sql-query:" + query);
        query = query != null ? query: "select * employee";
//        if (logger.isDebugEnabled()) {
//            logger.debug("SQL request is:" + query);
//        }
        String responce = dbDaoRef.executeQuery(query);
        responce += dbDaoMultipleRef1.executeQuery(query);
        responce += dbDaoMultipleRef2.executeQuery(query);
        responce += dbDaoMultipleRef3.executeQuery(query);
        resp.setContentType("text/html; charset=utf-8");
        resp.getWriter().write(responce);
//        resp.getWriter().write("booo");
//        if (logger.isTraceEnabled()) {
//            logger.trace("response is: " + responce);
//        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        doGet(req, resp);
    }
}