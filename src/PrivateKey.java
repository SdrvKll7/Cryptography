public class PrivateKey extends Solution {

    public long PrimeDelP(long p, long q){
        long z =3;
        while(p>0 && z<p-1){
            if(isPrime(z)){
                if(Mod((p-1),z)==0 && Mod(q-1,z)!=0) {
                        return z;
                }
                else z+=2;

            } else z+=2;
            //System.out.println(z);
        }

        return 0;
    }
    public long PrimeDelQ(long p, long q){
        long z =3;

        while(q>0 && z<q-1){
            if(isPrime(z)){
                if(Mod((q-1),z)==0 && Mod(p-1,z)!=0) {
                        return z;
                }
                else z+=2;

            } else z+=2;
        }

        return 0;
    }
    public long priveKey(long a ,long b){
        return a*b;
    }
    public boolean Eqvivalention(long e, long N, long gam){
        return Mod(e, N)==gam;
    }


}
