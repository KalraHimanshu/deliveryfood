package kalra.polarisgrid.deliveryfood.repository;

import kalra.polarisgrid.deliveryfood.domain.Rider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RiderRepository extends JpaRepository<Rider, Long> {
    Optional<Rider> findByEmail(String email);


    // Native SQL query to find available riders sorted by distance using ST_Distance_Sphere
    /*
    * => ST_Distance_Sphere is a MySQL spatial function that calculates the great-circle distance (distance over the Earth's surface, assuming a spherical Earth model) between two points given their latitude and longitude.
    *
    * => 4326 is the SRID (Spatial Reference System Identifier) for the WGS 84 coordinate system. WGS 84 is the World Geodetic System 1984, which is the most common coordinate system used for GPS and maps. This coordinate system uses degrees of latitude and longitude to represent positions on the Earth's surface.
    * The SRID 4326 ensures that both the target location and rider's location are interpreted using the same geospatial reference system (WGS 84).
    * */
    @Query(value = "SELECT r.* FROM rider r " +
            "WHERE r.status = 'Available' " +
            "ORDER BY ST_Distance_Sphere( " +
            "ST_GeomFromText('POINT(:longitude :latitude)', 4326), " +  // Target location
            "ST_GeomFromText(CONCAT('POINT(', r.longitude, ' ', r.latitude, ')'), 4326) ) ASC",
            nativeQuery = true)
    List<Rider> findAvailableRidersNearestToLocation(@Param("latitude") Integer latitude,
                                                     @Param("longitude") Integer longitude);
}

