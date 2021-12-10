package worldbuilder.controller;

import worldbuilder.entity.Location;
import worldbuilder.persistance.GenericDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (
        name = "deleteLocation",
        urlPatterns = {"/deleteLocation"}
)
public class DeleteLocation extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GenericDao<Location> locationData = new GenericDao<>(Location.class);
        locationData.delete(locationData.getById(Integer.parseInt(req.getParameter("id"))));

        RequestDispatcher dispatcher = req.getRequestDispatcher("searchLocations?searchTerm=&submit=viewAll");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
