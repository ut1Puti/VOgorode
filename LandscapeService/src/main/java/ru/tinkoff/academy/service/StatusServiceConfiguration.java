package ru.tinkoff.academy.service;

import io.grpc.Channel;
import net.devh.boot.grpc.client.channelfactory.InProcessChannelFactory;
import net.devh.boot.grpc.client.config.GrpcChannelsProperties;
import net.devh.boot.grpc.client.interceptor.GlobalClientInterceptorRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.tinkoff.academy.proto.StatusServiceGrpc;

@Configuration
public class StatusServiceConfiguration {
    @Bean
    public StatusServiceGrpc.StatusServiceBlockingStub foo(@Autowired ApplicationContext applicationContext) {
        GrpcChannelsProperties grpcChannelsProperties = new GrpcChannelsProperties();
        Channel channel = new InProcessChannelFactory(grpcChannelsProperties, new GlobalClientInterceptorRegistry(applicationContext)).createChannel("channel1");
        return StatusServiceGrpc.newBlockingStub(channel);
    }
}
