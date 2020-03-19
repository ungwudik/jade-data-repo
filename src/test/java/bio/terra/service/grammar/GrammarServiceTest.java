package bio.terra.service.grammar;

import bio.terra.common.category.Unit;
import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("google")
@Category(Unit.class)
public class GrammarServiceTest {

    @Test
    public void validateBQLString() throws IOException {
        GrammarService gs = new GrammarService();
        boolean res = gs.validateBQLString("SELECT DISTINCT variant.id FROM `broad-jade-my-data.datarepo_V2F_GWAS_Summary_Stats.variant` AS variant WHERE variant.id IN (\"5:145856597:T:C\")");
        Assert.assertEquals(true, res);
    }

    @Test
    public void testValidateInvalidBQL() throws IOException {
        GrammarService gs = new GrammarService();
        boolean res = gs.validateBQLString("hi rori");
        Assert.assertEquals(false, res);
    }

    @Test
    public void testGetDatasetName() {
        GrammarService gs = new GrammarService();
        String res = gs.getDatasetName("SELECT DISTINCT variant.id FROM `broad-jade-my-data.datarepo_V2F_GWAS_Summary_Stats.variant` AS variant WHERE variant.id IN (\"5:145856597:T:C\")");
        Assert.assertEquals("datarepo_V2F_GWAS_Summary_Stats", res);
    }
}
