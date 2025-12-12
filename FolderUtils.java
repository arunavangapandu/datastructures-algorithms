import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

public class FolderUtils {
    public static String generateUniqueFolderName(List<String> existingFolders) {
        String baseName = "New Folder";
        // Use a HashSet for O(1) lookups
        Set<String> existingSet = new HashSet<>(existingFolders);

        // Case 1: "New Folder" itself doesn't exist
        if (!existingSet.contains(baseName)) {
            return baseName;
        }

        // Case 2: Check "New Folder(2)", "New Folder(3)", etc.
        int i = 2;
        while (true) {
            String candidate = baseName + "(" + i + ")";
            if (!existingSet.contains(candidate)) {
                return candidate;
            }
            i++;
        }
    }

    public static void main(String[] args) {
        // Test case 1: User provided example (assuming typos in user input regarding spaces)
        // Note: The user wrote "NewFolder(3)" (no space) but "New Folder" (with space).
        // If we strictly follow the generation rule "New Folder(N)", "NewFolder(3)" is just a different name.
        List<String> folders1 = Arrays.asList("New Folder", "NewFolder(3)", "NewFolder(4)");
        System.out.println("Input: " + folders1);
        System.out.println("Output: " + generateUniqueFolderName(folders1));

        // Test case 2: Standard spacing
        List<String> folders2 = Arrays.asList("New Folder", "New Folder(3)", "New Folder(4)");
        System.out.println("\nInput: " + folders2);
        System.out.println("Output: " + generateUniqueFolderName(folders2));
        
        // Test case 3: Filling the gap
        List<String> folders3 = Arrays.asList("New Folder", "New Folder(2)", "New Folder(4)");
        System.out.println("\nInput: " + folders3);
        System.out.println("Output: " + generateUniqueFolderName(folders3));
    }
}


