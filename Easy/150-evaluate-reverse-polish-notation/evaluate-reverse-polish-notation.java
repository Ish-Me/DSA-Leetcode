class Solution {
    public int evalRPN(String[] tokens) {
        int i = 0;
        int ans = 0,a1=0,a2=0;
        Stack<Integer> st = new Stack<>();
        while(i < tokens.length){
            if(tokens[i].equals("*") || tokens[i].equals("/") || 
               tokens[i].equals("+") || tokens[i].equals("-")){
                int t1 = st.pop();
                int t2 = st.pop();
                ans = calculate(t2,t1,tokens[i]);
                st.push(ans);
            }
            else st.push(Integer.parseInt(tokens[i]));
            i++;
        }
        return st.pop();
    }
    public int calculate(int a, int b, String op) {
        switch (op) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;  
            case "%":
                return a % b;
            default:
                throw new IllegalArgumentException("Invalid operator");
        }
    }
}