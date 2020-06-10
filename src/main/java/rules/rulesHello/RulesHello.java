package rules.rulesHello;

import com.yej_group_01.helloworld.Person;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * Created by IntelliJ IDEA.
 * Date:  2020/05/28
 * Time:  15:32
 * User: yej
 */
public class RulesHello {
    public static void main(String[] args) {
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieContainer = kieServices.newKieClasspathContainer();
        KieSession kieSession = kieContainer.newKieSession("test01ssion");

        Person person = new Person();
        person.setId("00");
        person.setName("安安");
        person.setAge(23);
        kieSession.insert(person);

        int count = kieSession.fireAllRules();
        System.out.println("总共执行了"+count+"条规则");
        kieSession.dispose();
    }
}
