
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
        "is",
        "_behaviors",
        "proxy",
        "inject"
})
public class Response {

    @JsonProperty("is")
    private Is is;
    @JsonProperty("_behaviors")
    private Behaviors behaviors;
    @JsonProperty("proxy")
    private Proxy proxy;
    @JsonProperty("inject")
    private String inject;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("is")
    public Is getIs() {
        return is;
    }

    @JsonProperty("is")
    public void setIs(Is is) {
        this.is = is;
    }

    @JsonProperty("_behaviors")
    public Behaviors getBehaviors() {
        return behaviors;
    }

    @JsonProperty("_behaviors")
    public void setBehaviors(Behaviors behaviors) {
        this.behaviors = behaviors;
    }

    @JsonProperty("proxy")
    public Proxy getProxy() {
        return proxy;
    }

    @JsonProperty("proxy")
    public void setProxy(Proxy proxy) {
        this.proxy = proxy;
    }

    @JsonProperty("inject")
    public String getInject() {
        return inject;
    }

    @JsonProperty("inject")
    public void setInject(String inject) {
        this.inject = inject;
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
