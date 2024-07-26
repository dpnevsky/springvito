//package com.example.springvito.translator;
//
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.MediaType;
//import org.springframework.web.client.RestTemplate;
//
//
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Scanner;
//
//public class Translator {
//    public static void main(String[] args) {
//        System.out.println("Enter sentence for translate: ");
//        String strForTranslate = new Scanner(System.in).nextLine();
//        RestTemplate restTemplate = new RestTemplate();
//
//        String url = "https://translate.api.cloud.yandex.net/translate/v2/translate";
//        String token = "t1.9euelZrOnZLKkZWJjJGPlcuMxsyZmu3rnpWamcaVns7KjMmby5vPysqSmpTl8_caewRL-e85J2F4_t3z91opAkv57zknYXj-zef1656VmpaYmJqXj5eVjpfPyJ2Zmc_P7_zN5_XrnpWayZHGx8fHm5CVnJfNipiNx4rv_cXrnpWalpiYmpePl5WOl8_InZmZz88.RRVrCQalyf9DWl0RC66md3q7NgWbpJxELAPAJakHwdw4VIkeKNLYsm1ZxUqzvIWjpNurboCEgleHmFPwAYi2Dw";
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        headers.add("Authorization", "Bearer " + token);
//
//        Map<String, String> jsonData = new HashMap<>();
//        jsonData.put("folderId", "b1gfpel8emkb6l5ert4k");
//        jsonData.put("targetLanguageCode", "en");
//        jsonData.put("texts", "["+ strForTranslate +"]");
//
//        HttpEntity<Map<String, String>> request = new HttpEntity<>(jsonData, headers);
//        String response = restTemplate.postForObject(url, request, String.class);
//
//        System.out.println(response);
//
//    }
//}
