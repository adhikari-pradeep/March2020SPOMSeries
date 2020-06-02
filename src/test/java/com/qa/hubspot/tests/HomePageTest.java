package com.qa.hubspot.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BaseTest;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.utils.Constants;

public class HomePageTest extends BaseTest {

	HomePage homePage;
	
	@BeforeClass
	public void homeSetup() {
		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority = 3)
	public void verifyHomePageTitle() {
		String title = homePage.getHomePageTitle();
		System.out.println("Home Page title is :" + title);
		Assert.assertEquals(title, Constants.HOME_PAGE_TITLE, "home page title is not matched..");
	}

	@Test(priority = 1)
	public void verifyHomePageHeader() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String header=homePage.getHomePageHeaderText();
		System.out.println("Home page is : "+header);
		Assert.assertEquals(header, Constants.HOME_PAGE_HEADER, "home page header is not present..");
	}
	
	@Test(priority = 2,enabled = false)
	 public void verifyLoggedInUserTest() {
		String loggedInUser=homePage.getLoggedInUser();
		System.out.println("Logged in user : "+loggedInUser);
		Assert.assertEquals(loggedInUser, prop.getProperty("accountname"), "Logged in user is not matched ....");
	}

	
}
