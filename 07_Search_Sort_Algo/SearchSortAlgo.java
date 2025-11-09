import java.util.ArrayList;
import java.util.Scanner;

public class SearchSortAlgo {
    static ArrayList<NOOD> llist = new ArrayList<>();
    static int si = 0;
    static int current;

    public static class NOOD {
        int ni;
        int data;

        public NOOD() {
        }

        public NOOD(int data, int ni) {
            this.data = data;
            this.ni = ni;
        }
    }

    public static void Create() {
        Scanner sc = new Scanner(System.in);
        int n = 0;
        for (int i = 0;; i++) {
            System.out.print("Enter Elements for LinkedList(or -1 to quit): ");
            n = sc.nextInt();
            if (n == -1) {
                break;
            } else {
                llist.add(new NOOD(n, -1));
            }

        }

    }

    public static void Print() {
        System.out.println("Initial LinkList");
        for (int i = 0; i < llist.size(); i++) {
            System.out.println("Element =(" + llist.get(i).data + "," + llist.get(i).ni + ")");
        }
        // 1st step:To Find Si

        int min = 10000;
        for (int i = 0; i < llist.size(); i++) {
            if (llist.get(i).data < min) {
                min = llist.get(i).data;
                si = i;
            }
        }
        current = si;
        // second step To Store Reference points of next smallest value
        boolean[] Arr = new boolean[llist.size()];
        Arr[si] = true;
        int nextsmallestindex = -1;
        for (int j = 1; j < llist.size(); j++) {
            int mini = Integer.MAX_VALUE;

            for (int i = 0; i < llist.size(); i++) {
                if (!Arr[i]) {
                    if (llist.get(i).data < mini) {
                        mini = llist.get(i).data;
                        nextsmallestindex = i;
                    }
                }
            }
            llist.get(current).ni = nextsmallestindex;
            current = nextsmallestindex;
            if (current != -1) {
                Arr[current] = true;
            }
        }
        if (current != -1) {
            llist.get(current).ni = -1;
        }
        System.out.println("Here is The Linked List");
        int i = si;
        while (i != -1) {
            System.out.println("Element =(" + llist.get(i).data + "," + llist.get(i).ni + ")");
            i = llist.get(i).ni;
        }
    }

    public static void Add(int num) {
        if (num < llist.get(si).data) {
            llist.add(new NOOD(num, si));
            si = llist.size() - 1;

        } else if (num > llist.get(current).data) {
            boolean f = false;
            for (int i = 0; i < llist.size(); i++) {
                if (num < llist.get(i).data) {
                    f = true;
                }
                if (f) {
                    break;
                }
            }
            if (!f) {
                llist.add(new NOOD(num, -1));
                llist.get(current).ni = llist.size() - 1;
            }
        } else {
            int lastsmallerindex = -1;
            int nextbiggerindex = -1;
            int i = si;
            while (i != -1) {
                if (llist.get(i).data < num) {
                    lastsmallerindex = i;
                } else if (llist.get(i).data > num) {
                    nextbiggerindex = i;
                    break;
                }
                i = llist.get(i).ni;
            }
            llist.add(new NOOD(num, nextbiggerindex));
            llist.get(lastsmallerindex).ni = llist.size() - 1;
        }
        System.out.println("Here is The Updated Linked List");
        int i = si;
        while (i != -1) {
            System.out.println("Element =(" + llist.get(i).data + "," + llist.get(i).ni + ")");
            i = llist.get(i).ni;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("What do You want? \n1:Print List \n2:Create List \n3:Add in List");
        int x = sc.nextInt();
        if (x == 1) {
            Create();
            Print();
        } else if (x == 2) {
            Create();
        } else if (x == 3) {
            Create();
            Print();
            System.out.print("Enter Number You want to Add ");
            Add(sc.nextInt());
        }
    }
}