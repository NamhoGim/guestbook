package com.project.one.guestbook.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.one.guestbook.dao.GuestbookDao;
import com.project.one.guestbook.dto.Guestbook;

@WebServlet("/guestbooks/write")
public class GuestbookWriteServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text.html; charset=UTF-8");

        String name = req.getParameter("name");
        String description = req.getParameter("content");

        Guestbook guestbook = new Guestbook(name, description);
        GuestbookDao guestbookDao = new GuestbookDao();

        guestbookDao.addGuestBook(guestbook);


        resp.sendRedirect("/guestbooks");
    }
}
