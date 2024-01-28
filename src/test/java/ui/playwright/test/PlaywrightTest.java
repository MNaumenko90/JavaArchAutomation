package ui.playwright.test;

import org.testng.annotations.Test;
import ui.playwright.po.DocumentationPage;

import static org.assertj.core.api.Assertions.assertThat;

public class PlaywrightTest extends BaseTest {

    @Test
    void shouldBeLocatorCheck() {
        new DocumentationPage().clickDocs();

        assertThat(new DocumentationPage().getHeaderDocs()).as("The title is not found")
                .isEqualTo("Installation");
    }

}
