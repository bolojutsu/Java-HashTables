public class TestTimes implements TestTimesInterface {
    private TimeUnits timeUnits;
    private MemoryUnits memoryUnits;
    private static final int MAX_RECORDS = 10;
    private long[] testTimes;
    private long[] testMemoryUsages;
    private int totalAdded;

    public TestTimes() {
        this.timeUnits = TimeUnits.NanoSeconds;
        this.memoryUnits = MemoryUnits.Bytes;
        this.testTimes = new long[MAX_RECORDS];
        this.testMemoryUsages = new long[MAX_RECORDS];
        this.totalAdded = 0;
    }

    @Override
    public TimeUnits getTimeUnits() {
        return this.timeUnits;
    }

    @Override
    public void setTimeUnits(TimeUnits timeUnits) {
        this.timeUnits = timeUnits;
    }

    @Override
    public MemoryUnits getMemoryUnits() {
        return this.memoryUnits;
    }

    @Override
    public void setMemoryUnits(MemoryUnits memoryUnits) {
        this.memoryUnits = memoryUnits;
    }

    @Override
    public void addTestTime(long runTime) {
        int index = totalAdded % MAX_RECORDS;
        this.testTimes[index] = runTime;
        this.testMemoryUsages[index] = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        this.totalAdded++;
    }

    @Override
    public double getLastTestTime() {
        if (totalAdded == 0)
            return 0;
        int lastIndex = (totalAdded - 1) % MAX_RECORDS;
        return convertTime(this.testTimes[lastIndex]);
    }

    @Override
    public double getLastMemoryUsage() {
        if (totalAdded == 0)
            return 0.0;
        int lastIndex = (totalAdded - 1) % MAX_RECORDS;
        return convertMemory(this.testMemoryUsages[lastIndex]);
    }

    @Override
    public double[] getTestTimes() {
        double[] lastTen = new double[MAX_RECORDS];
        for (int i = 0; i < MAX_RECORDS; i++) {
            int virtualIndex = (totalAdded > MAX_RECORDS) ? (totalAdded - MAX_RECORDS + i) : i;

            if (virtualIndex < totalAdded) {
                lastTen[i] = convertTime(this.testTimes[virtualIndex % MAX_RECORDS]);
            } else {
                lastTen[i] = 0.0;
            }
        }
        return lastTen;
    }

    @Override
    public double[] getMemoryUsages() {
        double[] lastTen = new double[MAX_RECORDS];
        for (int i = 0; i < MAX_RECORDS; i++) {
            int virtualIndex = (totalAdded > MAX_RECORDS) ? (totalAdded - MAX_RECORDS + i) : i;

            if (virtualIndex < totalAdded) {
                lastTen[i] = convertMemory(this.testMemoryUsages[virtualIndex % MAX_RECORDS]);
            } else {
                lastTen[i] = 0.0;
            }
        }
        return lastTen;
    }

    @Override
    public double getAverageTestTime() {
        if (totalAdded == 0)
            return 0;
        double total = 0;
        int count = Math.min(totalAdded, MAX_RECORDS);

        for (int i = 0; i < count; i++) {
            total += convertTime(this.testTimes[i]);
        }
        return total / count;
    }

    @Override
    public double getAverageMemoryUsage() {
        if (totalAdded == 0)
            return 0.0;
        double total = 0;
        int count = Math.min(totalAdded, MAX_RECORDS);

        for (int i = 0; i < count; i++) {
            total += convertMemory(this.testMemoryUsages[i]);
        }
        return total / count;
    }

    @Override
    public void resetTestTimes() {
        this.testTimes = new long[MAX_RECORDS];
        this.testMemoryUsages = new long[MAX_RECORDS];
        this.totalAdded = 0;
    }

    private double convertTime(long time) {
        switch (this.timeUnits) {
            case Seconds:
                return time / 1_000_000_000.0;
            case MilliSeconds:
                return time / 1_000_000.0;
            case MicroSeconds:
                return time / 1_000.0;
            case NanoSeconds:
                return (double) time;
            default:
                return (double) time;
        }
    }

    private double convertMemory(long memory) {
        switch (this.memoryUnits) {
            case MegaBytes:
                return memory / (1024.0 * 1024.0);
            case KiloBytes:
                return memory / 1024.0;
            case Bytes:
                return (double) memory;
            default:
                return (double) memory;
        }
    }
}