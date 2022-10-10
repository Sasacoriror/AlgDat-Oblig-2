package no.oslomet.cs.algdat.Oblig2;


////////////////// class DobbeltLenketListe //////////////////////////////


import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;


public class DobbeltLenketListe<T> implements Liste<T> {

    /**
     * Node class
     *
     * @param <T>
     */
    private static final class Node<T> {
        private T verdi;                   // nodens verdi
        private Node<T> forrige, neste;    // pekere

        private Node(T verdi, Node<T> forrige, Node<T> neste) {
            this.verdi = verdi;
            this.forrige = forrige;
            this.neste = neste;
        }

        private Node(T verdi) {
            this(verdi, null, null);
        }
    }

    // instansvariabler
    private Node<T> hode;          // peker til den første i listen
    private Node<T> hale;          // peker til den siste i listen
    private int antall;            // antall noder i listen
    private int endringer;         // antall endringer i listen

    public DobbeltLenketListe() {
        hode = null;
        hale = null;
        antall = 0;
        endringer = 0;
    }

    public DobbeltLenketListe(T[] a) {
        Objects.requireNonNull(a,"Tabellen a er null!");

        for (int i = 0; i < a.length; i++){

            if(a[i] != null) {
                if (antall == 0) {
                    hode = new Node<T>(a[i], null, null);
                    hale = hode;
                    antall++;
                } else if (antall == 1) {
                    hale = new Node<T>(a[i], hode, null);
                    hode.neste = hale;
                    antall++;
                } else if (antall > 1) {
                    hale.neste = new Node<T>(a[i], hale, null);
                    hale = hale.neste;
                    antall++;
                }
            }
        }
    }

    private static void fratilKontroll(int antall, int fra, int til) {

        if (fra < 0)                                  // fra er negativ
            throw new IndexOutOfBoundsException
                    ("fra(" + fra + ") er negativ!");
        if (til > antall)                          // til er utenfor tabellen
            throw new IndexOutOfBoundsException
                    ("til(" + til + ") > antall(" + antall + ")");
        if (fra > til)                                // fra er større enn til
            throw new IllegalArgumentException
                    ("fra(" + fra + ") > til(" + til + ") - illegalt intervall!");
    }


    public Liste<T> subliste(int fra, int til) {
        fratilKontroll(antall, fra ,til);

        DobbeltLenketListe<T> verdi = new DobbeltLenketListe<>();

        for (int i = fra; i < til; i++){
            verdi.leggInn(hent(i));
        }
        return verdi;
    }

    @Override
    public int antall() {
        return antall;
    }

    @Override
    public boolean tom() {
        return  (antall == 0 && hode == null && hale == null);
    }

    @Override
    public boolean leggInn(T verdi) {
        Objects.requireNonNull(verdi, "Den er null");

        if (antall > 1){
            hale.neste = new Node<T>(verdi,hale, null);
            hale = hale.neste;
        }else if (antall == 0){
            hode = new Node<T>(verdi, null, null);
            hale = hode;
        } else if (antall == 1){
            hale = new Node<T>(verdi, hode, null);
            hode.neste = hale;
        }

        antall++;
        endringer++;

        return true;
    }


    private Node<T> finnNode(int indeks){

        if (antall/2 > indeks){
            Node<T> current = hode;
            for (int i = 0; i < indeks; i++){
                current = current.neste;
            }
            return current;
        } else {
            Node<T> venstre = hale;
            for (int i = antall-1; i > indeks; i--){
                venstre = venstre.forrige;
            }
            return venstre;
        }
    }

    @Override
    public void leggInn(int indeks, T verdi) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean inneholder(T verdi) {
        throw new UnsupportedOperationException();
    }

    @Override
    public T hent(int indeks) {
        indeksKontroll(indeks, false);
        return finnNode(indeks).verdi;
    }

    @Override
    public int indeksTil(T verdi) {
        throw new UnsupportedOperationException();
    }

    @Override
    public T oppdater(int indeks, T nyverdi) {
        indeksKontroll(indeks, false);
        Objects.requireNonNull(nyverdi, "Kan ikke være null");
        Node<T> gammelIndeks = finnNode(indeks);
        T gammelVerdi = gammelIndeks.verdi;
        gammelIndeks.verdi = nyverdi;
        endringer++;
        return gammelVerdi;
    }

    @Override
    public boolean fjern(T verdi) {
        throw new UnsupportedOperationException();
    }

    @Override
    public T fjern(int indeks) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void nullstill() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
       if (antall == 0){
           return "[]";
       }

       StringBuilder str = new StringBuilder();

       str.append("[");

       Node<T> node = hode;

       str.append(node.verdi);

       node = node.neste;

       while (node != null){
           str.append(", "+node.verdi);
           node = node.neste;
       }

       str.append("]");

       return str.toString();
    }

    public String omvendtString() {
        if(antall == 0){
            return "[]";
        }

        StringBuilder str1 = new StringBuilder();
        str1.append("[");

        Node<T> node = hale;

        str1.append(node.verdi);

        node = hale.forrige;

        while (node != null){
            str1.append(", "+node.verdi);
            node = node.forrige;
        }

        str1.append("]");

        return str1.toString();
    }

    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException();
    }

    public Iterator<T> iterator(int indeks) {
        throw new UnsupportedOperationException();
    }

    private class DobbeltLenketListeIterator implements Iterator<T> {
        private Node<T> denne;
        private boolean fjernOK;
        private int iteratorendringer;

        private DobbeltLenketListeIterator() {
            denne = hode;     // p starter på den første i listen
            fjernOK = false;  // blir sann når next() kalles
            iteratorendringer = endringer;  // teller endringer
        }

        private DobbeltLenketListeIterator(int indeks) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean hasNext() {
            return denne != null;
        }

        @Override
        public T next() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

    } // class DobbeltLenketListeIterator

    public static <T> void sorter(Liste<T> liste, Comparator<? super T> c) {
        throw new UnsupportedOperationException();
    }

} // class DobbeltLenketListe


