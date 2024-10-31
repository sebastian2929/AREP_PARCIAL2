package arep.parcial;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.Arrays;

@RestController
public class MathServices {

    @GetMapping("/linearsearch")
    public ResponseEntity<String> linearSearch(@RequestParam String list, @RequestParam String value) {
        String[] elements = list.split(",");
        int index = linearSearch(elements, value);
        return ResponseEntity.ok(formatResponse("linearSearch", list, value, index));
    }

    @GetMapping("/binarysearch")
    public ResponseEntity<String> binarySearch(@RequestParam String list, @RequestParam String value) {
        String[] elements = list.split(",");
        Arrays.sort(elements); // Ensure the list is sorted for binary search
        int index = binarySearch(elements, value, 0, elements.length - 1);
        return ResponseEntity.ok(formatResponse("binarySearch", list, value, index));
    }

    private int linearSearch(String[] list, String value) {
        for (int i = 0; i < list.length; i++) {
            if (list[i].equals(value)) {
                return i;
            }
        }
        return -1; // Not found
    }

    private int binarySearch(String[] list, String value, int left, int right) {
        if (right >= left) {
            int mid = left + (right - left) / 2;
            if (list[mid].equals(value)) {
                return mid;
            }
            if (list[mid].compareTo(value) > 0) {
                return binarySearch(list, value, left, mid - 1);
            }
            return binarySearch(list, value, mid + 1, right);
        }
        return -1; // Not found
    }

    private String formatResponse(String operation, String inputList, String value, int output) {
        return String.format("{\"operation\": \"%s\", \"inputlist\": \"%s\", \"value\": \"%s\", \"output\": \"%d\"}",
                operation, inputList, value, output);
    }
}
