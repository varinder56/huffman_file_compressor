package huffman;

public class HuffmanNode {

    int byteValue;
    long frequency;

    HuffmanNode left;
    HuffmanNode right;

    public HuffmanNode(int byteValue, long frequency) {
        this.byteValue = byteValue;
        this.frequency = frequency;
    }
}
