package rules;

import com.yej_group_01.helloworld.Person;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.QueryResults;
import org.kie.api.runtime.rule.QueryResultsRow;

/**
 * Created by IntelliJ IDEA.
 * Date:  2020/06/04
 * Time:  16:12
 * User: yej
 */
public class TestQuery {
    @Test
    public void testQuery(){
        KieServices kss = KieServices.Factory.get();
        KieContainer kc = kss.getKieClasspathContainer();
        KieSession ks = kc.newKieSession("query1");

        Person person1 = new Person("001","张三",24);
        Person person2 = new Person("002","李四",30);
        Person person3 = new Person("003","王五",35);
        Person person4 = new Person("004","张三",30);
        ks.insert(person1);
        ks.insert(person2);
        ks.insert(person3);
        ks.insert(person4);


        QueryResults queryResults = ks.getQueryResults("query age is 30");
        for (QueryResultsRow queryResult : queryResults) {
            Person p = (Person) queryResult.get("person");
            System.out.println("输出符合查询条件1的实体对象name为：" + p.getName());
        }
        System.out.println("-------------------");

        //传入参数的查询
        Object[] objects = new Object[]{"张三"};
        QueryResults qs = ks.getQueryResults("person name is 张三 and age is 30",objects);
        for (QueryResultsRow queryResult : qs) {
            Person p = (Person) queryResult.get("person");
            System.out.println("输出符合查询条件2的实体对象name为：" + p.getName());
        }


        ks.dispose();
    }
}
