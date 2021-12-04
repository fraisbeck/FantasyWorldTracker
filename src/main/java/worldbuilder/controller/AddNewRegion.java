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

@WebServlet(
        name = "addNewRegion",
        urlPatterns = {"/addNewRegion"}
)
public class AddNewRegion extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GenericDao<Continent> continentData = new GenericDao<>(Continent.class);
        List<Continent> continents = continentData.getAll();
        req.setAttribute("listContinents", continents);

        RequestDispatcher dispatcher = req.getRequestDispatcher("editRegion.jsp");
        dispatcher.forward(req, resp);
    }
}
