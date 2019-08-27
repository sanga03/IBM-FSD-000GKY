package code.D_28_08_19.servlet.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import code.D_27_08_19.Connection.ConnectionFactory;
import code.D_27_08_19.Model.League;

/**
 * Servlet implementation class AddPlay
 */
@WebServlet("/addPlayContoller")
public class AddPlayController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) {

		List<String> err = new LinkedList<String>();
		String season = request.getParameter("season");
		if (season == "") {
			err.add("please enter valid season");
		}
		int year = 0;
		try {
			 year = Integer.parseInt(request.getParameter("year").toString());
			if (year < 2008 || year > 2019) {
				err.add("enter valid year");
			}
		} catch (NumberFormatException e) {
			err.add("year has to be number");
		}

		String league = request.getParameter("league");
		if (league == "un") {
			err.add("please select valid league");
		}

		if (err.isEmpty()) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("success.view");
			
			Connection conn = ConnectionFactory.getConnection();
			try {
				PreparedStatement pst =(PreparedStatement) conn.prepareStatement("insert into league (title,season,year,uid) values(?,?,?,?)");
				pst.setString(1, league);
				pst.setString(2, season);
				pst.setInt(3, year);
				pst.setInt(4, League.serialVersionUID++);
				pst.executeUpdate();
				
			
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			
			try {
				requestDispatcher.forward(request, response);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			request.setAttribute("err", err);

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("form.view");
			try {
				requestDispatcher.forward(request, response);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}
