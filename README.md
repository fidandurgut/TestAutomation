# TestAutomation
Build with Maven using Java 8

You can find the end to end test case [here](./AmazonWeb/src/test/java/com/amazon/shopping/test/ShoppingTest.java)

This test includes all instructions:

1. Navigate to "www.amazon.com"
2. Go into "Best sellers in Digital Cameras"
3. Open details of 5-th product
4. Add 8 pieces (or the maximum amount if it's less than 8) to the shopping cart (not accepted any other options that are proposed by the e-shop)
5. Checks that correct product was added (By comparing the titles before adding cart and after at cart)
6. Checks that subtotal price sum is correct (By comparing price*count before adding the cart and after at cart)

Please ignore enum.package. They are not used anywhere at the current project but may be used in improvements. I haven't removed them for any future improvement
