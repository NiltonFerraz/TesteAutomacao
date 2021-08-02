
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class TesteAutomacaoSteps {

	private WebDriver driver;

	@Before
	public void setUp() throws Exception {
//		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

	}

	@After
	public void tearDown() throws Exception {
//		Thread.sleep(3000);
//		driver.close();

	}

	String site1 = "http://demo.automationtesting.in/Register.html";
	String site2 = "http://demo.automationtesting.in/Frames.html";
	String site3 = "http://demo.automationtesting.in/Datepicker.html";
	String site4 = "http://demo.automationtesting.in/Slider.html";

	@Test
	@Given("^que ao acessar o site \"([^\"]*)\"$")
	public void que_ao_acessar_o_site(String arg1) throws Throwable {
		if (arg1 == site1) {
			executa_lo_deve_preencher_o_formulario();
			o_formulario_deve_ser_enviado_com_sucesso();
		} else if (arg1 == site2) {
			executa_lo_deve_escrever_dentro_do_frame();
			o_frame_deve_receber_o_texto_com_sucesso();
		} else if (arg1 == site3) {
			executa_lo_deve_inserir_a_data_de_nascimento_nos_dois_campos();
			a_data_de_nascimento_deve_ser_inserida_com_sucesso();
		} else if (arg1 == site4) {
			executa_lo_a_barra_deve_movimentar();
			a_barra_deve_ser_movimentada_com_sucesso();
		}
	}

	@When("^executa-lo deve preencher o formulario$")
	public void executa_lo_deve_preencher_o_formulario() throws Throwable {
		
		// Visita a página do Automation Demo Site - Register
		driver.get("http://demo.automationtesting.in/Register.html");

		// Escolhe o valor de First Name
		WebElement inputFirstName = driver.findElement(By.cssSelector("input[ng-model='FirstName'"));
		inputFirstName.sendKeys("Nilton");
		Assert.assertEquals("Nilton",
				driver.findElement(By.cssSelector("input[ng-model='FirstName'")).getAttribute("value"));

		// Escolhe o valor de Last Name
		WebElement inputLastName = driver.findElement(By.cssSelector("input[ng-model='LastName'"));
		inputLastName.sendKeys("Ferraz");
		Assert.assertEquals("Ferraz",
				driver.findElement(By.cssSelector("input[ng-model='LastName'")).getAttribute("value"));

		// Escolhe o valor de Address
		WebElement textArea = driver.findElement(By.cssSelector("textarea[ng-model='Adress'"));
		textArea.sendKeys("Al. Salerno, 75");
		Assert.assertEquals("Al. Salerno, 75",
				driver.findElement(By.cssSelector("textarea[ng-model='Adress'")).getAttribute("value"));

		// Escolhe o valor de Email
		WebElement inputEmail = driver.findElement(By.cssSelector("input[ng-model='EmailAdress'"));
		inputEmail.sendKeys("nilferraz@gmail.com");
		Assert.assertEquals("nilferraz@gmail.com",
				driver.findElement(By.cssSelector("input[ng-model='EmailAdress'")).getAttribute("value"));

		// Escolhe o valor de Phone
		WebElement inputPhone = driver.findElement(By.cssSelector("input[ng-model='Phone'"));
		inputPhone.sendKeys("0991611043");
		Assert.assertEquals("0991611043",
				driver.findElement(By.cssSelector("input[ng-model='Phone'")).getAttribute("value"));

		// Escolhe o valor de Gender
		WebElement inputGender = driver.findElement(By.cssSelector("input[value='Male'"));
		inputGender.click();
		Assert.assertEquals("Male", driver.findElement(By.cssSelector("input[value='Male'")).getAttribute("value"));

		// Escolhe o valor de Hobbies
		WebElement inputCheck1 = driver.findElement(By.cssSelector("input[id='checkbox1'"));
		inputCheck1.click();
		WebElement inputCheck2 = driver.findElement(By.cssSelector("input[id='checkbox2'"));
		inputCheck2.click();
		Assert.assertEquals("Cricket",
				driver.findElement(By.cssSelector("input[id='checkbox1'")).getAttribute("value"));
		Assert.assertEquals("Movies", driver.findElement(By.cssSelector("input[id='checkbox2'")).getAttribute("value"));

		// Escolhe o valor de Skilss
		Select selectSkills = new Select(driver.findElement(By.cssSelector("select[id='Skills'")));
		selectSkills.selectByIndex(38);
		Assert.assertEquals("Java", driver.findElement(By.cssSelector("select[id='Skills'")).getAttribute("value"));

		// Escolhe o valor de Country
		Select selectCountry = new Select(driver.findElement(By.cssSelector("select[id='countries'")));
		selectCountry.selectByVisibleText("Brazil");
		Assert.assertEquals("Brazil",
				driver.findElement(By.cssSelector("select[id='countries'")).getAttribute("value"));

		// Escolhe o valor de Date of Birth - Year
		Select selectYear = new Select(driver.findElement(By.id("yearbox")));
		selectYear.selectByVisibleText("1981");
		Assert.assertEquals("1981", driver.findElement(By.id("yearbox")).getAttribute("value"));

		// Escolhe o valor de Date of Birth - Month
		Select selectMonth = new Select(driver.findElement(By.cssSelector("select[ng-model='monthbox'")));
		selectMonth.selectByVisibleText("January");
		Assert.assertEquals("January",
				driver.findElement(By.cssSelector("select[ng-model='monthbox'")).getAttribute("value"));

		// Escolhe o valor de Date of Birth - Day
		Select selectDay = new Select(driver.findElement(By.cssSelector("select[ng-model='daybox'")));
		selectDay.selectByVisibleText("17");
		Assert.assertEquals("17", driver.findElement(By.cssSelector("select[ng-model='daybox'")).getAttribute("value"));

		// Escolhe o valor de First Password
		WebElement inputPassword = driver.findElement(By.id("firstpassword"));
		inputPassword.sendKeys("Pw123456");
		Assert.assertEquals("Pw123456", driver.findElement(By.id("firstpassword")).getAttribute("value"));

		// Escolhe o valor de Last Password
		WebElement inputConfirmPassword = driver.findElement(By.id("secondpassword"));
		inputConfirmPassword.sendKeys("Pw123456");
		Assert.assertEquals("Pw123456", driver.findElement(By.id("secondpassword")).getAttribute("value"));

		// Insere uma foto
		WebElement uploadImage = driver.findElement(By.id("imagesrc"));
		uploadImage.sendKeys("C:\\foto2.jpg");
//		Assert.assertEquals("foto2.jpg", driver.findElement(By.id("imagesrc")).getAttribute("value"));

		// Clica no botão Submit
		WebElement buttonSubmit = driver.findElement(By.cssSelector("button[value='sign up'"));
		buttonSubmit.click();

	}

	@Then("^o formulario deve ser enviado com sucesso$")
	public void o_formulario_deve_ser_enviado_com_sucesso() throws Throwable {

	}

	@When("^executa-lo deve escrever dentro do frame$")
	public void executa_lo_deve_escrever_dentro_do_frame() throws Throwable {
		
		// Visita a página do Automation Demo Site - Switch to - Frames
		driver.get("http://demo.automationtesting.in/Frames.html");
		driver.manage().window().maximize();

		// Direciona para o frame
		driver.switchTo().frame("singleframe");

		// Escreve dentro do frame
		WebElement inputText = driver
				.findElement(By.cssSelector("body > section > div > div > div > input[type='text'"));
		inputText.sendKeys("Nilton");

	}

	@Then("^o frame deve receber o texto com sucesso$")
	public void o_frame_deve_receber_o_texto_com_sucesso() throws Throwable {
		Assert.assertEquals("Nilton",
				driver.findElement(By.cssSelector("body > section > div > div > div > input[type='text'"))
						.getAttribute("value"));
	}

	@When("^executa-lo deve inserir a data de nascimento nos dois campos$")
	public void executa_lo_deve_inserir_a_data_de_nascimento_nos_dois_campos() throws Throwable {
		
		// Visita a página do Automation Demo Site - Datepicker
		driver.get("http://demo.automationtesting.in/Datepicker.html");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// put date on Datepicker1 Calendar
		driver.findElement(By.xpath("//input[@id='datepicker1']")).click();

		// Creating the JavascriptExecutor interface object by Type casting
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// i have stored my elements somehwere on a file as String
		WebElement disElement = driver.findElement(By.xpath("//input[@id='datepicker1']"));

		// Js executor on Readonly argument
		((JavascriptExecutor) driver).executeScript("arguments[0].value=arguments[1]", disElement, "01/17/1981");

		// put date on Datepicker2 Calendar
		driver.findElement(By.xpath("//input[@id='datepicker2']")).click();
		driver.findElement(By.xpath("//input[@id='datepicker2']")).sendKeys("01/17/1981");
		driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/a[2]")).click();
	}

	@Then("^a data de nascimento deve ser inserida com sucesso$")
	public void a_data_de_nascimento_deve_ser_inserida_com_sucesso() throws Throwable {
		Assert.assertEquals("01/17/1981",
				driver.findElement(By.xpath("//input[@id='datepicker1']")).getAttribute("value"));
		Assert.assertEquals("01/17/1981",
				driver.findElement(By.xpath("//input[@id='datepicker2']")).getAttribute("value"));
	}

	@Test
	@When("^executa-lo a barra deve movimentar$")
	public void executa_lo_a_barra_deve_movimentar() throws Throwable {

		// Visita a página do Automation Demo Site - Slider
		driver.get("http://demo.automationtesting.in/Slider.html");

		try {
			/* create an object for the Actions class and pass the driver argument */
			int x = 2;
			WebElement slider = driver.findElement(By.id("slider"));
			int width = slider.getSize().getWidth();
			Actions act = new Actions(driver);
			int new_width = (width * x) / 100;
			act.dragAndDropBy(slider, new_width, 0).perform();
			Thread.sleep(2000);
			System.out.println("Drag & Drop test case successful\n");
			Thread.sleep(3000);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

//		Actions move = new Actions(driver);
//		WebElement output = driver.findElement(By.xpath("//*[@id='slider']/a"));
//		System.out.println("Saida: " + act.);

		// Cria o movimento do slider
//		move.moveToElement(slider, ((width * x) / 100), 0).click();
//		move.build().perform();		

//		Assert.assertEquals(new_width, act.dragAndDropBy(slider, new_width, 0).perform());
	}

	@Test
	@Then("^a barra deve ser movimentada com sucesso$")
	public void a_barra_deve_ser_movimentada_com_sucesso() throws Throwable {
//		Assert.assertEquals("new_width", act.dragAndDropBy(slider, new_width, 0).perform());

	}

}
