package problem2;

public interface IListOfStrings {

  boolean isEmpty();
  int size();
  boolean contains(String input);
  boolean containsAll(IListOfStrings other);
  IListOfStrings filerLargerThan(int max);
  boolean hasDuplicates();
  IListOfStrings removeDuplicates();
}
