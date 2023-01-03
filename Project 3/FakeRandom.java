import java.util.Random;

/**
 * It allows us to prespecify a random number.
 * NOTE -- this only works with the nextInt(int) method
 */
public class FakeRandom extends Random {
    private int random;

    public FakeRandom(int random) {
        this.random = random;
    }

    @Override
    public int nextInt(int bound) {
        System.out.println("nextInt: "+bound);
        return random;
    }
}
