/**
An array is provided with a number with integers that repeat exactly twice except one integer.
**/
public class SingleNonDuplicate{

    public SingleNonDuplicate(){

    }

    public static void main(String[] args){
        int[] nums = { 1, 1, 2, 3, 3, 4, 4, 5, 5};
        SingleNonDuplicate single  = new SingleNonDuplicate();
        System.out.println("The number that stands out is "+single.helper(nums, 0, nums.length-1));
    }

    // a helper function that provides a recursive solution to give out number
    public int helper(int[] nums, int x, int y){
        int mid = x + (y-x)/2;
        //System.out.println("Mid value is "+mid+ " x value "+x+" y value "+y);
        if(x == y){ //That means the solution has moved towards an answer
          return nums[x];
        }
        if((nums[mid] == nums[mid-1])){
            if(mid % 2 == 0){   //The part of the list is even
                return helper(nums, x, mid-1);
            }else{
                return helper(nums, mid+1, y);
            }
        }else if((nums[mid] == nums[mid+1])){
            if(mid % 2 == 0){   //The part of the list is even
                return helper(nums, mid+1, y);
            }else{
                return helper(nums, x, mid-1);
            }
        }
        return nums[mid];
    }
}
