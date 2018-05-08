package ru.aparfenov.restful.pocket;

import ru.aparfenov.restful.pocket.dao.PocketDao;
import ru.aparfenov.restful.pocket.model.PocketElement;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by ArtemParfenov on 12.04.2018.
 */

@WebServlet("/pocket")
public class PocketService extends HttpServlet {

    @EJB
    private PocketDao dbDaoRef;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        getPocketList(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getParameter("action");
        if (action != null) {
            if ("add".equals(action)) {
                try {
                    handleAddition(request);
                } catch (Throwable t) {
                    throw new RuntimeException(t);
                }
            }
        }
        response.sendRedirect("pocket");
    }

    private void getPocketList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<PocketElement> pocketList = dbDaoRef.getPockets();
        if (!pocketList.isEmpty()) {
            request.setAttribute("pocket-list", pocketList);
        }
        request.getServletContext().getRequestDispatcher("/WEB-INF/pages/jsp/pocket.jsp").forward(request, response);
    }

    private void handleAddition(HttpServletRequest request) {
        String newPocketTitile = request.getParameter("new-pocket-title");
        String newPocketData = request.getParameter("new-pocket-data");
        PocketElement newPocketElement = new PocketElement(newPocketTitile, newPocketData);
        if (!newPocketElement.isEmpty()) {
            dbDaoRef.putIntoPocket(newPocketElement);
        }
    }
}
