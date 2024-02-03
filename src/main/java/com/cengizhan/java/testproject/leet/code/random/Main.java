package com.cengizhan.java.testproject.leet.code.random;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Main {
    public static int FirstFactorial(int num) {
        if (num == 0) {
            return 1;
        } else if (num < 18 && num > 0) {
            return num * FirstFactorial(num - 1);
        } else {
            return -1;
        }
    }

    public static int BracketCombinations(int num) {
        return FirstFactorial(num * 2) / (FirstFactorial(num + 1) * FirstFactorial(num));
    }

    public static int[] twoSum(int[] nums, int target) { // array,sort,stream,indexOf
        int[] firstArray = Arrays.copyOf(nums, nums.length);
        Arrays.sort(nums);
        int[] newArray = Arrays.stream(nums).sorted().filter(i -> i <= target - nums[0]).toArray();
        for (int i = 0; i < newArray.length; i++) {
            for (int j = i + 1; j < newArray.length; j++) {
                if (newArray[i] + newArray[j] == target) {
                    int index1 = indexOf(firstArray, newArray[i]);
                    int index2 = indexOf(firstArray, newArray[j]) == index1 ? indexOf(firstArray, newArray[j]) + 1 : indexOf(firstArray, newArray[j]);
                    return new int[]{index1, index2};
                }
            }
        }
        return new int[]{-1, -1};
    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x == 0) {
            return true;
        }
        if (x % 10 == 0) {
            return false;
        }
        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }
        return x == revertedNumber || x == revertedNumber / 10;
    }

    // Dizideki bir elemanın indeksini bulan yardımcı metot
    public static int indexOf(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }




    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else if (c == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
            } else if (c == '}' && !stack.isEmpty() && stack.peek() == '{') {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }



    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int low = i + 1;
                int high = nums.length - 1;
                int sum = 0 - nums[i];
                while (low < high) {
                    if (nums[low] + nums[high] == sum) {
                        list.add(Arrays.asList(nums[i], nums[low], nums[high]));
                        while (low < high && nums[low] == nums[low + 1]) low++;
                        while (low < high && nums[high] == nums[high - 1]) high--;
                        low++;
                        high--;
                    } else if (nums[low] + nums[high] < sum) {
                        low++;
                    } else {
                        high--;
                    }
                }
            }
        }
        return list;
    }

    public static int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        System.out.println(Arrays.toString(nums));
        return i + 1;
    }

    public int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    public static int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        return nums.length;
    }

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            Set<Character> set = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.' && !set.add(board[i][j])) {
                    return false;
                }
            }
        }
        for (int i = 0; i < 9; i++) {
            Set<Character> set = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[j][i] != '.' && !set.add(board[j][i])) {
                    return false;
                }
            }
        }
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                Set<Character> set = new HashSet<>();
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        if (board[i + k][j + l] != '.' && !set.add(board[i + k][j + l])) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static String TreeConstructor(String[] strArr) {
        List<Integer> solSayilar = new ArrayList<>();
        List<Integer> sagSayilar = new ArrayList<>();
        for (String input : strArr) {
            String[] sayilar = sayilariAyir(input);
            solSayilar.add(Integer.parseInt(sayilar[0]));
            sagSayilar.add(Integer.parseInt(sayilar[1]));
        }
        return strArr[0];
    }

    public static String[] sayilariAyir(String input) {
        Pattern pattern = Pattern.compile("\\((\\d+),(\\d+)\\)");
        Matcher matcher = pattern.matcher(input);

        if (matcher.matches()) {
            String solSayi = matcher.group(1);
            String sagSayi = matcher.group(2);
            return new String[]{solSayi, sagSayi};
        } else {
            throw new IllegalArgumentException("Geçersiz formatta giriş: " + input);
        }
    }

    public static boolean StringChallenge(String str) {
        String cleanStr = str.replaceAll("\\s+", "").replaceAll("[^a-zA-Z]", "").toUpperCase();
        StringBuilder reversedString = new StringBuilder(cleanStr).reverse();
        String result = reversedString.toString().toUpperCase();
        return result.equals(cleanStr);
    }

    public static int MathChallenge(String str) {
        int result;
        String containXNum = "";
        int notContainXNum = 0;
        String[] words = str.split("=");
        int x = words[0].length() > 1 ? 0 : 1;
        String[] beforeEqualsNums = words[x].trim().split(" ");
        if (words[x == 0 ? 1 : 0].contains("x")) {
            return operation2(beforeEqualsNums[1], Integer.parseInt(beforeEqualsNums[0]), Integer.parseInt(beforeEqualsNums[2]));
        }else {
            containXNum = beforeEqualsNums[0].contains("x") ? beforeEqualsNums[0] :  beforeEqualsNums[2];
            notContainXNum = Integer.parseInt(beforeEqualsNums[0].contains("x") ? beforeEqualsNums[2] :  beforeEqualsNums[0]);
        }
        result =operation(beforeEqualsNums[1],  Integer.parseInt(words[x == 0 ? 1 : 0].trim()), notContainXNum);
        if(containXNum.length() == 1){
            return result;
        }else {
            for (int i = 0; i < containXNum.length(); i++) {
                if (containXNum.charAt(i) == 'x') {
                    String resultStr = String.valueOf(result);
                    return Integer.parseInt(String.valueOf(resultStr.charAt(i)));
                }
            }
        }
        return result;
    }
    public static int operation(String operator, int result, int notContainXNum) {
        System.out.println(operator);
        switch (operator) {
            case "+" -> result -= notContainXNum;
            case "-" -> result += notContainXNum;
            case "*" -> result /= notContainXNum;
            case "/" -> result *= notContainXNum;
        }
        return result;
    }
    public static int operation2(String operator, int result, int notContainXNum) {
        switch (operator) {
            case "+" -> result += notContainXNum;
            case "-" -> result -= notContainXNum;
            case "*" -> result *= notContainXNum;
            case "/" -> result /= notContainXNum;
        }
        return result;
    }



    public static String GradeChallenge(String[] str) {
        int numberOfLetters = Integer.parseInt(str[0]);
        String[] letters = Arrays.copyOfRange(str, 1, numberOfLetters + 1);
        String[] paths = Arrays.copyOfRange(str, numberOfLetters + 1, str.length);
        Map<String, List<String>> graph = buildGraph(letters, paths);

        String start = str[1];
        String end = str[numberOfLetters];

        List<String> shortestPath = findShortestPath(graph, start, end);
        StringBuilder result = new StringBuilder();
//        for (int i = 0; i < shortestPath.size(); i++) {
//           result.append(shortestPath.get(i));
//
//        }
       return shortestPath.toString();
    }

    private static Map<String, List<String>> buildGraph(String[] letters, String[] paths) {
        Map<String, List<String>> graph = new HashMap<>();

        for (String letter : letters) {
            graph.put(letter, new ArrayList<>());
        }

        for (String path : paths) {
            String[] nodes = path.split("-");
            graph.get(nodes[0]).add(nodes[1]);
            graph.get(nodes[1]).add(nodes[0]);
        }
        System.out.println(graph);
        return graph;
    }
    private static List<String> findShortestPath(Map<String, List<String>> graph, String start, String end) {
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        Map<String, String> parentMap = new HashMap<>();

        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            String current = queue.poll();

            for (String neighbor : graph.get(current)) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                    parentMap.put(neighbor, current);
                }
            }
        }

        return buildPath(parentMap, start, end);
    }
    private static List<String> buildPath(Map<String, String> parentMap, String start, String end) {
        List<String> path = new ArrayList<>();
        String current = end;

        while (current != null) {
            path.add(current);
            current = parentMap.get(current);
        }

        Collections.reverse(path);

        return path;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
//        System.out.println(MathChallenge("1x0 * 12 = 1200"));
        String[] str = {"5","A","B","C","D","F","A-B","A-C","B-C","C-D","D-F"};
        System.out.println("En kısa yol: " + GradeChallenge(str));
    }

}