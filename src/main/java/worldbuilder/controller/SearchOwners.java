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
        name = "searchOwners",
        urlPatterns = {"/searchOwners"}
)

public class SearchOwners extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        GenericDao<Owner> ownerData = new GenericDao<>(Owner.class);
        if (req.getParameter("submit").equals("search")) {
            session.setAttribute("owners", ownerData.getByIdentifierLike(req.getParameter("shopOwnerSearchType"), req.getParameter("shopOwnerSearchTerm")));
        } else {
            session.setAttribute("owners", ownerData.getAll());
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
