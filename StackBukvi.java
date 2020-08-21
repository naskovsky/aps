import java.io.IOException;
import java.util.Arrays;
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

public class Main {
    static int proveri_t_posle_s(char[] St) {
        ArrayStack<String> stckarr = new ArrayStack<>(St.length);
        for (int i = St.length - 1; i >= 0; i--) {
            stckarr.push(Character.toString(St[i]));
        }
        /*for (int i = 0; i < St.length; i++) {
            System.out.println(i + ": " + stckarr.pop());
        }*/
        int daliS = 0;
        int brojachTvoS = 0;
        int brojachTvonS = 0;
        while(!stckarr.isEmpty()){
            if(stckarr.peek().equals("S") && daliS == 0){ // pocetok na S
                daliS++;
                stckarr.pop();
            }else if(stckarr.peek().equals("T") && daliS != 0){ // T vo S
                stckarr.pop();
                brojachTvoS++;
            }else if(stckarr.peek().equals("S") && daliS == 1){ // Kraj na S
                daliS = 0;
                stckarr.pop();
            }else if(stckarr.peek().equals("T") && daliS == 0 && brojachTvoS != 0){ // T von S
                stckarr.pop();
                brojachTvonS++;
            }else{
                stckarr.pop();
            }
        }

        if(brojachTvoS == brojachTvonS)
            return 1;
        else
            return 0;

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
