package ru.aparfenov.restful.pocket.rest.converter;

import ru.aparfenov.restful.pocket.converter.EncodeConverter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ArtemParfenov on 08.04.2018.
 */
@WebServlet("/encode")
public class EncodeConverterService extends HttpServlet {

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
//        String responce = dbDaoRef.executeQuery(query);
        String responce = EncodeConverter.convert(req.getParameter("sql-query"), "src-encode", "target-encode");
//        responce += dbDaoMultipleRef1.executeQuery(query);
//        responce += dbDaoMultipleRef2.executeQuery(query);
//        responce += dbDaoMultipleRef3.executeQuery(query);
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
