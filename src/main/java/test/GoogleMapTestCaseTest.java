package test;

import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseTest;

public class GoogleMapTestCaseTest extends BaseTest {
	  Row row;
	  String keyWord;
	  String shopName;
	  int scrollCount;
	  double shopLatitude;
	  double shopLongitude;
	  double pointBLatitude;
	  int miles;
	  int scrollTimeStart;
	  int scrollTimeEnd;
	  long startTime;
//	  long elapsedTime;
	  int exicutionCount;
	  int passedExicutionCount;
	  int failedExicutionCount;
	  //long timeLimitMillis = 4 * 60 * 60 * 1000;
	  int maxExecutionMinutes = 120;
	  int resetNetworkCount;
	  int rowCount;
	
	  @Parameters({"deviceName", "udid"}) 
      @Test
      public void testGoogleMapTestCase(String deviceName, String udid) throws Exception {
     
//    	  startTime = System.currentTimeMillis();
//	      //long timeLimitMillis = 24 * 60 * 60 * 1000;
//    	  double timeLimitMillis =  (1.5 * 60 * 60 * 1000);
//	      while (isWithinMaxExecutionTime()) {
	    	  int executionCount = 0;
	            int passCount = 0;
	            int failCount = 0;
	            System.out.println(deviceName+udid);
	            //startAppium();
	            //sleep(5);
	            

	    	  exicutionCount++;
//    	  startTime = System.currentTimeMillis();
//    	  while(true) {
//    		  elapsedTime = System.currentTimeMillis()-startTime;
//    		  
//    		  if(elapsedTime >= timeLimitMillis) {
//    			  System.out.println("Completed Exicution");
//    	          System.out.println("Total Exicution ___"+exicutionCount);
//    			  break;
//    		  }  
    	  Sheet sheet = getExcelSheet("Resources/GoogleMapTestData.xlsx", "Sheet9");
    	  System.out.println("Sheet = "+sheet);
    	  System.out.println("sheet2");
    	  for (int i = 1; i <=sheet.getLastRowNum(); i++) {
    		  
    		  		//startAppiumServer();
    		  		//executeCommand("appium server  -p 4723 -a 127.0.0.1 -pa /wd/hub");//
    		      //  
    		        beforeMethod( deviceName,  udid);
    		        System.out.println("Google Map");
    		        
    		        //////////////////
    		        
                    row = sheet.getRow(i);
                    keyWord = row.getCell(3).getStringCellValue();
                    shopName = row.getCell(5).getStringCellValue();
                    scrollCount = (int) row.getCell(4).getNumericCellValue();
                    shopLatitude = row.getCell(0).getNumericCellValue();
                    shopLongitude = row.getCell(1).getNumericCellValue();
                    //pointBLatitude = row.getCell(2).getNumericCellValue();
                    miles = (int) row.getCell(2).getNumericCellValue();
                    scrollTimeStart =  (int) row.getCell(6).getNumericCellValue();
                    scrollTimeEnd = (int) row.getCell(7).getNumericCellValue();
 
                    String url = "https://httpbin.org/user-agent";
                    
                    // startDriver();
                    
                    //Network Reset
                      toogleFlightMode();
                      sendRequestWithDynamicUserAgent(url, true);
//      	            connectWifi();
//      	            driver.quit();
//      	            sleep(3);
//      	            
//      	            beforeMethod( deviceName,  udid);
         
           	     //Change Location
                   double[] randomLocation = generateRandomLocation(shopLatitude, shopLongitude, miles);
                    
                    
                    changeLocation(randomLocation[0], randomLocation[1], 0);  
           	        //sleep(1);
                    //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                   // changeLocation(generateRandomLatitudeFormP_AToPoint_B(pointALatitude, pointBLatitude),generateRandomLatitudeFormP_AToPoint_B(pointALongitude, pointBLongitude), 0);
                    //sleep(2);
                    
                    
           	        //keyword search
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    
                    googleMapPage.clickOnSearchBoxSendText(keyWord);
                    System.out.println("KeyWord..."+keyWord);
                    
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                   // googleMapPage.checkInternetIsWorking();
                    
                    //Sorting with distance
                    //googleMapPage.chnageToDistance();
                    //sleep(2);
                    //Scroll to find shop name
                    googleMapPage.scrollDownIfSponseredComes();
                    googleMapPage.scrollDownIfSponseredComes();
                    googleMapPage.scrollDownIfSponseredComes();
                    googleMapPage.moveToShopName(driver, shopName,scrollCount );
                    System.out.println("Shop Name --"+shopName+"Scroll Count--"+scrollCount);
                   
                    chromeBrowserPage.scrollForTimeInTouchAction(driver, generateRndmNumber(scrollTimeStart, scrollTimeEnd));
                    googleMapPage.executeClickSession(driver, generateRndmNumber(scrollTimeStart, scrollTimeEnd));
                    googleMapPage.ClickonOverview();
                    //Navigate to Shop GMB
                    String result = googleMapPage.getYesOrNo();
                    if (result.equals("yes")) {
                    	System.out.println("Deided to click the URl");
                        //performAction();
                    	googleMapPage.clickOnShopUrl();
                    	for(int j = 8; j <=row.getLastCellNum()-1 ; j++) {
            	        	System.out.println("In 2nd loop");
            	        	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//            	        	chromeBrowserPage.useWithoutAnAccount();
            	        	sleep(1);
            	        	//chromeBrowserPage.scrollForTimeInTouchAction(driver, generateRndmNumber(scrollTimeStart, scrollTimeEnd));
            	        	//scrollForDurationInSeconds(driver, generateRndmNumber(scrollTimeStart, scrollTimeEnd));
            	        	//scrollForTimeInTouchAction(driver,generateRndmNumber(scrollTimeStart, scrollTimeEnd));
            	        	scrollForTime(generateRndmNumber(scrollTimeStart, scrollTimeEnd));
    	        		    scrollInTouchActionToTheTop(driver);
////    	        		    chromeBrowserPage.moveToTopView();
////    	        		    chromeBrowserPage.pageMenuOption();
////    	        		    chromeBrowserPage.exicuteRandomMethod();
    	        		    sleep(1);
    	        		    chromeBrowserPage.scrollForTimeInTouchAction(driver, generateRndmNumber(scrollTimeStart, scrollTimeEnd));
    	        		    scrollInTouchActionToTheTop(driver);
    	        		    //googleMapPage.sendTextToUrlSearchBox((row.getCell(j).getStringCellValue()));
    	        		    System.out.println((row.getCell(j).getStringCellValue()));
    	        		    System.out.println(j);
//    	        		    
//    	        		    //Scroll the pages
    	        		    scrollInTouchActionToTheTop(driver);
//    	        		    
//    	        		    
            	     }
                    }
//      	            googleMapPage.clickOnShopUrl();
//        	        System.out.println("Navigate to Shop GMB");
        	        
        	        //Navigate different pages from xls file
        	        
        	        
        	       // scrollInTouchActionToTheTop(driver);   
        	       sleep(1);
        	       
        	       //Close all the tabs
        	     chromeBrowserPage.clearBrowserData();
        	     System.out.println("All tabs clear");
        	     
        	    // DisconnectedWifi();
        	     
        	     //Close all Apps
        	     chromeBrowserPage.closeAllApps();
        	     System.out.println("Closed all app");
        	     
        	     
        	     
        	     //Network Reset
        	     //toogleFlightMode();
        	     //sleep(3);
        	     //toogleFlightMode();
        	    
        	     resetNetworkCount++;
        	     
        	     
        	     driver.quit();
        	     rowCount++;
        	     System.out.println(rowCount+"Row completed");
        	     
	        	
      }
    	  passedExicutionCount++;
    	 
 		
 		 
 		 
 		 System.out.println(resetNetworkCount+"-- TImes Network Resetting");
     	 
    	  System.out.println("Passed Exicution--"+passedExicutionCount);
    	  System.out.println(exicutionCount+"___CompleteExicution");
    }
//	      System.out.println("Total Executions: " + exicutionCount);
//	        System.out.println("Successful Executions: " + passedExicutionCount);
//	        failedExicutionCount = exicutionCount - passedExicutionCount;
//	        System.out.println("Failed Executions: " + failedExicutionCount);
  
//      private boolean isWithinMaxExecutionTime() {
//          long currentTime = System.currentTimeMillis();
//          long elapsedMinutes = (currentTime - startTime) / (1000 * 60);
//          return elapsedMinutes < maxExecutionMinutes;
//      }
	
 	                         
    	  
    	  
    	  
}
      
