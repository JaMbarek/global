//package com.example.databus.client;
//
//import com.linkedin.databus.container.netty.HttpRelay;
//import com.linkedin.databus.core.util.InvalidConfigException;
//import com.linkedin.databus2.core.DatabusException;
//import com.linkedin.databus2.relay.DatabusRelayMain;
//import com.linkedin.databus2.relay.config.PhysicalSourceStaticConfig;
//
//import java.io.IOException;
//
//public class Main extends DatabusRelayMain {
//
//    public Main() throws IOException, InvalidConfigException, DatabusException {
//        this(new HttpRelay.Config(), null);
//    }
//
//    public Main(HttpRelay.Config config, PhysicalSourceStaticConfig[] pConfigs)
//            throws IOException, InvalidConfigException, DatabusException {
//        this(config.build(), pConfigs);
//    }
//
//    public Main(HttpRelay.StaticConfig config, PhysicalSourceStaticConfig[] pConfigs)
//            throws IOException, InvalidConfigException, DatabusException {
//        super(config, pConfigs);
//    }
//
//
//    public static void main(String[] args) throws Exception {
////E:\github\global\databus\relay\src\main\resources\source\person.json
//
//        HttpRelay.Cli cli = new HttpRelay.Cli();
//        cli.setDefaultPhysicalSrcConfigFiles("E:\\github\\global\\databus\\relay\\src\\main\\resources\\source\\person.json");
//
//        cli.processCommandLineArgs(args);
//        cli.parseRelayConfig();
//
//        PhysicalSourceStaticConfig[] pStaticConfigs = cli.getPhysicalSourceStaticConfigs();
//
//        HttpRelay.StaticConfig staticConfig = cli.getRelayConfigBuilder().build();
//
//        // Create and initialize the server instance
//        DatabusRelayMain serverContainer = new DatabusRelayMain(staticConfig, pStaticConfigs);
//
//        serverContainer.initProducers();
//        serverContainer.registerShutdownHook();
//        serverContainer.startAndBlock();
//    }
//
//}
