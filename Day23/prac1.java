public class prac1{
    public static void main(String[] args) {
        int n=4;
        for (int i = 0; i < n; i++) {
            for(int k=0;k<(n-i+1);k++){
                System.out.print(" ");
            }
            for(int j=0;j<=i;j++){
                System.out.print(i+1+" ");
            }
            System.out.println();
        }
    }
}
