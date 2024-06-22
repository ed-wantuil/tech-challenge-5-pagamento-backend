package br.com.fiap.techchallenge.frameworks.db.repositories;

import br.com.fiap.techchallenge.frameworks.db.entities.OrderEntity;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface SpringDataOrderRepository extends CrudRepository<OrderEntity, String> {

}
