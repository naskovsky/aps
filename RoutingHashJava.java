package finki.starter.com.lectures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RoutingHashJava {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		CBHT<String, String> koficka = new CBHT<String, String>(N);

		for (int i = 0; i < N; i++) {
			String prva = br.readLine();
			String vtora = br.readLine();
			koficka.insert(prva, vtora);
		}

		//System.out.println(koficka);
		
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			String interfejs = br.readLine(); //interface
			String[] ip = br.readLine().split("\\."); //ip
			//System.out.println(interfejs);
			//System.out.println(ip);
			SLLNode<MapEntry<String, String>> me = koficka.search(interfejs);
			//System.out.println(me);
			//System.out.println();
			if(me != null) {
				String interf = me.element.key;
				String[] ip_adresi = me.element.value.split("\\,");
				//System.out.println(interf);
				int br_pati = 0;
				for(int x =0;x<ip_adresi.length;x++) {
					//System.out.println(ip_adresi[x]);
					String[] delcinja_ip = ip_adresi[x].split("\\.");
					if(ip[0].equals(delcinja_ip[0]) && ip[1].equals(delcinja_ip[1]) && ip[2].equals(delcinja_ip[2])) {
						System.out.println("postoi");
						br_pati++;
						break;
					}
				}
				if(br_pati < 1) {
					System.out.println("ne postoi");
				}
			}else {
				System.out.println("ne postoi");
			}
		}
		br.close();
	}
}
