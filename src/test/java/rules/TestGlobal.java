package rules;

import com.yej_group_01.helloworld.Person;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * Created by IntelliJ IDEA.
 * Date:  2020/06/04
 * Time:  15:56
 * User: yej
 */
public class TestGlobal {
    /**
     * 全局变量的设置只会影响当前的规则 rule 不会影响到其他
     * rule 规则体中的内容
     */
    @Test
    public void testGloba01(){
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieContainer = kieServices.getKieClasspathContainer();
        KieSession kieSession = kieContainer.newKieSession("global1");

        Person person = new Person();
        person.setId("001");
        person.setName("张三");
        person.setAge(23);

        kieSession.insert(person);
        kieSession.setGlobal("count",2020);
        int count = kieSession.fireAllRules();
        System.out.println(kieSession.getGlobal("count"));
        System.out.println("总共执行了"+count+"条规则");
        kieSession.dispose();
    }
}
