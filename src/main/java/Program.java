import java.io.InputStream;
import java.util.Date;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.model.RoutesDefinition;

public class Program {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {

		DefaultCamelContext context = new DefaultCamelContext();

		InputStream inputStream = Program.class
				.getResourceAsStream("route.xml");
		RoutesDefinition rd = context.loadRoutesDefinition(inputStream);
		context.addRouteDefinitions(rd.getRoutes());

		context.start();
		System.in.read();
	}

}
