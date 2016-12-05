package {{package}}

import groovy.util.logging.Slf4j
import org.springframework.boot.test.SpringApplicationConfiguration
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.web.WebAppConfiguration
import spock.lang.Specification

@Slf4j
@ActiveProfiles("TEST")
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
class WithSpringSpec extends Specification {
}
