import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Lozinki {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        CBHT<String,String> tabela=new CBHT<String,String>(N);
        for(int i=0;i<N;i++){
            String[] niza = br.readLine().split(" ");
            tabela.insert(niza[0], niza[1]);
        }
        //System.out.println(tabela.toString());

        String zemi = br.readLine();
        while(!zemi.equals("KRAJ")){
            String[] niza = zemi.split(" ");
            if(tabela.search(niza[0]) != null){
                SLLNode<MapEntry<String, String>> hm = tabela.search(niza[0]);
                if(hm.element.value.equals(niza[1])){
                    System.out.println("Najaven");
                    break;
                }
                else{
                    System.out.println("Nenajaven");
                }
            }
            else
                System.out.println("Nenajaven");
            zemi = br.readLine();
        }
    }
}
