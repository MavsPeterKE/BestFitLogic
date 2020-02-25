public class BestFitMainClass {
    public static void main(String[] args){
        System.out.println("Test Test");
        int paymentsAvailable[] = { 300,200};
        int ordersToPay[] = {198, 230, 115, 3834};
        bestFit(paymentsAvailable, ordersToPay);
    }

    // Method to allocate memory to blocks as per Best fit
    // algorithm
    static void bestFit(int paymentsAvailable[], int ordersToPay[]) {
        // Stores block id of the block allocated to a
        // process
        int allocation[] = new int[ordersToPay.length]; // Store allocated Orders


        // Initially no block is assigned to any process
        for (int i = 0; i < allocation.length; i++){
            allocation[i] = -1;
            System.out.println("Allocation Item: "+allocation[i]);
        }

        // pick each process and find suitable blocks
        // according to its size ad assign to it
        for (int i=0; i<ordersToPay.length; i++)
        {
            // Find the best fit block for current process
            int bestIdx = -1;
            for (int j=0; j<paymentsAvailable.length; j++)
            {
                if (paymentsAvailable[j] >= ordersToPay[i])
                {
                    if (bestIdx == -1)
                        bestIdx = j;
                    else if (paymentsAvailable[bestIdx] > paymentsAvailable[j])
                        bestIdx = j;
                }
            }

            // If we could find a block for current process
            if (bestIdx != -1)
            {
                // allocate block j to p[i] process
                allocation[i] = bestIdx; // -- //

                // Reduce available memory in this block.
                paymentsAvailable[bestIdx] -= ordersToPay[i];
            }
        }

        System.out.println("\nProcess No.\tProcess Size\tBlock no.");
        for (int i = 0; i < ordersToPay.length; i++)
        {
            System.out.print("   " + (i+1) + "\t\t" + ordersToPay[i] + "\t\t");
            if (allocation[i] != -1)
                System.out.print(allocation[i] + 1);
            else
                System.out.print("Not Allocated");
            System.out.println();
        }
    }
}
