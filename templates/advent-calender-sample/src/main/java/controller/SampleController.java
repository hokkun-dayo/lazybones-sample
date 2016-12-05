package {{package}}.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import {{package}}.service.SampleService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class SampleController {
    @Autowired
    SampleService sampleService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(ModelMap modelMap) {
        log.info("echo");
        modelMap.addAllAttributes(sampleService.getHello());
        return "index";
    }
}
