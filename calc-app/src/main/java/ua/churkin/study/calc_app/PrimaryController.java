package ua.churkin.study.calc_app;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class PrimaryController {
	@FXML
	TextArea viewResult;
	
	@FXML
	private void initialize() {
		viewResult.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, 
					String oldValue, String newValue) {
				if (newValue.startsWith(","))
					viewResult.setText("0");
			}
		});
	}
	
	@FXML
	private void clickingBtn1() {
		addString("1");
	}
	@FXML
	private void clickingBtn2() {
		addString("2");
	}
	@FXML
	private void clickingBtn3() {
		addString("3");
	}
	@FXML
	private void clickingBtn4() {
		addString("4");
	}
	@FXML
	private void clickingBtn5() {
		addString("5");
	}
	@FXML
	private void clickingBtn6() {
		addString("6");
	}
	@FXML
	private void clickingBtn7() {
		addString("7");
	}
	@FXML
	private void clickingBtn8() {
		addString("8");
	}
	@FXML
	private void clickingBtn9() {
		addString("9");
	}
	@FXML
	private void clickingBtn0() {
		addString("0");
	}
	@FXML
	private void clickingBtnClearLast() {
		if (!viewResult.getText().equals("0"))
			viewResult.setText(viewResult.getText(0, viewResult.getLength()-1));
		if (viewResult.getText().equals(""))
			viewResult.setText("0");
	}
	@FXML
	private void clickingBtnClearAll() {
		viewResult.setText("0");
	}
	
	private void clickingBtnPercentage() {
		viewResult.setText("%");
	}
	@FXML
	private void clickingBtnDivision() {
		addString("/");
		
		Pattern pattern = Pattern.compile("\\/{2}");
		Matcher matcher = pattern.matcher(viewResult.getText());
		
		if (Pattern.matches("\\/", viewResult.getText())) {
			viewResult.setText("0");
		}
		if (matcher.find()) {
			viewResult.setText(viewResult.getText(0, viewResult.getText().length()-1));
		}
		
		Pattern pattern1 = Pattern.compile("[\\+\\-\\*\\.]\\/");
		Matcher matcher1 = pattern1.matcher(viewResult.getText());
		if (matcher1.find())
			viewResult.setText(viewResult.getText(0, viewResult.getText().length()-1));
	}
	@FXML
	private void clickingBtnMultiplication() {
		addString("*");
		
		Pattern pattern = Pattern.compile("\\*{2}");
		Matcher matcher = pattern.matcher(viewResult.getText());
		
		if (Pattern.matches("\\*", viewResult.getText())) {
			viewResult.setText("0");
		}
		if (matcher.find()) {
			viewResult.setText(viewResult.getText(0, viewResult.getText().length()-1));
		}
		
		Pattern pattern1 = Pattern.compile("[\\+\\-\\/\\.]\\*");
		Matcher matcher1 = pattern1.matcher(viewResult.getText());
		if (matcher1.find())
			viewResult.setText(viewResult.getText(0, viewResult.getText().length()-1));
	}
	@FXML
	private void clickingBtnMinus() {
		addString("-");
		
		Pattern pattern = Pattern.compile("\\-{2}");
		Matcher matcher = pattern.matcher(viewResult.getText());
		
		if (Pattern.matches("\\-", viewResult.getText())) {
			viewResult.setText("0");
		}
		if (matcher.find()) {
			viewResult.setText(viewResult.getText(0, viewResult.getText().length()-1));
		}
		
		Pattern pattern1 = Pattern.compile("[\\+\\/\\*\\.]\\-");
		Matcher matcher1 = pattern1.matcher(viewResult.getText());
		if (matcher1.find())
			viewResult.setText(viewResult.getText(0, viewResult.getText().length()-1));
	}
	@FXML
	private void clickingBtnPlus() {
		addString("+");
		
		Pattern pattern = Pattern.compile("\\+{2}");
		Matcher matcher = pattern.matcher(viewResult.getText());
		
		if (Pattern.matches("\\+", viewResult.getText())) {
			viewResult.setText("0");
		}
		if (matcher.find()) {
			viewResult.setText(viewResult.getText(0, viewResult.getText().length()-1));
		}
		
		Pattern pattern1 = Pattern.compile("[\\/\\-\\*\\.]\\+");
		Matcher matcher1 = pattern1.matcher(viewResult.getText());
		if (matcher1.find())
			viewResult.setText(viewResult.getText(0, viewResult.getText().length()-1));
	}
	@FXML
	private void clickingBtnTotal() {
		try {
			Expression exp = new ExpressionBuilder(viewResult.getText()).build();
			viewResult.setText(Double.toString(exp.evaluate()));
		}
		catch (IllegalArgumentException e) {
			viewResult.setText(viewResult.getText());
		}
	}
	
	@FXML
	private void clickingBtnComma() {
		addString(".");
		
		Pattern pattern = Pattern.compile("\\.{2}");
		Matcher matcher = pattern.matcher(viewResult.getText());
		
		//if (Pattern.matches("\\.", viewResult.getText())) {
		//	viewResult.setText("0");
		//}
		if (matcher.find()) {
			viewResult.setText(viewResult.getText(0, viewResult.getText().length()-1));
		}
		
		Pattern pattern1 = Pattern.compile("[\\+\\-\\*\\/]\\.");
		Matcher matcher1 = pattern1.matcher(viewResult.getText());
		if (matcher1.find())
			viewResult.setText(viewResult.getText(0, viewResult.getText().length()-1));
		Pattern pattern2 = Pattern.compile("\\d+\\.\\d+\\.");
		Matcher matcher2 = pattern2.matcher(viewResult.getText());
		if (matcher2.find())
			viewResult.setText(viewResult.getText(0, viewResult.getText().length()-1));
	}
	
	private void addString(String str) {
		if (viewResult.getText().equals("0") && !str.equals("."))
			viewResult.setText(str);
		else
			viewResult.setText(viewResult.getText() + str);
	}
}
