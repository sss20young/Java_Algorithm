class P_Level3_자물쇠와열쇠 {
    static int keySize;
    static int lockSize;
    static int[][] expandedLock;

    public static void main(String[] args) {
        int[][] key = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
        int[][] lock = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        solution(key, lock);
    }
    
    public static boolean solution(int[][] key, int[][] lock) {
        
        keySize = key.length;
        lockSize = lock.length;

        // lock 확장
        int size = lockSize + (keySize - 1) * 2;
        expandedLock = new int[size][size];
        for (int i = keySize-1; i < keySize-1+lockSize; i++) {
            for (int j = keySize-1; j < keySize-1+lockSize; j++) {
                expandedLock[i][j] = lock[i-(keySize-1)][j-(keySize-1)];
            }
        }
        
        // key 회전시키면서 
        for (int i = 0; i < 4; i++) {
            key = rotate(key);
            
            // key와 맞는 구역
            for (int j = 0; j < keySize+lockSize-1; j++) {
                for (int k = 0; k < keySize+lockSize-1; k++) {
                    if (match(j, k, key)) {
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
    
    static int[][] rotate(int[][] array) {
        
        int n = array.length;
        int[][] newArray = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                newArray[j][n-i-1] = array[i][j]; 
            }
        }

        return newArray;
    }
    
    static boolean match (int a, int b, int[][] key) {
        // copy
        int[][] test = new int[expandedLock.length][expandedLock.length];
        for (int i = 0; i < expandedLock.length; i++) {
            for (int j = 0; j < expandedLock.length; j++) {
                test[i][j] = expandedLock[i][j];
            }
        }
        
        // 홈과 돌기부분 합치기 -> 1
        for (int i = 0; i < keySize; i++) {
            for (int j = 0; j < keySize; j++) {
                test[i+a][j+b] += key[i][j];
            }
        }
        
        // lock에 홈 부분이 모두 채워졌는지 확인
        for (int i = keySize-1; i < keySize-1+lockSize; i++) {
            for (int j = keySize-1; j < keySize-1+lockSize; j++) {
                if (test[i][j] != 1)
                    return false;
            }
        }
        
        return true;
    }
}