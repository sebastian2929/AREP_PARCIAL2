package arep.parcial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ProxyServer {
    @Autowired
    private RoundRobin roundRobin;

    @GetMapping("/proxy/linearsearch")
    public String proxyLinearSearch(@RequestParam String list, @RequestParam String value) {
        String serviceUrl = roundRobin.getNextServiceUrl() + "/linearsearch?list=" + list + "&value=" + value;
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(serviceUrl, String.class);
    }

    @GetMapping("/proxy/binarysearch")
    public String proxyBinarySearch(@RequestParam String list, @RequestParam String value) {
        String serviceUrl = roundRobin.getNextServiceUrl() + "/binarysearch?list=" + list + "&value=" + value;
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(serviceUrl, String.class);
    }
}
