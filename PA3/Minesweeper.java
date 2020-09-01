public class Minesweeper {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        int k = Integer.parseInt(args[2]);

        String[][] arr = new String[m][n];
        int count = 0;
        while(count < k){
            int rand = (int)(Math.random()*m*n);
            int row = rand/n;
            int column = rand%n;
            if (arr[row][column] != "*"){
                arr[row][column]="*";
                count += 1;
            }
        }

        for( int i = 0; i < m; i++ ){
            for( int j = 0; j < n; j++ ){
                if (arr[i][j] != "*"){
                    int cnt = 0;
                    if (i+1 < m && j+1<n && arr[i+1][j+1]=="*")   cnt+=1;
                    if (i+1 < m && arr[i+1][j]=="*")              cnt+=1;
                    if (i+1 < m && j-1>=0 && arr[i+1][j-1]=="*")  cnt+=1;
                    if (i-1 >= 0 && j+1<n && arr[i-1][j+1]=="*")  cnt+=1;
                    if (i-1 >= 0 && arr[i-1][j]=="*")             cnt+=1;
                    if (i-1 >= 0 && j-1>=0 && arr[i-1][j-1]=="*") cnt+=1;
                    if ( j+1 <n  && arr[i][j+1]=="*")             cnt+=1;
                    if ( j-1>=0 && arr[i][j-1]=="*")              cnt+=1;
                    arr[i][j] = Integer.toString(cnt);
                }
            }
        }

        for( int i = 0; i < m; i++ ){
            for( int j = 0; j < n; j++ ){
               System.out.print(arr[i][j]+" ");
            }
            System.out.println("");
        }

    }
}
