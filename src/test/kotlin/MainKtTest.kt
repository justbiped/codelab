import com.biped.automator.core.AutomatorRunner
import com.biped.automator.core.Scenario
import org.junit.jupiter.api.Test

class MainKtTest {

    @Test
    fun `happy test case`() {
        val testSuite = AutomatorTestSuite()
        print(testSuite)
    }
}

@Scenario(1)
@AutomatorRunner
class MyTestClass() {
    fun blabla() {
        print("haha")
    }
}

@Scenario(2)
@AutomatorRunner
class OtherMyTestClass() {
    fun blabla() {
        print("haha")
    }
}

@Scenario(3)
@AutomatorRunner
class OneMoreMyTestClass() {
    fun blabla() {
        print("haha")
    }
}