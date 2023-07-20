//package test;
//
//import java.util.concurrent.CompletableFuture;
//
//public class t3 {
//    CompletableFuture<String> future = CompletableFuture.completedFuture("hello!")
//            .thenApply(s -> s + "world!");
//    assertEquals("hello!world!", future.get());
//// 这次调用将被忽略。
//    future.thenApply(s -> s + "nice!");
//    assertEquals("hello!world!", future.get());
//
//}
