class Solution {
    public List<Integer> majorityElement(int[] v) {
        List<Integer> list = new ArrayList<>();
        int cn1=0,cn2=0;
        int el1 = Integer.MIN_VALUE;
        int el2 = Integer.MIN_VALUE;
        for(int i=0;i<v.length;i++){
            if(cn1 == 0 && v[i]!=el2){
                cn1=1;
                el1=v[i];
            }
            else if(cn2 == 0 && v[i]!=el1){
                cn2=1;
                el2=v[i];
            }
            else if(v[i] == el1)cn1++;
            else if(v[i] == el2)cn2++;
            else{
                cn1--;cn2--;
            }
        }
        cn1=0;cn2=0;
        int mini = (int)v.length/3 ;
        for(int i=0;i<v.length;i++){
            if(el1==v[i])cn1++;
            if(el2==v[i])cn2++;
        }
        if(cn1>mini)list.add(el1);
        if(cn2>mini)list.add(el2);

        return list;
    }
}