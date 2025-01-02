import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while ( t > 0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++){
                arr[i] = sc.nextInt();
            }
            int target = sc.nextInt();
            int ans = solve(arr,target,arr.length-1);
            System.out.println(ans);
            t--;
        }
        sc.close();
    }
    public static int solve(int[] arr, int target,int i){
        if (target == 0){
            return 1;
        }
    if ( i == 0){
        if ( arr[0] == target ){
            return 1;
        }
        else{
            return 0;
        }
    }
        int pick = 0;
        if ( target >= arr[i] ){
            pick = solve(arr,target-arr[i],i-1);
        }
        int notpick = solve(arr,target,i-1);
        return pick + notpick;
    }
}
