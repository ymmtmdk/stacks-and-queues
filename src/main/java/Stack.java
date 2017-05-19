public interface Stack<Item> {
    //insert a new string onto stack
    void push(Item item);
    // remove and return the string most recently added
    Item pop();

    boolean isEmpty();

    int size();
}
