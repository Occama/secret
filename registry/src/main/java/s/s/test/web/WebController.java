package s.s.test.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import s.s.test.domain.model.DAO.UserDAO;
import s.s.test.domain.model.Device;
import s.s.test.domain.model.User;

import java.util.UUID;

@Controller
public class WebController {
    @RequestMapping("/devices")
    public String devices(ModelMap model) {
        model.addAttribute("message", "Hello Spring MVC Framework!");
        return "devices";
    }

    @RequestMapping("/stats")
    public String stats(ModelMap model) {
        model.addAttribute("message", "Hello Spring MVC Framework!");
        return "stats";
    }

    @RequestMapping(path="/add", method=RequestMethod.GET)
    public String add(ModelMap model) {
        User user = new User();
        user.setId(1);
        user.setLogin("razor");
        user.setPassword("23456");
        Device device = new Device();
        device.setSerialNo("123456");
        device.setDescription("qwerty");
        device.setId(UUID.randomUUID());
        device.setType("lol");
        user.addDevice(device);
        UserDAO.save(user);
        model.addAttribute("message", "Hello Spring MVC Framework!");
        return "add";
    }

    @RequestMapping(path="/add", method=RequestMethod.POST)
    public String process(ModelMap model) {
        model.addAttribute("message", "Hello Spring MVC Framework!");
        return "add";
    }
}
