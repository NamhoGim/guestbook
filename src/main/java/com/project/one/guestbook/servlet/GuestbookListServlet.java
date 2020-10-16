package com.project.one.guestbook.servlet;



import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.one.guestbook.dao.GuestbookDao;
import com.project.one.guestbook.dto.Guestbook;


@WebServlet("/guestbooks")
public class GuestbookListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GuestbookDao dao = new GuestbookDao();
        List<Guestbook> guestbookList =  dao.getGuestBooks();
        req.setAttribute("guestbooks",guestbookList);

        RequestDispatcher rd = req.getRequestDispatcher("/guestbooks.jsp");
        rd.forward(req,resp);
    }
}
