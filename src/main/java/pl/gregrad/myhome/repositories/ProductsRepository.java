package pl.gregrad.myhome.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.gregrad.myhome.entity.Products;

import java.util.List;

public interface ProductsRepository extends JpaRepository<Products, Long> {

    @Query ("SELECT p FROM Products p WHERE p.category = :category")
    List<Products> findProductsByCategory (@Param("category") String category);

    @Query ("SELECT d FROM Products d WHERE YEAR(d.date) =:year AND MONTH(d.date) = :month")
    List<Products> findProductsByDate (@Param("year") Integer year, @Param("month") Integer month);
    
    @Query ("SELECT c FROM Products c WHERE YEAR(c.date) =:year AND MONTH(c.date) =:month AND c.category = :category")
    List<Products> findCategorizeProductsByDate (@Param("year") Integer year, @Param("month") Integer month, @Param("category") String category);
    
    @Query ("SELECT c FROM Products c WHERE YEAR(c.date) =:year AND c.category = :category")
    List<Products> findCategorizeProductsByYear (@Param("year") Integer year, @Param("category") String category);
    
    @Query ("SELECT m FROM Products m WHERE MONTH(m.date) = :month")
    List<Products> findProductsByMonth (@Param("month") Integer month);
    
    @Query ("SELECT y FROM Products y WHERE YEAR(y.date) =:year")
    List<Products> findProductsByYear (@Param("year") Integer year);
    
}
 