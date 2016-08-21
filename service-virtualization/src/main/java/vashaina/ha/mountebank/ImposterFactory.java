package vashaina.ha.mountebank;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import vashaina.ha.mountebank.domain.Equals;
import vashaina.ha.mountebank.domain.Imposter;
import vashaina.ha.mountebank.domain.Is;
import vashaina.ha.mountebank.domain.Predicate;
import vashaina.ha.mountebank.domain.Response;
import vashaina.ha.mountebank.domain.Stub;

/**
 * Builds {@link Imposter}s from {@link ServiceDoubleRequest}s.
 */
@Service
public class ImposterFactory {

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
    protected Imposter buildImposter(int port, String path, String method, int responseStatus, String responseBody) {
        Imposter imposter = new Imposter();
        imposter.setPort(port);
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
        is.setStatusCode(responseStatus);
        is.setBody(responseBody);
        firstResponse.setIs(is);

        //predicates
        List<Predicate> predicates = new ArrayList<>();
        Predicate firstPredicate = new Predicate();
        predicates.add(firstPredicate);
        firstStub.setPredicates(predicates);

        //equals
        Equals equals = new Equals();
        equals.setMethod(method);
        equals.setPath(path);
        firstPredicate.setEquals(equals);

        return imposter;
    }

}
