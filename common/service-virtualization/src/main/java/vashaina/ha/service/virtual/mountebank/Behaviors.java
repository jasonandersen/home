
package vashaina.ha.service.virtual.mountebank;

import java.util.HashMap;
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
        "wait",
        "decorate"
})
public class Behaviors {

    @JsonProperty("wait")
    private Integer wait;
    @JsonProperty("decorate")
    private String decorate;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Integer getWait() {
        return wait;
    }

    @JsonProperty("wait")
    public void setWait(Integer wait) {
        this.wait = wait;
    }

    @JsonProperty("decorate")
    public String getDecorate() {
        return decorate;
    }

    @JsonProperty("decorate")
    public void setDecorate(String decorate) {
        this.decorate = decorate;
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
