package io.pivotal.literx;

import reactor.core.publisher.Flux;

import static java.time.Duration.ofMillis;
import static java.util.Arrays.asList;
import static reactor.core.publisher.Flux.*;

/**
 * Learn how to create Flux instances.
 *
 * @author Sebastien Deleuze
 * @see <a href="http://projectreactor.io/docs/core/release/api/reactor/core/publisher/Flux.html">Flux Javadoc</a>
 */
class Part01Flux {

//========================================================================================

	Flux<String> emptyFlux() {
		return empty();
	}

//========================================================================================

	Flux<String> fooBarFluxFromValues() {
		return just("foo", "bar");
	}

//========================================================================================

	Flux<String> fooBarFluxFromList() {
		return fromIterable(asList("foo", "bar"));
	}

//========================================================================================

	Flux<String> errorFlux() {
		return Flux.error(new IllegalStateException());
	}

//========================================================================================

		// TODO Create a Flux that emits increasing values from 0 to 9 each 100ms
	Flux<Long> counter() {
		return Flux.interval(ofMillis(100)).take(10);
	}

}
