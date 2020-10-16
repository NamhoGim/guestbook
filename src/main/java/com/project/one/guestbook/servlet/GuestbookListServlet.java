package com.project.one.guestbook.servlet;

import com.project.one.guestbook.dao.GuestbookDao;
import com.project.one.guestbook.dto.Guestbook;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/guestbooks")
public class GuestbookListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GuestbookDao dao = new GuestbookDao();
        List<Guestbook> list =  dao.getGuestBooks();

        resp.getWriter();
    }
}
