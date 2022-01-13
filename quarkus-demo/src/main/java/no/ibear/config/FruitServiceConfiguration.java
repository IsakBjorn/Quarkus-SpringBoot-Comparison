package no.ibear.config;

import io.quarkus.arc.DefaultBean;
import io.quarkus.arc.profile.IfBuildProfile;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import no.ibear.services.ExternalFruitService;
import no.ibear.services.FruitService;
import no.ibear.services.MockFruitService;

@Dependent
public class FruitServiceConfiguration {

//    @Produces
//    @IfBuildProfile("prod")
//    public FruitService realTracer() {
//        return new ExternalFruitService();
//    }
//
//    @Produces
//    @DefaultBean
//    public FruitService Mock() {
//        return new MockFruitService();
//    }
}
