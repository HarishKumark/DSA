/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsa;

import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 *
 * @author hkorada
 */
class State {

    int row;
    int col;
    String keys;
    int moves;

    public State(int row, int col, String keys, int moves) {
        this.row = row;
        this.col = col;
        this.keys = keys;
        this.moves = moves;
    }
}

public class LowestMovesToAcquireKeys {

    public int shortestPathAllKeys(String[] grid) {
        int m = grid.length;
        int n = grid[0].length();
        int targetKeys = 0;
        int startRow = -1;
        int startCol = -1;

        // Find the starting position and count the target keys
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = grid[i].charAt(j);
                if (c == '@') {
                    startRow = i;
                    startCol = j;
                } else if (c >= 'a' && c <= 'f') {
                    targetKeys |= (1 << (c - 'a')); // Set the bit for the key
                }
            }
        }

        Queue<State> queue = new java.util.LinkedList<>();
        Set<String> visited = new HashSet<>();
        State initialState = new State(startRow, startCol, "", 0);
        queue.offer(initialState);
        visited.add(startRow + "," + startCol + ",");

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!queue.isEmpty()) {
            State state = queue.poll();
            int row = state.row;
            int col = state.col;
            String keys = state.keys;
            int moves = state.moves;

            // Check if all keys have been collected
            if (keys.length() == Integer.bitCount(targetKeys)) {
                return moves;
            }

            // Explore
            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && grid[newRow].charAt(newCol) != '#') {
                    char nextCell = grid[newRow].charAt(newCol);
                    String nextKeys = keys;
                    int nextMoves = moves + 1;
                    if (nextCell >= 'a' && nextCell <= 'f') {
                        nextKeys += nextCell; // Collect the key
                    } else if (nextCell >= 'A' && nextCell <= 'F' && !keys.contains(Character.toLowerCase(nextCell) + "")) {
                        continue; // Skip if the lock is not opened
                    }

                    String nextStateKey = newRow + "," + newCol + "," + nextKeys;
                    if (!visited.contains(nextStateKey)) {
                        queue.offer(new State(newRow, newCol, nextKeys, nextMoves));
                        visited.add(nextStateKey);
                    }
                }
            }
        }

        return -1; // Impossible to acquire all keys

    }

    public static void main(String[] args) {
        System.out.println("val == " + new LowestMovesToAcquireKeys().shortestPathAllKeys(new String[]{"@.a..", "###.#", "b.A.B"}));
    }
}
