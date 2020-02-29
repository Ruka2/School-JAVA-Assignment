//Suppose you have a stack S containing n elements and a queue Q that is initially empty.
// Describe how you can use Q to scan S to see if it contains a certain element x,
// with the additional constraint that your algorithm must return the elements back to S in their original order.
// You may only use S, Q, and a constant number of other primitive variables.

import java.util.ArrayList;

public class Assignment3 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        list.add(7); list.add(8); list.add(9);
        System.out.println("\tcbb + ba = abc\n\t799 + 98 = 897");
        new puzzle().solve(list.size(), list2 , list);
    }
}
class puzzle {
    public void solve(int k, ArrayList<Integer> s, ArrayList<Integer> u) {
        for (int i = 0; i < u.size(); i++) {       // for all e in U do

            int e = u.get(i);                      // get e
            u.remove(i);                           // Remove e from U
            s.add(e);                              // Add e to the end of S

            if (k == 1) {//Test whether S is a configuration that solves the puzzle
                int a = s.get(0), b = s.get(1), c = s.get(2);
                int result = (c*100 + b*10 + b) + (b*10 + a);
                if (result == (a*100 + b*10 + c)) {
                    System.out.println("Solution found: S = "+ s);
                    return;
                }
            } else {
                solve(k - 1, s, u);
            }

            u.add(e);                              // Add e back to U
            s.remove(i);                           // Remove e from the end of S
        }
    }
}