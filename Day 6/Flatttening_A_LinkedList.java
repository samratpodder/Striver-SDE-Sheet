// { Driver Code Starts
    import java.util.Scanner;
    import java.util.*;
    import java.io.*;
    
    class Node
    {
        int data;
        Node next;
        Node bottom;
        Node(int d)
        {
            data = d;
            next = null;
            bottom = null;
        }
        // @Override
        // public String toString(Node n){
        //     String res = new String();
        //     while (n!=null) {
        //         res+=n.data+" ";
        //     }
        //     return res;
        // }
    }
    
    
    class Flatttening_A_LinkedList
    {	
        Node head;
        
        void printList(Node node)
        {
            //Node temp = head;
            while (node != null)
            {
                System.out.print(node.data + " ");
                node =node.bottom;
            }
            System.out.println();
        }
        public  static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            Flatttening_A_LinkedList list = new Flatttening_A_LinkedList();
            while(t>0)
            {
                int N = sc.nextInt();
                int arr[] = new int[N];
                for(int i=0;i<N;i++)
                    arr[i] = sc.nextInt();
                
                Node temp = null;
                Node tempB = null;
                Node pre = null;
                Node preB = null;	
                int flag=1;
                int flag1=1;
                for(int i=0; i<N;i++)
                {
                    int m = arr[i];
                    m--;
                    int a1 = sc.nextInt();
                    temp = new Node(a1);
                    if(flag == 1)
                    {
                        list.head = temp;
                        pre = temp;
                        flag = 0;
                        flag1 = 1;
                    }
                    else
                    {
                        pre.next = temp;
                        pre = temp;
                        flag1 = 1;
                    }
                    
                    for(int j=0;j<m;j++)
                    {
                        int a = sc.nextInt();
                        tempB = new Node(a);
                        if(flag1 == 1)
                        {
                            temp.bottom = tempB;
                            preB = tempB;
                            flag1 = 0;
                        }
                        else
                        {
                            preB.bottom = tempB;
                            preB = tempB;
                        }
                    }
                    
                }
                //list.printList();
                GfG g = new GfG();
                Node root = g.flatten(list.head);
                list.printList(root);
            
            t--;
            }
        }	
    }// } Driver Code Ends
    
    
    /*Node class  used in the program
    class Node
    {
        int data;
        Node next;
        Node bottom;
        
        Node(int d)
        {
            data = d;
            next = null;
            bottom = null;
        }
    }
    */
    /*  Function which returns the  root of 
        the flattened linked list. */
    class GfG
    {
        Node flatten(Node root)
        {
            // Node temp = root;
            // int i = 0;
            // ArrayList<Node> l = new ArrayList<>();
            // while(temp!=null)
            // {
            //     l.add(temp);
            //     temp=temp.next;
            // }
            Node dummy = root;
            Node returnList = root;
            while (dummy!=null) {
                 mergeLists(dummy, dummy.next);

                // System.out.println(returnList);
                dummy = dummy.next;
                // i++;
            }
            return root;
        }
        Node mergeLists(Node a, Node b)
        {
            Node newList = new Node(0);
            Node dummy = newList;
            while (a!=null && b!=null) {
                if (a.data<=b.data) {
                    dummy.bottom = a;
                    a=a.bottom;
                }
                else{
                    dummy.bottom = b;
                    b=b.bottom;
                }
                dummy = dummy.bottom;
            }
            if(a!=null)
            {
                dummy.bottom = a;
            }
            else if(b!=null)
            {
                dummy.bottom = b;
            }
            return newList.bottom;
        }
    }