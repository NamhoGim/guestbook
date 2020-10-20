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
    static final String GUESTBOOK_LIST_PAGE = "/WEB-INF/view/guestbooks.jsp";

    private final GuestbookDao guestbookDao;

    public GuestbookListServlet() {
        this.guestbookDao = new GuestbookDao();
    }

    public GuestbookListServlet(GuestbookDao guestbookDao) {
        this.guestbookDao = guestbookDao;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Guestbook> guestbookList = guestbookDao.getGuestBooks();
        req.setAttribute("guestbooks", guestbookList);

        RequestDispatcher rd = req.getRequestDispatcher(GUESTBOOK_LIST_PAGE);
        rd.forward(req, resp);
    }
}
