package testSuite

import org.junit.jupiter.api.Test
import org.junit.experimental.categories.Category

/**
 *
 * @author Jane* @date 2020-02-29 9:29 PM
 *
 *
 * */
class TestClassA {
    @Category([FirstCategory])
    @Test()
    void firstMethod() {
        println("this is first method from TestClassA")
    }

    @Category([SecondCategory])
    @Test()
    void secondMethod() {
        println("this is second method from TestClassA")
    }
}
