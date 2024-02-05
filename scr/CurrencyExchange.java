import java.util.Random;

public class CurrencyExchange {
    public static void main(String[] args) {
        Bank[] banks = new Bank[14];
        Random random = new Random();

        for (int i = 0; i < 14; i++) {
            String bankName = "Bank " + (i + 1);
            double buyingPrice = 37 + (5 * random.nextDouble());
            double sellingPrice = buyingPrice + 1;
            banks[i] = new Bank(bankName, buyingPrice, sellingPrice);
        }
        double dollars = 1000; // Assuming you have 1000 dollars
        System.out.println("You have " + dollars + " dollars.");

        Bank bestBuyingBank = null;
        Bank bestSellingBank = null;
        double bestProfit = 0;

        for (Bank bank : banks) {
            double hryvniasAfterBuying = dollars * bank.getBuyingPrice();
            double profit = hryvniasAfterBuying - dollars;

            if (profit > bestProfit) {
                bestProfit = profit;
                bestBuyingBank = bank;
                bestSellingBank = bank;
            }
        }

        System.out.println("Найвигідніший банк для купівлі: " + bestBuyingBank.getName() +
                " (Ціна купівлі: " + bestBuyingBank.getBuyingPrice() + ")");
        System.out.println("Найвигідніший банк для продажу: " + bestSellingBank.getName() +
                " (Ціна продажу: " + bestSellingBank.getSellingPrice() + ")");
    }
}