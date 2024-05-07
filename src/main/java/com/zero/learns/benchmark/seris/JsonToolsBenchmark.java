package com.zero.learns.benchmark.seris;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.mockito.Mockito;
import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

/**
 * com.zero.learns.seris.JsonSerDeserBenchmark
 *
 * @author ylxb2
 * @since 2024/1/18 20:20
 */
@State(Scope.Benchmark)
@BenchmarkMode(Mode.Throughput)
@Warmup(iterations = 1, time = 3, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 3, time = 3, timeUnit = TimeUnit.SECONDS)
public class JsonToolsBenchmark {

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
    private ObjectMapper objectMapper = new ObjectMapper();

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


    // --------- fastjson -----------
    @Benchmark
    @OperationsPerInvocation()
    public void fastjsonBenchmarkLittlePropertiesSerialize() {
        JSON.toJSONString(littlePropertiesValue);
    }
    @Benchmark
    @OperationsPerInvocation()
    public void fastjsonBenchmarkLittlePropertiesDeserialize() {
        JSON.parseObject(littleString, LittlePropertiesValue.class);
    }

    @Benchmark
    @OperationsPerInvocation()
    public void fastjsonBenchmarkElevenPropertiesValueSerialize() {
        JSON.toJSONString(elevenPropertiesValue);
    }
    @Benchmark
    @OperationsPerInvocation()
    public void fastjsonBenchmarkElevenPropertiesValueDeserialize() {
        JSON.parseObject(elevenString, ElevenPropertiesValue.class);
    }

    @Benchmark
    @OperationsPerInvocation()
    public void fastjsonBenchmarkElevenDeepPropertiesValueSerialize() {
        JSON.toJSONString(elevenDeepPropertiesValue);
    }
    @Benchmark
    @OperationsPerInvocation()
    public void fastjsonBenchmarkElevenDeepPropertiesValueDeserialize() {
        JSON.parseObject(elevenDeepString, ElevenDeepPropertiesValue.class);
    }

    @Benchmark
    @OperationsPerInvocation()
    public void fastjsonBenchmarkHundredPropertiesValueSerialize() {
        JSON.toJSONString(hundredPropertiesValue);
    }
    @Benchmark
    @OperationsPerInvocation()
    public void fastjsonBenchmarkHundredPropertiesValueDeserialize() {
        JSON.parseObject(hundredString, HundredPropertiesValue.class);
    }

    @Benchmark
    @OperationsPerInvocation()
    public void fastjsonBenchmarkThousandPropertiesValueSerialize() {
        JSON.toJSONString(thousandPropertiesValue);
    }
    @Benchmark
    @OperationsPerInvocation()
    public void fastjsonBenchmarkThousandPropertiesValueDeserialize() {
        JSON.parseObject(thousandString, ThousandPropertiesValue.class);
    }

    // --------- fastjson -----------
    // --------- fastjson2 -----------

    @Benchmark
    @OperationsPerInvocation()
    public void fastjson2BenchmarkLittlePropertiesSerialize() {
        com.alibaba.fastjson2.JSON.toJSONString(littlePropertiesValue);
    }
    @Benchmark
    @OperationsPerInvocation()
    public void fastjson2BenchmarkLittlePropertiesDeserialize() {
        com.alibaba.fastjson2.JSON.parseObject(littleString, LittlePropertiesValue.class);
    }

    @Benchmark
    @OperationsPerInvocation()
    public void fastjson2BenchmarkElevenPropertiesValueSerialize() {
        com.alibaba.fastjson2.JSON.toJSONString(elevenPropertiesValue);
    }
    @Benchmark
    @OperationsPerInvocation()
    public void fastjson2BenchmarkElevenPropertiesValueDeserialize() {
        com.alibaba.fastjson2.JSON.parseObject(elevenString, ElevenPropertiesValue.class);
    }

    @Benchmark
    @OperationsPerInvocation()
    public void fastjson2BenchmarkElevenDeepPropertiesValueSerialize() {
        com.alibaba.fastjson2.JSON.toJSONString(elevenDeepPropertiesValue);
    }
    @Benchmark
    @OperationsPerInvocation()
    public void fastjson2BenchmarkElevenDeepPropertiesValueDeserialize() {
        com.alibaba.fastjson2.JSON.parseObject(elevenDeepString, ElevenDeepPropertiesValue.class);
    }

    @Benchmark
    @OperationsPerInvocation()
    public void fastjson2BenchmarkHundredPropertiesValueSerialize() {
        com.alibaba.fastjson2.JSON.toJSONString(hundredPropertiesValue);
    }
    @Benchmark
    @OperationsPerInvocation()
    public void fastjson2BenchmarkHundredPropertiesValueDeserialize() {
        com.alibaba.fastjson2.JSON.parseObject(hundredString, HundredPropertiesValue.class);
    }

