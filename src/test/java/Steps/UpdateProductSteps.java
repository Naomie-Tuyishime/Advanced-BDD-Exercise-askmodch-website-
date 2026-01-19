package Steps;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;

import pages.CartPage;

public class UpdateProductSteps {
    private CartPage cartPage  = new CartPage ();

    @Given("I am on the cart page")
    public void i_am_on_the_cart_page() {
        DriverFactory.getDriver();
      cartPage.load("https://askomdch.com/store/");
   cartPage.addProductToCart();

    }


    @When("I increase or decrease the product quantity in cart")
    public void i_increase_or_decrease_the_product_quantity_in_cart() {
      cartPage.productIncrimenting();
    }

    @When("I remove a product from the cart")
    public void i_remove_a_product_from_the_cart() {
    cartPage.removeItem();
    }

    @Then("Product quantity in the cart should be updated")
    public void product_quantity_in_the_cart_should_be_updated() {
       cartPage.clickUpdateBtn();
    }

    @Then("the product should be removed from the cart")
    public void the_product_should_be_removed_from_the_cart() {
      cartPage.productRemovedMsg();
}}
