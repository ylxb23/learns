package com.zero.learns.benchmark.seris.fastjson2;

import com.alibaba.fastjson2.JSON;
import com.zero.learns.benchmark.seris.*;
import org.mockito.Mockito;
import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

/**
 * com.zero.learns.fastjson2.Fastjson2Benchmark
 *
 * @author ylxb2
 * @since 2024/1/18 11:02
 */
@State(Scope.Benchmark)
@BenchmarkMode(Mode.Throughput)
@Warmup(iterations = 1, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 3, time = 1, timeUnit = TimeUnit.SECONDS)
public class Fastjson2Benchmark {
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

    @Setup(Level.Trial)
    public void init() {
        littlePropertiesValue = Mockito.mock(LittlePropertiesValue.class);
        littleString = JSON.toJSONString(littlePropertiesValue);
        elevenPropertiesValue = Mockito.mock(ElevenPropertiesValue.class);
        elevenString = JSON.toJSONString(elevenPropertiesValue);
        elevenDeepPropertiesValue = Mockito.mock(ElevenDeepPropertiesValue.class);
        elevenDeepString = JSON.toJSONString(elevenDeepPropertiesValue);
        hundredPropertiesValue = Mockito.mock(HundredPropertiesValue.class);
        hundredString = JSON.toJSONString(hundredPropertiesValue);
        thousandPropertiesValue = Mockito.mock(ThousandPropertiesValue.class);
        thousandString = JSON.toJSONString(thousandPropertiesValue);
    }

    @Benchmark
    @OperationsPerInvocation()
    public void benchmarkLittlePropertiesSerialize() {
        JSON.toJSONString(littlePropertiesValue);
    }
    @Benchmark
    @OperationsPerInvocation()
    public void benchmarkLittlePropertiesDeserialize() {
        JSON.parseObject(littleString, LittlePropertiesValue.class);
    }


    @Benchmark
    @OperationsPerInvocation()
    public void benchmarkElevenPropertiesValueSerialize() {
        JSON.toJSONString(elevenPropertiesValue);
    }
    @Benchmark
    @OperationsPerInvocation()
    public void benchmarkElevenPropertiesValueDeserialize() {
        JSON.parseObject(elevenString, ElevenPropertiesValue.class);
    }


    @Benchmark
    @OperationsPerInvocation()
    public void benchmarkElevenDeepPropertiesValueSerialize() {
        JSON.toJSONString(elevenDeepPropertiesValue);
    }
    @Benchmark
    @OperationsPerInvocation()
    public void benchmarkElevenDeepPropertiesValueDeserialize() {
        JSON.parseObject(elevenDeepString, ElevenDeepPropertiesValue.class);
    }



    @Benchmark
    @OperationsPerInvocation()
    public void benchmarkHundredPropertiesValueSerialize() {
        JSON.toJSONString(hundredPropertiesValue);
    }
    @Benchmark
    @OperationsPerInvocation()
    public void benchmarkHundredPropertiesValueDeserialize() {
        JSON.parseObject(hundredString, HundredPropertiesValue.class);
    }


    @Benchmark
    @OperationsPerInvocation()
    public void benchmarkThousandPropertiesValueSerialize() {
        JSON.toJSONString(thousandPropertiesValue);
    }
    @Benchmark
    @OperationsPerInvocation()
    public void benchmarkThousandPropertiesValueDeserialize() {
        JSON.parseObject(thousandString, ThousandPropertiesValue.class);
    }
}
