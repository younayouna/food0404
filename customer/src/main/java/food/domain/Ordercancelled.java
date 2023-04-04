package food.domain;

import food.domain.*;
import food.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class Ordercancelled extends AbstractEvent {

    private Long id;

    public Ordercancelled(Order aggregate) {
        super(aggregate);
    }

    public Ordercancelled() {
        super();
    }
}
