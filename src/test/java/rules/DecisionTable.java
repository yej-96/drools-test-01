package rules;

import org.drools.decisiontable.InputType;
import org.drools.decisiontable.SpreadsheetCompiler;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * Created by IntelliJ IDEA.
 * Date:  2020/06/01
 * Time:  14:03
 * User: yej
 */
public class DecisionTable {
    /**
     * 测试决策表
     */
    @Test
    public void testisXls(){
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieContainer = kieServices.newKieClasspathContainer();
        KieSession kieSession = kieContainer.newKieSession("testXls");
        int count = kieSession.fireAllRules();
        System.out.println("总共执行了"+count+"条规则");
        kieSession.dispose();
    }

    /**
     * 将决策表输出为DRL 规则
     * @throws FileNotFoundException
     */
    @Test
    public void verificationDT() throws FileNotFoundException{
        File file = new File("E:\\Maven\\WorkspaceForIdea\\test\\drools-test-01\\src\\main\\resources\\rules.table\\rulesTwo.xls");
        InputStream is = new FileInputStream(file);
        SpreadsheetCompiler compiler = new SpreadsheetCompiler();
        String drl = compiler.compile(is, InputType.XLS);
        System.out.println(drl);
    }
}
