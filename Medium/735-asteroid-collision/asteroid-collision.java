import java.util.*;
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        List<Integer> st=new ArrayList<>();
        int n=asteroids.length;
        for(int i=0;i<n;i++){
            if(asteroids[i]>0)st.add(asteroids[i]);
            else{
                while (!st.isEmpty() && st.get(st.size() - 1) > 0 &&
                       st.get(st.size() - 1) < Math.abs(asteroids[i])) {
                    st.remove(st.size() - 1);
                }
                if (!st.isEmpty() && st.get(st.size() - 1) == Math.abs(asteroids[i])) {
                    st.remove(st.size() - 1);
                }
                else if(st.isEmpty() || st.get(st.size()-1)<0)st.add(asteroids[i]);
            }
        }
         return st.stream().mapToInt(Integer::intValue).toArray();  
      }
}