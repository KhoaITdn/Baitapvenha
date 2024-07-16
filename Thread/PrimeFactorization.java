package Thread;

public class PrimeFactorization {
    public static void main(String[] args) {
        Thread lazyThread = new Thread(new LazyPrimeFactorization());
        Thread optimizedThread = new Thread(new OptimizedPrimeFactorization());

        lazyThread.start();
        optimizedThread.start();
    }
}

class LazyPrimeFactorization implements Runnable {
    @Override
    public void run() {
        long number = 2;
        while (true) {
            if (isPrime(number)) {
                System.out.println("LazyPrimeFactorization found prime: " + number);
            }
            number++;
        }
    }

    private boolean isPrime(long num) {
        if (num < 2) return false;
        for (long i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}

class OptimizedPrimeFactorization implements Runnable {
    @Override
    public void run() {
        long number = 2;
        while (true) {
            if (isPrime(number)) {
                System.out.println("OptimizedPrimeFactorization found prime: " + number);
            }
            number++;
        }
    }

    private boolean isPrime(long num) {
        if (num < 2) return false;
        for (long i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
