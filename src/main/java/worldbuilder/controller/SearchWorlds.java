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
        name = "searchWorlds",
        urlPatterns = {"/searchWorlds"}
)
public class SearchWorlds extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        GenericDao<World> worlds = new GenericDao<>(World.class);


        if (req.getParameter("submit").equals("search")) {
            req.setAttribute("worlds", worlds.getByIdentifierLike(req.getParameter("searchType"), req.getParameter("searchTerm")));
        } else {
            req.setAttribute("worlds", worlds.getAll());
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("/worldResults.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
