
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
        "timestamp",
        "requestFrom",
        "method",
        "path",
        "query",
        "headers",
        "body"
})
public class Request_ {

    @JsonProperty("timestamp")
    private String timestamp;
    @JsonProperty("requestFrom")
    private String requestFrom;
    @JsonProperty("method")
    private String method;
    @JsonProperty("path")
    private String path;
    @JsonProperty("query")
    private Query_ query;
    @JsonProperty("headers")
    private Headers___ headers;
    @JsonProperty("body")
    private String body;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("timestamp")
    public String getTimestamp() {
        return timestamp;
    }

    @JsonProperty("timestamp")
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @JsonProperty("requestFrom")
    public String getRequestFrom() {
        return requestFrom;
    }

    @JsonProperty("requestFrom")
    public void setRequestFrom(String requestFrom) {
        this.requestFrom = requestFrom;
    }

    @JsonProperty("method")
    public String getMethod() {
        return method;
    }

    @JsonProperty("method")
    public void setMethod(String method) {
        this.method = method;
    }

    @JsonProperty("path")
    public String getPath() {
        return path;
    }

    @JsonProperty("path")
    public void setPath(String path) {
        this.path = path;
    }

    @JsonProperty("query")
    public Query_ getQuery() {
        return query;
    }

    @JsonProperty("query")
    public void setQuery(Query_ query) {
        this.query = query;
    }

    @JsonProperty("headers")
    public Headers___ getHeaders() {
        return headers;
    }

    @JsonProperty("headers")
    public void setHeaders(Headers___ headers) {
        this.headers = headers;
    }

    @JsonProperty("body")
    public String getBody() {
        return body;
    }

    @JsonProperty("body")
    public void setBody(String body) {
        this.body = body;
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
