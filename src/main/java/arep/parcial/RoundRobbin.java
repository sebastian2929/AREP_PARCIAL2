import org.springframework.stereotype.Service;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class RoundRobbin {

    private List<String> serviceUrls = List.of("http://localhost:8081", "http://localhost:8082"); // Cambia estas URLs a las de tus servicios reales
    private AtomicInteger currentIndex = new AtomicInteger(0);

    public String getNextServiceUrl() {
        int index = currentIndex.getAndUpdate(i -> (i + 1) % serviceUrls.size());
        return serviceUrls.get(index);
    }
}
