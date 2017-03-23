package container;

import java.util.Optional;



interface Opcje<T> {
    void showAll();
    void addOnBack(T n);
    void add(T n);
    void addSorted(T n);
    int size();
    T getNode(int n);
   // T size();
    //T getNode(T n);
}


class Container<T> implements Opcje<T>{
    
    private Numbers<T> top = null;
    private Numbers<T> current = null;
    private Numbers<T> last = null;
    private Numbers<T> insert = null;
    private Numbers<T> previous = null;
    Optional<T> optional = Optional.empty();
    

    @Override
    public void add(T n) {
    	optional = Optional.ofNullable(n);
        while(optional.isPresent()) {
            current = new Numbers<>(n);
            if(top==null) top = current;
            else last.next = current;  
            last = current;
            System.out.println("number " + current.num);
            break;
        }
    }
    
    @Override
    public void addOnBack(T n) {
        optional = Optional.ofNullable(n);
        if(optional.isPresent()) {
            
            current = new Numbers<>(n);
            current.next = top;
             
            top = current;
            System.out.println("number " + top.num);
        }
    }
    
    @Override
    public void showAll() {
        current = top;
        while(current!=null) {
            System.out.println(current.num);
            current = current.next;
        }
    }

    @Override
    public void addSorted(T n) {
           
            insert = new Numbers<>(n);
            previous = null;
            current = top;
            
            while(current!=null && current.num.toString().compareToIgnoreCase(n.toString())<0) {
                    previous = current;
                    current = current.next;
            }
          
                insert.next = current;
                if(previous==null) top = insert;  
                else
                previous.next = insert;
    }

    @Override
    public int size() {
        int size = 0;
        current = top;
        while(current!=null) {
            size++;
            current = current.next;
        }
        return size;
    }

    @Override
    public T getNode(int n) {
        int size = this.size();
        Numbers<T> searchingNumber = top;
        Numbers<T> target = null;
        T t = null;
        if(n<=size()&& searchingNumber!=null) {
            for(int a=0; a<n; a++) {
                target = searchingNumber;
                System.out.println("inside loop " + searchingNumber.num);
                searchingNumber = searchingNumber.next;      
            }       
        }
        else System.out.println("indexOut");
        if(target!=null) t = target.num;
        else System.out.println("null");
        
        return t;
    }
    public Numbers getTop() {
        return this.top;
    }
}

class Numbers<T> {
    T num;
    Numbers next;
    
    public Numbers(T n) {
        num = n;
        next = null;
    }
}
