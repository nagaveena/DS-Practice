/*
 *Sample Input
 * 4
1100
1110
0110
0001

*Sample Output
*2
*
*Explanation
**We have n = 4 zombies numbered z0 through z3. There are 2 pairs of zombies who directly know each another: (z0, z1) and (z1, z2). 
**Because of zombiism's transitive property, the set of zombies {z0, z1, z2} is considered to be a single zombie cluster. The remaining zombie, z3, 
**doesn't know any other zombies and is considered to be his own, separate zombie cluster ({z3}). This gives us a total of 2 zombie clusters.
 */
public class ZombieCluster {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    static int zombieCluster(String[] zombies) {
        if(zombies == null) {
            return -1;
        }
        
        int[][] zombieGrid = buildGrid(zombies);
        int count = 0;
        
        for(int i=0;i<zombieGrid.length;i++) {
            if(zombieGrid[i][i]==0) {
                continue;
            } else {
                explore(zombieGrid, i);
                count += 1;
            }
        }
        
        return count;
    }
    
    static void explore(int[][] zombieGrid, int i) {
        if(i<0||i>=zombieGrid.length) return;
        
        if(zombieGrid[i][i]==0) {
            return;
        }
        
        zombieGrid[i][i]=0;
        for(int neighbor = 0; neighbor<zombieGrid[0].length;neighbor++) {
            if(zombieGrid[neighbor][neighbor] == 0) {
                zombieGrid[i][neighbor] = 0;
            } else if(zombieGrid[i][neighbor]==1) {
                explore(zombieGrid, neighbor);
            }
        }
    }
    
    static int[][] buildGrid(String[] zombies) {
        int[][] zombieGrid = new int[zombies.length][zombies[0].length()];
        
        for(int i=0;i<zombies.length;i++) {
            for(int j=0;j<zombies[0].length();j++) {
                zombieGrid[i][j] = zombies[i].charAt(j)-'0';
            }
        }
     return zombieGrid;
        
    }

}
