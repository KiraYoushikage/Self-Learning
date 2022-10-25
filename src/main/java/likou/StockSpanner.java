package likou;

import java.util.ArrayList;
import java.util.List;

class StockSpanner {

    private int max;
    private List<PairNum>pairNumList;
    public StockSpanner() {
        pairNumList=new ArrayList<>();
        max=Integer.MIN_VALUE;
    }
    
    public int next(int price) {
        PairNum pairNum=new PairNum();
        pairNumList.add(pairNum);
        pairNum.price=price;
        pairNum.count=1;
        if (price>max){
            pairNum.count= pairNumList.size();
            max=price;
            return pairNum.count;
        }
        int index=pairNumList.size()-2;
        while(index>=0){
            PairNum pairNumTemp=pairNumList.get(index);
            if (pairNumTemp.price<price)pairNum.count++;
            else if(pairNumTemp.price==price){
                pairNum.count+=pairNumTemp.count;
                return pairNum.count;
            }else {
                break;
            }
            index--;
        }
        return pairNum.count;
    }
    public static class PairNum{
        public int price;
        public int count;
    }

    public static void main(String[] args) {
        StockSpanner stockSpanner=new StockSpanner();
        int nums[]={28,14,28,35,46,53,66,80,87,88};
        for (int i = 0; i <nums.length ; i++) {
            System.out.println(stockSpanner.next(nums[i]));
        }
    }
}