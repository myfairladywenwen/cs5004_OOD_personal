package starterCode;

import java.util.function.DoubleBinaryOperator;
import problem1.Name;

/**
 * Person is a class that has a name, age, height, and phoneNumber
 */
public class Person {
  protected Name name;
  protected Integer age;
  protected Double height;
  protected String phoneNumber;


  public Person(Name name, Integer age, Double height, String phoneNumber) {
    this.name = name;
    this.age = age;
    this.height = height;
    this.phoneNumber = phoneNumber;
  }


  public Name getName() {
    return name;
  }

  public Integer getAge() {
    return age;
  }

  public Double getHeight() {
    return height;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setName(Name name) {
    this.name = name;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public void setHeight(Double height) {
    this.height = height;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }
}
