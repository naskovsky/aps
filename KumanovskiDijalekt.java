

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class KumanovskiDijalekt {

    public static String prvaGolemaBukva(String s){
        String str = s;
        String output = str.substring(0, 1).toUpperCase() + str.substring(1);
        return output;
    }

    public static void main(String[] args) throws IOException {
        HashMap<String, String> hashmapa = new HashMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String rechnik[] = new String[N];
        for (int i = 0; i < N; i++) {
            rechnik[i] = br.readLine();
        }

        //System.out.println();

        for (int i = 0; i < N; i++) {
            String[] pom = rechnik[i].split(" ");
            hashmapa.put(pom[0], pom[1]);

            //System.out.println(pom[0] + " " + pom[1]);
        }


        String tekst = br.readLine();
        String[] tekstSreden = tekst.split(" ");
        String[] tekstPomosen = tekst.split(" ");

        for (Map.Entry<String, String> hm : hashmapa.entrySet()) {
            String literaturenZbor = hm.getValue();
            for (int i = 0; i < tekstSreden.length; i++) {
                if(hm.getKey().equalsIgnoreCase(tekstSreden[i].replaceAll("\\p{Punct}", ""))){
                    tekstSreden[i] = literaturenZbor;
                }
                /*if (hm.getKey().equalsIgnoreCase(tekstSreden[i].replaceAll("\\p{Punct}", ""))) {
                    tekstSreden[i] = literaturenZbor;
                }*/
            }
        }
        //Vasiot kod tuka

        for (int i = 0; i < tekstSreden.length; i++) {
            if (i == tekstSreden.length - 1)
                System.out.print(tekstSreden[i]);
            else if(i==0){
                System.out.print(prvaGolemaBukva(tekstSreden[i]) + " ");
            }
            else if(tekstSreden[i-1].contains(".")){
                System.out.print(prvaGolemaBukva(tekstSreden[i]) + " ");
            }
            else if(tekstPomosen[i].contains(",")){
                System.out.print(tekstSreden[i]+", ");
            }
            else
                System.out.print(tekstSreden[i] + " ");
        }

    }
}
