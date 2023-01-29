package pages.careers;

import org.junit.jupiter.api.Test;
import pages.BasePageTest;

import static org.assertj.core.api.Assertions.*;

public class CareerPageTest extends BasePageTest {
    static final String ANY_JOBS_SEARCH_TEXT = "Senior Software Development Engineer in Test";
    static final String NO_JOBS_SEARCH_TEXT = "XXX";
    static final String LOCATION_TEXT_POLAND = "Poland";
    static final String LOCATION_TEXT_USA = "United States";
    static final int ZERO = 0;

    @Test
    public void anyJobOffersAreFoundForLocationPolandTest() {
        CareerPage careerPage = new CareerPage(driver)
                .findYourCareerInputText(ANY_JOBS_SEARCH_TEXT)
                .searchButtonClick()
                .locationInputTextSelectCountry(LOCATION_TEXT_POLAND);

        assertThat(careerPage.getFoundJobsCountFromTextMessage())
                .isGreaterThan(ZERO);

    }

    @Test
    public void anyJobOffersAreFounForLocationUsaTest() {
        CareerPage careerPage = new CareerPage(driver)
                .findYourCareerInputText(ANY_JOBS_SEARCH_TEXT)
                .searchButtonClick()
                .locationInputTextSelectCountry(LOCATION_TEXT_USA);

        assertThat(careerPage.getFoundJobsCountFromTextMessage())
                .isGreaterThan(ZERO);
    }

    @Test
    public void isJobMessageCountEqualsToResultRowCountTest() {
        CareerPage careerPage = new CareerPage(driver)
                .findYourCareerInputText(ANY_JOBS_SEARCH_TEXT)
                .searchButtonClick()
                .locationInputTextSelectCountry(LOCATION_TEXT_USA);

        assertThat(careerPage.getFoundJobsCountFromTextMessage())
                .isEqualTo(careerPage.getFoundJobsRowCount());
    }

    @Test
    public void noJobOffersAreFoundTest() {
        CareerPage careerPage = new CareerPage(driver)
                .findYourCareerInputText(NO_JOBS_SEARCH_TEXT)
                .searchButtonClick();

        assertThat(careerPage.getFoundJobsCountFromTextMessage())
                .isEqualTo(ZERO);
    }
}
