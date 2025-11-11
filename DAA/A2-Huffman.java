import java.util.HashMap;
import java.util.PriorityQueue;

class HuffmanNode {
    char ch;
    int frequency;

    HuffmanNode left, right;

    HuffmanNode(
            char ch,
            int frequency
    ) {
        this.ch = ch;
        this.frequency = frequency;
        left = right = null;
    }
}


/**
 * Huffman encoding
 * <p>
 * internal nodes -> No data, just connect others
 * leaf nodes -> has data
 */
public class Huffman {

    /**
     * Created a freq map for the message
     *
     * @param map     Map
     * @param message Message
     */
    public static void createFreqMap(
            HashMap<Character, Integer> map,
            String message
    ) {
        for (char c : message.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
    }

    public static void buildHuffmanTree(PriorityQueue<HuffmanNode> queue) {
        while (queue.size() > 1) {
            HuffmanNode left = queue.poll();
            HuffmanNode right = queue.poll();

            //create internal node
            int rightFreq = 0;
            if (right != null) {
                rightFreq = right.frequency;
            }
            HuffmanNode internal = new HuffmanNode('$', left.frequency + rightFreq);

            internal.left = left;
            internal.right = right;
            queue.add(internal);
        }
    }

    public static void printTreeCodes(HuffmanNode root, StringBuilder code) {
        if (root == null) {
            return;
        }

        //print if not internal node
        if (root.ch != '$') {
            System.out.println(root.ch + " : " + code);
        }

        //traverse left tree
        if (root.left != null) {
            printTreeCodes(root.left, code.append('0'));

            //remove the last char before traversing the other paths
            code.deleteCharAt(code.length() - 1);
        }

        //traverse right tree
        if (root.right!= null) {
            printTreeCodes(root.right, code.append('1'));

            //remove the last char before traversing the other paths
            code.deleteCharAt(code.length() - 1);
        }

    }

    public static void main(String[] args) {

        HashMap<Character, Integer> freqMap = new HashMap<>();
        String message = "Throughout heaven and earth, I alone am the honoured one";

        PriorityQueue<HuffmanNode> queue = new PriorityQueue<>((a, b) -> a.frequency - b.frequency);

        //-------create map--------
        createFreqMap(freqMap, message);

        //add nodes to priority queue
        for (char c : freqMap.keySet()) {
            queue.add(new HuffmanNode(c, freqMap.getOrDefault(c, 0)));
        }

        buildHuffmanTree(queue);

        HuffmanNode root = queue.poll();

        printTreeCodes(root,new StringBuilder());

//        System.out.println(freqMap);

    }

}
