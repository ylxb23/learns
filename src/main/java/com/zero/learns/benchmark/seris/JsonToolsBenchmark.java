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
    public void FastjsonBenchmarkLittlePropertiesSerialize() {
        JSON.toJSONString(littlePropertiesValue);
    }
    @Benchmark
    @OperationsPerInvocation()
    public void FastjsonBenchmarkLittlePropertiesDeserialize() {
        JSON.parseObject(littleString, LittlePropertiesValue.class);
    }

    @Benchmark
    @OperationsPerInvocation()
    public void FastjsonBenchmarkElevenPropertiesValueSerialize() {
        JSON.toJSONString(elevenPropertiesValue);
    }
    @Benchmark
    @OperationsPerInvocation()
    public void FastjsonBenchmarkElevenPropertiesValueDeserialize() {
        JSON.parseObject(elevenString, ElevenPropertiesValue.class);
    }

    @Benchmark
    @OperationsPerInvocation()
    public void FastjsonBenchmarkElevenDeepPropertiesValueSerialize() {
        JSON.toJSONString(elevenDeepPropertiesValue);
    }
    @Benchmark
    @OperationsPerInvocation()
    public void FastjsonBenchmarkElevenDeepPropertiesValueDeserialize() {
        JSON.parseObject(elevenDeepString, ElevenDeepPropertiesValue.class);
    }

    @Benchmark
    @OperationsPerInvocation()
    public void FastjsonBenchmarkHundredPropertiesValueSerialize() {
        JSON.toJSONString(hundredPropertiesValue);
    }
    @Benchmark
    @OperationsPerInvocation()
    public void FastjsonBenchmarkHundredPropertiesValueDeserialize() {
        JSON.parseObject(hundredString, HundredPropertiesValue.class);
    }

    @Benchmark
    @OperationsPerInvocation()
    public void FastjsonBenchmarkThousandPropertiesValueSerialize() {
        JSON.toJSONString(thousandPropertiesValue);
    }
    @Benchmark
    @OperationsPerInvocation()
    public void FastjsonBenchmarkThousandPropertiesValueDeserialize() {
        JSON.parseObject(thousandString, ThousandPropertiesValue.class);
    }

    // --------- fastjson -----------
    // --------- fastjson2 -----------

    @Benchmark
    @OperationsPerInvocation()
    public void Fastjson2BenchmarkLittlePropertiesSerialize() {
        com.alibaba.fastjson2.JSON.toJSONString(littlePropertiesValue);
    }
    @Benchmark
    @OperationsPerInvocation()
    public void Fastjson2BenchmarkLittlePropertiesDeserialize() {
        com.alibaba.fastjson2.JSON.parseObject(littleString, LittlePropertiesValue.class);
    }

    @Benchmark
    @OperationsPerInvocation()
    public void Fastjson2BenchmarkElevenPropertiesValueSerialize() {
        com.alibaba.fastjson2.JSON.toJSONString(elevenPropertiesValue);
    }
    @Benchmark
    @OperationsPerInvocation()
    public void Fastjson2BenchmarkElevenPropertiesValueDeserialize() {
        com.alibaba.fastjson2.JSON.parseObject(elevenString, ElevenPropertiesValue.class);
    }

    @Benchmark
    @OperationsPerInvocation()
    public void Fastjson2BenchmarkElevenDeepPropertiesValueSerialize() {
        com.alibaba.fastjson2.JSON.toJSONString(elevenDeepPropertiesValue);
    }
    @Benchmark
    @OperationsPerInvocation()
    public void Fastjson2BenchmarkElevenDeepPropertiesValueDeserialize() {
        com.alibaba.fastjson2.JSON.parseObject(elevenDeepString, ElevenDeepPropertiesValue.class);
    }

    @Benchmark
    @OperationsPerInvocation()
    public void Fastjson2BenchmarkHundredPropertiesValueSerialize() {
        com.alibaba.fastjson2.JSON.toJSONString(hundredPropertiesValue);
    }
    @Benchmark
    @OperationsPerInvocation()
    public void Fastjson2BenchmarkHundredPropertiesValueDeserialize() {
        com.alibaba.fastjson2.JSON.parseObject(hundredString, HundredPropertiesValue.class);
    }

    @Benchmark
    @OperationsPerInvocation()
    public void Fastjson2BenchmarkThousandPropertiesValueSerialize() {
        com.alibaba.fastjson2.JSON.toJSONString(thousandPropertiesValue);
    }
    @Benchmark
    @OperationsPerInvocation()
    public void Fastjson2BenchmarkThousandPropertiesValueDeserialize() {
        com.alibaba.fastjson2.JSON.parseObject(thousandString, ThousandPropertiesValue.class);
    }
    // --------- fastjson2 -----------
    // --------- gson -----------
    @Benchmark
    @OperationsPerInvocation()
    public void GsonBenchmarkLittlePropertiesSerialize() {
        gson.toJson(littlePropertiesValue);
    }
    @Benchmark
    @OperationsPerInvocation()
    public void GsonBenchmarkLittlePropertiesDeserialize() {
        gson.fromJson(littleString, LittlePropertiesValue.class);
    }

    @Benchmark
    @OperationsPerInvocation()
    public void GsonBenchmarkElevenPropertiesValueSerialize() {
        gson.toJson(elevenPropertiesValue);
    }
    @Benchmark
    @OperationsPerInvocation()
    public void GsonBenchmarkElevenPropertiesValueDeserialize() {
        gson.fromJson(elevenString, ElevenPropertiesValue.class);
    }

    @Benchmark
    @OperationsPerInvocation()
    public void GsonBenchmarkElevenDeepPropertiesValueSerialize() {
        gson.toJson(elevenDeepPropertiesValue);
    }
    @Benchmark
    @OperationsPerInvocation()
    public void GsonBenchmarkElevenDeepPropertiesValueDeserialize() {
        gson.fromJson(elevenDeepString, ElevenDeepPropertiesValue.class);
    }

    @Benchmark
    @OperationsPerInvocation()
    public void GsonBenchmarkHundredPropertiesValueSerialize() {
        gson.toJson(hundredPropertiesValue);
    }
    @Benchmark
    @OperationsPerInvocation()
    public void GsonBenchmarkHundredPropertiesValueDeserialize() {
        gson.fromJson(hundredString, HundredPropertiesValue.class);
    }

    @Benchmark
    @OperationsPerInvocation()
    public void GsonBenchmarkThousandPropertiesValueSerialize() {
        gson.toJson(thousandPropertiesValue);
    }
    @Benchmark
    @OperationsPerInvocation()
    public void GsonBenchmarkThousandPropertiesValueDeserialize() {
        gson.fromJson(thousandString, ThousandPropertiesValue.class);
    }
    // --------- gson -----------
    // --------- jackson -----------
    @Benchmark
    @OperationsPerInvocation()
    public void JacksonBenchmarkLittlePropertiesSerialize() throws JsonProcessingException {
        objectMapper.writeValueAsString(littlePropertiesValue);
    }
    @Benchmark
    @OperationsPerInvocation()
    public void JacksonBenchmarkLittlePropertiesDeserialize() throws JsonProcessingException {
        objectMapper.readValue(littleString, LittlePropertiesValue.class);
    }

    @Benchmark
    @OperationsPerInvocation()
    public void JacksonBenchmarkElevenPropertiesValueSerialize() throws JsonProcessingException {
        objectMapper.writeValueAsString(elevenPropertiesValue);
    }
    @Benchmark
    @OperationsPerInvocation()
    public void JacksonBenchmarkElevenPropertiesValueDeserialize() throws JsonProcessingException {
        objectMapper.readValue(elevenString, ElevenPropertiesValue.class);
    }

    @Benchmark
    @OperationsPerInvocation()
    public void JacksonBenchmarkElevenDeepPropertiesValueSerialize() throws JsonProcessingException {
        objectMapper.writeValueAsString(elevenDeepPropertiesValue);
    }
    @Benchmark
    @OperationsPerInvocation()
    public void JacksonBenchmarkElevenDeepPropertiesValueDeserialize() throws JsonProcessingException {
        objectMapper.readValue(elevenDeepString, ElevenDeepPropertiesValue.class);
    }

    @Benchmark
    @OperationsPerInvocation()
    public void JacksonBenchmarkHundredPropertiesValueSerialize() throws JsonProcessingException {
        objectMapper.writeValueAsString(hundredPropertiesValue);
    }
    @Benchmark
    @OperationsPerInvocation()
    public void JacksonBenchmarkHundredPropertiesValueDeserialize() throws JsonProcessingException {
        objectMapper.readValue(hundredString, HundredPropertiesValue.class);
    }

    @Benchmark
    @OperationsPerInvocation()
    public void JacksonBenchmarkThousandPropertiesValueSerialize() throws JsonProcessingException {
        objectMapper.writeValueAsString(thousandPropertiesValue);
    }
    @Benchmark
    @OperationsPerInvocation()
    public void JacksonBenchmarkThousandPropertiesValueDeserialize() throws JsonProcessingException {
        objectMapper.readValue(thousandString, ThousandPropertiesValue.class);
    }
    // --------- jackson -----------
}
