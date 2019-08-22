package s.s.test.web;

import com.google.gson.GsonBuilder;
import org.springframework.http.MediaType;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import s.s.test.domain.model.Device;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    @RequestMapping(value = "/api/devices", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String apiDevices(ModelMap model) {
        model.addAttribute("message", "Hello Spring MVC Framework!");
        return (new GsonBuilder().create()).toJson(new Device());
    }
}
