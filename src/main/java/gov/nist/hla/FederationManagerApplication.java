package gov.nist.hla;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import gov.nist.hla.resources.IndexResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class FederationManagerApplication extends Application<FederationManagerConfig> {

	private static Logger log = LoggerFactory.getLogger(FederationManagerApplication.class);

	@Override
	public void initialize(Bootstrap<FederationManagerConfig> bootstrap) {
		log.trace("initialize==>");
	}

	@Override
	public void run(FederationManagerConfig configuration, Environment environment) throws Exception {
		log.trace("run==>");

		environment.jersey().register(new IndexResource(configuration.getFederation()));
	}
	
    public static void main(String[] args) throws Exception {
        new FederationManagerApplication().run(args);
    }
}
