package net.okur.orderservice.repository;

import net.okur.orderservice.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author dogancan.okur
 * 5.12.2022 04:29
 */
@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

}
