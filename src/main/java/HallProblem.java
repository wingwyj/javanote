import java.util.Random;

/**
 * @author wyj
 * @version 1.0
 * @date 2025/6/10
 */
public class HallProblem {
    public static void main(String[] args) {
        hallProblemTest(10000000);
    }

    /**
     * 模拟次数
     * @param n
     */
    public static void hallProblemTest(int n) {
        // 不换门赢的次数
        int notChangeWinCount  = 0;
        // 换门赢的次数
        int changeWinCount  = 0;

        Random random = new Random();

        for (int i = 0; i < n; i++) {
            // 随机汽车位置
            int carIndex = random.nextInt(3);
            // 玩家选择
            int playerIndex = random.nextInt(3);

            // 玩家不换门
            if (playerIndex == carIndex) {
                notChangeWinCount++;
            }

            // 换门情况
            // 主持人打开门的index
            int hostIndex;
            do {
                hostIndex = random.nextInt(3);
            } while (hostIndex == carIndex || hostIndex == playerIndex);

            // 换门index
            int changeIndex = 0;
            for (int j = 0; j < 3; j++) {
                if (j != playerIndex && j != hostIndex) {
                    changeIndex = j;
                    break;
                }
            }
            // 换门赢的统计
            if (changeIndex == carIndex) {
                changeWinCount++;
            }


        }

        System.out.println("不换门赢的概率:" + (double) notChangeWinCount / n);
        System.out.println("换门赢的概率:" + (double) changeWinCount / n);

    }
}
