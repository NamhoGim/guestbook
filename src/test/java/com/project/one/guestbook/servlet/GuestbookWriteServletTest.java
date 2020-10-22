package com.project.one.guestbook.servlet;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.io.IOException;

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
public class GuestbookWriteServletTest {

    @Mock private HttpServletRequest request;
    @Mock private HttpServletResponse response;
    @Mock private RequestDispatcher dispatcher;

    @Mock private GuestbookDao guestbookDao;

    @Before
    public void setUp() {
        assertNotNull(request);
        assertNotNull(response);
        assertNotNull(dispatcher);

        assertNotNull(guestbookDao);

        when(request.getParameter("name")).thenReturn("test-name");
        when(request.getParameter("content")).thenReturn("test-content");
    }

    @Test
    public void guestbookWriteServlet() throws ServletException, IOException {
        GuestbookWriteServlet guestbookWriteServlet = new GuestbookWriteServlet(guestbookDao);

        guestbookWriteServlet.doPost(request, response);

        verify(response).sendRedirect("/guestbooks");
    }
}
