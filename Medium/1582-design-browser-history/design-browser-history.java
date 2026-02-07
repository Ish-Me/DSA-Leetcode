class ListNode{
    String val;
    ListNode next;
    ListNode back;
    public ListNode(String val,ListNode next,ListNode back){
        this.val=val;this.next=next;this.back=back;
        }
    public ListNode(String val){
        this.val=val;this.next=null;this.back=null;
        }
    public ListNode(){
        this.val=null;this.next=null;this.back=null;
        }
}
class BrowserHistory {
    //Ishaan
        ListNode current;
    public BrowserHistory(String homepage) {
        current = new ListNode(homepage,null,null);
    }
    
    public void visit(String url) {
        ListNode newNode = new ListNode(url,null,current);
        current.next=newNode;
        current=newNode;
    }
    
    public String back(int steps) {
        while(steps!=0){
            if(current.back!=null){
                current=current.back;
            }
            else {
                break;
                }
            steps--;
        }
        return current.val;
    }
    
    public String forward(int steps) {
        while(steps!=0){
            if(current.next!=null){
                current=current.next;
            }
            else {
                break;
                }
            steps--;
        }
        return current.val;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */