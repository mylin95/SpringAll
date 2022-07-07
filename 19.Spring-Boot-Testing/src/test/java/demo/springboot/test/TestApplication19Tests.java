package demo.springboot.test;

import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author:       linmingyi
 * @DateTime:     2021/7/27 9:07
 * @Description:  JUnit4注解
 * JUnit4中包含了几个比较重要的注解：@BeforeClass、@AfterClass、@Before、@After和@Test。
 *  其中， @BeforeClass和@AfterClass在每个类加载的开始和结束时运行，必须为静态方法；
 *  而@Before和@After则在每个测试方法开始之前和结束之后运行。
 * 见如下例子：
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestApplication19Tests {

    @BeforeClass
    public static void beforeClassTest() {
        System.out.println("before class test");
    }

    @Before
    public void beforeTest() {
        System.out.println("before test");
    }

    @Test
    public void Test1() {
        System.out.println("test 1+1=2");
        Assert.assertEquals(2, 1 + 1);
    }

    @Test
    public void Test2() {
        System.out.println("test 2+2=4");
        Assert.assertEquals(4, 2 + 2);
    }

    @After
    public void afterTest() {
        System.out.println("after test");
    }

    @AfterClass
    public static void afterClassTest() {
        System.out.println("after class test");
    }
}