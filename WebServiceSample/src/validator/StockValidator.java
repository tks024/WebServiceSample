package validator;

import java.util.ArrayList;

import form.StockForm;

public class StockValidator {

	public ArrayList<String> validate(StockForm stockForm) {
		ArrayList<String> errors = new ArrayList<String>();

		//errors.add("名前は必ず入力してください");

		String value;

		value = stockForm.getProductID();
		if (value == null || value.trim().isEmpty()) {
			errors.add("品目は必ず入力してください");
		}

		value = stockForm.getProductColorID();
		if (value == null || value.trim().isEmpty()) {
			errors.add("色種は必ず入力してください");
		}

		value = stockForm.getQuatity();
		if (value == null || value.trim().isEmpty()) {
			errors.add("数量は必ず入力してください");
		} else {
			try {
				Integer.parseInt(value);
			} catch (NumberFormatException e) {
				errors.add("数量には数値で正しく入力してください");
			}
		}

		int status;
		status = stockForm.getStatus();
		if (status == 0) {
			errors.add("状態のいずれかにチェックを入れてください");
		}

		return errors;
	}

}