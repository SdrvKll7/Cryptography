
import java.util.Random;

public class Solution {
    private long p;
    private long q;

    public long generateLargePrime(long keysize) {
        while (true) {
            Random r = new Random();
            long num = 1 + r.nextInt((int) (((Math.pow(2, keysize) - 1 - Math.pow(2, (keysize - 1))) + 1) + Math.pow(2, (keysize - 1))));
            if (isPrime(num))
                return num;
        }
    }

    public long[] generateKeys(long keysize) {
        keysize = 1024;
        long e = 0, d = 0, N = 0;
        p = generateLargePrime(keysize);
        q = generateLargePrime(keysize);
        System.out.println("p: " + p);
        System.out.println("q: " + q);
        N = p * q;
        long phiN = (p - 1) * (q - 1);
        while (true) {
            e = (long) (Math.pow(2, (keysize - 1)) + (long) (Math.random() * (Math.pow(2, keysize)) - 1));
            if (isCoPrime(e, phiN))
                break;
        }
        d = modularInv(e, phiN);
        long[] a = new long[3];
        a[0] = e;
        a[1] = d;
        a[2] = N;
        return a;
    }

    public boolean isPrime(long n) {
        if (n == 1) return false;
        if (n >= 2) {
            if (Mod(n, 2) == 0) return false;
        }
        long max_divisor = (long) Math.floor(Math.sqrt(n));
        for (long i = 3; i < 1 + max_divisor; i += 2) {
            if (Mod(n, i) == 0) return false;
        }

        return true;
    }

    public long Mod(long a, long b) {
        long sem = a / b;
        long res = a - (sem * b);
        return res;
    }

    public boolean isCoPrime(long p, long q) {
        return (gcd(p, q) == 1);
    }

    public long gcd(long p, long q) {
        while (q > 0) {
            long z = q;
            q = Mod(p, q);
            p = z;
        }
        return p;
    }

    public long[] egcd(long a, long b) {
        long s = 0;
        long olds = 1;
        long t = 1;
        long oldt = 0;
        long r = b;
        long oldr = a;
        long z;
        while (r != 0) {
            long quotient = oldr / r;
            z = r;
            r = oldr - quotient * r;
            oldr = z;
            z = s;
            s = olds - quotient * s;
            olds = z;
            z = t;
            t = oldt - quotient * t;
            oldt = z;
        }
        long[] ar = new long[3];
        ar[0] = oldr;
        ar[1] = olds;
        ar[2] = oldt;
        return ar;
    }

    public long modularInv(long a, long b) {
        long[] ar = egcd(a, b);
        long gcd = ar[0];
        long x = ar[1];
        long y = ar[2];
        if (x < 0)
            x += b;
        return x;

    }

    public long[] get() {
        long[] a = new long[2];
        a[0] = p;
        a[1] = q;
        return a;
    }
}
