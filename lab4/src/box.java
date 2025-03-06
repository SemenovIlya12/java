public class box<T> {
    private T item;

    public box() {
        this.item = null;
    }

    public void SetItem(T item) {
        if (this.item != null) throw new IllegalStateException("Box is full!");

        this.item = item;
    }

    public T get() {
        T tempitem = this.item;
        this.item = null;
        return tempitem;
    }

    public boolean isEmpty() {
        return this.item == null;
    }

    @Override
    public String toString() {
        if (this.isEmpty()) return "Box is empty!";
        return "box contains " + this.item;
    }

}
