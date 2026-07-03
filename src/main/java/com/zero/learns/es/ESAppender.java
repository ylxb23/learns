package com.zero.learns.es;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.indices.CreateIndexResponse;

import java.io.IOException;

public class ESAppender {
    private ElasticsearchClient client;

    public ESAppender(String u, String a) {
        client = ElasticsearchClient.of(c -> c.host(u).apiKey(a));
    }

    public static void main(String[] args) {
        String url = "http://192.168.8.8:9200";
        String apiKey = "eyJ2ZXIiOiI4LjE0LjAiLCJhZHIiOlsiMTcyLjE3LjAuMjo5MjAwIl0sImZnciI6ImY3ZWZmMjBhMTI4NTMzZDI1MjllNWE1MzM2MGY5MzI3MDRkOWE0MDkwMmY4NTY2YjdlNzQ0YjA5NmJhZGVhZmMiLCJrZXkiOiJoQTdKU1o0Qk52NG95cDlld3UzczpWbkxIWmY0VWlBaUx6UngwaHJuQ1RRIn0=";
        ESAppender es = new ESAppender(url, apiKey);
        try {
            CreateIndexResponse res =  es.client.indices().create(c -> c.index("pro"));
            System.out.println(res);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
