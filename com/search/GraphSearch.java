package com.search;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class GraphSearch {

    // Sample graph
    private static HashMap<String, String[]> graph = new HashMap<>();

    public static void main(String[] args) {
        // Initialize the graph
        graph.put("you", new String[] {"alice", "bob", "claire"});
        graph.put("alice", new String[] {"peggy"});
        graph.put("bob", new String[] {"anuj", "peggy"});
        graph.put("claire", new String[] {"thom", "jonny"});
        graph.put("peggy", new String[] {});
        graph.put("anuj", new String[] {});
        graph.put("thom", new String[] {});
        graph.put("jonny", new String[] {});

        // Call the search function
        search("you");
    }

    // Function to check if a person is a mango seller (for demonstration purposes, let's assume names ending with 'm' are sellers)
    public static boolean personIsSeller(String name) {
        return name.endsWith("m"); // Assuming people whose names end with "m" are mango sellers
    }

    // Breadth-First Search (BFS) algorithm
    public static boolean search(String name) {
        // Create a queue for the search and a set to track searched nodes
        Queue<String> searchQueue = new LinkedList<>();
        Set<String> searched = new HashSet<>();

        // Add all neighbors of the starting node to the queue
        for (String person : graph.get(name)) {
            searchQueue.add(person);
        }

        // Perform BFS
        while (!searchQueue.isEmpty()) {
            String person = searchQueue.poll(); // Dequeue the first person

            // Check if this person has already been searched
            if (!searched.contains(person)) { // ②

                // Check if this person is a mango seller
                if (personIsSeller(person)) {
                    System.out.println(person + " is a mango seller!");
                    return true;
                } else {
                    // If not, add their neighbors to the queue
                    for (String neighbor : graph.get(person)) {
                        searchQueue.add(neighbor);
                    }
                    // Mark this person as searched
                    searched.add(person); // ③
                }
            }
        }

        // If no mango seller is found
        return false;
    }
}
