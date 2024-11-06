package br.com.dev.api_service.repository;

import br.com.dev.api_service.domain.Called;
import br.com.dev.api_service.domain.dtos.CalledResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CalledRepository extends JpaRepository<Called, Long> {
    @Query("SELECT c FROM Called c WHERE c.user = :email")
    Page<Called> findAllByUserEmail(@Param("email") String email, Pageable pageable);
}
