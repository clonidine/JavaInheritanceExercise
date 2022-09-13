import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class App {

    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        List<Product> products = new ArrayList<>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Enter the number of products: ");
        int numberProducts = sc.nextInt();

        for (int i = 0; i < numberProducts; i++) {
            System.out.printf("\nProduct #%d data:\n", (i + 1));

            System.out.print("\nCommon, used or imported (c/u/i)? ");
            char productType = sc.next().charAt(0);

            if (productType == 'i') {
                sc.nextLine();

                System.out.print("Name: ");
                String name = sc.nextLine();

                System.out.print("Price: ");
                double price = sc.nextDouble();

                System.out.print("Customs fee: ");
                double customsFee = sc.nextDouble();

                Product product = new ImportedProduct(name, price, customsFee);
                products.add(product);
            }

            if (productType == 'c') {

                sc.nextLine();

                System.out.print("Name: ");
                String name = sc.nextLine();

                System.out.print("Price: ");
                double price = sc.nextDouble();

                Product product = new Product(name, price);
                products.add(product);
            }

            if (productType == 'u') {

                sc.nextLine();

                System.out.print("Name: ");
                String name = sc.nextLine();

                System.out.print("Price: ");
                double price = sc.nextDouble();

                System.out.print("Manufacture date (DD/MM/YYYY): ");
                Date date = simpleDateFormat.parse(sc.next());

                Product product = new UsedProduct(name, price, date);
                products.add(product);
            }
        }

        System.out.println("\nPRICE TAGS:");

        for (Product product : products) {
            System.out.println(product.priceTag());
        }
    }
}
