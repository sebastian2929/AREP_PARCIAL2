package arep.parcial;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping("/proxy")
public class ProxyServer {

    // Endpoint para realizar la búsqueda lineal
    @GetMapping("/linearsearch")
    public ResponseEntity<?> linearSearch(@RequestParam String list, @RequestParam String value) {
        String[] elements = list.split(","); // Divide la lista de entrada en un arreglo
        int index = linearSearch(elements, value); // Realiza la búsqueda lineal
        return ResponseEntity.ok(formatResponse("linearSearch", list, value, index));
    }

    // Endpoint para realizar la búsqueda binaria
    @GetMapping("/binarysearch")
    public ResponseEntity<?> binarySearch(@RequestParam String list, @RequestParam String value) {
        String[] elements = list.split(","); // Divide la lista de entrada en un arreglo
        Arrays.sort(elements); // Ordena la lista para la búsqueda binaria
        int index = binarySearch(elements, value, 0, elements.length - 1); // Realiza la búsqueda binaria
        return ResponseEntity.ok(formatResponse("binarySearch", list, value, index));
    }

    // Método de búsqueda lineal
    private int linearSearch(String[] list, String value) {
        for (int i = 0; i < list.length; i++) {
            if (list[i].equals(value)) {
                return i; // Retorna el índice si se encuentra el valor
            }
        }
        return -1; // Retorna -1 si no se encuentra el valor
    }

    // Método de búsqueda binaria
    private int binarySearch(String[] list, String value, int left, int right) {
        if (right >= left) {
            int mid = left + (right - left) / 2; // Calcula el punto medio
            if (list[mid].equals(value)) {
                return mid; // Retorna el índice si se encuentra el valor
            }
            if (list[mid].compareTo(value) > 0) {
                return binarySearch(list, value, left, mid - 1); // Llama recursivamente en la mitad izquierda
            }
            return binarySearch(list, value, mid + 1, right); // Llama recursivamente en la mitad derecha
        }
        return -1; // Retorna -1 si no se encuentra el valor
    }

    // Formatea la respuesta en JSON con el resultado de la búsqueda
    private String formatResponse(String operation, String inputList, String value, int output) {
        return String.format("{\"operation\": \"%s\", \"inputlist\": \"%s\", \"value\": \"%s\", \"output\": \"%d\"}",
                operation, inputList, value, output);
    }
}
