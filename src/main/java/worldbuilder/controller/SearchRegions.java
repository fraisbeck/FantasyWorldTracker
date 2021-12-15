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
        name = "searchRegions",
        urlPatterns = {"/searchRegions"}
)
public class SearchRegions extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        GenericDao<Region> regions = new GenericDao<>(Region.class);
        GenericDao<Continent> continentData = new GenericDao<>(Continent.class);

        if (req.getParameter("submit").equals("search")) {
            session.setAttribute("regions", regions.getByIdentifierLike(req.getParameter("regionSearchType"), req.getParameter("regionSearchTerm")));
        } else if (req.getParameter("submit").equals("continent")) {
            Continent newContinent = continentData.getById(Integer.parseInt(req.getParameter("id")));
            session.setAttribute("regions", regions.getByIdentifierIntEqual("continent", newContinent.getId()));
        } else {
            session.setAttribute("regions", regions.getAll());
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
