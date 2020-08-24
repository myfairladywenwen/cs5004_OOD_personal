package p1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function; import java.util.stream.Collectors;

public class CustomerProcessor {

  private List<Customer> customers = new ArrayList<>();

  public CustomerProcessor(List<Customer> customers){this.customers = customers;}

  public CustomerProcessor(Customer customer1, Customer customer2){
    this.customers.add(customer1);
    this.customers.add(customer2);
  }

  public static Map<Customer, Long> countCustomers(List<Customer> customers) {
    return customers.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
  }

  public void printCustomersWithAFewItems(){
    //YOUR CODE HERE
  }
}
