package Primes;

public class Primes {
    public static Boolean isPrime(Integer possiblePrime) throws Exception {
        if (possiblePrime <= 0) {
            throw new Exception("Will not take anything less than one");
        }

        if (possiblePrime == 1 || possiblePrime == 2) {
            return true;
        }

        for (int divisor = 2; divisor < possiblePrime; divisor++) {
            if (possiblePrime % divisor == 0) {
                return false;
            }
        }

        return true;
    }
}
