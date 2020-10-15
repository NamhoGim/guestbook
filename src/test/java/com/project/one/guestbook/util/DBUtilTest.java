package com.project.one.guestbook.util;

import junit.framework.TestCase;
import org.junit.Test;

import com.project.one.guestbook.util.DBUtil;

public class DBUtilTest extends TestCase {

    @Test
    public void testGetConnection() {
        assertNotNull(DBUtil.getConnection());
    }
}