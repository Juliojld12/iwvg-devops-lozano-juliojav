package es.upm.miw.devops.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class SearchesTest {

    private Searches searches;

    @BeforeEach
    void setUp() {
        this.searches = new Searches(new UsersDatabase());
    }

    @Test
    void testFindFractionDivisionByUserId() {
        Fraction result = this.searches.findFractionDivisionByUserId("1");

        assertThat(result).isNotNull();
        assertThat(result.getNumerator()).isEqualTo(15);   // 3/4 ÷ 2/5 = 15/8
        assertThat(result.getDenominator()).isEqualTo(8);

        System.out.println("División usuario 1: " + result);
    }

    @Test
    void testFindUserIdByAllProperFraction() {
        List<String> result = this.searches.findUserIdByAllProperFraction().toList();

        assertThat(result)
                .isNotEmpty()
                .contains("1", "2", "4")
                .doesNotContain("3");
    }


}
