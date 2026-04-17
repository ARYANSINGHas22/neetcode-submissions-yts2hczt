class Solution {

    // Encode list of strings to a single string
    public String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();

        for (String str : strs) {
            encoded.append(str.length()).append('#').append(str);
        }

        return encoded.toString();
    }

    // Decode single string back to list
    public List<String> decode(String s) {
        List<String> result = new ArrayList<>();
        Stack<Character> charStack = new Stack<>();

        // Push all characters into stack
        for (char c : s.toCharArray()) {
            charStack.push(c);
        }

        // Reverse stack to process left → right
        Stack<Character> tempStack = new Stack<>();
        while (!charStack.isEmpty()) {
            tempStack.push(charStack.pop());
        }

        while (!tempStack.isEmpty()) {

            // Step 1: Read length
            StringBuilder num = new StringBuilder();
            while (!tempStack.isEmpty() && tempStack.peek() != '#') {
                num.append(tempStack.pop());
            }

            tempStack.pop(); // remove '#'
            int length = Integer.parseInt(num.toString());

            // Step 2: Read string
            StringBuilder word = new StringBuilder();
            for (int i = 0; i < length; i++) {
                word.append(tempStack.pop());
            }

            result.add(word.toString());
        }

        return result;
    }
}