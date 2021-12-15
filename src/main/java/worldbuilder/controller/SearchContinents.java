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
        name = "searchContinents",
        urlPatterns = {"/searchContinents"}
)
public class SearchContinents extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        GenericDao<Continent> continents = new GenericDao<>(Continent.class);
        GenericDao<World> worlds = new GenericDao<>(World.class);

        if (req.getParameter("submit").equals("search")) {
            session.setAttribute("continents", continents.getByIdentifierLike(req.getParameter("continentSearchType"), req.getParameter("continentSearchTerm")));
        } else if (req.getParameter("submit").equals("world")) {
            World newWorld = worlds.getById(Integer.parseInt(req.getParameter("id")));
            session.setAttribute("continents", continents.getByIdentifierIntEqual("world", newWorld.getId()));
        } else {
            session.setAttribute("continents", continents.getAll());
        }
        // RequestDispatcher dispatcher = req.getRequestDispatcher("/continentResults.jsp");
        RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
