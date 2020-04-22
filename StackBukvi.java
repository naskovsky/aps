import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

interface Stack<E> {

    // Elementi na stekot se objekti od proizvolen tip.

    // Metodi za pristap:

    public boolean isEmpty();
    // Vrakja true ako i samo ako stekot e prazen.

    public E peek();
    // Go vrakja elementot na vrvot od stekot.

    // Metodi za transformacija:

    public void clear();
    // Go prazni stekot.

    public void push(E x);
    // Go dodava x na vrvot na stekot.

    public E pop();
    // Go otstranuva i vrakja elementot shto e na vrvot na stekot.
}

class ArrayStack<E> implements Stack<E> {
    private E[] elems;
    private int depth;

    @SuppressWarnings("unchecked")
    public ArrayStack(int maxDepth) {
        // Konstrukcija na nov, prazen stek.
        elems = (E[]) new Object[maxDepth];
        depth = 0;
    }


    public boolean isEmpty() {
        // Vrakja true ako i samo ako stekot e prazen.
        return (depth == 0);
    }


    public E peek() {
        // Go vrakja elementot na vrvot od stekot.
        if (depth == 0)
            throw new NoSuchElementException();
        return elems[depth - 1];
    }


    public void clear() {
        // Go prazni stekot.
        for (int i = 0; i < depth; i++) elems[i] = null;
        depth = 0;
    }


    public void push(E x) {
        // Go dodava x na vrvot na stekot.
        elems[depth++] = x;
    }


    public E pop() {
        // Go otstranuva i vrakja elementot shto e na vrvot na stekot.
        if (depth == 0)
            throw new NoSuchElementException();
        E topmost = elems[--depth];
        elems[depth] = null;
        return topmost;
    }
}

public class StackBukvi {
    static int proveri_t_posle_s(char[] st) {
        int result = 1;
        int count = 0;
        int countT = 0;
        ArrayStack<String> as = new ArrayStack<>(st.length);
        ArrayStack<Integer> numberOfT = new ArrayStack<>(st.length);
        ArrayList<Integer> test = new ArrayList<>();
        Integer[]dada = new Integer[st.length];
        String[] sAndTs = new String[st.length];
        for (int i = 0; i < st.length; i++) {
            as.push(String.valueOf(st[i]));
        }
        int j = 0;
        int countTTTTT = 0;
        while (!as.isEmpty()) {
            String element = as.pop();
            if (element.equals("T")) {
                count++;
            } else if (element.equals("S")) {
                if(dada[0] == null){
                    dada[j] = count;
                    countTTTTT++;
                } else {
                    j++;
                    countTTTTT++;
                    dada[j] = count;
                }
                count = 0;
            }
        }
        for (int i = 0; i < countTTTTT; i++) {
            if (i < countTTTTT - 1) {
                if (dada[i] != dada[i+1]) {
                    result = 0;
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        char[] niza = new char[100];

        Scanner f = new Scanner(System.in);
        String st = f.next();
        niza = st.toCharArray();

        int rez = proveri_t_posle_s(niza);
        System.out.println(rez);
    }


}