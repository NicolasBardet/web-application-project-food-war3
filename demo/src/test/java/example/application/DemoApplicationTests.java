package example.application;

import example.application.controllers.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;
@SpringBootTest
public class DemoApplicationTests {
	StoreFinderController storetests;
	MainPageController mainpagetests;

	RestaurantController restauranttests;
	PrivacyPolicyController privacyPolicyTest;
	QuestionController QuestionTest;

	@BeforeEach
	public void beforeEachTest()
	{
		storetests = new StoreFinderController();
		mainpagetests = new MainPageController();
		restauranttests = new RestaurantController();
		privacyPolicyTest = new PrivacyPolicyController();
		QuestionTest = new QuestionController();
	}
	//Test whether the storeNav method redirects the webpage to the Store/Restaurant page
	@Test
	void storeNavTest() {
		String result = storetests.storenav();
		assertNotNull(result);
	}
	//Test whether the mainNav method redirects the webpage to the Main page
	@Test
	void mainNavTest() {
		String result = mainpagetests.mainpage();
		assertNotNull(result);

	}
	//Test whether the mainPage method returns the correct html template
	@Test
	void mainPageTest() {
		//Create new instance of model using concurrentmodel so that the method can be run from the test method
		Model model = new ConcurrentModel();
		String result = mainpagetests.mainPage(model);
		assertEquals("main-page-view", result);
	}
	//Test whether the accountNav method redirects the webpage to the Account Details page
	@Test
	void accountNavTest() {
		String result = mainpagetests.account();
		assertNotNull(result);
	}
	//Test whether the storeFinder method returns the correct html template
	@Test
	void storePageTest() {
		//Create new instance of model using concurrentmodel so that the method can be run from the test method
		Model model = new ConcurrentModel();
		String result = storetests.storefinder(model);
		assertEquals("store-view", result);
	}
	@Test
	void restaurantTest() {
		Model model = new ConcurrentModel();
		String result = restauranttests.restaurant(model);
		assertEquals("restaurant-view", result);
	}
	@Test
	void restaurantNavTest() {
		String result = restauranttests.restaurantnav();
		assertNotNull(result);
	}
	@Test
	void privacyPolicyTest() {
		Model model = new ConcurrentModel();
		String result = privacyPolicyTest.privacyPolicy(model);
		assertEquals("privacy-view", result);
	}
	@Test
	void privacyPolicyNavTest() {
		String result = privacyPolicyTest.privacyPolicynav();
		assertNotNull(result);
	}
	@Test
	void QuestionTest() {
		Model model = new ConcurrentModel();
		String result = QuestionTest.question(model);
		assertEquals("question-view", result);
	}
	@Test
	void QuestionNavTest() {
		String result = QuestionTest.questionnav();
		assertNotNull(result);
	}
}

