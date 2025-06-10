package com.example.expense_tracker_app.controller;

import com.example.expense_tracker_app.dto.CategoryDto;
import com.example.expense_tracker_app.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(
        name="CRUD REST APIs for Category Resource",
        description = "CRUD REST APIs for Category Resource - Create Category"+
                      "Get Category, Update Category, and Delete Category"
)

@AllArgsConstructor
@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private CategoryService service;

    @Operation(
            summary = "Create Category REST API",
            description = "Create Category Rest API to save category into Database"
    )@ApiResponse(
            responseCode = "201",
            description = "HTTP STATUS 201 CREATED"
    )
    @PostMapping()
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto){
        CategoryDto nam=service.createCategory(categoryDto);
        return new ResponseEntity<>(nam, HttpStatus.CREATED);
    }

    @Operation(
            summary = "GET Category REST API",
            description = "Get Category Rest API Get category from Database"
    )@ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS 200 OK"
    )
    @GetMapping("/get/{id}")
    public ResponseEntity<CategoryDto> getCategeory(@PathVariable("id") Long id){
        CategoryDto nam=service.getCategoryById(id);
        return ResponseEntity.ok(nam);
    }

    @Operation(
            summary = "GetAll Category REST API",
            description = "GetALL Categories Rest API GetALL categories from Database"
    )@ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS 200 OK"
    )
    @GetMapping("/all")
    public ResponseEntity<List<CategoryDto>> getAllCategory(){
        return ResponseEntity.ok(service.getAllCategory());
    }

    @Operation(
            summary = "Update Category REST API",
            description = "Update Category Rest API Update category into Database"
    )@ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS 200 OK"
    )
    @PutMapping("/updated/{id}")
    public ResponseEntity<CategoryDto> updateCategory(@PathVariable("id") Long id,@RequestBody CategoryDto categoryDto){
        return ResponseEntity.ok(service.updateCategory(id,categoryDto));
    }

    @Operation(
            summary = "Delete Category REST API",
            description = "Delete Category Rest API Delete category from Database"
    )@ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS 200 OK"
    )
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable("id") Long id){
         service.deletecategory(id);
        return ResponseEntity.ok("Id data has been removed");
    }
}
