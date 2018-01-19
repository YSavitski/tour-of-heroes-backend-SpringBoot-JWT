package com.example.angular.tour_of_heroes_backend.repository;

import com.example.angular.tour_of_heroes_backend.model.Hero;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HeroRepository extends CrudRepository<Hero, Long> {
    @Query("from Hero h where lower(h.name) like CONCAT('%', lower(:name), '%')")
    Iterable<Hero> findByName(@Param("name") String name);
}
