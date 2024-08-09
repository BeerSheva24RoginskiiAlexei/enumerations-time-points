package telran.time;

import java.util.Arrays;

public class FutureProximityAdjuster implements TimePointAdjuster{
    TimePoint [] timePoints;
    public FutureProximityAdjuster(TimePoint [] timePoints) {
        this.timePoints = Arrays.copyOf(timePoints, timePoints.length);
        Arrays.sort(this.timePoints);
    }
    @Override
    public TimePoint adjust(TimePoint timePoint) {
        int res = Arrays.binarySearch(timePoints, timePoint);
        if (res >= 0) {
            while (res < timePoints.length && timePoints[res].compareTo(timePoint) <= 0) {
                res++;
            }
        } else {
            res = -res - 1;
        }
        if (res == timePoints.length) {
            return null;
        }
       
        return timePoints[res];
    }
}