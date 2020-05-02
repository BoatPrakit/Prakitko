/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Model.Map;
import static Service.MonsterService.*;

/**
 *
 * @author Klitb
 */
public class MapService {
    
    public static void createForest(){
        Map newMap = new Map();
        newMap.addMonsterInMap(createSlime());
        newMap.addMonsterInMap(createWolf());
    }
    public static void createHideOut(){
        Map newMap = new Map();
        newMap.addMonsterInMap(createOrc());
        newMap.addMonsterInMap(createOrge());
    }
    public static void createGraveYard(){
        Map newMap = new Map();
        newMap.addMonsterInMap(createZombie());
        newMap.addMonsterInMap(createSkeletion());
    }
}
