package Field;

import prototype.Monster;

public abstract class Map {
    
    private Monster monsterCollection[];
    private int count;
    
    public Map(){
    
    }
    
    public Map(Monster[] monsterCollection){
        this.monsterCollection = monsterCollection;
    }
    
    public void addMonster(Monster monster){
        Monster[] newMonsterCollection = new Monster[count+1];
        System.arraycopy(monsterCollection, 0, newMonsterCollection, 0, count);
        newMonsterCollection[count] = monster;
        count++;        
    }
    
    public void removeMonster(Monster monster){
        for (int i = 0; i < count; i++) {
            if (this.monsterCollection[i].getClass()==monster.getClass()) {
                for (int j = i; j < count-1; j++) {
                    monsterCollection[j] = monsterCollection[j+1];
                }
                monsterCollection[count] = null;
                count--;
            }
        }
    }

    public void fight(){
    
    }
    
    public void arrayCheck(){
    
    }
    
//    public abstract int spawnrate();
}
