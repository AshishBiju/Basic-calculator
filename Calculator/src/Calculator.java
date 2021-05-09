import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.fathzer.soft.javaluator.DoubleEvaluator;

public class Calculator implements ActionListener {

	JFrame jf;
	JLabel displayField;
	JButton buttonSeven, buttonEight, buttonNine, buttonFour, buttonFive, buttonSix, buttonOne, buttonTwo, buttonThree,
			buttonDot, buttonZero, buttonEquals, buttonDiv, buttonMulti, buttonMinus, buttonAdd, buttonClear,
			buttonOpenBracket, buttonCloseBracket, buttonPower;

	String expression = "";
	boolean isCalculatorOn = true;
	boolean isEqual = false;

	// Constructor
	public Calculator() {
		jf = new JFrame("Calculator");
		jf.setLayout(null);
		jf.setSize(540, 580);
		jf.setLocation(500, 150);
		jf.setResizable(false);

		displayField = new JLabel();
		displayField.setBounds(30, 50, 480, 40);
		displayField.setFont(new Font("Serif", Font.PLAIN, 30));
		displayField.setBackground(Color.gray);
		displayField.setOpaque(true);
		displayField.setHorizontalAlignment(SwingConstants.RIGHT);
		displayField.setForeground(Color.white);
		jf.add(displayField);

		buttonSeven = new JButton(Constants.NUMBER_SEVEN);
		buttonSeven.setFont(new Font("Arial", Font.PLAIN, 30));
		buttonSeven.setBounds(30, 130, 80, 80);
		buttonSeven.addActionListener(this);
		jf.add(buttonSeven);

		buttonEight = new JButton(Constants.NUMBER_EIGHT);
		buttonEight.setFont(new Font("Arial", Font.PLAIN, 30));
		buttonEight.setBounds(130, 130, 80, 80);
		buttonEight.addActionListener(this);
		jf.add(buttonEight);

		buttonNine = new JButton(Constants.NUMBER_NINE);
		buttonNine.setFont(new Font("Arial", Font.PLAIN, 30));
		buttonNine.setBounds(230, 130, 80, 80);
		buttonNine.addActionListener(this);
		jf.add(buttonNine);

		buttonFour = new JButton(Constants.NUMBER_FOUR);
		buttonFour.setFont(new Font("Arial", Font.PLAIN, 30));
		buttonFour.setBounds(30, 230, 80, 80);
		buttonFour.addActionListener(this);
		jf.add(buttonFour);

		buttonFive = new JButton(Constants.NUMBER_FIVE);
		buttonFive.setFont(new Font("Arial", Font.PLAIN, 30));
		buttonFive.setBounds(130, 230, 80, 80);
		buttonFive.addActionListener(this);
		jf.add(buttonFive);

		buttonSix = new JButton(Constants.NUMBER_SIX);
		buttonSix.setFont(new Font("Arial", Font.PLAIN, 30));
		buttonSix.setBounds(230, 230, 80, 80);
		buttonSix.addActionListener(this);
		jf.add(buttonSix);

		buttonOne = new JButton(Constants.NUMBER_ONE);
		buttonOne.setFont(new Font("Arial", Font.PLAIN, 30));
		buttonOne.setBounds(30, 330, 80, 80);
		buttonOne.addActionListener(this);
		jf.add(buttonOne);

		buttonTwo = new JButton(Constants.NUMBER_TWO);
		buttonTwo.setFont(new Font("Arial", Font.PLAIN, 30));
		buttonTwo.setBounds(130, 330, 80, 80);
		buttonTwo.addActionListener(this);
		jf.add(buttonTwo);

		buttonThree = new JButton(Constants.NUMBER_THREE);
		buttonThree.setFont(new Font("Arial", Font.PLAIN, 30));
		buttonThree.setBounds(230, 330, 80, 80);
		buttonThree.addActionListener(this);
		jf.add(buttonThree);

		buttonDot = new JButton(Constants.SYMBOL_DOT);
		buttonDot.setFont(new Font("Arial", Font.PLAIN, 30));
		buttonDot.setBounds(30, 430, 80, 80);
		buttonDot.addActionListener(this);
		jf.add(buttonDot);

		buttonZero = new JButton(Constants.NUMBER_ZERO);
		buttonZero.setFont(new Font("Arial", Font.PLAIN, 30));
		buttonZero.setBounds(130, 430, 80, 80);
		buttonZero.addActionListener(this);
		jf.add(buttonZero);

		buttonEquals = new JButton(Constants.SYMBOL_EQUALS);
		buttonEquals.setFont(new Font("Arial", Font.PLAIN, 30));
		buttonEquals.setBounds(230, 430, 80, 80);
		buttonEquals.addActionListener(this);
		jf.add(buttonEquals);

		buttonDiv = new JButton(Constants.SYMBOL_DIVISION);
		buttonDiv.setFont(new Font("Arial", Font.PLAIN, 30));
		buttonDiv.setBounds(330, 130, 80, 80);
		buttonDiv.addActionListener(this);
		jf.add(buttonDiv);

		buttonMulti = new JButton(Constants.SYMBOL_MULTIPLICATION);
		buttonMulti.setFont(new Font("Arial", Font.PLAIN, 30));
		buttonMulti.setBounds(330, 230, 80, 80);
		buttonMulti.addActionListener(this);
		jf.add(buttonMulti);

		buttonMinus = new JButton(Constants.SYMBOL_SUB);
		buttonMinus.setFont(new Font("Arial", Font.PLAIN, 30));
		buttonMinus.setBounds(330, 330, 80, 80);
		buttonMinus.addActionListener(this);
		jf.add(buttonMinus);

		buttonClear = new JButton(Constants.CLEAR_OPTION);
		buttonClear.setFont(new Font("Arial", Font.PLAIN, 30));
		buttonClear.setBounds(330, 430, 80, 80);
		buttonClear.setBackground(Color.cyan);
		buttonClear.addActionListener(this);
		jf.add(buttonClear);

		buttonPower = new JButton(Constants.ON_OFF);
		buttonPower.setFont(new Font("Arial", Font.PLAIN, 30));
		buttonPower.setBounds(430, 130, 80, 180);
		buttonPower.setBackground(Color.red);
		buttonPower.addActionListener(this);
		jf.add(buttonPower);

		buttonAdd = new JButton(Constants.SYMBOL_ADD);
		buttonAdd.setFont(new Font("Arial", Font.PLAIN, 30));
		buttonAdd.setBounds(430, 330, 80, 180);
		buttonAdd.addActionListener(this);
		jf.add(buttonAdd);

		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object button = e.getSource();
		expression = displayField.getText();
		if (button.equals(buttonZero)) {
			if (isEqual) {
				reset();
			}
			if (displayField.getText().equals(Constants.NUMBER_ZERO)) {
				displayField.setText(Constants.NUMBER_ZERO);
			} else {
				displayField.setText(expression + Constants.NUMBER_ZERO);
			}
		} else if (button.equals(buttonOne)) {
			if (isEqual) {
				reset();
			}
			displayField.setText(expression + Constants.NUMBER_ONE);
		} else if (button.equals(buttonTwo)) {
			if (isEqual) {
				reset();
			}
			displayField.setText(expression + Constants.NUMBER_TWO);
		} else if (button.equals(buttonThree)) {
			if (isEqual) {
				reset();
			}
			displayField.setText(expression + Constants.NUMBER_THREE);
		} else if (button.equals(buttonFour)) {
			if (isEqual) {
				reset();
			}
			displayField.setText(expression + Constants.NUMBER_FOUR);
		} else if (button.equals(buttonFive)) {
			if (isEqual) {
				reset();
			}
			displayField.setText(expression + Constants.NUMBER_FIVE);
		} else if (button.equals(buttonSix)) {
			if (isEqual) {
				reset();
			}
			displayField.setText(expression + Constants.NUMBER_SIX);
		} else if (button.equals(buttonSeven)) {
			if (isEqual) {
				reset();
			}
			displayField.setText(expression + Constants.NUMBER_SEVEN);
		} else if (button.equals(buttonEight)) {
			if (isEqual) {
				reset();
			}
			displayField.setText(expression + Constants.NUMBER_EIGHT);
		} else if (button.equals(buttonNine)) {
			if (isEqual) {
				reset();
			}
			displayField.setText(expression + Constants.NUMBER_NINE);
		} else if (button.equals(buttonDot)) {
			if (isEqual) {
				reset();
			}
			displayField.setText(expression + Constants.SYMBOL_DOT);
		} else if (button.equals(buttonAdd)) {
			isEqual = false;
			displayField.setText(expression + Constants.SYMBOL_ADD);
		} else if (button.equals(buttonMinus)) {
			isEqual = false;
			displayField.setText(expression + Constants.SYMBOL_SUB);
		} else if (button.equals(buttonDiv)) {
			isEqual = false;
			displayField.setText(expression + Constants.SYMBOL_DIVISION);
		} else if (button.equals(buttonMulti)) {
			isEqual = false;
			displayField.setText(expression + Constants.OPERATOR_MULTIPLICATION);
		}

		else if (button.equals(buttonClear)) {
			isEqual = false;
			displayField.setText("");
		} else if (button.equals(buttonPower)) {
			isEqual = false;
			displayField.setText("");
			if (isCalculatorOn) {
				toggleOnOff();
				isCalculatorOn = false;
				buttonPower.setText("On");
			} else {
				toggleOnOff();
				isCalculatorOn = true;
				buttonPower.setText("Off");
			}

		} else if (button.equals(buttonEquals)) {
			isEqual = true;
			evaluateExpression();
		}
	}

