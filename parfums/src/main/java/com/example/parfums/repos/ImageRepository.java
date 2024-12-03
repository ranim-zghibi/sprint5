package com.example.parfums.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.parfums.entities.Image;
import com.example.parfums.entities.Parfum;

public interface ImageRepository  extends JpaRepository<Image, Long>{
	@Modifying
    @Transactional
    @Query("DELETE FROM Image i WHERE i.parfum = :parfum")
    void deleteByParfum(@Param("parfum") Parfum t);

}
