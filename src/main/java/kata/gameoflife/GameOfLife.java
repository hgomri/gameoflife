package kata.gameoflife;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameOfLife {

    private Cell[][] gameGrid;
    private int nbrOfRows;
    private int nbrOfColumns;

    public GameOfLife(){

    }

    public GameOfLife(int nbrOfRows, int nbrOfColumns){
        this.nbrOfRows =nbrOfRows;
        this.nbrOfColumns = nbrOfColumns;
        gameGrid = new Cell[nbrOfRows][nbrOfColumns];
        for(int i=0; i< nbrOfRows; i++ ){
            for(int j=0; j< nbrOfColumns;j++){
                gameGrid[i][j] = new Cell();
            }
        }
    }

    public void computeNextGeneration(){

        for(int i=0; i< nbrOfRows ; i++){
            for(int j=0; j< nbrOfColumns;j++){
                int neighboursAlive= getNeighboursLiveCount(i,j);
                if( gameGrid[i][j].getAlive() && neighboursAlive < 2 ){
                    gameGrid[i][j].setAlive(Boolean.FALSE);
                }else if(gameGrid[i][j].getAlive() && neighboursAlive > 3){
                    gameGrid[i][j].setAlive(Boolean.FALSE);
                }
                else if(!gameGrid[i][j].getAlive() && neighboursAlive == 3){
                    gameGrid[i][j].setAlive(Boolean.TRUE);
                }
            }
        }
    }

    public void setAlive(int row , int column){
        gameGrid[row][column].setAlive(Boolean.TRUE);
    }

    public int getNeighboursLiveCount(int row, int column){
        int count = 0;
        List<Cell> neighbours = new ArrayList();

        for(int i = Math.max(0, row-1); i <= Math.min(row+1,nbrOfRows-1 ); i++){
            for(int j = Math.max(0, column-1); j <= Math.min(column+1, nbrOfColumns-1); j++){
                if(i != row || j != column){
                    neighbours.add(gameGrid[i][j]);
                }
            }
        }

        for(int i=0 ; i< neighbours.size();i++){
            if(neighbours.get(i).getAlive()){
                count++;
            }
        }
        return count;
    }


    public int getNbrOfRows() {
        return nbrOfRows;
    }

    public void setNbrOfRows(int nbrOfRows) {
        this.nbrOfRows = nbrOfRows;
    }

    public int getNbrOfColumns() {
        return nbrOfColumns;
    }

    public void setNbrOfColumns(int nbrOfColumns) {
        this.nbrOfColumns = nbrOfColumns;
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
        for(int i=0; i< this.nbrOfRows;i++){
            for(int j = 0; j< this.nbrOfColumns; j++){
                result.append(gameGrid[i][j] + " ");
            }
            result.append("\n");
        }
        return result.toString();
    }

}
