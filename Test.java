package capstone.pizza;



import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.FlowLayout;
import java.awt.Font;
import java.text.NumberFormat;

import javax.swing.*;

public class Test extends JFrame implements ActionListener, ItemListener {
	double Price;
	double base = 7;
	double toppings;
	double sizeToppings;

	Font headlineFont = new Font("Courier", Font.BOLD, 50);        
	Font sizeFont = new Font("Courier", Font.BOLD, 25);        
	Font toppingFont = new Font("Courier", Font.BOLD, 15);        
	Font priceFont = new Font("Courier", Font.BOLD, 20);        
	JLabel title = new JLabel("PizzaPizzaPizzaPizza");        
	JLabel sizeText = new JLabel("Please select the size of pizza?");        
	JLabel toppingText = new JLabel("What would you like on your pizza?");        

	JCheckBox extraCheese= new JCheckBox("Extra Cheese", false);        
	JCheckBox pepperoni = new JCheckBox("Pepperoni", false);        
	JCheckBox sausage = new JCheckBox("Sausage", false);        
	JCheckBox ham = new JCheckBox("Ground Beef", false);     
	JCheckBox onions = new JCheckBox("Onions", false);
	JCheckBox bacon = new JCheckBox("Bacon" , false);


	String[] pizzaSize = { "Small", "Medium", "Large",
	"Extra-Large" };        
	JComboBox sizeChoice = new JComboBox(pizzaSize);     


	JLabel priceLabel = new JLabel("Total Price");        
	JTextField price = new JTextField(10);


	public Test() {

		super("pizza");        

		sizeChoice.addActionListener(this);        
		price.addActionListener(this);        
		title.setBounds(0, 10, 1350, 50);
		add(title);
		add(sizeChoice);
		sizeChoice.setBounds(270, 120, 100, 20);
		add(sizeText);
		sizeText.setBounds(10, 50, 300,150);


		add(toppingText);

		//(x, y, height, width)

		add(pepperoni);
		pepperoni.setBounds(20,200,100,100);
		add(sausage);
		sausage.setBounds(130, 200, 100, 100);
		add(ham);
		ham.setBounds(240, 200, 100, 100);
		add(bacon);
		bacon.setBounds(350, 200, 100, 100);
		add(extraCheese);
		extraCheese.setBounds(460, 200, 110,100);
		add(onions);
		onions.setBounds(570, 200, 100, 100);

		add(priceLabel);
		priceLabel.setBounds(1170, 615, 100, 100);

		add(price);
		price.setBounds(1250,650, 80, 30 );


		pepperoni.addItemListener(this);
		sausage.addItemListener(this);
		ham.addItemListener(this);
		bacon.addItemListener(this);
		onions.addItemListener(this);
		extraCheese.addItemListener(this);

		title.setFont(headlineFont);
		sizeText.setFont(sizeFont);
		toppingText.setFont(toppingFont);
		price.setFont(priceFont);
		setLayout(null);
		sizeChoice.setSelectedIndex(2);

	}

	public static void main(String[] args) {
		Test Pizza = new Test();
		final int WIDTH = 1920;
		final int HEIGHT = 1080;
		Pizza.setSize(WIDTH, HEIGHT);
		Pizza.setVisible(true);
		Pizza.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public void actionPerformed(ActionEvent e) {
		JComboBox decide = (JComboBox) e.getSource();
		String pizzaSize = (String) decide.getSelectedItem();    

		System.out.println(pizzaSize);    
		if (pizzaSize.equals("Small")){
			Price = base;   
			sizeToppings = .25;
			System.out.println(toppings);
		}else if (pizzaSize.equals("Medium")){
			Price = base + 2;   
			sizeToppings = .5;
		}else if (pizzaSize.equals("Large")){
			Price = base + 4;    
			sizeToppings = .75;
		}else{
			Price = base + 7;  
			sizeToppings = 1;
			System.out.println(Price);
			System.out.println(toppings);

		}

		NumberFormat currency = NumberFormat.getCurrencyInstance();
		String sizePriceFormatted = currency.format(Price);

		price.setText(sizePriceFormatted);
		price.setEditable(false);
	}

	public void itemStateChanged(ItemEvent event) {
		Object source = event.getSource();
		int select = event.getStateChange();    




		if (source == extraCheese) {
			if (select == ItemEvent.SELECTED) {
				toppings += 1;

			} else
				toppings -= 1;
		} else if (source == pepperoni) {
			if (select == ItemEvent.SELECTED)
				toppings += sizeToppings;
			else
				toppings -= sizeToppings;
		
		} else if (source == bacon) {
			if (select == ItemEvent.SELECTED)
				toppings += sizeToppings;
			else
				toppings -= sizeToppings;
		
		} else if (source == onions) {
			if (select == ItemEvent.SELECTED)
				toppings += sizeToppings;
			else
				toppings -= sizeToppings;
		} else if (source == sausage) {
			if (select == ItemEvent.SELECTED)
				toppings += sizeToppings;
			else
				toppings -= sizeToppings;
		} else if (source == ham) {
			if (select == ItemEvent.SELECTED)
				toppings += sizeToppings;
			else
				toppings -= sizeToppings;


		} else if (select == ItemEvent.SELECTED)
			toppings += sizeToppings;
		else
			toppings -= sizeToppings;

		double totalPrice = toppings + Price;

		NumberFormat currency = NumberFormat.getCurrencyInstance();
		String priceFormatted = currency.format(totalPrice);
		price.setText(priceFormatted);

		System.out.println(toppings + Price);
		price.setEditable(false);
	}
}

