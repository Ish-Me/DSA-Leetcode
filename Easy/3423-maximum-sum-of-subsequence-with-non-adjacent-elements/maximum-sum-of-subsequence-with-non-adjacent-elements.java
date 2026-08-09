class Solution {
    static final long NEG = Long.MIN_VALUE / 4;
    static final int MOD = 1_000_000_007;
    long[][] tree;
    int n;

    public int maximumSumSubsequence(int[] nums, int[][] queries) {
        n = nums.length;
        tree = new long[4 * n][4];
        build(1, 0, n - 1, nums);

        long answer = 0;

        for (int[] query : queries) {
            update(1, 0, n - 1, query[0], query[1]);

            long current = 0;
            for (int i = 0; i < 4; i++) {
                current = Math.max(current, tree[1][i]);
            }

            answer = (answer + current) % MOD;
        }

        return (int) answer;
    }

    void build(int node, int l, int r, int[] nums) {
        if (l == r) {
            setLeaf(node, nums[l]);
            return;
        }

        int mid = (l + r) / 2;
        build(node * 2, l, mid, nums);
        build(node * 2 + 1, mid + 1, r, nums);
        merge(node);
    }

    void setLeaf(int node, int value) {
        tree[node][0] = 0;
        tree[node][1] = NEG;
        tree[node][2] = NEG;
        tree[node][3] = Math.max(0L, (long) value);
    }

    void merge(int node) {
        long[] left = tree[node * 2];
        long[] right = tree[node * 2 + 1];
        long[] result = new long[4];

        Arrays.fill(result, NEG);

        for (int ls = 0; ls < 4; ls++) {
            for (int rs = 0; rs < 4; rs++) {
                int leftLast = ls & 1;
                int rightFirst = (rs >> 1) & 1;

                if (leftLast == 1 && rightFirst == 1) {
                    continue;
                }

                int first = (ls >> 1) & 1;
                int last = rs & 1;
                int state = (first << 1) | last;

                if (left[ls] == NEG || right[rs] == NEG) {
                    continue;
                }
                result[state] = Math.max(
                    result[state],
                    left[ls] + right[rs]
                );
            }
        }
        tree[node] = result;
    }

    void update(int node, int l, int r, int pos, int value) {
        if (l == r) {
            setLeaf(node, value);
            return;
        }
        int mid = (l + r) / 2;
        if (pos <= mid) {
            update(node * 2, l, mid, pos, value);
        } else {
            update(node * 2 + 1, mid + 1, r, pos, value);
        }
        merge(node);
    }
}