/*
`* To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Optional;

interface List<T> {

    void showAll();

    void addOnBack(T n);
    void add(T n);

    void addSorted(T n);

    int size();

    T getNode(int n);
    void removeNode(int n);
    <T> void reverse(Element top);

}

class Container<T> implements List<T> {

    // general and top are main list
    private Element<T> top = null;
    private Element<T> current = null;
    private Element<T> general = null;
    private Element<T> insert = null;
    private Element<T> previous = null;
    Optional<T> optional = Optional.empty();

    public Container() {
    }

    public Container(int tab[]) {
        for (int a : tab) {
            T t = (T) (Integer) a;
            this.add(t);
        }
    }

    public Container(double tab[]) {
        for (double a : tab) {
            T t = (T) (Double) a;
            this.add(t);
        }
    }

    public Container(T tab[]) {
        for (T t : tab) {
            this.add(t);
        }
    }

    @Override
    public void add(T n) {
        optional = Optional.ofNullable(n);
        if (optional.isPresent()) {
            current = new Element<>(n);
            if (top == null) {
                top = current;
            } else {
                general.next = current;
            }
            general = current;
        }
    }

    @Override
    public void addSorted(T n) {

        insert = new Element<>(n);
        previous = null;
        current = top;
        general = insert;
        if (general != null && general.num instanceof Integer) {
            sortedInteger(n);
        }
        if (general != null && general.num instanceof String) {
            sortedString(n);
        }

    }

    @Override
    public void addOnBack(T n) {
        optional = Optional.ofNullable(n);
        if (optional.isPresent()) {

            current = new Element<>(n);
            current.next = top;

            top = current;
        }
    }

    public void sortedString(T n) {
        String gg = null;
        if (general != null && general.num instanceof String && general.num.toString().compareToIgnoreCase(n.toString()) < 0) {
            gg = (String) general.num;
            this.add(n);
        } else {

            while (current != null
                    && current.num instanceof String
                    && current.num.toString().compareToIgnoreCase(n.toString()) < 0) {
                previous = current;
                current = current.next;
            }
            this.toSortedMethod();
        }
    }

    public void sortedInteger(T n) {
        int a;
        int b;
        int g = 0;
        if (general != null && general.num instanceof Integer && g >= (a = (Integer) n)) {
            g = (Integer) general.num;
            this.add(n);
        } else {
            while (current != null && current.num instanceof Integer
                    && (b = (Integer) current.num) < (a = (Integer) n)) {
                previous = current;
                current = current.next;
            }
            this.toSortedMethod();
        }
    }

    public void toSortedMethod() {
        insert.next = current;
        if (previous == null) {
            top = general = insert;
        } else {
            previous.next = insert;
        }
    }

    @Override
    public void showAll() {
        current = top;
        while (current != null) {
        	
            System.out.print(current.num + " ");
            
            current = current.next;
        }
    }

    @Override
    public int size() {
        int size = 0;
        current = top;
        while (current != null) {
            size++;
            current = current.next;
        }
        return size;
    }

    public Element<T> getTop() {
        return this.top;
    }

    @Override
    public <T> void reverse(Element top) {
        if (top != null) {
            reverse(top.next);
            System.out.println(top.num);
        }
    }

    @Override
    public T getNode(int n) {
        int size = this.size();
        Element<T> searchingNumber = top;
        Element<T> target = null;
        T t = null;
        if (n <= size() && searchingNumber != null) {
            for (int a = 0; a < n; a++) {
                target = searchingNumber;
                System.out.println("inside loop " + searchingNumber.num);
                searchingNumber = searchingNumber.next;
            }
        } else {
            System.out.println("indexOut");
        }
        if (target != null) {
            t = target.num;
        } else {
            System.out.println("null");
        }

        return t;
    }

    @Override
    public void removeNode(int n) {
        if (n <= 0 || n > size()) {
            System.out.println("indexOut");
        } else {
            if (n == 1) {
                top = top.next;
            }
            current = null;
            current = top;

            if (current != null) {
                for (int a = 1; a < n; a++) {
                    previous = current;
                    current = current.next;
                }
            }

            if (n > 1) {
                previous.next = current.next;
            }
        }

    }

}

class Element<T> {

    T num;
    Element next;

    public Element(T n) {
        num = n;
        next = null;
    }
}