    @Benchmark
    @OperationsPerInvocation()
    public void fastjson2BenchmarkThousandPropertiesValueSerialize() {
        com.alibaba.fastjson2.JSON.toJSONString(thousandPropertiesValue);
    }
    @Benchmark
    @OperationsPerInvocation()
    public void fastjson2BenchmarkThousandPropertiesValueDeserialize() {
        com.alibaba.fastjson2.JSON.parseObject(thousandString, ThousandPropertiesValue.class);
    }
    // --------- fastjson2 -----------
    // --------- gson -----------
    @Benchmark
    @OperationsPerInvocation()
    public void gsonBenchmarkLittlePropertiesSerialize() {
        gson.toJson(littlePropertiesValue);
    }
    @Benchmark
    @OperationsPerInvocation()
    public void gsonBenchmarkLittlePropertiesDeserialize() {
        gson.fromJson(littleString, LittlePropertiesValue.class);
    }

    @Benchmark
    @OperationsPerInvocation()
    public void gsonBenchmarkElevenPropertiesValueSerialize() {
        gson.toJson(elevenPropertiesValue);
    }
    @Benchmark
    @OperationsPerInvocation()
    public void gsonBenchmarkElevenPropertiesValueDeserialize() {
        gson.fromJson(elevenString, ElevenPropertiesValue.class);
    }

    @Benchmark
    @OperationsPerInvocation()
    public void gsonBenchmarkElevenDeepPropertiesValueSerialize() {
        gson.toJson(elevenDeepPropertiesValue);
    }
    @Benchmark
    @OperationsPerInvocation()
    public void gsonBenchmarkElevenDeepPropertiesValueDeserialize() {
        gson.fromJson(elevenDeepString, ElevenDeepPropertiesValue.class);
    }

    @Benchmark
    @OperationsPerInvocation()
    public void gsonBenchmarkHundredPropertiesValueSerialize() {
        gson.toJson(hundredPropertiesValue);
    }
    @Benchmark
    @OperationsPerInvocation()
    public void gsonBenchmarkHundredPropertiesValueDeserialize() {
        gson.fromJson(hundredString, HundredPropertiesValue.class);
    }

    @Benchmark
    @OperationsPerInvocation()
    public void gsonBenchmarkThousandPropertiesValueSerialize() {
        gson.toJson(thousandPropertiesValue);
    }
    @Benchmark
    @OperationsPerInvocation()
    public void gsonBenchmarkThousandPropertiesValueDeserialize() {
        gson.fromJson(thousandString, ThousandPropertiesValue.class);
    }
    // --------- gson -----------
    // --------- jackson -----------
    @Benchmark
    @OperationsPerInvocation()
    public void jacksonBenchmarkLittlePropertiesSerialize() throws JsonProcessingException {
        objectMapper.writeValueAsString(littlePropertiesValue);
    }
    @Benchmark
    @OperationsPerInvocation()
    public void jacksonBenchmarkLittlePropertiesDeserialize() throws JsonProcessingException {
        objectMapper.readValue(littleString, LittlePropertiesValue.class);
    }

    @Benchmark
    @OperationsPerInvocation()
    public void jacksonBenchmarkElevenPropertiesValueSerialize() throws JsonProcessingException {
        objectMapper.writeValueAsString(elevenPropertiesValue);
    }
    @Benchmark
    @OperationsPerInvocation()
    public void jacksonBenchmarkElevenPropertiesValueDeserialize() throws JsonProcessingException {
        objectMapper.readValue(elevenString, ElevenPropertiesValue.class);
    }

    @Benchmark
    @OperationsPerInvocation()
    public void jacksonBenchmarkElevenDeepPropertiesValueSerialize() throws JsonProcessingException {
        objectMapper.writeValueAsString(elevenDeepPropertiesValue);
    }
    @Benchmark
    @OperationsPerInvocation()
    public void jacksonBenchmarkElevenDeepPropertiesValueDeserialize() throws JsonProcessingException {
        objectMapper.readValue(elevenDeepString, ElevenDeepPropertiesValue.class);
    }

    @Benchmark
    @OperationsPerInvocation()
    public void jacksonBenchmarkHundredPropertiesValueSerialize() throws JsonProcessingException {
        objectMapper.writeValueAsString(hundredPropertiesValue);
    }
    @Benchmark
    @OperationsPerInvocation()
    public void jacksonBenchmarkHundredPropertiesValueDeserialize() throws JsonProcessingException {
        objectMapper.readValue(hundredString, HundredPropertiesValue.class);
    }

    @Benchmark
    @OperationsPerInvocation()
    public void jacksonBenchmarkThousandPropertiesValueSerialize() throws JsonProcessingException {
        objectMapper.writeValueAsString(thousandPropertiesValue);
    }
    @Benchmark
    @OperationsPerInvocation()
    public void jacksonBenchmarkThousandPropertiesValueDeserialize() throws JsonProcessingException {
        objectMapper.readValue(thousandString, ThousandPropertiesValue.class);
    }
    // --------- jackson -----------
}
