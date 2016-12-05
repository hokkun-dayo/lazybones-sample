package {{package}}.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.google.common.collect.Maps;

@Service
public class SampleService {

    public Map<String, Object> getHello() {
        Map<String, Object> map = Maps.newHashMap();
        map.put("hello", "Hello, world.");
        map.put("time", System.currentTimeMillis());
        return map;
    }

}
