package ru.aparfenov.restful.pocket.restful;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**Сервис возвращает дату и время сервера */
@WebServlet("/sql")
public class ServerDateTimeService extends HttpServlet{
    /**Receives SQL requests from clients to pass them to the database and returns dataset or error*/
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html; charset=utf-8");
        resp.getWriter().write(new SimpleDateFormat("dd-MM-YY HH:mm:ss").format(new Date()));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        doGet(req, resp);
    }
}
