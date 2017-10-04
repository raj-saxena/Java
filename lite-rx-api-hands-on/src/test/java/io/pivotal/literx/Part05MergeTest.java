package io.pivotal.literx;

import io.pivotal.literx.domain.User;
import io.pivotal.literx.repository.ReactiveRepository;
import io.pivotal.literx.repository.ReactiveUserRepository;
import org.junit.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static io.pivotal.literx.domain.User.*;

/**
 * Learn how to merge flux.
 *
 * @author Sebastien Deleuze
 */
public class Part05MergeTest {
    Part05Merge workshop = new Part05Merge();

    private final static User MARIE = new User("mschrader", "Marie", "Schrader");
    private final static User MIKE = new User("mehrmantraut", "Mike", "Ehrmantraut");

    private ReactiveRepository<User> repositoryWithDelay = new ReactiveUserRepository(500);
    private ReactiveRepository<User> repository = new ReactiveUserRepository(MARIE, MIKE);

//========================================================================================

    @Test
    public void mergeWithInterleave() {
        Flux<User> flux = workshop.mergeFluxWithInterleave(repositoryWithDelay.findAll(), repository.findAll());
        StepVerifier.create(flux)
                .expectNext(MARIE, MIKE, SKYLER, JESSE, WALTER, SAUL)
                .verifyComplete();
    }

//========================================================================================

    @Test
    public void mergeWithNoInterleave() {
        Flux<User> flux = workshop.mergeFluxWithNoInterleave(repositoryWithDelay.findAll(), repository.findAll());
        StepVerifier.create(flux)
                .expectNext(SKYLER, JESSE, WALTER, SAUL, MARIE, MIKE)
                .verifyComplete();
    }

//========================================================================================

    @Test
    public void multipleMonoToFlux() {
        Mono<User> skylerMono = repositoryWithDelay.findFirst();
        Mono<User> marieMono = repository.findFirst();
        Flux<User> flux = workshop.createFluxFromMultipleMono(skylerMono, marieMono);
        StepVerifier.create(flux)
                .expectNext(SKYLER, MARIE)
                .verifyComplete();
    }

}
