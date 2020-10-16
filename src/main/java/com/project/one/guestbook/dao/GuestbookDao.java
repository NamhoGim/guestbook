package com.project.one.guestbook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import com.project.one.guestbook.dto.Guestbook;
import com.project.one.guestbook.util.DBUtil;

public class GuestbookDao {
    public List<Guestbook> getGuestBooks() {

        List<Guestbook> guestbooks = new ArrayList<>();
        String sql = "SELECT * FROM user";

        try(Connection conn = DBUtil.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()) {

            while (rs.next()){
                Guestbook guestbook = new Guestbook (rs.getLong("id"), rs.getString("user_name")
                        , rs.getString("description"), rs.getDate("datetime"));

                guestbooks.add(guestbook);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return guestbooks;
    }

    public void addGuestBook(Guestbook guestbook) {
        String sql = "INSERT INTO user(user_name, description, datetime) VALUES(?, ?, ?)";

        try(Connection conn = DBUtil.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1, guestbook.getName());
            stmt.setString(2, guestbook.getContent());
            stmt.setDate(3, new java.sql.Date(guestbook.getRegdate().getTime()));

            stmt.executeUpdate();

        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
