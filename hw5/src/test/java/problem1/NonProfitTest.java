package problem1;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class NonProfitTest {

  NonProfit testNonProfit;
  List<Donation> testlist = new ArrayList<Donation>();
  Donation d1;
  Donation d2;
  Donation d3;

  @Before
  public void setUp() throws Exception {
    testNonProfit = new NonProfit("name", testlist);
  }

  @Test
  public void testRemoveDonation(){
    testNonProfit.removeDonation(null);
    assertEquals(testNonProfit, testNonProfit);
  }


  @Test
  public void getTotalDonationsForYear1() {
    d1 = new OneTime(10);
    d2 = new OneTime(10, LocalDate.of(2019, 1, 10));
    testNonProfit.addDonation(d1);
    testNonProfit.addDonation(d2);
    assertEquals(10, testNonProfit.getTotalDonationsForYear(2019).intValue());
  }


  @Test
  public void getTotalDonationsForYear2() {
    d1 = new OneTime(10, LocalDate.of(2019, 2, 5));
    d2 = new OneTime(10, LocalDate.of(2019, 1, 10));
    testNonProfit.addDonation(d1);
    testNonProfit.addDonation(d2);
    assertEquals(20, testNonProfit.getTotalDonationsForYear(2019).intValue());
  }


  @Test
  public void getTotalDonationsForYear3() {
    d1 = new OneTime(10, LocalDate.of(2019, 2, 5));
    d2 = new OneTime(10, LocalDate.of(2019, 1, 10));
    d3 = new Monthly(10);  // create 2020.2, not cancel, due2019.12.31
    testNonProfit.addDonation(d1);
    testNonProfit.addDonation(d2);
    testNonProfit.addDonation(d3);
    assertEquals(20, testNonProfit.getTotalDonationsForYear(2019).intValue());
  }

  @Test
  public void getTotalDonationsForYear4() {
    d1 = new OneTime(10, LocalDate.of(2019, 2, 5));
    d2 = new OneTime(10, LocalDate.of(2019, 1, 10));
    // creat: 2019.5.1  not canceled, due2019.12.31
    d3 = new Monthly(10, LocalDate.of(2019, 5, 1));
    testNonProfit.addDonation(d1);
    testNonProfit.addDonation(d2);
    testNonProfit.addDonation(d3);
    assertEquals(20 + 10 * 8, testNonProfit.getTotalDonationsForYear(2019).intValue());
    testNonProfit.removeDonation(d3);
    Monthly md1 = new Monthly(10, LocalDate.of(2018, 5, 1));
    // creat: 2018.5.1    not canceled    due: 2019.12.31
    testNonProfit.addDonation(md1);
    assertEquals(20 + 10 * 12, testNonProfit.getTotalDonationsForYear(2019).intValue());
    testNonProfit.removeDonation(md1);

    // 2018.2.1 created   2018.5.1 canceled   2019.12.31 due
    Monthly md2 = new Monthly(10, LocalDate.of(2018, 2, 1));
    md2.setCancelDate(LocalDate.of(2018, 5, 1));
    testNonProfit.addDonation(md2);
    assertEquals(20, testNonProfit.getTotalDonationsForYear(2019).intValue());
    testNonProfit.removeDonation(md2);

    // 2018.4.5 created, 2020.10.10 cancel, 2019.12.31 due
    Monthly md7 = new Monthly(10, LocalDate.of(2018, 4, 5));
    md7.setCancelDate(LocalDate.of(2020, 10, 10));
    testNonProfit.addDonation(md7);
    assertEquals(20 + 10 * 12, testNonProfit.getTotalDonationsForYear(2019).intValue());
    testNonProfit.removeDonation(md7);

    //2019.4.5 created, 2020.10.1 cancel, 2019.12.31 due
    Monthly md8 = new Monthly(10, LocalDate.of(2019, 4, 5));
    md8.setCancelDate(LocalDate.of(2020, 10, 1));
    testNonProfit.addDonation(md8);
    assertEquals(20 + 10 * 9, testNonProfit.getTotalDonationsForYear(2019).intValue());
    testNonProfit.removeDonation(md8);

    // 2018.4.1 created, 2019.10.10 cancel, 2019.12.31 due
    Monthly md4 = new Monthly(10, LocalDate.of(2018, 4, 1));
    md4.setCancelDate(LocalDate.of(2019, 10, 10));
    testNonProfit.addDonation(md4);
    assertEquals(20 + 10 * 10, testNonProfit.getTotalDonationsForYear(2019).intValue());
    testNonProfit.removeDonation(md4);

    // 2018.4.15 created, 2019.10.10 cancel, 2019.12.31 due
    Monthly md5 = new Monthly(10, LocalDate.of(2018, 4, 15));
    md5.setCancelDate(LocalDate.of(2019, 10, 10));
    testNonProfit.addDonation(md5);
    assertEquals(20 + 10 * 9, testNonProfit.getTotalDonationsForYear(2019).intValue());
    testNonProfit.removeDonation(md5);

    //2019.4.15 created, 2019.10.10 cancel, 2019.12.31 due
    Monthly md6 = new Monthly(10, LocalDate.of(2019, 4, 15));
    md6.setCancelDate(LocalDate.of(2019, 10, 10));
    testNonProfit.addDonation(md6);
    assertEquals(20 + 10 * 6, testNonProfit.getTotalDonationsForYear(2019).intValue());
    testNonProfit.removeDonation(md6);

//    // 2018.2.1 created   2020.1.10 canceled   2019.12.31 due
////    Monthly md3 = new Monthly(10, LocalDate.of(2018,2,1));
////    md3.setCancelDate(LocalDate.of(2020,1,10));
////    testNonProfit.addDonation(md3);
////    assertEquals(20+10*12, testNonProfit.getTotalDonationsForYear(2019).intValue());
////    testNonProfit.removeDonation(md3);
////
    //2019.4.5 created, 2019.10.10 cancel, 2019.12.31 due
    Monthly md10 = new Monthly(10, LocalDate.of(2019, 4, 5));
    md10.setCancelDate(LocalDate.of(2019, 10, 10));
    testNonProfit.addDonation(md10);
    assertEquals(20 + 10 * 7, testNonProfit.getTotalDonationsForYear(2019).intValue());
    testNonProfit.removeDonation(md10);

    // 2020.2.1 created   2019.12.31 due
    Monthly md9 = new Monthly(10, LocalDate.of(2020, 2, 1));
    testNonProfit.addDonation(md9);
    assertEquals(20, testNonProfit.getTotalDonationsForYear(2019).intValue());
    testNonProfit.removeDonation(md9);
  }

  @Test
  public void getTotalDonationsForYear5() {
    d1 = new OneTime(10, LocalDate.of(2019, 2, 5));
    d2 = new OneTime(10, LocalDate.of(2019, 1, 10));
    Pledge d3 = new Pledge(10, LocalDate.of(2019, 1, 5),
        LocalDate.of(2019, 2, 5));
    testNonProfit.addDonation(d1);
    testNonProfit.addDonation(d2);
    testNonProfit.addDonation(d3);
    assertEquals(30, testNonProfit.getTotalDonationsForYear(2019).intValue());
  }


}