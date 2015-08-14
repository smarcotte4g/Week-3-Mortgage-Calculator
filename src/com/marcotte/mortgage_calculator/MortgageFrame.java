package com.marcotte.mortgage_calculator;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.*;

public class MortgageFrame extends JFrame 
{
	// class level references
	JTextField txfLoan;
	JTextField txfInterest;
	JTextField txfYears;
	JTextField txfResult;

	// constructor
	public MortgageFrame()
	{
		// set the layout manager
		this.setLayout(new GridLayout(5,1));

		// create the first panel and load it
		JPanel pnlFirst = new JPanel(new GridLayout(1,2));
		JLabel lblLoan = new JLabel("Loan Amount: ");
		lblLoan.setHorizontalAlignment(JLabel.CENTER);
		txfLoan = new JTextField(10);
		txfLoan.setHorizontalAlignment(JTextField.CENTER);
		pnlFirst.add(lblLoan);
		pnlFirst.add(txfLoan);
		this.add(pnlFirst);

		// create the second panel and load it
		JPanel pnlSecond = new JPanel(new GridLayout(1,2));
		JLabel lblInterest = new JLabel("Interest Rate: ");
		lblInterest.setHorizontalAlignment(JLabel.CENTER);
		txfInterest = new JTextField(10);
		txfInterest.setHorizontalAlignment(JTextField.CENTER);
		pnlSecond.add(lblInterest);
		pnlSecond.add(txfInterest);
		this.add(pnlSecond);

		// create the third panel and load it
		JPanel pnlthird = new JPanel(new GridLayout(1,2));
		JLabel lblYears = new JLabel("Years: ");
		lblYears.setHorizontalAlignment(JLabel.CENTER);
		txfYears = new JTextField(10);
		txfYears.setHorizontalAlignment(JTextField.CENTER);
		pnlthird.add(lblYears);
		pnlthird.add(txfYears);
		this.add(pnlthird);

		// create the fourth panel and load it
		JPanel pnlfourth = new JPanel(new GridLayout(1,2));
		JLabel lblResult = new JLabel("Result: ");
		lblResult.setHorizontalAlignment(JLabel.CENTER);
		txfResult = new JTextField(10);
		txfResult.setHorizontalAlignment(JTextField.CENTER);
		txfResult.setEditable(false);
		pnlfourth.add(lblResult);
		pnlfourth.add(txfResult);
		this.add(pnlfourth);
		
		JPanel pnlFifth = new JPanel(new FlowLayout());
		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ev) 
			{
				// get the input
				double loan = Double.parseDouble(txfLoan.getText());
				double interest = Double.parseDouble(txfInterest.getText());
				int years = Integer.parseInt(txfYears.getText());
				
				// calculate monthly payment
				double monthlyInterest = (interest / 12.0) / 100.0;
				int months = years * 12;
				//P = L[i(1+ i)^n]/[(1+i)^n -1]
				double term = Math.pow(1 + monthlyInterest, months);
				double payments = loan * (monthlyInterest * term) / (term -1);
				
				// show output
				DecimalFormat fmt = new DecimalFormat("$#,##0.00");
				txfResult.setText(fmt.format(payments));
				
			}});
		pnlFifth.add(btnCalculate);
		this.add(pnlFifth);


	}
}
