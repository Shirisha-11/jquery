
package com.testscript;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.pageobject.JqueryPageObject;
import com.utility.BaseClass;
import com.utility.ConfigFile;



public class JqueryTestScript extends BaseClass {
	
	JqueryPageObject jqueryobject=new JqueryPageObject(driver);
	BaseClass base = new BaseClass();
	ConfigFile config=new ConfigFile();
	public JqueryTestScript() throws Exception {
		config.loadPropertyFile();
}
	@BeforeSuite
	public void open() {
		
		openWebPage(config.getProperty("url"));
	}
	@Test
	public void jqueryscript() throws InterruptedException{
		Thread.sleep(5000);
		jqueryobject.scrollingPage(driver);
		jqueryobject.displayList(driver);
		jqueryobject.displayRecentList(driver);
      //  jqueryobject.clickonAboutJqueryLink(driver);
        //jqueryobject.clickonRecentUpdatelist(driver);
}
}