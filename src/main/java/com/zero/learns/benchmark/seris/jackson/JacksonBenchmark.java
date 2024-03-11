package com.zero.learns.benchmark.seris.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zero.learns.benchmark.seris.*;
import org.mockito.Mockito;
import org.mockito.internal.creation.MockSettingsImpl;
import org.mockito.internal.stubbing.defaultanswers.ReturnsMocks;
import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

/**
 * com.zero.learns.jackson.JacksonBenchmark
 *
 * @author ylxb2
 * @since 2024/1/18 11:01
 */
@State(Scope.Benchmark)
@BenchmarkMode(Mode.Throughput)
@Warmup(iterations = 1, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 3, time = 1, timeUnit = TimeUnit.SECONDS)
public class JacksonBenchmark {
    private LittlePropertiesValue littlePropertiesValue;
    private String littleString;
    private ElevenPropertiesValue elevenPropertiesValue;
    private String elevenString;
    private ElevenDeepPropertiesValue elevenDeepPropertiesValue;
    private String elevenDeepString;
    private HundredPropertiesValue hundredPropertiesValue;
    private String hundredString;
    private ThousandPropertiesValue thousandPropertiesValue;
    private String thousandString;

    private ObjectMapper objectMapper;

    @Setup(Level.Trial)
    public void init() throws JsonProcessingException {
        objectMapper = new ObjectMapper();
        littlePropertiesValue = Mockito.mock(LittlePropertiesValue.class, new MockSettingsImpl<>().defaultAnswer(new ReturnsMocks()));
        littleString = objectMapper.writeValueAsString(littlePropertiesValue);
        elevenPropertiesValue = Mockito.mock(ElevenPropertiesValue.class);
        elevenString = objectMapper.writeValueAsString(elevenPropertiesValue);
        elevenDeepPropertiesValue = Mockito.mock(ElevenDeepPropertiesValue.class);
        elevenDeepString = objectMapper.writeValueAsString(elevenDeepPropertiesValue);
        hundredPropertiesValue = Mockito.mock(HundredPropertiesValue.class);
        hundredString = objectMapper.writeValueAsString(hundredPropertiesValue);
        thousandPropertiesValue = Mockito.mock(ThousandPropertiesValue.class);
        thousandString = objectMapper.writeValueAsString(thousandPropertiesValue);
    }

    @Benchmark
    @OperationsPerInvocation()
    public void benchmarkLittlePropertiesSerialize() throws JsonProcessingException {
        objectMapper.writeValueAsString(littlePropertiesValue);
    }
    @Benchmark
    @OperationsPerInvocation()
    public void benchmarkLittlePropertiesDeserialize() throws JsonProcessingException {
        objectMapper.readValue(littleString, LittlePropertiesValue.class);
    }


    @Benchmark
    @OperationsPerInvocation()
    public void benchmarkElevenPropertiesValueSerialize() throws JsonProcessingException {
        objectMapper.writeValueAsString(elevenPropertiesValue);
    }
    @Benchmark
    @OperationsPerInvocation()
    public void benchmarkElevenPropertiesValueDeserialize() throws JsonProcessingException {
        objectMapper.readValue(elevenString, ElevenPropertiesValue.class);
    }


    @Benchmark
    @OperationsPerInvocation()
    public void benchmarkElevenDeepPropertiesValueSerialize() throws JsonProcessingException {
        objectMapper.writeValueAsString(elevenDeepPropertiesValue);
    }
    @Benchmark
    @OperationsPerInvocation()
    public void benchmarkElevenDeepPropertiesValueDeserialize() throws JsonProcessingException {
        objectMapper.readValue(elevenDeepString, ElevenDeepPropertiesValue.class);
    }



    @Benchmark
    @OperationsPerInvocation()
    public void benchmarkHundredPropertiesValueSerialize() throws JsonProcessingException {
        objectMapper.writeValueAsString(hundredPropertiesValue);
    }
    @Benchmark
    @OperationsPerInvocation()
    public void benchmarkHundredPropertiesValueDeserialize() throws JsonProcessingException {
        objectMapper.readValue(hundredString, HundredPropertiesValue.class);
    }


    @Benchmark
    @OperationsPerInvocation()
    public void benchmarkThousandPropertiesValueSerialize() throws JsonProcessingException {
        objectMapper.writeValueAsString(thousandPropertiesValue);
    }
    @Benchmark
    @OperationsPerInvocation()
    public void benchmarkThousandPropertiesValueDeserialize() throws JsonProcessingException {
        objectMapper.readValue(thousandString, ThousandPropertiesValue.class);
    }
}
