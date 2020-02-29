package testSuite

import org.junit.experimental.categories.Categories
import org.junit.runner.RunWith
import org.junit.runners.Suite

/**
 *
 * @author Jane* @date 2020-02-29 9:38 PM
 *
 *
 * */
@RunWith(Categories.class)
@Categories.IncludeCategory(FirstCategory.class)
@Suite.SuiteClasses([TestClassA, TestClassB])
class FirstTestSuite {}
