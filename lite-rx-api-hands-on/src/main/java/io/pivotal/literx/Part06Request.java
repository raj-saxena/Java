package io.pivotal.literx;

import io.pivotal.literx.domain.User;
import io.pivotal.literx.repository.ReactiveRepository;
import io.pivotal.literx.repository.ReactiveUserRepository;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import static io.pivotal.literx.domain.User.JESSE;
import static io.pivotal.literx.domain.User.SKYLER;
import static reactor.test.StepVerifier.create;

/**
 * Learn how to control the demand.
 *
 * @author Sebastien Deleuze
 */
class Part06Request {

	ReactiveRepository<User> repository = new ReactiveUserRepository();

//========================================================================================

	// Create a StepVerifier that initially requests all values and expect 4 values to be received
	StepVerifier requestAllExpectFour(Flux<User> flux) {
		return create(flux).thenRequest(Long.MAX_VALUE).expectNextCount(4).expectComplete();
	}

//========================================================================================

	// Create a StepVerifier that initially requests 1 value and expects User.SKYLER then requests another value and expects User.JESSE.
	StepVerifier requestOneExpectSkylerThenRequestOneExpectJesse(Flux<User> flux) {
		return create(flux)
				.thenRequest(1L).expectNext(SKYLER)
				.thenRequest(1L).expectNext(JESSE)
				.thenCancel();
	}

//========================================================================================

	// Return a Flux with all users stored in the repository that prints automatically logs for all Reactive Streams signals
	Flux<User> fluxWithLog() {
		return repository.findAll().log();
	}

//========================================================================================

	// Return a Flux with all users stored in the repository that prints "Starring:" on subscribe, "firstname lastname" for all values and "The end!" on complete
	Flux<User> fluxWithDoOnPrintln() {
		return repository.findAll()
				.doOnSubscribe(s -> System.out.println("Starring"))
				.doOnNext(u -> System.out.println(u.getFirstname() + " " + u.getLastname()))
				.doOnComplete(() -> System.out.println("The end!"));
	}
}