	@SuppressWarnings("unused")
	private void evaluateExpression() {
		String a = expression;
		if (!expression.isEmpty()) {
			DoubleEvaluator eval = new DoubleEvaluator();
			try {
				Double result = eval.evaluate(a);
				displayField.setText(Double.toString(result));
			} catch (Exception e) {
				displayField.setText("ERROR!");
			}
		}
	}

	private void toggleOnOff() {
		if (isCalculatorOn) {
			disableAll();
		} else {
			enableAll();
		}

	}

	private void disableAll() {

		buttonPower.setBackground(Color.green);
		buttonSeven.setEnabled(false);
		buttonEight.setEnabled(false);
		buttonNine.setEnabled(false);
		buttonFour.setEnabled(false);
		buttonFive.setEnabled(false);
		buttonSix.setEnabled(false);
		buttonOne.setEnabled(false);
		buttonTwo.setEnabled(false);
		buttonThree.setEnabled(false);
		buttonDot.setEnabled(false);
		buttonZero.setEnabled(false);
		buttonEquals.setEnabled(false);
		buttonDiv.setEnabled(false);
		buttonMulti.setEnabled(false);
		buttonMinus.setEnabled(false);
		buttonAdd.setEnabled(false);
		buttonClear.setEnabled(false);

	}

	private void enableAll() {

		buttonPower.setBackground(Color.red);
		buttonSeven.setEnabled(true);
		buttonEight.setEnabled(true);
		buttonNine.setEnabled(true);
		buttonFour.setEnabled(true);
		buttonFive.setEnabled(true);
		buttonSix.setEnabled(true);
		buttonOne.setEnabled(true);
		buttonTwo.setEnabled(true);
		buttonThree.setEnabled(true);
		buttonDot.setEnabled(true);
		buttonZero.setEnabled(true);
		buttonEquals.setEnabled(true);
		buttonDiv.setEnabled(true);
		buttonMulti.setEnabled(true);
		buttonMinus.setEnabled(true);
		buttonAdd.setEnabled(true);
		buttonClear.setEnabled(true);

	}

	private void reset() {
		displayField.setText("");
		expression = "";
	}
}
