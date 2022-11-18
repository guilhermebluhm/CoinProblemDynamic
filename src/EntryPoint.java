public class EntryPoint {

    public static void main(String[] args) {

        int v[] = {1,2,5};
        coinProblem(v,3,2);

    }

    static final int maxLengthMinCoin = 100000;

    static void coinProblem(int m[], int t, int k){

        int cache[] = new int[t+1];
        int cedulas[] = new int[t+1];

        for(int i = 1 ; i <= t ; i+=1){

            cache[i] = -1;
            cedulas[i] = -1;

        }

        for(int i = 1 ; i <= t ; i+=1){

            int minMoeda = maxLengthMinCoin;
            int minCedula = 0;

            for(int j = 0 ; j <= k ; j+=1){

                if(i >= m[j]) {

                    if (1 + cache[i - m[j]] < minMoeda) {

                        minMoeda = 1 + cache[i - m[j]];
                        minCedula = j;

                    }
                }
            }

            cache[i] = minMoeda;
            cedulas[i] = minCedula;

        }
        int contagemCedulas = t;
        while(contagemCedulas > 0){

            System.out.println(m[cedulas[contagemCedulas]]);
            contagemCedulas -= m[cedulas[contagemCedulas]];

        }

        System.out.println("numero minimo de moedas para troco: " + cache[t]);
    }

}
