package io.pivotal.literx;

import reactor.core.publisher.Mono;

import static reactor.core.publisher.Mono.*;

/**
 * Learn how to create Mono instances.
 *
 * @author Sebastien Deleuze
 * @see <a href="http://projectreactor.io/docs/core/release/api/reactor/core/publisher/Mono.html">Mono Javadoc</a>
 */
class Part02Mono {

//========================================================================================

	Mono<String> emptyMono() {
		return empty();
	}

//========================================================================================

	Mono<String> monoWithNoSignal() {
		return never();
	}

//========================================================================================

	Mono<String> fooMono() {
		return just("foo");
	}

//========================================================================================

	Mono<String> errorMono() {
		return error(new IllegalStateException());
	}

}
