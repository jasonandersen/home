package vashaina.ha.service.virtual;

/**
 * Reqests the creation of a service double.
 */
public class ServiceDoubleRequest {

    private final int port;
    private final String path;
    private final String method;
    private final int responseStatus;
    private final String responseBody;

    /**
     * 
     * @param port
     * @param path
     * @param method
     * @param responseStatus
     * @param responseBody
     */
    public ServiceDoubleRequest(int port, String path, String method, int responseStatus, String responseBody) {
        this.port = port;
        this.path = path;
        this.method = method;
        this.responseBody = responseBody;
        this.responseStatus = responseStatus;
    }

    public int getPort() {
        return port;
    }

    public String getPath() {
        return path;
    }

    public String getMethod() {
        return method;
    }

    public int getResponseStatus() {
        return responseStatus;
    }

    public String getResponseBody() {
        return responseBody;
    }

}
