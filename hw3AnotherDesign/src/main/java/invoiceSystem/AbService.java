package invoiceSystem;

public abstract class AbService implements IService{
  protected String address;
  protected Size size;
  protected boolean monthly;
  protected int preService;

  public AbService(String address, Size size, boolean monthly, int preService) {
    this.address = address;
    this.size = size;
    this.monthly = monthly;
    this.preService = preService;
  }
}
