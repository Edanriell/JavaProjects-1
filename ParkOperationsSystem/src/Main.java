import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.atomic.AtomicInteger;

// ParkStatus Class (Managing Shared Resources)
class ParkStatus {
	private AtomicInteger foodStock; // Using AtomicInteger to prevent race conditions
	private final Lock lock = new ReentrantLock(); // Lock for manual synchronization

	public ParkStatus(int foodStock) {
		this.foodStock = new AtomicInteger(foodStock);
	}

	public int getFoodStock() {
		return this.foodStock.get();
	}

	public void reduceFood(int amount) {
		lock.lock();
		try {
			if (foodStock.get() >= amount) {
				System.out.println(Thread.currentThread().getName() + " is feeding dinosaurs.");
				foodStock.getAndAdd(-amount);
				System.out.println("Food stock after feeding: " + getFoodStock());
			} else {
				System.out.println("Not enough food to feed the dinosaurs.");
			}
		} finally {
			lock.unlock();
		}
	}

	public void addFood(int amount) {
		lock.lock();
		try {
			System.out.println(Thread.currentThread().getName() + " is restocking food.");
			foodStock.getAndAdd(amount);
			System.out.println("Food stock after restocking: " + getFoodStock());
		} finally {
			lock.unlock();
		}
	}
}

// FeedingDinosaurs Class (Feeding Thread)
class FeedingDinosaurs implements Runnable {
	private final ParkStatus parkStatus;

	public FeedingDinosaurs(ParkStatus parkStatus) {
		this.parkStatus = parkStatus;
	}

	@Override
	public void run() {
		while (!Thread.currentThread().isInterrupted()) {
			parkStatus.reduceFood(1);
			try {
				Thread.sleep(500); // Simulate time taken to feed
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
	}
}

// TrackingMovements Class (Tracking Dinosaur Movements)
class TrackingMovements implements Runnable {
	private final ParkStatus parkStatus;

	public TrackingMovements(ParkStatus parkStatus) {
		this.parkStatus = parkStatus;
	}

	@Override
	public void run() {
		while (!Thread.currentThread().isInterrupted()) {
			System.out.println(Thread.currentThread().getName() + " is tracking movements. Food stock: " + parkStatus.getFoodStock());
			try {
				Thread.sleep(1000); // Simulate tracking time
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
	}
}

// RestockingFood Class (Simulate Restocking)
class RestockingFood implements Runnable {
	private final ParkStatus parkStatus;

	public RestockingFood(ParkStatus parkStatus) {
		this.parkStatus = parkStatus;
	}

	@Override
	public void run() {
		while (!Thread.currentThread().isInterrupted()) {
			parkStatus.addFood(10);
			try {
				Thread.sleep(2000); // Simulate restocking interval
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
	}
}

// Main Class
public class Main {
	public static void main(String[] args) {
		// Initial food stock
		ParkStatus parkStatus = new ParkStatus(100);

		// Create an ExecutorService to manage threads
		ExecutorService executorService = Executors.newFixedThreadPool(3);

		// Submit tasks to the executor
		executorService.submit(new FeedingDinosaurs(parkStatus));
		executorService.submit(new TrackingMovements(parkStatus));
		executorService.submit(new RestockingFood(parkStatus));

		// Let the system run for a while before shutting it down
		try {
			Thread.sleep(10000); // Let the system run for 10 seconds
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		} finally {
			// Gracefully shutdown the ExecutorService
			executorService.shutdownNow();
			try {
				if (!executorService.awaitTermination(5, TimeUnit.SECONDS)) {
					System.err.println("Tasks didn't finish in time, forcing shutdown.");
				}
			} catch (InterruptedException e) {
				executorService.shutdownNow();
			}
		}

		System.out.println("Park operations have been shut down.");
	}
}
