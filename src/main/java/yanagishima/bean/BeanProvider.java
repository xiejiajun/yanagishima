package yanagishima.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.google.inject.Injector;

import yanagishima.config.YanagishimaConfig;
import yanagishima.pool.StatementPool;
import yanagishima.repository.TinyOrm;
import yanagishima.service.HiveService;

@Component
public class BeanProvider {
  private final HiveService hiveService;
  private final StatementPool statements;
  private final YanagishimaConfig config;
  private final TinyOrm db;

  @Autowired
  public BeanProvider(Injector injector) {
    this.hiveService = injector.getInstance(HiveService.class);
    this.statements = injector.getInstance(StatementPool.class);
    this.config = injector.getInstance(YanagishimaConfig.class);
    this.db = injector.getInstance(TinyOrm.class);
  }

  @Bean
  public HiveService hiveService() {
    return hiveService;
  }

  @Bean
  public StatementPool statements() {
    return statements;
  }

  @Bean
  public YanagishimaConfig config() {
    return config;
  }

  @Bean
  public TinyOrm db() {
    return db;
  }
}
