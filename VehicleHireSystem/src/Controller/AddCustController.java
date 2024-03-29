package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.CorporateCustomer;
import Model.HireSystem;
import Model.Login;
import View.LoginView;
import View.StaffAddCustomerView;
import View.StaffQueryCustomerView;
import View.StaffQueryVehicleView;
import View.View;

public class AddCustController implements ActionListener {
	
	private HireSystem system;
	private StaffAddCustomerView view;


	public AddCustController(HireSystem system) {
		this.system = system;
	}
	
	public void addView(StaffAddCustomerView view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(this.view.getSaveButton())) {
			String customerId = this.view.getCustomerId();
			String customerName = this.view.getCustomerName();
			String customerAddr = this.view.getCustomerAddress();
			String customerPhoneNum = this.view.getCustomerPhoneNum();
			String customerEmail = this.view.getCustomerEmail();
			String customerUsername = this.view.getCustomerUsername();
			String customerPassword = this.view.getCustomerPassword();
			CorporateCustomer newCustomer = new CorporateCustomer(customerUsername,customerPassword,customerId,customerName,customerAddr,customerPhoneNum,customerEmail);
			if(this.system.addCustomer(newCustomer)) {
				this.view.setSuccessText("New Customer Added Successfully");
			}else{
				this.view.setSuccessText("Customer ID already exists.");
			};
			
		}  else if (e.getSource().equals(this.view.getCustomersButton())) {
			StaffQueryCustomerView newView = new StaffQueryCustomerView();
			this.view.setNextView(newView);
		} else if (e.getSource().equals(this.view.getVehiclesButton())) {
			StaffQueryVehicleView newView = new StaffQueryVehicleView();
			this.view.setNextView(newView);
		} else if (e.getSource().equals(this.view.getLogoutButton())) {
			Login login = new Login();
			LoginController loginController = new LoginController(login);
			LoginView newView = new LoginView(loginController);
			this.view.setNextView(newView);
		
	}
		
	}

	
}
