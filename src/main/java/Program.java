import java.util.Date;
import java.util.Map;
import java.util.Set;

import javax.activation.DataHandler;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.InvalidPayloadException;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class Program {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {

		CamelContext context = new DefaultCamelContext();
		RoutesBuilder builder = new DummyRoutesBuild();
		// Add route definication
		context.addRoutes(builder);
		context.start();
		System.in.read();
	}

	public static class DummyRoutesBuild extends RouteBuilder {

		@Override
		public void configure() throws Exception {

			from("timer:mytimer?period=2000").process(new Processor() {

				public void process(Exchange exc) throws Exception {
					System.out.println("we get called");
					// TODO Auto-generated method stub
					exc.getOut().setBody(
							"Hello, Now it is " + new Date().toString());
				}
			}).to("log://com.androidyou.DummyRoutesBuilder");
		}

	}

}
