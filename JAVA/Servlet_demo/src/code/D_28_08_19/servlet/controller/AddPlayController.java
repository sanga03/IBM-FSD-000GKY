package code.D_28_08_19.servlet.controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

		try {
			int year = Integer.parseInt(request.getParameter("year").toString());
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
			try {
				requestDispatcher.forward(request, response);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			request.setAttribute("err", err);

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("error.view");
			try {
				requestDispatcher.forward(request, response);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}
