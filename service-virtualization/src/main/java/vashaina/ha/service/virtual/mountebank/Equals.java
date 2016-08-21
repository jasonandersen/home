
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
        "path",
        "method",
        "body",
        "caseSensitive",
        "except",
        "json",
        "xpath"
})
public class Equals {

    @JsonProperty("path")
    private String path;
    @JsonProperty("method")
    private String method;
    @JsonProperty("body")
    private String body;
    @JsonProperty("caseSensitive")
    private Boolean caseSensitive;
    @JsonProperty("except")
    private String except;
    @JsonProperty("json")
    private Json json;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("path")
    public String getPath() {
        return path;
    }

    @JsonProperty("path")
    public void setPath(String path) {
        this.path = path;
    }

    @JsonProperty("method")
    public String getMethod() {
        return method;
    }

    @JsonProperty("method")
    public void setMethod(String method) {
        this.method = method;
    }

    @JsonProperty("body")
    public String getBody() {
        return body;
    }

    @JsonProperty("body")
    public void setBody(String body) {
        this.body = body;
    }

    @JsonProperty("caseSensitive")
    public Boolean getCaseSensitive() {
        return caseSensitive;
    }

    @JsonProperty("caseSensitive")
    public void setCaseSensitive(Boolean caseSensitive) {
        this.caseSensitive = caseSensitive;
    }

    @JsonProperty("except")
    public String getExcept() {
        return except;
    }

    @JsonProperty("except")
    public void setExcept(String except) {
        this.except = except;
    }

    @JsonProperty("json")
    public Json getJson() {
        return json;
    }

    @JsonProperty("json")
    public void setJson(Json json) {
        this.json = json;
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
