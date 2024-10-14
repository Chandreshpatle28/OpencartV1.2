package testCase;



import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass 
{
	@Test(groups={"Sanity","Master"})
	public void verify_login()
	{
		logger.info("********** Starting TC002_LoginTest **********" );
		
		try
		{
		//Homepage
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		
		//Loginpage
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		
		//MyAccount
		MyAccountPage Myacc=new MyAccountPage(driver);
		boolean target=Myacc.isMyAccountPageExits();
		
		//Assert.assertEquals(target, true, "Login Failed");
		
		Assert.assertTrue(target);
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("********** Finished TC002_LoginTest **********" );
		
	}

}
