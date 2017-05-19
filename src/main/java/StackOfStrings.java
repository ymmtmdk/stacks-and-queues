public interface StackOfStrings {
    //insert a new string onto stack
    void push(String item);
    // remove and return the string most recently added
    String pop();

    boolean isEmpty();

    int size();
}
