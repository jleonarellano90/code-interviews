package others;

public class Instacart {

	public static void main(String[] args) {
		int[] order = {100, 4, 4};
		int[][] shoppers = {{100,33,1}};
		
		boolean[] result = delivery(order, shoppers);
		
		printResult(result);
		
	}
	
	static boolean[] delivery(int[] order, int[][] shoppers) {
		int i = 0;
		double orderDistance = order[0];
		double orderReceiveTime = order[1];
		double orderWaitTime = order[2];
		boolean[] result = new boolean[shoppers.length];
	    
	    for (int[] shopper : shoppers) {
	    	double shopperDistance = shopper[0];
	    	double shopperSpeed = shopper[1];
	    	double shopperSpendTime = shopper[2];
	        double fulfillTime = (orderDistance + shopperDistance) / shopperSpeed + shopperSpendTime;
	        double idleTime = orderReceiveTime - fulfillTime;
	        double maxTime = orderReceiveTime + orderWaitTime; //35
	        
	        if (idleTime > 0 || fulfillTime > maxTime) {
	            result[i++] = false;
	        } else {
	        	result[i++] = true;
	        }
	    }
	    return result;
	}

	static boolean validateOrder(int[] order) {
		for (int value : order) {
			if (value < 1 || value > 1000) {
				return false;
			}
		}		
		return true;
	}
	
	static boolean validateShoppers(int[][] shoppers) {
		if (shoppers.length < 1 || shoppers.length > 5) {
			return false;
		}
		
		for (int[] shopper : shoppers) {
			for (int value : shopper) {
				if (value < 1 || value > 1000) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	static void printResult(boolean[] result) {
		for (boolean value : result) {
			System.out.println(value);
		}
	}
}
