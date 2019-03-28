package utility;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.testng.IAlterSuiteListener;
import org.testng.xml.XmlSuite;
//***** Below is code to set the parameters values of property file
public class Propertylistener implements IAlterSuiteListener {

	public void alter(List<XmlSuite> suites) {
		// TODO Auto-generated method stub
		XmlSuite suite = suites.get(0);
        Properties properties = new Properties();
        try {
            properties.load(new FileReader(("src//test//resources//locator//locator.properties")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Map<String, String> params = new HashMap<String, String>();
        for (Map.Entry<Object, Object> each : properties.entrySet()) {
            params.put(each.getKey().toString(), each.getValue().toString());

        }
        System.out.println("parameters are" + params);
        suite.setParameters(params);
	}

}
