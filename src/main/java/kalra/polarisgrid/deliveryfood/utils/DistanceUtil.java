package kalra.polarisgrid.deliveryfood.utils;

// Second option to use, but not planned to use this, intead used mysql query to fetch only related Rider
public class DistanceUtil {
    private static final double EARTH_RADIUS = 6371; // Radius of the earth in kilometers

    public static double calculateDistance(Integer lat1, Integer lon1, Integer lat2, Integer lon2) {
        double lat1Rad = Math.toRadians(lat1);
        double lon1Rad = Math.toRadians(lon1);
        double lat2Rad = Math.toRadians(lat2);
        double lon2Rad = Math.toRadians(lon2);

        double dLat = lat2Rad - lat1Rad;
        double dLon = lon2Rad - lon1Rad;

        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(lat1Rad) * Math.cos(lat2Rad) *
                        Math.sin(dLon / 2) * Math.sin(dLon / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return EARTH_RADIUS * c;  // Distance in kilometers
    }
}
