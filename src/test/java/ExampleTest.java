
import com.example.model.Matrix;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;



@RunWith(Cucumber.class)
@CucumberOptions(features = "Features",plugin={"json:target/report.json"}
)
public class ExampleTest {
    @Test
    public void testMultiplyByConstant() {


        Matrix matrix = new Matrix(2, 2);
        matrix.setValueAt(0, 0, 1);
        matrix.setValueAt(0, 1, 2);
        matrix.setValueAt(1, 0, 3);
        matrix.setValueAt(1, 1, 4);

        Matrix result = matrix.multiplyByConstant(2.0);

        Assert.assertEquals(2, result.getValueAt(0, 0), 0);
        Assert.assertEquals(4, result.getValueAt(0, 1), 0);
        Assert.assertEquals(6, result.getValueAt(1, 0), 0);
        Assert.assertEquals(8, result.getValueAt(1, 1), 0);
    }
}