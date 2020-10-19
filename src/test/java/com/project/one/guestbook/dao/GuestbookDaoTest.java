package com.project.one.guestbook.dao;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.project.one.guestbook.dto.Guestbook;

@RunWith(MockitoJUnitRunner.class)
public class GuestbookDaoTest {

    @Mock private DataSource ds;
    @Mock private Connection conn;
    @Mock private PreparedStatement stmt;
    @Mock private ResultSet rs;

    private Guestbook guestbook;

    @Before
    public void setUp() throws Exception {
        assertNotNull(ds);
        assertNotNull(conn);

        when(conn.prepareStatement(anyString())).thenReturn(stmt);
        when(ds.getConnection()).thenReturn(conn);

        java.sql.Date sqlDate = new java.sql.Date(new Date().getTime());

        guestbook = new Guestbook(1L, "test-name", "test-content", sqlDate);

        when(rs.next()).thenReturn(true).thenReturn(false);
        when(rs.getLong("id")).thenReturn(guestbook.getId());
        when(rs.getString("user_name")).thenReturn(guestbook.getName());
        when(rs.getString("description")).thenReturn(guestbook.getContent());
        when(rs.getDate("datetime")).thenReturn(new java.sql.Date(guestbook.getRegdate().getTime()));
        when(stmt.executeQuery()).thenReturn(rs);
        when(stmt.executeUpdate()).thenReturn(1);
    }

    @Test
    public void addGuestbook() {
        new GuestbookDao(ds).addGuestBook(guestbook);
    }

    @Test
    public void addAndGetGuestbook() {
        GuestbookDao dao = new GuestbookDao(ds);
        dao.addGuestBook(guestbook);

        Guestbook guestbookEntry = dao.getGuestBooks().get(0);
        assertEquals(guestbookEntry.toString(), guestbook.toString());
    }
}
