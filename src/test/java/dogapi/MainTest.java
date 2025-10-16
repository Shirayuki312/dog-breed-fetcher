package dogapi;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void getNumberOfSubBreedsValidBreed() {
        BreedFetcherForLocalTesting mock = new BreedFetcherForLocalTesting();

        assertEquals(2, Main.getNumberOfSubBreeds("hound", mock));
    }

    @Test
    void getNumberOfSubBreedsInvalidBreed() {
        BreedFetcherForLocalTesting mock = new BreedFetcherForLocalTesting();

        assertEquals(0, Main.getNumberOfSubBreeds("cat", mock));
    }

    @Test
    void exceptionTypeTest() {
        BreedFetcher.BreedNotFoundException bfe = new BreedFetcher.BreedNotFoundException("hound");

        // 1️⃣ must be a subclass of Exception
        assertTrue(bfe instanceof Exception, "BreedFetcher.BreedNotFoundException must extend Exception.");

        // 2️⃣ must NOT be a subclass of RuntimeException
        boolean isRuntime = RuntimeException.class.isAssignableFrom(bfe.getClass());
        assertTrue(!isRuntime, "BreedFetcher.BreedNotFoundException must NOT extend RuntimeException.");
    }

}