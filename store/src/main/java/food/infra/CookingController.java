package food.infra;

import food.domain.*;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// @RequestMapping(value="/cookings")
@Transactional
public class CookingController {

    @Autowired
    CookingRepository cookingRepository;

    @RequestMapping(
        value = "cookings/{id}/aceeptorreject",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Cooking aceeptorReject(
        @PathVariable(value = "id") Long id,
        @RequestBody AceeptorRejectCommand aceeptorRejectCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /cooking/aceeptorReject  called #####");
        Optional<Cooking> optionalCooking = cookingRepository.findById(id);

        optionalCooking.orElseThrow(() -> new Exception("No Entity Found"));
        Cooking cooking = optionalCooking.get();
        cooking.aceeptorReject(aceeptorRejectCommand);

        cookingRepository.save(cooking);
        return cooking;
    }

    @RequestMapping(
        value = "cookings/{id}/start",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Cooking start(
        @PathVariable(value = "id") Long id,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /cooking/start  called #####");
        Optional<Cooking> optionalCooking = cookingRepository.findById(id);

        optionalCooking.orElseThrow(() -> new Exception("No Entity Found"));
        Cooking cooking = optionalCooking.get();
        cooking.start();

        cookingRepository.save(cooking);
        return cooking;
    }

    @RequestMapping(
        value = "cookings/{id}/finished",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Cooking finished(
        @PathVariable(value = "id") Long id,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /cooking/finished  called #####");
        Optional<Cooking> optionalCooking = cookingRepository.findById(id);

        optionalCooking.orElseThrow(() -> new Exception("No Entity Found"));
        Cooking cooking = optionalCooking.get();
        cooking.finished();

        cookingRepository.save(cooking);
        return cooking;
    }
}
