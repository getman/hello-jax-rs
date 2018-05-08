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
        String dataToConvert=req.getParameter("data");
        String responce = EncodeConverter.convertToUnicode(dataToConvert, true);
        resp.setContentType("text/html; charset=utf-8");
        resp.getWriter().write(responce);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        doGet(req, resp);
    }
}
