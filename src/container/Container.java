import java.util.Optional;

interface Opcje<T> {
    void showAll();
    void addOnBack(T n);
    void add(T n);
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
}

class Numbers<T> {
    T num;
    Numbers next;
    
    public Numbers(T n) {
        num = n;
        next = null;
    }
}
