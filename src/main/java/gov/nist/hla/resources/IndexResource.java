package gov.nist.hla.resources;

import java.util.Map;
import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import c2w.hla.FederateObject;
import c2w.hla.FederationManager;

@Path("fedmgr")
public class IndexResource {

	private static Logger log = LoggerFactory.getLogger(IndexResource.class);

	private FederationManager fedmgr;

	public IndexResource(Map<String, String> federation) {
		try {
			log.debug("FOM_file_name=" + federation.get("FOM_file_name"));
			log.debug("federationEndTime=" + federation.get("federationEndTime"));
			fedmgr = new FederationManager(federation.get("federation_name"), 
					federation.get("FOM_file_name"),
					federation.get("script_file_name"), 
					federation.get("dbName"), 
					federation.get("logLevel"),
					new Boolean(federation.get("mode")), 
					federation.get("lockFilename"),
					new Double(federation.get("step")), 
					new Double(federation.get("lookahead")),
					new Boolean(federation.get("_terminateOnCOAFinish")),
					new Double(federation.get("_federationEndTime")), 
					new Long(federation.get("seed4Dur")),
					new Boolean(federation.get("autoStart")),
					new Boolean(federation.get("gui")));
		} catch (NumberFormatException e) {
			log.error("", e);
		} catch (Exception e) {
			log.error("", e);
		}
	}

	// We have this to determine if anything is even working.
	// A response of healty indicates minimal functionality.
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public String health() {
		log.info("healthy==>");
		log.info("fedmgr=" + fedmgr);
		return "healthy";

	}

	@GET
	@Path("/id")
	@Produces({ MediaType.APPLICATION_JSON })
	public String getFederationId() {
		log.debug("fedmgr=" + fedmgr);
		return fedmgr.getFederationId();
	}

	@GET
	@Path("/discovered")
	@Produces({ MediaType.APPLICATION_JSON })
	public Map<Integer, String> getDiscoveredFederates() {
		return fedmgr.get_discoveredFederates();
	}

	@GET
	@Path("/expected")
	@Produces({ MediaType.APPLICATION_JSON })
	public Set<String> getExpectedFederates() {
		return fedmgr.get_expectedFederates();
	}

	@GET
	@Path("/incomplete")
	@Produces({ MediaType.APPLICATION_JSON })
	public Set<FederateObject> getIncompleteFederates() {
		return fedmgr.get_incompleteFederates();
	}

	@GET
	@Path("/start")
	@Produces({ MediaType.APPLICATION_JSON })
	public String startSimulation() {
		return fedmgr.startSimulation();
	}

	@GET
	@Path("/pause")
	@Produces({ MediaType.APPLICATION_JSON })
	public String pauseSimulation() {
		return fedmgr.pauseSimulation();
	}

	@GET
	@Path("/resume")
	@Produces({ MediaType.APPLICATION_JSON })
	public String resumeSimulation() {
		return fedmgr.resumeSimulation();
	}

	@GET
	@Path("/terminate")
	@Produces({ MediaType.APPLICATION_JSON })
	public String terminateSimulation() {
		return fedmgr.terminateSimulation();
	}

	@GET
	@Path("/updateloglevel/{level}")
	public void updateLogLevel(@PathParam("level") int level) {
		fedmgr.updateLogLevel(level);
	}}
