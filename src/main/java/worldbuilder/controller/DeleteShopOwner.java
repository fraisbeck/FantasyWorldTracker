package worldbuilder.controller;

import worldbuilder.entity.Owner;
import worldbuilder.persistance.GenericDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (
        name = "deleteShopOwner",
        urlPatterns = {"/deleteShopOwner"}
)
public class DeleteShopOwner extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GenericDao<Owner> ownerData = new GenericDao<>(Owner.class);
        ownerData.delete(ownerData.getById(Integer.valueOf(req.getParameter("id"))));

        RequestDispatcher dispatcher = req.getRequestDispatcher("searchOwners?searchTerm=&submit=viewAll");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
