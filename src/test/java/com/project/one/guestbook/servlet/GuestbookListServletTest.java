package com.project.one.guestbook.servlet;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static com.project.one.guestbook.servlet.GuestbookListServlet.*;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.project.one.guestbook.dao.GuestbookDao;

@RunWith(MockitoJUnitRunner.class)
public class GuestbookListServletTest {

    @Mock private HttpServletRequest request;
    @Mock private HttpServletResponse response;
    @Mock private RequestDispatcher dispatcher;
    @Mock private ServletContext context;

    @Mock private GuestbookDao guestbookDao;

    @Before
    public void setUp() {
        assertNotNull(request);
        assertNotNull(response);
        assertNotNull(dispatcher);
        assertNotNull(context);

        assertNotNull(guestbookDao);

        when(guestbookDao.getGuestBooks()).thenReturn(new ArrayList<>());

        when(request.getServletContext()).thenReturn(context);
        when(request.getRequestDispatcher(GUESTBOOK_LIST_PAGE)).thenReturn(dispatcher);
    }

    @Test
    public void guestbookListServlet() throws ServletException, IOException {
        GuestbookListServlet guestbookListServlet = new GuestbookListServlet(guestbookDao);

        guestbookListServlet.doGet(request, response);

        verify(request, times(1)).getRequestDispatcher(GUESTBOOK_LIST_PAGE);
        verify(request, never()).getSession();
        verify(dispatcher).forward(request, response);
    }
}
