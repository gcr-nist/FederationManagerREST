package gov.nist.hla;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.dropwizard.Configuration;

public class FederationManagerConfig extends Configuration {

	private Map<String, String> federation;

	public Map<String, String> getFederation() {
		return federation;
	}

	@JsonProperty("federation")
	public void setFederation(Map<String, String> federation) {
		this.federation = federation;
	}
}
