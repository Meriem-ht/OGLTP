
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
        // Create a 2x2 matrix for testing
        Matrix matrix = new Matrix(2, 2);
        matrix.setValueAt(0, 0, 1);
        matrix.setValueAt(0, 1, 2);
        matrix.setValueAt(1, 0, 3);
        matrix.setValueAt(1, 1, 4);

        // Multiply the matrix by a constant (e.g., 2.0)
        Matrix result = matrix.multiplyByConstant(2.0);

        // Check the values of the resulting matrix
        Assert.assertEquals(2, result.getValueAt(0, 0), 0);
        Assert.assertEquals(4, result.getValueAt(0, 1), 0);
        Assert.assertEquals(6, result.getValueAt(1, 0), 0);
        Assert.assertEquals(8, result.getValueAt(1, 1), 0);
    }
}