package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilites.DataProviders;

/*
 * Data is valid -- login success -- test pass -- logout
 * Data is valid -- login failed -- test fail
 * 
 * Data is invalid -- login success -- test fail -- logout
 * Data is invalid -- login failed -- test pass 
 * 
 * */

public class TC003_LoginDDT extends BaseClass{

	@Test(dataProvider = "LoginData", dataProviderClass=DataProviders.class,groups="DataDriven")
	public void verify_loginDDT(String email, String pwd, String exp)
	{
		logger.info("********** Starting TC003_LoginDDT **********" );
		
		try
		{
		//Homepage
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		
		//Loginpage
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(email);
		lp.setPassword(pwd);
		lp.clickLogin();
		
		//MyAccount
		MyAccountPage Myacc=new MyAccountPage(driver);
		boolean target=Myacc.isMyAccountPageExits();
		
		if(exp.equalsIgnoreCase("Valid"))
		{
			if(target==true) 
			{
				Myacc.clickLogout();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		if(exp.equalsIgnoreCase("Invalid"))
		{
			if(target==true) 
			{
				Myacc.clickLogout();
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);
			}
		}
		}
		catch(Exception e)
		{
			Assert.fail();
		}
			
		logger.info("********** Finished TC003_LoginDDT **********" );

		
	}
	
	
	

}
