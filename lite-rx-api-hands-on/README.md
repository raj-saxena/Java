# [Lite Rx API Hands-on](https://github.com/reactor/lite-rx-api-hands-on)

This Hands-on is designed to help you to learn easily the lite Rx API provided by [Reactor Core 3.x](https://github.com/reactor/reactor-core/).

You will mostly need these 3 classes Javadoc:

 - [Flux](http://projectreactor.io/docs/core/release/api/reactor/core/publisher/Flux.html)
 - [Mono](http://projectreactor.io/docs/core/release/api/reactor/core/publisher/Mono.html)
 - [StepVerifier](http://projectreactor.io/docs/test/release/api/reactor/test/StepVerifier.html)
 
To do this Hands-on, you just have to:

 - Have [Java 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) and a Java IDE ([IntelliJ IDEA](https://www.jetbrains.com/idea/) for example) installed with Maven support
 - Clone this repository (or your fork)
 - Import the project as a Maven one in your IDE
 - Make sure that the language level is set to Java 8 in your IDE project settings
 - Fix the TODO one by one in Part01 to Part11 main classes in `io.pivotal.literx` package
   to make unit tests green (you can have a look at the unit tests too if you want)

The solution is available in the `complete` branch to compare, when you have finished, with what you have done.

A Kotlin version that takes advantage of [reactor-kotlin-extensions](https://github.com/reactor/reactor-kotlin-extensions) is available [here](https://github.com/eddumelendez/reactor-kotlin-workshop).

More information available on [Reactor website](http://projectreactor.io).

___
### Notes
* Understanding reactive - https://spring.io/blog/2016/06/13/notes-on-reactive-programming-part-ii-writing-some-code
    - Generators/ Publisher/ Flux/ Observables
    - Consumers/ Subscribers/ 
    - you can configure the subscriptions to be handled in a background thread using `Flux.subscribeOn():`  

* [Reactor](http://projectreactor.io) has
    - Flux 
    - Mono
* Java 9 has [Flow](http://docs.oracle.com/javase/9/docs/api/index.html?java/util/concurrent/Flow.html) that works with
    - Flow.Processor<T, R> 
    - Flow.Publisher<T> 
    - Flow.Subscriber<T> 
    - Flow.Subscription
* Similarly, [RxJava](https://github.com/ReactiveX/RxJava) has
    - Observable
    - Single
    - Flowable 

