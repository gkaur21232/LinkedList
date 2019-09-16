import java.util.EmptyStackException;

public class LinkedStack<T> implements ADTStack<T> {

    private int count;

    private LinearNode<T> top;

    public LinkedStack(){
        count = 0;
        top = null;
    }

    public void push ( T element) {
        LinearNode<T> node = new LinearNode<T>(element);
        node.setNext(top);
        top = node;
        count++;
    }

    public T pop() throws EmptyStackException
    {
        if ( isEmpty())
            throw new EmptyStackException();

        T element = top.getElement();
        top = top.getNext();
        count--;
        return element;
    }

    public T peak() throws EmptyStackException{
        if (isEmpty())
            throw new EmptyStackException();
        return top.getElement();
    }

    public int size(){
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        LinearNode<T> pt = top;
        while(pt != null){
            stringBuilder.append(pt.getElement());
            if(pt.getNext() != null) stringBuilder.append( " ");
            pt = pt.getNext();
        }
        return stringBuilder.toString();
    }
}
