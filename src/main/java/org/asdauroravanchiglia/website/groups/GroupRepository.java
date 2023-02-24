package org.asdauroravanchiglia.website.groups;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<Group, UUID> {
    

    @Query(value="SELECT * FROM groups g WHERE REPLACE(LOWER(TRIM(g.title)), ' ', '-') = :title", nativeQuery=true)
    public Optional<Group> findByTitle(String title);
}
