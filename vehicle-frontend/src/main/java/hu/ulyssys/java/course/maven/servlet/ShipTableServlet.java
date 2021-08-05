package hu.ulyssys.java.course.maven.servlet;


import hu.ulyssys.java.course.maven.entity.Ship;
import hu.ulyssys.java.course.maven.service.ShipService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

@WebServlet("/slug")
public class ShipTableServlet extends HttpServlet {

    @Inject
    private ShipService shipService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        StringBuilder builder = new StringBuilder();
        builder.append("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "<title>Ez az én címem</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "\n" +
                "<h1>Ez a csigabiga oldal</h1>\n");
        builder.append("<table>");
        builder.append("<tr>");
        builder.append("<td>ID</td>");
        builder.append("<td>Név</td>");
        builder.append("<td>Lábak száma</td>");
        builder.append("<td>Típus</td>");
        builder.append("</tr>");
        //for ciklust ami végig megy az összes Car-on, p-tag készítbelőle
        for (Ship ship : shipService.getAll()) {
            builder.append("<tr>");
            builder.append("<td>" + ship.getId() +
                    "</td>" +
                    " <td>" + ship.getManufacturer() +
                    "</td>" +
                    " <td>" + ship.getLicensePlateNumber() +
                    "</td>" +
                    "<td>" + ship.getType() +
                    "</td>");
            builder.append("</tr>");
        }
        builder.append("</table>");
        PrintWriter out = resp.getWriter();
        out.println(new String(builder.toString().getBytes(StandardCharsets.UTF_8), StandardCharsets.UTF_8.name()));
        out.println("</body>\n" + "</html>\n");
    }
}
