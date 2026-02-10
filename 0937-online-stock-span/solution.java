class StockSpanner {
    Stack<Integer> st;
    ArrayList<Integer> arr;
    int i;
    public StockSpanner() {
        st=new Stack<>();
        arr=new ArrayList<>();
        i=0;
    }
    
    public int next(int price) {
        arr.add(price);
        while(!st.isEmpty() && arr.get(i)>=arr.get(st.peek())){
            st.pop();
        }
        int span;
        if(st.isEmpty()){
            span=i+1;
        }
        else{
            span=i-st.peek();
        }
        st.push(i);
        i++;
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
