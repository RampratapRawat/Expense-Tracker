package com.example.expense_tracker_app.repository;

import com.example.expense_tracker_app.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
