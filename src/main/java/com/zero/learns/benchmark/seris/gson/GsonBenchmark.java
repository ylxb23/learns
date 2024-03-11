package com.zero.learns.benchmark.seris.gson;

import com.google.gson.Gson;
import com.zero.learns.benchmark.seris.*;
import org.mockito.Mockito;
import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

/**
 * com.zero.learns.gson.GsonBenchmark
 *
 * @author ylxb2
 * @since 2024/1/18 11:01
 */
@State(Scope.Benchmark)
@BenchmarkMode(Mode.Throughput)
@Warmup(iterations = 1, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 3, time = 1, timeUnit = TimeUnit.SECONDS)
public class GsonBenchmark {
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
    
    private Gson gson = new Gson();

    @Setup(Level.Trial)
    public void init() {
        littlePropertiesValue = Mockito.mock(LittlePropertiesValue.class);
        littleString = gson.toJson(littlePropertiesValue);
        elevenPropertiesValue = Mockito.mock(ElevenPropertiesValue.class);
        elevenString = gson.toJson(elevenPropertiesValue);
        elevenDeepPropertiesValue = Mockito.mock(ElevenDeepPropertiesValue.class);
        elevenDeepString = gson.toJson(elevenDeepPropertiesValue);
        hundredPropertiesValue = Mockito.mock(HundredPropertiesValue.class);
        hundredString = gson.toJson(hundredPropertiesValue);
        thousandPropertiesValue = Mockito.mock(ThousandPropertiesValue.class);
        thousandString = gson.toJson(thousandPropertiesValue);
    }

    @Benchmark
    @OperationsPerInvocation()
    public void benchmarkLittlePropertiesSerialize() {
        gson.toJson(littlePropertiesValue);
    }
    @Benchmark
    @OperationsPerInvocation()
    public void benchmarkLittlePropertiesDeserialize() {
        gson.fromJson(littleString, LittlePropertiesValue.class);
    }


    @Benchmark
    @OperationsPerInvocation()
    public void benchmarkElevenPropertiesValueSerialize() {
        gson.toJson(elevenPropertiesValue);
    }
    @Benchmark
    @OperationsPerInvocation()
    public void benchmarkElevenPropertiesValueDeserialize() {
        gson.fromJson(elevenString, ElevenPropertiesValue.class);
    }


    @Benchmark
    @OperationsPerInvocation()
    public void benchmarkElevenDeepPropertiesValueSerialize() {
        gson.toJson(elevenDeepPropertiesValue);
    }
    @Benchmark
    @OperationsPerInvocation()
    public void benchmarkElevenDeepPropertiesValueDeserialize() {
        gson.fromJson(elevenDeepString, ElevenDeepPropertiesValue.class);
    }



    @Benchmark
    @OperationsPerInvocation()
    public void benchmarkHundredPropertiesValueSerialize() {
        gson.toJson(hundredPropertiesValue);
    }
    @Benchmark
    @OperationsPerInvocation()
    public void benchmarkHundredPropertiesValueDeserialize() {
        gson.fromJson(hundredString, HundredPropertiesValue.class);
    }


    @Benchmark
    @OperationsPerInvocation()
    public void benchmarkThousandPropertiesValueSerialize() {
        gson.toJson(thousandPropertiesValue);
    }
    @Benchmark
    @OperationsPerInvocation()
    public void benchmarkThousandPropertiesValueDeserialize() {
        gson.fromJson(thousandString, ThousandPropertiesValue.class);
    }
}
