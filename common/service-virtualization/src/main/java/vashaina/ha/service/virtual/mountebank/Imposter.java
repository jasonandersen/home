
package vashaina.ha.service.virtual.mountebank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "port",
        "protocol",
        "name",
        "key",
        "cert",
        "mutualAuth",
        "stubs",
        "endOfRequestResolver",
        "requests",
        "_links"
})
public class Imposter {

    @JsonProperty("port")
    private Integer port;
    @JsonProperty("protocol")
    private String protocol;
    @JsonProperty("name")
    private String name;
    @JsonProperty("key")
    private String key;
    @JsonProperty("cert")
    private String cert;
    @JsonProperty("mutualAuth")
    private Boolean mutualAuth;
    @JsonProperty("stubs")
    private List<Stub> stubs = new ArrayList<Stub>();
    @JsonProperty("endOfRequestResolver")
    private EndOfRequestResolver endOfRequestResolver;
    @JsonProperty("requests")
    private List<Request_> requests = new ArrayList<Request_>();
    @JsonProperty("_links")
    private Links links;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("port")
    public int getPort() {
        return port;
    }

    @JsonProperty("port")
    public void setPort(Integer port) {
        this.port = port;
    }

    @JsonProperty("protocol")
    public String getProtocol() {
        return protocol;
    }

    @JsonProperty("protocol")
    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("key")
    public String getKey() {
        return key;
    }

    @JsonProperty("key")
    public void setKey(String key) {
        this.key = key;
    }

    @JsonProperty("cert")
    public String getCert() {
        return cert;
    }

    @JsonProperty("cert")
    public void setCert(String cert) {
        this.cert = cert;
    }

    @JsonProperty("mutualAuth")
    public Boolean getMutualAuth() {
        return mutualAuth;
    }

    @JsonProperty("mutualAuth")
    public void setMutualAuth(Boolean mutualAuth) {
        this.mutualAuth = mutualAuth;
    }

    @JsonProperty("stubs")
    public List<Stub> getStubs() {
        return stubs;
    }

    @JsonProperty("stubs")
    public void setStubs(List<Stub> stubs) {
        this.stubs = stubs;
    }

    @JsonProperty("endOfRequestResolver")
    public EndOfRequestResolver getEndOfRequestResolver() {
        return endOfRequestResolver;
    }

    @JsonProperty("endOfRequestResolver")
    public void setEndOfRequestResolver(EndOfRequestResolver endOfRequestResolver) {
        this.endOfRequestResolver = endOfRequestResolver;
    }

    @JsonProperty("requests")
    public List<Request_> getRequests() {
        return requests;
    }

    @JsonProperty("requests")
    public void setRequests(List<Request_> requests) {
        this.requests = requests;
    }

    @JsonProperty("_links")
    public Links getLinks() {
        return links;
    }

    @JsonProperty("_links")
    public void setLinks(Links links) {
        this.links = links;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
