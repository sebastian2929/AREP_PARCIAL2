package arep.parcial;

import org.springframework.stereotype.Component;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class RoundRobin {
    private final List<String> serviceUrls; // Lista de URLs de los servicios MathServices
    private final AtomicInteger index = new AtomicInteger(0);

    public RoundRobin(List<String> serviceUrls) {
        this.serviceUrls = serviceUrls;
    }

    public String getNextServiceUrl() {
        int currentIndex = index.getAndUpdate(i -> (i + 1) % serviceUrls.size());
        return serviceUrls.get(currentIndex);
    }
}
