class Solution {
    public int minOperations(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int oper = 0;
        if (nums[1] - nums[0] == 1) {
            int a = 0;
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i + 1] > nums[i] && ((nums[i + 1] - nums[i]) == 1)) {
                    oper++;
                } else if (nums[i + 1] > nums[i]) {
                    return -1;
                } else {
                    a = i + 1;
                    break;
                }
            }
            if (oper == nums.length - 1) {
                return 0;
            }
            if (a == nums.length - 1) {
                return Math.min(oper + 1, 3);
            }
            for (int j = a; j < nums.length - 1; j++) {
                if ((nums[j + 1] - nums[j]) != 1) {
                    return -1;
                }
            }
            return Math.min(oper + 1, nums.length - a + 2);
        } else if (nums[0] - nums[1] == 1) {
            int b = 0;
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i + 1] < nums[i] && nums[i] - nums[i + 1] == 1) {
                    oper++;
                } else if (nums[i + 1] < nums[i]) {
                    return -1;
                } else {
                    b = i + 1;
                    break;
                }
            }
            if (oper == nums.length - 1) {
                return 1;
            }
            if (b == nums.length - 1) {
                return 2;
            }
            for (int j = b; j < nums.length - 1; j++) {
                if (nums[j + 1] > nums[j]) {
                    return -1;
                } else if (nums[j] - nums[j + 1] != 1) {
                    return -1;
                }
            }
            return Math.min(oper + 2, nums.length - b + 1);
        } else if (nums[0] < nums[1]) {
            if (nums[1] != nums.length - 1) {
                return -1;
            }
            for (int i = 1; i < nums.length - 1; i++) {
                if (nums[i] - nums[i + 1] != 1) {
                    return -1;
                }
            }
            return 2;
        } else if (nums[0] > nums[1]) {
            if (nums[1] != 0) {
                return -1;
            }
            for (int i = 1; i < nums.length - 1; i++) {
                if (nums[i + 1] - nums[i] != 1) {
                    return -1;
                }
            }
            return 1;
        }
        return -1;
    }
}