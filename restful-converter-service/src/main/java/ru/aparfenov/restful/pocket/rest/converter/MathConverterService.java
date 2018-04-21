package ru.aparfenov.restful.pocket.rest.converter;

import ru.aparfenov.restful.pocket.converter.MathConverter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ArtemParfenov on 08.04.2018.
 */
@WebServlet("/math")
public class MathConverterService extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        resp.setContentType("text/html; charset=utf-8");
//        resp.getWriter().write(new SimpleDateFormat("dd-MM-YY HH:mm:ss").format(new Date()));

        String query=req.getParameter("sql-query");
        log("query param sql-query:" + query);
        query = query != null ? query: "select * employee";

        String responce = MathConverter.convert(req.getParameter("sql-query"), "src-numeral-system", "target-numeral-system");

        resp.setContentType("text/html; charset=utf-8");
        resp.getWriter().write(responce);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        doGet(req, resp);
    }
}
