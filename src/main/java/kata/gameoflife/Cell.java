package kata.gameoflife;

public class Cell {

    private Boolean isAlive = Boolean.FALSE;

    public Boolean getAlive() {
        return isAlive;
    }

    public void setAlive(Boolean alive) {
        isAlive = alive;
    }

    @Override
    public String toString(){
        if(this.isAlive){
            return "*";
        }
        return ".";
    }
}
