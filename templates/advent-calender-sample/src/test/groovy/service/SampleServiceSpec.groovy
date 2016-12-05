package {{package}}.service

import {{package}}.WithSpringSpec
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired

@Slf4j
class SampleServiceSpec extends WithSpringSpec {
    @Autowired
    SampleService sampleService

    def "GetHello"() {
        setup:
        log.info(sampleService.getHello().get("hello") as String)
        def map = sampleService.getHello()

        expect:
        map.size() == 2
        map.get("hello") == "Hello, world."
        map.get("time") instanceof Long
    }
}
