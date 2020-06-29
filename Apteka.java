import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
class SLLNode<E> {
    protected E element;
    protected SLLNode<E> succ;
 
    public SLLNode(E elem, SLLNode<E> succ) {
        this.element = elem;
        this.succ = succ;
    }
 
    @Override
    public String toString() {
        return element.toString();
    }
}
 
class MapEntry<K extends Comparable<K>,E> implements Comparable<K> {
 
    // Each MapEntry object is a pair consisting of a key (a Comparable
    // object) and a value (an arbitrary object).
    K key;
    E value;
 
    public MapEntry (K key, E val) {
        this.key = key;
        this.value = val;
    }
 
    public int compareTo (K that) {
        // Compare this map entry to that map entry.
        @SuppressWarnings("unchecked")
        MapEntry<K,E> other = (MapEntry<K,E>) that;
        return this.key.compareTo(other.key);
    }
 
    public String toString () {
        return "<" + key + "," + value + ">";
    }
}
 
class CBHT<K extends Comparable<K>, E> {
 
    // An object of class CBHT is a closed-bucket hash table, containing
    // entries of class MapEntry.
    private SLLNode<MapEntry<K,E>>[] buckets;
 
    @SuppressWarnings("unchecked")
    public CBHT(int m) {
        // Construct an empty CBHT with m buckets.
        buckets = (SLLNode<MapEntry<K,E>>[]) new SLLNode[m];
    }
 
    private int hash(K key) {
        // Translate key to an index of the array buckets.
        return Math.abs(key.hashCode()) % buckets.length;
    }
 
    public SLLNode<MapEntry<K,E>> search(K targetKey) {
        // Find which if any node of this CBHT contains an entry whose key is
        // equal
        // to targetKey. Return a link to that node (or null if there is none).
        int b = hash(targetKey);
        for (SLLNode<MapEntry<K,E>> curr = buckets[b]; curr != null; curr = curr.succ) {
            if (targetKey.equals(((MapEntry<K, E>) curr.element).key))
                return curr;
        }
        return null;
    }
 
    public void insert(K key, E val) {      // Insert the entry <key, val> into this CBHT.
        MapEntry<K, E> newEntry = new MapEntry<K, E>(key, val);
        int b = hash(key);
        for (SLLNode<MapEntry<K,E>> curr = buckets[b]; curr != null; curr = curr.succ) {
            if (key.equals(((MapEntry<K, E>) curr.element).key)) {
                // Make newEntry replace the existing entry ...
                curr.element = newEntry;
                return;
            }
        }
        // Insert newEntry at the front of the 1WLL in bucket b ...
        buckets[b] = new SLLNode<MapEntry<K,E>>(newEntry, buckets[b]);
    }
 
    public void delete(K key) {
        // Delete the entry (if any) whose key is equal to key from this CBHT.
        int b = hash(key);
        for (SLLNode<MapEntry<K,E>> pred = null, curr = buckets[b]; curr != null; pred = curr, curr = curr.succ) {
            if (key.equals(((MapEntry<K,E>) curr.element).key)) {
                if (pred == null)
                    buckets[b] = curr.succ;
                else
                    pred.succ = curr.succ;
                return;
            }
        }
    }
 
    public String toString() {
        String temp = "";
        for (int i = 0; i < buckets.length; i++) {
            temp += i + ":";
            for (SLLNode<MapEntry<K,E>> curr = buckets[i]; curr != null; curr = curr.succ) {
                temp += curr.element.toString() + " ";
            }
            temp += "\n";
        }
        return temp;
    }
 
}
 
class Lek{
    protected int negPoz;
    protected int cena;
    protected int brojParcinja;
 
    public Lek(int negPoz, int cena, int brojParcinja){
        this.negPoz = negPoz;
        this.cena = cena;
        this.brojParcinja = brojParcinja;
    }
}
 
public class Apteka {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        CBHT<String, Lek> hashTabela = new CBHT<>(N+1);
 
        for(int i=0;i<N;i++){
            String line = br.readLine();
            String[] things = line.split(" ");
            int negPoz = Integer.parseInt(things[1]);
            int cena = Integer.parseInt(things[2]);
            int brojParcinja = Integer.parseInt(things[3]);
            Lek lek = new Lek(negPoz, cena, brojParcinja);
            hashTabela.insert(things[0], lek);
        }
 
        //System.out.println(hashTabela.toString());
 
        String line = br.readLine().toUpperCase();  //upperCase() na nizata koja kje ja sporeduvate so key elementot od hashtabelata
        while(!line.equals("KRAJ")){                //za da bidat i dvete uppercase i da ne ispuka greshka
            N = Integer.parseInt(br.readLine());
            SLLNode<MapEntry<String, Lek>> node = hashTabela.search(line);
            if(hashTabela.search(line) != null){
                if(N > node.element.value.brojParcinja){
                    System.out.println("Nema dovolno lekovi");
                }else{
                    System.out.println(node.element.key);
                    if(node.element.value.negPoz == 1) {
                        System.out.println("POZ");
                    }
                    else {
                        System.out.println("NEG");
                    }
                    System.out.println(node.element.value.cena);
                    System.out.println(node.element.value.brojParcinja);
                    node.element.value.brojParcinja = node.element.value.brojParcinja - N; //update na zalihata na lekovi
                    System.out.println("Napravena naracka");
                }
            }
            else
                System.out.println("Nema takov lek");
 
            line = br.readLine().toUpperCase();
        }
    }
}
