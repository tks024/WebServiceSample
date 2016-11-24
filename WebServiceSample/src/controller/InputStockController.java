package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InputStockController implements Controller {
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		return "/WEB-INF/jsp/StockForm.jsp";
	}
}