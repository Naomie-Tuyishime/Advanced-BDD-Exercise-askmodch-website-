//package Steps;
//
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import java.time.Duration;
//import java.util.List;
//
//import static Hooks.Hooks.driver;
//import static org.junit.Assert.assertTrue;
//
//public class FilteringByCategorySteps {
//    @Given("I am on the store page")
//    public void i_am_on_the_store_page() {
//
//        driver.get("https://askomdch.com/store");
//    }
//
//    @When("I select the category {string}")
//    public void i_select_the_category(String category) {
//        WebElement categoryDropdown = driver.findElement(By.name("product_cat"));
//        Select select = new Select(categoryDropdown);
//        select.selectByValue(category);
//    }
//
//    @Then("I should see only products in the {string} category")
//    public void i_should_see_only_products_in_the_category() {
//
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".products")));
//
//
//                driver.findElements(By.cssSelector(".woocommerce-loop-product__title"));
//       driver.getTitle();
//
//    }
//
//}
