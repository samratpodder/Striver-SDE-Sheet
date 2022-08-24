import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    Queue<Integer> q;
    public MyStack() {
        this.q = new LinkedList<>();
        
    }
    
    public void push(int x) {
        int sz=q.size();
        this.q.offer(x);
        for(int i=0;i<sz;i++)
            this.q.offer(this.q.poll());
    }
    
    public int pop() {
        return this.q.poll();
    }
    
    public int top() {
        return this.q.peek();
    }
    
    public boolean empty() {
        return this.q.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */