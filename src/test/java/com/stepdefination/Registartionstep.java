package com.stepdefination;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Registartionstep {

	WebDriver driver;

	@Given("user registration page")
	public void user_registration_page() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://mytestingthoughts.com/Sample/home.html");

	}

	@When("provided below details to form")
	public void provided_below_details_to_form(DataTable dataTable) {
		List<List<String>> datatablev = dataTable.asLists();
		for (List<String> string : datatablev) {

			driver.findElement(By.name("first_name")).sendKeys(string.get(0));
			driver.findElement(By.name("last_name")).sendKeys(string.get(1));
			driver.findElement(By.id("inlineRadioMale")).click();
			WebElement dropdown = driver.findElement(By.id("exampleFormControlSelect2"));
			Select selectvalue = new Select(dropdown);
			selectvalue.selectByVisibleText(string.get(2));

			WebElement dropdown2 = driver.findElement(By.name("department"));
			Select selectvalue2 = new Select(dropdown2);
			selectvalue2.selectByVisibleText(string.get(3));

			driver.findElement(By.name("user_name")).sendKeys(string.get(4));
			driver.findElement(By.xpath("//button[@type='submit']")).click();
		}

	}

	@Then("success Message")
	public void success_message() {
		System.out.println("Success");
	}

}
