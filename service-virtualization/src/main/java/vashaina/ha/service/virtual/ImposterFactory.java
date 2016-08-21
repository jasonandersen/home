package vashaina.ha.service.virtual;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import vashaina.ha.service.virtual.mountebank.Equals;
import vashaina.ha.service.virtual.mountebank.Imposter;
import vashaina.ha.service.virtual.mountebank.Is;
import vashaina.ha.service.virtual.mountebank.Predicate;
import vashaina.ha.service.virtual.mountebank.Response;
import vashaina.ha.service.virtual.mountebank.Stub;

/**
 * Builds {@link Imposter}s from {@link ServiceDoubleRequest}s.
 */
@Service
public class ImposterFactory {

    private static Logger log = LoggerFactory.getLogger(ImposterFactory.class);

    private static final String DEFAULT_PROTOCOL = "http";

    /**
     * 
     * @param port
     * @param path
     * @param method
     * @param responseStatus
     * @param responseBody
     * @return 
     */
    protected Imposter buildImposter(ServiceDoubleRequest request) {
        log.debug("building imposter from request {}", request.toString());

        Imposter imposter = new Imposter();
        imposter.setPort(request.getPort());
        imposter.setProtocol(DEFAULT_PROTOCOL);

        //stubs
        List<Stub> stubs = new ArrayList<>();
        Stub firstStub = new Stub();
        stubs.add(firstStub);
        imposter.setStubs(stubs);

        //responses
        List<Response> responses = new ArrayList<>();
        Response firstResponse = new Response();
        responses.add(firstResponse);
        firstStub.setResponses(responses);

        //is
        Is is = new Is();
        is.setStatusCode(request.getResponseStatus());
        is.setBody(request.getResponseBody());
        firstResponse.setIs(is);

        //predicates
        List<Predicate> predicates = new ArrayList<>();
        Predicate firstPredicate = new Predicate();
        predicates.add(firstPredicate);
        firstStub.setPredicates(predicates);

        //equals
        Equals equals = new Equals();
        equals.setMethod(request.getMethod());
        equals.setPath(request.getPath());
        firstPredicate.setEquals(equals);

        return imposter;
    }

}
