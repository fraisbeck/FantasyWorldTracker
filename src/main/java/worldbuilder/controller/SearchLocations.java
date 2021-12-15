package worldbuilder.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import worldbuilder.entity.*;
import worldbuilder.persistance.GenericDao;

import java.io.IOException;

@WebServlet(
        name = "searchLocations",
        urlPatterns = {"/searchLocations"}
)
public class SearchLocations extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        GenericDao<Location> locationData = new GenericDao<>(Location.class);
        GenericDao<Region> regionData = new GenericDao<>(Region.class);

        if (req.getParameter("submit").equals("search")) {
            session.setAttribute("locations", locationData.getByIdentifierLike(req.getParameter("locationSearchType"), req.getParameter("locationSearchTerm")));
        } else if (req.getParameter("submit").equals("region")) {
            Region newRegion = regionData.getById(Integer.parseInt(req.getParameter("id")));
            session.setAttribute("locations", locationData.getByIdentifierIntEqual("region", newRegion.getId()));
        } else {
            session.setAttribute("locations", locationData.getAll());
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
