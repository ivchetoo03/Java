import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ParallelMonteCarloPi {

    public static final int totalPoints = 1_000_000_000;
    
    public static void calculate(int numThreads){
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);
        List<Callable<Long>> tasks = getCallables(numThreads, totalPoints);

        long startTime = System.currentTimeMillis();
        long totalPointsInCircle = 0;

        try {
            List<Future<Long>> results = executor.invokeAll(tasks);
            for (Future<Long> result : results) {
                totalPointsInCircle += result.get();
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }

        long endTime = System.currentTimeMillis();
        double pi = 4.0 * totalPointsInCircle / totalPoints;

        System.out.println("\nPI is " + pi);
        System.out.println("THREADS " + numThreads);
        System.out.printf("ITERATIONS %,d%n", totalPoints);
        System.out.println("TIME " + (endTime - startTime) + "ms\n");
    }

    private static List<Callable<Long>> getCallables(int numThreads, int totalPoints) {
        List<Callable<Long>> tasks = new ArrayList<>();

        int iterationsPerThread = totalPoints / numThreads;

        for (int i = 0; i < numThreads; i++) {
            tasks.add(() -> {
                long pointsInCircle = 0;
                ThreadLocalRandom random = ThreadLocalRandom.current();

                for (int j = 0; j < iterationsPerThread; j++) {
                    double x = random.nextDouble();
                    double y = random.nextDouble();

                    if (x * x + y * y <= 1.0) {
                        pointsInCircle++;
                    }
                }
                return pointsInCircle;
            });
        }
        return tasks;
    }
}