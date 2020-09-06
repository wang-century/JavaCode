package cn.centuryw.AdvancedToLearn.TestJunit;

import org.junit.*;

/**
 目标:单元测试的概念和操作步骤。
 单元测试是指程序员写的测试代码给自己的类中的方法进行预期正确性的验证。
 单元测试一旦写好了这些测试代码，就可以一直使用，可以实现一定程度上的自动化测试。

 单元测试一般要使用框架进行
 什么是框架?
 --框架是前人或者一些牛逼的技术公司在实战或者研发中设计的一些优良的设计方案
 或者成型的代码功能，作为一个完整的技术体系发行出来称为框架。
 --框架可以让程序员快速拥有一个强大的解决方案，可以快速的开发功能，提高效率
 并且直接就有了很好的性能。

 单元测试的经典框架: Junit.
 Junit是什么
 Junit是Java语言编写的第三方单元测试框架
 Junit框架的方案可以帮助我们方便且快速的测试我们的代码的正确性。

 单元测试概念
 单元:在Java中，一个类就是一个单元
 单元测试:程序猿用Junit编写的一小段代码，
 用来对某个类中的某个方法进行功能测试或业务逻辑测试。

 Junit单元测试框架的作用
 用来对类中的方法功能进行有目的的测试，以保证程序的正确性和稳定性。
 能够独立的测试某个方法或者所有方法的预期正确性。

 Junit框架的使用步骤:
 (1）下载这个框架。（别人设计好的技术体系）
 框架一般是jar包的形式， jar包里面都是class文件。(Java工程的最终形式)
 class文件就是我们调用的核心代码。
 --现在不需要大家去官网下载，因为很多知名框架其实IDEA工具早就整合好了，
 程序员可以直接使用。
 Junit已经被IDEA下载好了，可以直接导入到项目使用的。
 (2）直接用Junit测试代码即可
 a.先模拟业务代码
 b.写测试类
 测试类的命名规范:以Test开头，以业务类类名结尾，使用驼峰命名法
 业务名称是:Userservice
 测试这个业务类的测试类:Testuserservice/userserviceTest
 c.在测试类中写测试方法
 测试方法的命名规则:以test开头，以业务方法名结尾
 比如被测试业务方法名为: login，那么测试方法名就应该叫: testLogin
 d.测试方法注意事项
 必须是public修饰的，没有返回值，没有参数
 必须使注解@Test修饰
 (3)如何运行测试方法
 选中方法名-->右键--> Run '测试方法名'运行选中的测试方法
 选中测试类类名-->右键--> Run '测试类类名'运行测试类中所有测试方法
 选中模块名-->右键-->Run 'All Tests'运行模块中的所有测试类的所有测试方法

 Junit常用注解(Junit 4.xxxx版本)
 @Test测试方法!
 @Before:用来修饰实例方法，该方法会在每一个测试方法执行之前执行一次。
 @After:用来修饰实例方法，该方法会在每一个测试方法执行之后执行一次。
 @BeforeClass:用来静态修饰方法，该方法会在所有测试方法之前只执行一次。
 @AfterClass:用来静态修饰方法，该方法会在所有测试方法之后只执行一次。
 开始执行的方法:初始化资源
 执行完之后的方法:释放资源

 Junit常用注解(Junit5.xxxx版本)
 @Test测试方法!
 @BeforeEach:用来修饰实例方法，该方法会在每一个测试方法执行之前执行一次。
 @AfterEach:用来修饰实例方法，该方法会在每一个测试方法执行之后执行一次。
 @BeforeAll:用来静态修饰方法，该方法会在所有测试方法之前只执行一次。
 @AfterAll:用来静态修饰方法，该方法会在所有测试方法之后只执行一次。

 */



/* 测试类 */
public class UserServiceTest {
    @Before
    public void before(){
        System.out.println("Before...");
    }

    @BeforeClass
    public static void beforeClass(){
        System.out.println("BeforeClass");
    }

    @Test
    public void testLogin(){
        UserService userService = new UserService();
        String result = userService.login("admin","123");
        /**
         * 断言预期结果的正确性
         * 参数说明：
         *    参数一：测试失败的提示信息
         *    参数二：期望值
         *    参数三：实际值
         */
        Assert.assertEquals(result,"success",result);
    }

    @Test
    public void testDivision(){
        UserService userService = new UserService();
        userService.division(5,1);
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("AfterClass");
    }

    @After
    public void after(){
        System.out.println("After...");
    }
}
