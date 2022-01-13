public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(
                solution.solution(
                    new int[] {100, 100, 100, -10},
                    new String[] {"2020-12-31", "2020-12-22", "2020-12-03", "2020-12-29"}
                )
        );
        System.out.println(
                solution.solution(
                        new int[] {180, -50, -25, -25},
                        new String[] {"2020-01-01", "2020-01-01", "2020-01-01", "2020-01-31"}
                )
        );
    }
}
