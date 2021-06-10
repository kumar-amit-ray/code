/**
Given n orders, each order consist in pickup and delivery services. 

Count all valid pickup/delivery possible sequences such that delivery(i) is always after of pickup(i). 

Since the answer may be too large, return it modulo 10^9 + 7.

 

Example 1:

Input: n = 1
Output: 1
Explanation: Unique order (P1, D1), Delivery 1 always is after of Pickup 1.
Example 2:

Input: n = 2
Output: 6
Explanation: All possible orders: 
(P1,P2,D1,D2), (P1,P2,D2,D1), (P1,D1,P2,D2), (P2,P1,D1,D2), (P2,P1,D2,D1) and (P2,D2,P1,D1).
This is an invalid order (P1,D2,P2,D1) because Pickup 2 is after of Delivery 2.
Example 3:

Input: n = 3
Output: 90

@Leetcode - https://leetcode.com/problems/count-all-valid-pickup-and-delivery-options/
 */
public class PickupAndDeliveries {
    private static final int PICKUP = 1;
    private static final int DELIVERY = 2;
    
    /**
     This solution with Time limit exceed in Leetcode. But it has the logic to generate all possible
     combination which is another varient of the problem. 
     */
    public int countOrders(int n) {
        List<String> pickup = new ArrayList<>();
        List<String> delivery = new ArrayList<>();
        for (int i=1; i<=n; i++) {
            String p = "P" + i;
            String d = "D" + i;
            pickup.add(p);
            delivery.add(d);
        }
        List<List<String>> res = new ArrayList<>();
        getCombos(pickup, delivery, res, new ArrayList<>(), new boolean[n], new boolean[n]);
        System.out.println(res);
        return res.size();
    }
    
    public void getCombos (List<String> pickup, List<String> delivery, List<List<String>> res, List<String> curr, boolean[] picked, boolean[] delivered) {
        if (curr.size() == pickup.size() * 2)
            res.add(new ArrayList<>(curr));

        for (int i=0; i<pickup.size(); i++) {
            if (!picked[i]) {
                curr.add(pickup.get(i));
                picked[i] = true;
                getCombos(pickup, delivery, res, curr, picked, delivered);
                curr.remove(curr.size()-1);
                picked[i] = false;
            }
        }
        for (int i=0; i<delivery.size(); i++) {
            if (picked[i] && !delivered[i]) {
                curr.add(delivery.get(i));
                delivered[i] = true;
                getCombos(pickup, delivery, res, curr, picked, delivered);
                curr.remove(curr.size()-1);
                delivered[i] = false;
            }
        }
    }
    
    /**
        This is another varient of the problem where given a list of pick up and deliveries, make sure they are valid or not. 
        we just need to make sure the Pi is always before Di. 
     */
    public boolean validatePickupDelivery(String[] pdOrders) {
        if (pdOrders == null || pdOrders.length == 0) {
            return true;
        }
        if (pdOrders.length % 2 != 0) {
            return false;
        }
        Set<String> set = new HashSet<>();
        for (String pdOrder: pdOrders) {
            if (isPickup(pdOrder)) {
                if (set.contains(reverseMapper(pdOrder))) {
                    return false;
                }
            } else {
                if (!set.contains(reverseMapper(pdOrder))) {
                    return false;
                }
            }
            set.add(pdOrder);
        }
        return true;
    }

    private String reverseMapper(String mapFrom) {
        if (isPickup(mapFrom)) {
            String[] splitters = mapFrom.split("P");
            int number = Integer.parseInt(splitters[1]);
            return "D"+number;
        } else {
            String[] splitters = mapFrom.split("D");
            int number = Integer.parseInt(splitters[1]);
            return "P"+number;
        }
    }

    private boolean isPickup(String data) {
        return data.startsWith("P");
    }

    public static void main(String[] args) {
        //System.out.println(new PickupAndDeliveries().countOrders(2));
        System.out.println(new PickupAndDeliveries().validatePickupDelivery(new String[]{"P1", "D1"}));
        System.out.println(new PickupAndDeliveries().validatePickupDelivery(new String[]{"P299", "D199", "P199", "D299"}));
    }
}
