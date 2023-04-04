package food.domain;

import food.domain.*;
import food.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class DeliveryComfirmed extends AbstractEvent {

    private Long id;

    public DeliveryComfirmed(Delivery aggregate) {
        super(aggregate);
    }

    public DeliveryComfirmed() {
        super();
    }
}
