package home.bilqu.sb.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class HoHealthCheck implements HealthIndicator {

    @Override
    public Health health() {
        int errorCode = checkHoHealth(); // perform some specific health check
        if (errorCode != 0) {
            return Health
                    .down()
                    .withDetail("Error Code", errorCode)
                    .build();
        }
        return Health.up().build();
    }

    //Logic
    public int checkHoHealth() {

        return 0;
    }
}
