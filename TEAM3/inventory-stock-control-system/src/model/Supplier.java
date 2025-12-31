package model;

public class Supplier {

    private int supplierId;
    private String supplierName;
    private String contactNumber;

    public Supplier(int supplierId, String supplierName, String contactNumber) {
        this.supplierId = supplierId;
        this.supplierName = supplierName;
        this.contactNumber = contactNumber;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public String getContactNumber() {
        return contactNumber;
    }
}
