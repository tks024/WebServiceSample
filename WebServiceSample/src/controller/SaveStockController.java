package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.StockData;
import form.StockForm;
import validator.StockValidator;

public class SaveStockController implements Controller {
	public String handleRequest(HttpServletRequest request,
						HttpServletResponse response) {

		//フォームセット
		String value;
		StockForm stockForm = new StockForm();
		//品目
		value = request.getParameter("select-product-item");
		stockForm.setProductID(value);

		//色種
		value = request.getParameter("select-product-color");
		stockForm.setProductColorID(value);

		//数量
		value = request.getParameter("text-quatity");
		stockForm.setQuatity(value);


		//状態
		int _status;
		value = request.getParameter("radio-status");

		if(value == null){
			_status = 0;
		}else{
			if (value.equals("status-new")){
				_status = 1;
			}
			else if (value.equals("status-old")){
				_status = 2;
			}
			else{
				_status = 0;
			}
		}
		stockForm.setStatus(_status);


		//入力チェック
		StockValidator stockValidator = new StockValidator();
		ArrayList<String> errors = stockValidator.validate(stockForm);

		if(errors.isEmpty()) {
			//データセット
			StockData stockdata = new StockData();
			//品目
			stockdata.setProductID(stockForm.getProductID());
			//色種
			stockdata.setProductColorID(stockForm.getProductColorID());
			//数量
			stockdata.setQuatity(Integer.parseInt(stockForm.getQuatity()));
			//状態
			stockdata.setStatus(stockForm.getStatus());
			//追加処理
			stockdata.InsertProc();

			//request.setAttribute("stock", stock);
			request.setAttribute("msg", "登録が完了しました");
			return "/WEB-INF/jsp/StockForm.jsp";
		} else {
			request.setAttribute("errors", errors);
			request.setAttribute("form", stockForm);
			return "/WEB-INF/jsp/StockForm.jsp";
		}

	}
}