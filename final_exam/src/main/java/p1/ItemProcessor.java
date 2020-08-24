package p1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function; import java.util.stream.Collectors;

public class ItemProcessor {
  private List<Item> items = new ArrayList<>();

  public ItemProcessor(List<Item> items){this.items = items;}

  public ItemProcessor(Item item1, Item item2, Item item3){
    this.items.add(item1);
    this.items.add(item2);
    this.items.add(item3);
  }

  public static Map<Item, Long> countItems(List<Item> items) {
    return items.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
  }

  public List<Item> filterByPrice(Float minPrice, Float maxPrice){
    //YOUR CODE HERE
    return null;
  }
}