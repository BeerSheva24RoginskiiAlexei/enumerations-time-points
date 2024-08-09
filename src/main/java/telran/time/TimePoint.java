package telran.time;

public class TimePoint implements Comparable<TimePoint>{
    private float amount;
    private TimeUnit timeUnit;
    public TimePoint(float amount, TimeUnit timeUnit) {
        this.amount = amount;
        this.timeUnit = timeUnit;
    }
    // @Override
    // public int compareTo(TimePoint arg0) {
    //     int res = 0;
    //     int diff = (int)timeUnit.between(this, arg0);
    //     if (diff > 0) {
    //         res = 1;
    //     } else if (diff < 0) {
    //         res = -1;
    //     } else {
    //         res = 0;
    //     }
    //     return res;
    // }

    @Override
    public int compareTo(TimePoint arg0) {
        return (int)TimeUnit.SECOND.between(arg0, this);
    }
    public float getAmount(){
        return amount;
    }
    public TimeUnit getTimeUnit() {
        return timeUnit;
    }
    @Override
    public boolean equals(Object obj) {
        return (int)TimeUnit.SECOND.between(this, (TimePoint) obj) == 0;
    }
    public TimePoint convert(TimeUnit timeUnit) {
        return new TimePoint(getTimeUnit().getValueOfSeconds() * amount / timeUnit.getValueOfSeconds(), timeUnit);
    }
    public TimePoint with(TimePointAdjuster adjuster) {
        return adjuster.adjust(this);
    }

}