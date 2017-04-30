import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation{
    WeightedQuickUnionUF unionArr;
    private int size;
    private boolean open[][];
    
    // create n-by-n grid, with all sites blocked
    public Percolation(int n){
       size = n;
       unionArr = new WeightedQuickUnionUF(n*n + 2);
       open = new boolean[n][n];
        
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                open[i][j] = false;
            }
        }
        connectToTopBot();
    }
    
    public boolean testConnected(int x, int y){
        return unionArr.connected(x,y);
    }
    
    // open site (row, col) if it is not open already
    public void open(int row, int col){
        if (isFull(row,col)){
            open[row][col] = true;
            
            //Make unions for these
            if (validateIndicies(row + 1, col) ){
                if ( isOpen(row+1, col) ){
                    open[row+1][col] = true;
                    unionArr.union(xyTo1D(row,col),xyTo1D(row+1,col));
                }
            }
                
            if (validateIndicies(row, col + 1) ){
                if ( isOpen(row, col + 1) ){
                    open[row][col+1] = true;
                    unionArr.union(xyTo1D(row,col),xyTo1D(row,col+1));
                }
            }
                
            if (validateIndicies(row - 1, col)){
                if (isOpen(row - 1, col)){
                    open[row-1][col] = true;
                    unionArr.union(xyTo1D(row,col),xyTo1D(row-1,col));
                }
            }
                
            if (validateIndicies(row, col - 1)){
                if (isOpen(row, col - 1)){
                    open[row][col-1] = true;
                    unionArr.union(xyTo1D(row,col),xyTo1D(row,col-1));
                }
            }
                
                
        }
    }
    
    public boolean isOpen(int row,int col){
        return open[row][col];
    }
    
    public boolean isFull(int row, int col){
        return !isOpen(row,col);
    }
    
    public int numberOfOpenSites(){
        return unionArr.count();
    }
    
    public boolean percolates(){
       return unionArr.connected(0,size + 1);
    }
    
    private void connectToTopBot(){
        for (int i = 0; i < size; i++){
            unionArr.union(0,xyTo1D(0,i));
            unionArr.union( size + 1 ,xyTo1D(size-1,i));
        }
    }
    
    private int xyTo1D(int x, int y){
        return ( x*open.length + y +1);
    }
    
    private boolean validateIndicies(int x, int y){
        return (x >= 0 && x < size && y >= 0 && y < size);
    }
    
    //Test Code
   public static void main(String[] args){
       Percolation perc = new Percolation(5);
      perc.open(1,1);
     perc.open(1,2);
        System.out.print(perc.isOpen(1,1));
    }
  
}
