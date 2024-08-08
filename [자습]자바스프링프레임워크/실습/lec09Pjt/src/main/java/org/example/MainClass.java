//package org.example;
//
//import org.example.service.WordRegisterService;
//import org.example.service.WordSearchService;
//import org.springframework.context.support.GenericXmlApplicationContext;
//
//public class MainClass {
//    public static void main(String[] args) {
//        String[] keyWords = {"c","c++","java","jsp","spring"};
//        String[] values = {"C는 프로그래밍 언어이다.",
//        "C++는 프로그래밍 언어이다.", "자바는 프로그래밍 언어이다.", "JSP는 프로그래밍 언어이다.",
//        "스프링은 프레임워크이다."};
//
//        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:appCtx.xml");
//
//        WordRegisterService registerService = ctx.getBean("registerService", WordRegisterService.class);
//
//        for (int i= 0; i<values.length; i++){
//            WordSet wordSet = new WordSet(keyWords[i],values[i]);
//            registerService.register(wordSet);
//        }
//
//        WordSearchService searchService=
//                ctx.getBean("searchService", WordSearchService.class);
//
//        System.out.println("\n\n-----------------------------");
//        for (int i =0; i<keyWords.length; i++){
//            WordSet wordSet =searchService.searchWord(keyWords[i]);
//            System.out.print(wordSet.getWordKey() + "\t: ");
//            System.out.println(wordSet.getWordValue());
//            System.out.println("[출처: 위키]");
//
//        }
//        ctx.close();
//    }
//}