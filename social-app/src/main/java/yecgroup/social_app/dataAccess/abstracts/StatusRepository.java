package yecgroup.social_app.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import yecgroup.social_app.entities.concretes.Status;

public interface StatusRepository extends JpaRepository<Status, Integer> {

}
