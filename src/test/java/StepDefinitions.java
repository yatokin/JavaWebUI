import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lesson8.LoginBlock;
import lesson8.MainPage;
import lesson8.SportPage;

import static com.codeborne.selenide.Selenide.open;

public class StepDefinitions {
    @Given("Пользователь авторизован на сайте")
    public void userAutorization() {
        open("https://spb.kassir.ru/");
        new MainPage().clickLoginButton();
        new LoginBlock()
                .fillLoginInput("yatokinmi@yandex.ru")
                .fillPasswordInput("kassirtest")
                .submitLogin();
    }

    @When("Я кликаю на раздел Спорт")
    public void iClickSportPage() {
        new MainPage().clickSportButton();
    }

    @And("Я кликаю на конкретное мероприятие")
    public void iClickEvent() {
        new SportPage()
                .chooseEvent();
    }

    @And("Я выбираю место")
    public void iSelectPlace() {
        new SportPage()
                .goToTicketSelection()
                .sectorSelection()
                .placeSelection();
    }

    @And("Я кликаю Оформить заказ")
    public void iBuyTicket() {
        new SportPage()
                .buyingTicket();
    }

    @Then("Билет добавляется в корзину")
    public void addTicketToBasket() {
        new SportPage()
                .removeTicket()
                .deleteTicket();
    }
}
