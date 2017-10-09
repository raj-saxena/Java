import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.util.function.Consumer;

public class ReactiveTest {

    private static org.slf4j.Logger logger = LoggerFactory.getLogger(ReactiveTest.class);

    public static void main(String[] args) throws InterruptedException {
        new ReactiveTest().doReactiveStuff();
    }

    private void doReactiveStuff() throws InterruptedException {
        Flux<String> flux = Flux.just("red", "white", "blue", "black", "green", "yellow", "white");

        Flux<String> source = flux
                .log()
                .map(String::toUpperCase)
                .subscribeOn(Schedulers.newParallel("sub--"))
                .publishOn(Schedulers.newParallel("++PUB"))
                ;

        source.subscribe(doSomethingWithData());
        Thread.sleep(2000);

    }

    private Consumer<String> doSomethingWithData() {
        return value -> logger.info("Consumed: " + value);
    }
}
