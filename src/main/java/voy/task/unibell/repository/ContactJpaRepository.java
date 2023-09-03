package voy.task.unibell.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import voy.task.unibell.model.entity.Contact;
import voy.task.unibell.model.entity.ContactType;

import java.util.Set;

public interface ContactJpaRepository extends JpaRepository<Contact, Integer> {

    @Query("SELECT c FROM Contact c WHERE c.client.id =:client_id")
    Set<Contact> findAllByClientId(@Param("client_id") Integer clientId);

    @Query("SELECT c FROM Contact c WHERE c.client.id = :client_id AND c.contactType = :contact_type ")
    Set<Contact> findAllByContactType(@Param("client_id") Integer clientId,
                                      @Param("contact_type") ContactType contactType);


}
