package com.laba1.laba1;


import org.springframework.data.jpa.repository.JpaRepository;
import com.laba1.laba1.Greeting;


public interface DataBaseRepository extends JpaRepository< Greeting, Integer> {
}
