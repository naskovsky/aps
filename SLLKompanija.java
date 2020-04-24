import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class SLLNode {
    protected int id;
    protected int plata;
    protected SLLNode succ;

    public SLLNode(int id, int plata, SLLNode succ) {
        this.id = id;
        this.plata = plata;
        this.succ = succ;
    }


}

class SLL {
    private SLLNode first;

    public SLL() {
        // Construct an empty SLL
        this.first = null;
    }

    public void deleteList() {
        first = null;
    }

    public int length() {
        int ret;
        if (first != null) {
            SLLNode tmp = first;
            ret = 1;
            while (tmp.succ != null) {
                tmp = tmp.succ;
                ret++;
            }
            return ret;
        } else
            return 0;

    }


    public void insertFirst(int id, int plata) {
        SLLNode ins = new SLLNode(id, plata, first);
        first = ins;
    }

    public void insertLast(int id, int plata) {
        if (first != null) {
            SLLNode tmp = first;
            while (tmp.succ != null)
                tmp = tmp.succ;
            SLLNode ins = new SLLNode(id, plata, null);
            tmp.succ = ins;
        } else {
            insertFirst(id, plata);
        }
    }

    public SLLNode getFirst() {
        return first;
    }

    public void deleteNode(SLLNode p) {
        SLLNode p1 = this.first;
        if (p1 == p) {
            this.first = p1.succ;
            return;
        }
        SLLNode pred = new SLLNode(0, 0, null);
        while (p1 != null) {
            if (p1 == p) {
                pred.succ = p1.succ;
            }
            pred = p1;
            p1 = p1.succ;
        }
    }

    public SLL brisi_pomali_od(int iznos) {
        SLLNode p = this.first;
        while (p != null) {
            if (p.plata < iznos) {
                SLLNode p1 = p.succ;
                this.deleteNode(p);
                p = p1;
            } else {
                p = p.succ;
            }
        }
        return this;
    }

    public boolean is_max(SLLNode p) {
        if (p == null)
            return true;
        SLLNode max = p;                                    // Postavi max da e p
        for (SLLNode t = p; t.succ != null; t = t.succ)
            if (max.id < t.succ.id)                         // Sporeduvaj go samo "max" so site ostanati
                return false;
        return true;
    }

    public SLL sortiraj_opagacki(SLL lista) {
        int dolzina = lista.length();
        SLL lista1 = new SLL();
        SLLNode current = null;

        while (lista1.length() != dolzina) {
            current = lista.getFirst();
            while (current != null) {
                if (is_max(current)) {
                    lista1.insertLast(current.id, current.plata);   // Max elementot stavi go vo nova lista
                    deleteNode(current);                            // Istiot posle izbrishi go od originalnata lista
                    break;                                          // Prekini go procesot
                }
                current = current.succ;
            }
        }

        return lista1;
    }

    public void pecati(SLL lista) {
        SLLNode p = lista.first;
        while (p != null) {
            System.out.println(p.id + " " + p.plata);
            p = p.succ;
        }
    }

}

public class SLLKompanija {
    public static void main(String[] args) throws IOException {

        SLL lista1 = new SLL();
        BufferedReader stdin = new BufferedReader(new InputStreamReader(
                System.in));
        String s = stdin.readLine();
        int N = Integer.parseInt(s);

        for (int i = 0; i < N; i++) {
            s = stdin.readLine();
            String s1 = stdin.readLine();
            lista1.insertLast(Integer.parseInt(s), Integer.parseInt(s1));
        }
        s = stdin.readLine();

        lista1 = lista1.brisi_pomali_od(Integer.parseInt(s));
        if (lista1.length() == 0) {
            System.out.println("nema");
        } else {
            if (lista1 != null) {
                lista1 = lista1.sortiraj_opagacki(lista1);
                lista1.pecati(lista1);
            }
        }
    }
}
