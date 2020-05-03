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

    public static Map createForest() {
        Map newMap = new Map();
        newMap.clearMonster();
        newMap.addMonsterInMap(createSlime());
        newMap.addMonsterInMap(createWolf());
        return newMap;
    }

    public static Map createHideOut() {
        Map newMap = new Map();
        newMap.clearMonster();
        newMap.addMonsterInMap(createOrc());
        newMap.addMonsterInMap(createOrge());
        return newMap;
    }

    public static Map createGraveYard() {
        Map newMap = new Map();
        newMap.clearMonster();
        newMap.addMonsterInMap(createZombie());
        newMap.addMonsterInMap(createSkeletion());
        return newMap;
    }
}
