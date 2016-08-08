package blah;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * This dark theme is really messing up my shit.
 */
@RestController
public class BowlingGameController {

    @RequestMapping("/bowling/nextthrow")
    public boolean registerNextThrow(@RequestParam int score) {
        return true;
    }

}
