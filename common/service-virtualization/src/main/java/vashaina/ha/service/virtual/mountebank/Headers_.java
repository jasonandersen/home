
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
        "accept",
        "host",
        "content-type",
        "connection",
        "transfer-encoding"
})
public class Headers_ {

    @JsonProperty("accept")
    private String accept;
    @JsonProperty("host")
    private String host;
    @JsonProperty("content-type")
    private String contentType;
    @JsonProperty("connection")
    private String connection;
    @JsonProperty("transfer-encoding")
    private String transferEncoding;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getAccept() {
        return accept;
    }

    @JsonProperty("accept")
    public void setAccept(String accept) {
        this.accept = accept;
    }

    @JsonProperty("host")
    public String getHost() {
        return host;
    }

    @JsonProperty("host")
    public void setHost(String host) {
        this.host = host;
    }

    @JsonProperty("content-type")
    public String getContentType() {
        return contentType;
    }

    @JsonProperty("content-type")
    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    @JsonProperty("connection")
    public String getConnection() {
        return connection;
    }

    @JsonProperty("connection")
    public void setConnection(String connection) {
        this.connection = connection;
    }

    /**
     * 
     * @return
     *     The transferEncoding
     */
    @JsonProperty("transfer-encoding")
    public String getTransferEncoding() {
        return transferEncoding;
    }

    /**
     * 
     * @param transferEncoding
     *     The transfer-encoding
     */
    @JsonProperty("transfer-encoding")
    public void setTransferEncoding(String transferEncoding) {
        this.transferEncoding = transferEncoding;
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
