package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic.WebGeneric;

public class LoginPage {
	private WebDriver driver;
	//Declaration
		@FindBy(id="txtUsername")
		private WebElement unTB;
		@FindBy(id="txtPassword")
		private WebElement pwTB;
		@FindBy(id="btnLogin")
		private WebElement LoginBTN;

	//initialization
		public LoginPage(WebDriver driver){
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}

	//utilization
		public void setUsername(String un){
			unTB.sendKeys(un);
			
		}
		public void setPassword(String pw){
			pwTB.sendKeys(pw);
		}
		public void clickLogin(){
			LoginBTN.click();
		}
	}
