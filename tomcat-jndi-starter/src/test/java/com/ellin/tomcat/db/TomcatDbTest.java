package com.ellin.tomcat.db;


import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.AutoConfigurations;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;

import static org.assertj.core.api.Assertions.assertThat;



class TomcatDbTest {
    private final ApplicationContextRunner contextRunner = new ApplicationContextRunner()
            .withConfiguration(AutoConfigurations.of(TomcatDb.class));

    @Test
    void clientExists() {
        this.contextRunner.run((context) -> assertThat(context).hasSingleBean(TomcatServletWebServerFactory.class));
    }

}