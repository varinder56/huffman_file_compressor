package huffman;

import java.io.FileInputStream;
import java.io.IOException;

public class FrequencyCounter {

    private final long[] frequencies = new long[256];

    public void countFrequencies(String filePath) throws IOException {

        try (FileInputStream input = new FileInputStream(filePath)) {

            int value;

            while ((value = input.read()) != -1) {
                frequencies[value]++;
            }
        }
    }

    public long[] getFrequencies() {
        return frequencies;
    }
}