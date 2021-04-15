public class Main {
    public static void main(String[] args){
        Solution s = new Solution();
        long keysize = 54;
        long[] a = s.generateKeys(keysize);
        long e = a[0];
        long d = a[1];
        long N = a[2];
        System.out.println("e: "+e);
        System.out.println("d: "+d);
        System.out.println("N: "+N);
        String msg="eojfghjlerg";
        long[] arr = s.get();
        long p = arr[0];
        long q = arr[1];
        PrivateKey privateKey = new PrivateKey();
        long primeP=privateKey.PrimeDelP(p,q);
        long primeQ = privateKey.PrimeDelQ(p,q);
        System.out.println("prime P: " +primeP);
        System.out.println("prime Q: "+primeQ);
        long privekey = privateKey.priveKey(primeP, primeQ);
        System.out.println(privekey);
        System.out.println(privateKey.Eqvivalention(e,N,privekey));

    }
}
