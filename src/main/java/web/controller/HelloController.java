package web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import web.model.WorldModel;

@RestController
@RequestMapping(value = "/hello")
public class HelloController {
	
    private static final Logger log = LoggerFactory.getLogger(HelloController.class);

    WorldModel model;
    
    public HelloController(WorldModel model) {
    	this.model = model;
    }

    @GetMapping(value = "/world")
    public WorldModel world(){
        return model;
    }
    
    @PostMapping(value = "/world")
    public WorldModel setWorld(@RequestBody WorldModel world){
        model.setValue(world.getValue());
        log.info("set value : {}",model.getValue());
        return world;
    }
    
}