package org.asdauroravanchiglia.website.groups;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<Group, UUID> {
    

    public Optional<Group> findByTitle(String title);
}
