package com.application.configuration;

import io.r2dbc.spi.ConnectionFactories;
import io.r2dbc.spi.ConnectionFactory;
import io.r2dbc.spi.ConnectionFactoryOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@Configuration
@EnableR2dbcRepositories
public class R2DBCConfiguration extends AbstractR2dbcConfiguration {

  @Value("${db.server.driver}")
  private String driver;

  @Value("${db.server.protocol}")
  private String protocol;

  @Value("${db.server.host}")
  private String host;

  @Value("${db.server.port}")
  private int port;

  @Value("${db.server.schema}")
  private String schema;

  @Value("${db.server.user}")
  private String user;

  @Value("${db.server.password}")
  private String password;

  @Bean
  public ConnectionFactory connectionFactory() {
    ConnectionFactoryOptions options =
            ConnectionFactoryOptions.builder()
                    .option(ConnectionFactoryOptions.DRIVER, driver)
                    .option(ConnectionFactoryOptions.PROTOCOL, protocol)
                    .option(ConnectionFactoryOptions.HOST, host)
                    .option(ConnectionFactoryOptions.PORT, port)
                    .option(ConnectionFactoryOptions.DATABASE, schema)
                    .option(ConnectionFactoryOptions.USER, user)
                    .option(ConnectionFactoryOptions.PASSWORD, password)
                    .build();

    return ConnectionFactories.get(options);
  }
}
