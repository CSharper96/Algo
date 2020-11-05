package blatt04.tasklist;

public class TaskDemo {

	public static void reorderTasks(TaskList tlist)
	{
		//bubblesort(tlist);
		quicksort(tlist, 0, tlist.size() - 1);
	}
	private static void quicksort(TaskList tlist, int begin, int end) //Verursacht StackOverflowError! Ist aber deutlich schneller als Bubblesort!!
	{
		if (begin < end)
		{
			int partitionIndex = partition(tlist, begin, end);

			quicksort(tlist, begin, partitionIndex-1);
			quicksort(tlist, partitionIndex+1, end);
		}
	}
	private static int partition(TaskList arr, int begin, int end)
	{
		Priority pivot = arr.getPriority(end);
		int i = (begin-1);

		for (int j = begin; j < end; j++)
		{
			if (lowerPriority(pivot, arr.getPriority(j)))
			{	//(arr[j] <= pivot) {
				i++;
				arr.swap(i, j);
			}
		}
		arr.swap(i+1, end);

		return i+1;
	}
	private static boolean lowerPriority(Priority p1, Priority p2)
	{
		if(p1.equals(p2))
			return true;
		else if(p1 == Priority.LOW)
			return true;
		else if(p1 == Priority.MEDIUM)
		{
			if(p2 == Priority.LOW)
				return false;
			else return true;
		}
		else return false;
	}
	private static void bubblesort(TaskList tlist) //ZU LANGSAM!!!!!
	{
		for(int i=1; i < tlist.size(); i++)
		{
			for(int j=0; j < tlist.size() - i; j++)
			{
				if(lowerPriority(tlist.getPriority(j), tlist.getPriority(j+1)))
				{
					tlist.swap(j, j+1);
				}
				// J <=> J+1
			}
		}
	}


	/**
	 * generates a list of tasks with randomly chosen priority
	 */
	public static TaskList generateRandomList(int size) {
		TaskList m = new TaskList(size);
		for (int i = 0; i < size; i++) {
			double rnd = Math.random();
			if (rnd < 0.33) {
				m.add(new Task(Priority.LOW, "task_low_" + i));
			} else if (rnd < 0.66) {
				m.add(new Task(Priority.MEDIUM, "task_medium_" + i));
			} else {
				m.add(new Task(Priority.HIGH, "task_high_" + i));
			}
		}

		return m;
	}
	
	
	
	public static void main(String[] args) {
		demo01();
		System.out.println();
		
		demo02();
		System.out.println();
		
		runtimeMeasurement();
		
		System.out.println("- done -");

	}
	
	public static void demo01() {
		System.out.println("demo01: ");
		TaskList tl1 = new TaskList(100);
		tl1.add(new Task(Priority.MEDIUM, "Task1"));
		tl1.add(new Task(Priority.HIGH, "Task2"));
		tl1.add(new Task(Priority.LOW, "Task3"));
		tl1.add(new Task(Priority.LOW, "Task4"));
		tl1.add(new Task(Priority.HIGH, "Task5"));
		tl1.add(new Task(Priority.MEDIUM, "Task6"));

		tl1.swap(2, 4);
		tl1.print();
		System.out.println("? Correctly ordered: " + tl1.isOrdered());

		System.out.println("--- reorder:");

		reorderTasks(tl1);
		tl1.print();
		System.out.println("? Correctly ordered: " + tl1.isOrdered());
		System.out.println();
	}

	
	public static void demo02() {
		System.out.println("demo02: ");
		TaskList m2 = generateRandomList(50);
		System.out.println("? Correctly ordered: " + m2.isOrdered());

		System.out.println("--- reorder ---:");

		reorderTasks(m2);
		m2.print();
		System.out.println("? Correctly ordered: " + m2.isOrdered());	
	}

	public final static int MAX_ANZAHL = 10000000;

	public static void runtimeMeasurement() {
		System.out.println("Runtime: ");
		for (int count = 10; count <= MAX_ANZAHL; count *= 10) {
			runtimeMS(count);
			
		}
	}
	
	/** generates a random list of count tasks and measures the running time
	 *  required to reorder the list.
	 * @param count	   number of tasks in the list
	 * @return         runtime for reordering in milliseconds
	 */
	
	public static double runtimeMS(int count) {
		System.out.printf("n = %9d ...", count);
		TaskList tl = generateRandomList(count);
		System.out.print("(generated): ");
		long start = System.nanoTime();
		reorderTasks(tl);
		long end = System.nanoTime();
		
		double timeMS =  (end - start) / 1e6;
		System.out.printf(" %8.3f ms.%n", timeMS);
		return timeMS;
	}
	
	 
}
