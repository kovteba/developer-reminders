//package kovteba.concurrency.examples;
//
//
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Date;
//import java.util.List;
//import java.util.concurrent.*;
//import java.util.concurrent.atomic.AtomicLong;
//import java.util.function.Function;
//import java.util.function.Supplier;
//import java.util.stream.Collectors;
//
//import static java.lang.Thread.currentThread;
//
//public class ConcurrencyTesting {
//
//    private static List<String> results = new ArrayList<>();
//
//    private static final RestTemplate restTemplate = new RestTemplate();
//
//    public static void main(String[] args) throws ExecutionException, InterruptedException {
//
//        CompletableFuture<String> whatsYourNameFuture = CompletableFuture.supplyAsync(() -> {
//            try {
//                TimeUnit.SECONDS.sleep(1);
//            } catch (InterruptedException e) {
//                throw new IllegalStateException(e);
//            }
//            System.out.println(Thread.currentThread().getName());
//            return "Rajeev";
//        });
//
//        CompletableFuture<String> greetingFuture = whatsYourNameFuture.thenApply(name -> {
//            System.out.println(Thread.currentThread().getName());
//            return "Hello " + name;
//        });
//        System.out.println(Thread.currentThread().getName()+" "+"go further");
//// Block and wait for the future to complete
//                System.out.println(Thread.currentThread().getName()+" "+greetingFuture.get());
//
////        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "Hi");
////
////        future.thenAccept(result -> System.out.println(result));
////
////        future.get();
////
////
////        long before = System.currentTimeMillis();
//////            test1();//100request=33884ms
//////            test4();//100requests=6024ms
//////            test1();//400request=203668ms
//        test4();//      400requests=22983ms
////
////        long after = System.currentTimeMillis();
////
////
////        System.out.println("-----------------------------------\nRESULT: " + (after - before));
//
//
//    }
//
//    static CompletableFuture<String> downloadWebPage(String link) {
//
//        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
//            ResponseEntity<String> forEntity = restTemplate.getForEntity(link, String.class);
//            return forEntity.getBody();
//            // Код загрузки и возврата содержимого веб-страницы
//        });
//
//        future.thenAccept(r -> results.add(r));
////        future.thenApplyAsync()
//
//        return future;
//    }
//
//    public static void test4() throws ExecutionException, InterruptedException {
//
//        List<String> webPageLinks = new ArrayList<>();
//        for (int i = 0; i < 1; i++) {
//            webPageLinks.add("https://google.com");
//        }
//
////// Асинхронно загружаем содержимое всех веб-страниц
//        List<CompletableFuture<String>> pageContentFutures = webPageLinks.stream()
//                .map(ConcurrencyTesting::downloadWebPage)
//                .collect(Collectors.toList());
//
//// Создаём комбинированный Future, используя allOf()
//        CompletableFuture<Void> allFutures = CompletableFuture.allOf(
//                pageContentFutures.toArray(new CompletableFuture[0])
//        );
//
//
//        CompletableFuture<List<String>> allPageContentsFuture = allFutures.thenApply(v -> pageContentFutures.stream()
//                .map(CompletableFuture::join)
//                .collect(Collectors.toList()));
//
//
//
//        List<String> strings = allPageContentsFuture.get();
//
//
//
//    }
//
//
//    private static void test1() {
//
//        for (int i = 0; i < 400; i++) {
////            ResponseEntity<String> forEntity = restTemplate.getForEntity("https://api.nasa.gov/planetary/apod?api_key=fF7J1d7aRtufFNdJFBe5KxeZWA3deaFH9S0EtmF1", String.class);
//            ResponseEntity<String> forEntity = restTemplate.getForEntity("https://google.com", String.class);
//        }
//    }
//
//    private static void test2() throws ExecutionException, InterruptedException {
//
//        CompletableFuture<String> completableFuture = new CompletableFuture<>();
//
//        CompletableFuture<String> future = CompletableFuture
//                .supplyAsync(() -> "Hi", Executors.newCachedThreadPool());
//
//        future.get();
//
//    }
//
//    public static Future<String> calculateAsync() throws InterruptedException {
//        CompletableFuture<String> completableFuture = new CompletableFuture<>();
//
//        Executors.newCachedThreadPool().submit(() -> {
//            Thread.sleep(500);
//            completableFuture.complete("Hello");
//            return null;
//        });
//
//        return completableFuture;
//    }
//
//    public static void test3() throws ExecutionException, InterruptedException {
//        CompletableFuture<Void> future = CompletableFuture.runAsync(new Runnable() {
//            @Override
//            public void run() {
//
//                ResponseEntity<String> forEntity = restTemplate.getForEntity("https://api.nasa.gov/planetary/apod?api_key=fF7J1d7aRtufFNdJFBe5KxeZWA3deaFH9S0EtmF1", String.class);
////                    System.out.println("responce " + forEntity.getBody());
//
//
//            }
//        });
//        future.thenApply(result -> {
//            System.out.println(result + " all"); //output Hi all
//            return result;
//        });
//        future.get();
//    }
//
//
//}
