package com.assets;

import java.util.Scanner;
import com.asset.model.*;
import com.asset.service.*;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        AssetService service = new AssetService();

        System.out.println("===== Asset Management System =====");

        while (true) {

            System.out.println("\n1. Register Laptop");
            System.out.println("2. Register Vehicle");
            System.out.println("3. Show Assets");
            System.out.println("4. Allocate Asset");
            System.out.println("5. Generate QR For Asset");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            String choiceLine = sc.nextLine();   // <-- ONLY nextLine
            int ch = Integer.parseInt(choiceLine);

            switch (ch) {

                case 1: {
                    System.out.println("[DEBUG] Laptop registration started");

                    System.out.print("Enter Laptop Asset ID: ");
                    String id = sc.nextLine();

                    System.out.print("Enter Laptop Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Cost: ");
                    String costLine = sc.nextLine();   // <-- READ HERE
                    double cost = Double.parseDouble(costLine);

                    Asset laptop = new LaptopAsset(id, name, cost);
                    service.registerAsset(laptop);

                    System.out.println("Laptop Registered Successfully!");
                    break;
                }

                case 2: {
                    System.out.println("[DEBUG] Vehicle registration started");

                    System.out.print("Enter Vehicle Asset ID: ");
                    String id = sc.nextLine();

                    System.out.print("Enter Vehicle Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Cost: ");
                    String costLine = sc.nextLine();   // <-- READ HERE
                    double cost = Double.parseDouble(costLine);

                    Asset vehicle = new VehicleAsset(id, name, cost);
                    service.registerAsset(vehicle);

                    System.out.println("Vehicle Registered Successfully!");
                    break;
                }

                case 3:
                    service.showAssets();
                    break;

                case 4: {
                    System.out.print("Enter Asset ID to Allocate: ");
                    String id = sc.nextLine();

                    Asset a = service.findAsset(id);

                    if (a == null) System.out.println("Asset Not Found!");
                    else if (a.isAllocated()) System.out.println("Asset Already Allocated!");
                    else {
                        System.out.print("Enter Employee Name: ");
                        String emp = sc.nextLine();
                        Allocation alloc = new Allocation(emp, a);
                        System.out.println("Allocated: " + alloc);
                    }
                    break;
                }

                case 5: {
                    System.out.print("Enter Asset ID for QR: ");
                    String id = sc.nextLine();

                    Asset a = service.findAsset(id);

                    if (a == null) System.out.println("Asset Not Found!");
                    else {
                        QRCodeGenerator.generateQRCode(a.toString(), id + ".png");
                        System.out.println("QR Generated Successfully!");
                    }
                    break;
                }

                case 6:
                    System.out.println("Exiting…");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}
