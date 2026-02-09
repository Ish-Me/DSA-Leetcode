class MyStack {
    Queue<Integer> q = new LinkedList<>();
    int size;
    public MyStack() {
       size=0;
    }
    
    public void push(int x) {
        size=q.size();
        q.offer(x);
        for(int i=1 ; i<=size ; i++){
            q.offer(q.peek());
            q.poll();
        }
    }
    
    public int pop() {
        return q.poll();
    }
    
    public int top() {
        return q.peek();
    }
    
    public boolean empty() {
        if(q.isEmpty())return true;
        else return false;
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