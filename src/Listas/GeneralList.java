package Listas;

public interface GeneralList<T> {

    void remove();
	void goNext();
    void goPrev();
    void goTo(int n);
    T getActual();
    int size();
    boolean isVoid();
    boolean endList();
    GeneralList<T> clone();
}
