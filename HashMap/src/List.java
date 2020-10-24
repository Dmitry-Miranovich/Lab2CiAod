public class List<E> {
    private Node<E> first = null;
    private Node<E> last = null;
    private int size = 0;
    public List(){
        last = new Node<>(null, null, first);
        first = new Node<>(null, last, null);
    }

    public void add(E elem) {
        Node<E> newElem = new Node<>(elem ,null, null);
        if(size == 0) {
            newElem.setNext(last);
            newElem.setPrev(first);
            last.setPrev(newElem);
            first.setNext(newElem);
        }else{
            last.getPrev().setNext(newElem);
            newElem.setPrev(last.getPrev());
            newElem.setNext(last);
           last.setPrev(newElem);
        }
        size++;
    }

    public E get(int index) {
        if(index>=size || index<0 )
            throw new IndexOutOfBoundsException("Index: " + index+ ", Size: " + size);
        Node<E> elem = first.getNext();
        for(int i = 0; i<index; i++){
            elem = elem.getNext();
        }
        return elem.getElem();
    }

    public int size() {
        return size;
    }


    public void add(E elem, int index) {
        if(index>size){
            System.out.println("Temporary mistake");
            return;
        }
        Node<E> newElem = new Node<>(elem, null, null);
        Node<E> currentElem = first;
        for(int i = 0; i<index; i++){
            currentElem = currentElem.getNext();
        }
        if(index == 0){
            newElem.setNext(first.getNext());
            newElem.setPrev(first);
            first.setNext(newElem);
        }else {
            newElem.setNext(currentElem.getNext());
            newElem.setPrev(currentElem);
            currentElem.setNext(newElem);
        }
        size++;
    }

    public boolean isEmpty() {
        return size==0;
    }

    public void clear() {
        first.setNext(null);
        last.setPrev(null);
    }

    public void remove(int index) {
        if(size<=index || index<0){
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node<E> currentElem = first.getNext();
        for(int i = 0; i<index; i++){
            currentElem = currentElem.getNext();
        }
        currentElem.setNext(null);
        currentElem.setPrev(null);
        size--;
    }
    protected static class Node<E> {
        private E elem;
        private Node<E> next;
        private Node<E> prev;

        protected Node(E elem, Node<E> next, Node<E> prev) {
            this.elem = elem;
            this.next = next;
            this.prev = prev;
        }

        public Node<E> getPrev() {
            return prev;
        }

        public void setPrev(Node<E> prev) {
            this.prev = prev;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }

        public E getElem() {
            return elem;
        }

        public void setElem(E elem) {
            this.elem = elem;
        }
    }
}

