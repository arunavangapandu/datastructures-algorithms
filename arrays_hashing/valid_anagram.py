class Solution:
    """
    Problem: Given two strings s and t, return true if t is an anagram of s, and false otherwise.
    An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
    typically using all the original letters exactly once.
    """
    def isAnagram(self, s: str, t: str) -> bool:
        if s is None or t is None:
            return False
        
        if len(s) != len(t):
            return False
            
        # Create Frequency Map
        frequency_map = {}
        
        for c in s:
            frequency_map[c] = frequency_map.get(c, 0) + 1
            
        # Loop through string t and lookup in frequency map
        for c in t:
            if c not in frequency_map:
                return False
            else:
                count = frequency_map[c]
                if count == 0:
                    return False
                frequency_map[c] = count - 1
                
        return True

if __name__ == "__main__":
    solution = Solution()
    
    # Test Case 1
    s1, t1 = "anagram", "nagaram"
    print(f"Test Case 1: {solution.isAnagram(s1, t1)}") # Expected: True

    # Test Case 2
    s2, t2 = "rat", "car"
    print(f"Test Case 2: {solution.isAnagram(s2, t2)}") # Expected: False
