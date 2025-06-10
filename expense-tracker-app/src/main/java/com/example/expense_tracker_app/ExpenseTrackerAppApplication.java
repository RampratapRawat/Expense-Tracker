package com.example.expense_tracker_app;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
		info=@Info(
			title = "Expense Tracker RestAPI Documentation",
			description = "Expense Tracker REST API Documentation",
			version = "v1.0",
			contact = @Contact(
					name = "Ram Rawat",
					email = "javaguides.net@gamil.com",
					url = "https://www.javaguides.net"
			),
			license=@License(
					name="Apache 2.0",
					url = "https://www.javaguides.net/license"
			)
		),
		externalDocs = @ExternalDocumentation(
				description = "Expense tracker RestAPI Documentation for Developers",
				url= "https://www.javaguides.net/external.doc.html"
		)
)
@SpringBootApplication
public class ExpenseTrackerAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExpenseTrackerAppApplication.class, args);
	}

}

//swagger thing i have done in this project

//1. Adding springdoc-openapi maven dependency
//2. Defining General API Information(Using Annotations)
// Ex-(@OpenAPIDefinition) in main Class use for describe project on swagger page

//3. Customizing Swagger API Documentation with Annotation
//  Define in Controller class for Describing CRUD APIs

//4.Customizing Swagger Models Documentation with Annotations
// Define Schema in DTO and Error class to Describe them on Swagger page
