package food.domain;

import food.domain.*;
import food.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class Regected extends AbstractEvent {

    private Long id;

    public Regected(Cooking aggregate) {
        super(aggregate);
    }

    public Regected() {
        super();
    }
}
