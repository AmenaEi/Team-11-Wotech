/*
package com.datorium.Datorium.API;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DatoriumApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DatoriumApiApplication.class, args);
	}

}
*/

package com.datorium.Datorium.API;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@CrossOrigin															//CORS policy ???
public class DatoriumApiApplication { 									//Main class

	public static void main(String[] args) {   							//This is the only one that needs to be here
		SpringApplication.run(DatoriumApiApplication.class, args);


	}


}