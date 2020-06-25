import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BubbleSortDLL {

    public static boolean sorted(DLL<Integer> lista) {
        DLLNode<Integer> pok = lista.getFirst();
        while (pok.succ != null) {
            if (pok.element > pok.succ.element) {
                return false;
            }
            pok = pok.succ;
        }
        return true;
    }

    public static void bubbleSort(DLL<Integer> lista) {
        DLLNode<Integer> pok = lista.getFirst();
        DLLNode<Integer> proveruvac = lista.getFirst();

        while (!sorted(lista)) {
            while (pok.succ != null) {
                if (pok.element > pok.succ.element) {
                    int tmp = pok.element;
                    pok.element = pok.succ.element;
                    pok.succ.element = tmp;
                }
                pok = pok.succ;
            }
            pok = lista.getFirst();
        }
        System.out.println(lista);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String s = stdin.readLine();
        int N = Integer.parseInt(s);
        s = stdin.readLine();
        String[] pomniza = s.split(" ");
        DLL<Integer> lista = new DLL<Integer>();
        for (int i = 0; i < N; i++) {
            lista.insertLast(Integer.parseInt(pomniza[i]));
        }
        //sorted(lista.getFirst());
        bubbleSort(lista);
    }
}