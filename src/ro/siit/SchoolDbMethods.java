package ro.siit;

/**
 * General class that keeps the methods for connection and database sorted display.
 *
 * @author Radu Popescu
 */

import java.sql.*;

public class SchoolDbMethods {

    public static Connection getConnection(String dbType, String host, String port,
                                           String dbName, String username, String password) {
        Connection conn = null;
        DriverManager.setLoginTimeout(60);
        try {
            StringBuilder connectionUrl = new StringBuilder();
            connectionUrl.append("jdbc:");
            connectionUrl.append(dbType);
            connectionUrl.append("://");
            connectionUrl.append(host);
            connectionUrl.append(":");
            connectionUrl.append(port);
            connectionUrl.append("/");
            connectionUrl.append(dbName);
            connectionUrl.append("?user=");
            connectionUrl.append(username);
            connectionUrl.append("&password=");
            connectionUrl.append(password);

            return DriverManager.getConnection(connectionUrl.toString());
        } catch (SQLException e) {
            System.out.println("Cannot connect to database: " + e.getMessage());
        }
        return null;
    }

    public static void getAllClasses() {
        Connection conn = getConnection(
                "mysql", "localhost", "3306", "school", "root", "manchester46");
        if (conn == null) return;

        Statement st = null;
        ResultSet rs = null;
        String format = "| %10s | %10s | %10s | %20s | %20s | %20s | %20s |\n";

        try {
            st = conn.createStatement();
            rs = st.executeQuery("SELECT * FROM classes");

            System.out.format(format, "Class Id", "Course Id", "Days", "Start time", "End time", "Building", "Room number");
            while (rs.next()) {
                String classid = rs.getString("classid");
                String courseid = rs.getString("courseid");
                String days = rs.getString("days");
                String starttime = rs.getString("starttime");
                String endtime = rs.getString("endtime");
                String bldg = rs.getString("bldg");
                String roomno = rs.getString("roomno");

                System.out.format(format, classid, courseid, days, starttime, endtime, bldg, roomno);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void getCourseById(int specificCourseId) {
        Connection conn = getConnection(
                "mysql", "localhost", "3306", "school", "root", "manchester46");
        if (conn == null) return;

        Statement st = null;
        ResultSet rs = null;
        String format = "| %20s | %20s | %20s | %35s | %20s |\n";

        try {
            st = conn.createStatement();
            rs = st.executeQuery("SELECT * FROM courses WHERE courseid = " + specificCourseId);

            System.out.format(format, "Course Id", "Area", "Title", "Description", "Prerequisite");
            while (rs.next()) {
                String courseid = rs.getString("courseid");
                String area = rs.getString("area");
                String title = rs.getString("title");
                String descrip = rs.getString("descrip");
                String prereqs = rs.getString("prereqs");

                System.out.format(format, courseid, area, title, descrip, prereqs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void getClassesWithIntroTitle() {
        Connection conn = getConnection(
                "mysql", "localhost", "3306", "school", "root", "manchester46");
        if (conn == null) return;

        Statement st = null;
        ResultSet rs = null;
        String format = "| %10s | %10s | %10s | %20s | %20s | %20s | %20s |\n";

        try {
            st = conn.createStatement();
            rs = st.executeQuery("SELECT \n" +
                    "\tcl.classid, cl.courseid, cl.days, cl.starttime, cl.endtime, cl.bldg, cl.roomno\n" +
                    "FROM \n" +
                    "\tclasses AS cl\n" +
                    "    INNER JOIN courses AS co\n" +
                    "    ON cl.courseid = co.courseid\n" +
                    "WHERE \n" +
                    "\tLOWER (co.title) LIKE 'intro%';");

            System.out.format(format, "Class Id", "Course Id", "Days", "Start time", "End time", "Building", "Room number");
            while (rs.next()) {
                String classid = rs.getString("classid");
                String courseid = rs.getString("courseid");
                String days = rs.getString("days");
                String starttime = rs.getString("starttime");
                String endtime = rs.getString("endtime");
                String bldg = rs.getString("bldg");
                String roomno = rs.getString("roomno");

                System.out.format(format, classid, courseid, days, starttime, endtime, bldg, roomno);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void getClassesWithCosDept() {
        Connection conn = getConnection(
                "mysql", "localhost", "3306", "school", "root", "manchester46");
        if (conn == null) return;

        Statement st = null;
        ResultSet rs = null;
        String format = "| %10s | %10s | %10s | %20s | %20s | %20s | %20s |\n";

        try {
            st = conn.createStatement();
            rs = st.executeQuery("SELECT \n" +
                    "\tcl.classid, cl.courseid, cl.days, cl.starttime, cl.endtime, cl.bldg, cl.roomno\n" +
                    "FROM \n" +
                    "\tclasses AS cl\n" +
                    "    INNER JOIN crosslistings AS cr\n" +
                    "    ON cl.courseid = cr.courseid\n" +
                    "WHERE \n" +
                    "\tLOWER (cr.dept) LIKE 'cos' AND CAST(cr.courseno AS CHAR(255)) LIKE '3%';");

            System.out.format(format, "Class Id", "Course Id", "Days", "Start time", "End time", "Building", "Room number");
            while (rs.next()) {
                String classid = rs.getString("classid");
                String courseid = rs.getString("courseid");
                String days = rs.getString("days");
                String starttime = rs.getString("starttime");
                String endtime = rs.getString("endtime");
                String bldg = rs.getString("bldg");
                String roomno = rs.getString("roomno");

                System.out.format(format, classid, courseid, days, starttime, endtime, bldg, roomno);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void getClassesWithCosProfname() {
        Connection conn = getConnection(
                "mysql", "localhost", "3306", "school", "root", "manchester46");
        if (conn == null) return;

        Statement st = null;
        ResultSet rs = null;
        String format = "| %10s | %10s | %10s | %20s | %20s | %20s | %20s |\n";

        try {
            st = conn.createStatement();
            rs = st.executeQuery("SELECT \n" +
                    "\tcl.classid, cl.courseid, cl.days, cl.starttime, cl.endtime, cl.bldg, cl.roomno\n" +
                    "FROM \n" +
                    "\tclasses AS cl\n" +
                    "    INNER JOIN coursesprofs AS co\n" +
                    "    ON cl.courseid = co.courseid\n" +
                    "    INNER JOIN profs AS p\n" +
                    "    ON co.profid = p.profid\n" +
                    "WHERE \n" +
                    "\tLOWER (p.profname) LIKE 'cos%';");

            System.out.format(format, "Class Id", "Course Id", "Days", "Start time", "End time", "Building", "Room number");
            while (rs.next()) {
                String classid = rs.getString("classid");
                String courseid = rs.getString("courseid");
                String days = rs.getString("days");
                String starttime = rs.getString("starttime");
                String endtime = rs.getString("endtime");
                String bldg = rs.getString("bldg");
                String roomno = rs.getString("roomno");

                System.out.format(format, classid, courseid, days, starttime, endtime, bldg, roomno);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}