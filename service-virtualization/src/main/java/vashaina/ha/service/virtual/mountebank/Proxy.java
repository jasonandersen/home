
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
        "to",
        "mode",
        "key",
        "cert",
        "predicateGenerators"
})
public class Proxy {

    @JsonProperty("to")
    private String to;
    @JsonProperty("mode")
    private String mode;
    @JsonProperty("key")
    private String key;
    @JsonProperty("cert")
    private String cert;
    @JsonProperty("predicateGenerators")
    private List<PredicateGenerator> predicateGenerators = new ArrayList<PredicateGenerator>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("to")
    public String getTo() {
        return to;
    }

    @JsonProperty("to")
    public void setTo(String to) {
        this.to = to;
    }

    @JsonProperty("mode")
    public String getMode() {
        return mode;
    }

    @JsonProperty("mode")
    public void setMode(String mode) {
        this.mode = mode;
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

    @JsonProperty("predicateGenerators")
    public List<PredicateGenerator> getPredicateGenerators() {
        return predicateGenerators;
    }

    @JsonProperty("predicateGenerators")
    public void setPredicateGenerators(List<PredicateGenerator> predicateGenerators) {
        this.predicateGenerators = predicateGenerators;
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
