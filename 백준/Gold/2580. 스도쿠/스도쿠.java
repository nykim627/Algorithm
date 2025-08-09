import java.io.*;
import java.util.*;

class Main {
    static ArrayList<Pos> arrList;
    static int[][] map;

    static class Pos {
        int x, y;
        public Pos(int x, int y) { this.x = x; this.y = y; }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        map = new int[9][9];
        arrList = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) arrList.add(new Pos(i, j));
            }
        }

        backTrackingDfs(0); // 한 해만 찾으면 멈춤

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) sb.append(map[i][j]).append(' ');
            sb.append('\n');
        }
        System.out.print(sb);
    }

    // 성공하면 true 반환하여 상위로 즉시 종료
    private static boolean backTrackingDfs(int idx) {
        if (idx == arrList.size()) return true; // 모든 빈칸을 채움

        Pos curr = arrList.get(idx);
        int x = curr.x, y = curr.y;

        for (int num = 1; num <= 9; num++) {
            if (!isValid(x, y, num)) continue;
            map[x][y] = num;
            if (backTrackingDfs(idx + 1)) return true; // 성공 전파
            map[x][y] = 0; // 실패 시 되돌리기
        }
        return false; // 이 칸에서 어떤 수로도 불가능
    }

    private static boolean isValid(int x, int y, int num) {
        // 행/열 검사
        for (int i = 0; i < 9; i++) {
            if (map[x][i] == num) return false;
            if (map[i][y] == num) return false;
        }
        // 3x3 박스 검사
        int bx = (x / 3) * 3, by = (y / 3) * 3;
        for (int i = bx; i < bx + 3; i++) {
            for (int j = by; j < by + 3; j++) {
                if (map[i][j] == num) return false;
            }
        }
        return true;
    }
}
