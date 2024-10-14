package testCase;



import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;

import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass
{
	@Test(groups={"Regression","Master"})
	public void verify_account_registration() 
	{
		logger.info("******* Starting TC001_AccountRegistrationTest *******");
		
		try {
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on MyAccount Link");
		
		hp.clickRegister();
		logger.info("Clicked on Register Link");
		
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		
		regpage.setFirstName(randomString().toUpperCase());
		regpage.setLastName(randomString().toUpperCase());
		regpage.setEmail(randomString()+"@gmail.com"); //randomly generate the email
		regpage.setTelephone(randomNumber());
		
		String password=randomAlphaNumeric();
		
		regpage.setPassword(password);
		regpage.setConfrimPassword(password);
		
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		
		
		logger.info("Validation expected message..");
		String confmsg=regpage.getConfrimationMsg();
		if(confmsg.equals("Your Account Has Been Created!"))
		{
			AssertJUnit.assertTrue(true);
		}
		else
		{
			logger.error("Test failed..");
			logger.debug("Debugs logs..");
			AssertJUnit.assertTrue(false);
			
		}
		
		//Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		
		}
		catch(Exception e)
		{
			AssertJUnit.fail();
		}
		
		logger.info("********** Finished TC001_AccountRegistrationTest **********");
	}
	
	
	

}
