package worldbuilder.controller;

import worldbuilder.entity.*;
import worldbuilder.persistance.GenericDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet (
        name = "addNewOwner",
        urlPatterns = {"/addNewOwner"}
)
public class AddNewOwner extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GenericDao<Owner> ownerData = new GenericDao<>(Owner.class);

        List<Owner> owners = ownerData.getAll();
        req.setAttribute("listOwners", owners);

        RequestDispatcher dispatcher = req.getRequestDispatcher("editOwner.jsp");
        dispatcher.forward(req, resp);
    }
}
