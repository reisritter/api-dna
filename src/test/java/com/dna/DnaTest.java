package com.dna;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import com.dna.model.SerVivo;
import com.dna.repository.ISerVivoRepository;
import com.dna.service.SerVivoService;

@SpringBootTest
@AutoConfigureMockMvc
public class DnaTest {	 		
	
//		@Autowired
//	    private TestEntityManager entityManager;
//
//	    @Autowired
//	    private ISerVivoRepository iSerVivoRepository;
	    
	    @Autowired
	    private SerVivoService service;
		    
	    @Test
	    public void caso1() {
	        
	    	SerVivo ser = new SerVivo();
	    	String [] dna = {"CTGAGA", "CTATGC", "TATTGT", "AGAGGG", "CCCCTA", "TCACTG"};
	    	ser.setDna(dna);
	    	
	        boolean a = service.isSimian(dna);	        

	        Assertions.assertEquals(a,true);
	    }
	    
	    @Test
	    public void caso2() {
	        
	    	SerVivo ser = new SerVivo();
	    	String [] dna = {"ATGCGA", "CAGTGC", "TTATTT", "AGACGG", "GCGTCA", "TCACTG"};
	    	ser.setDna(dna);
	    	
	        boolean a = service.isSimian(dna);	        

	        Assertions.assertEquals(a,false);
	    }
	    
	    @Test
	    public void caso3() {
	        
	    	SerVivo ser = new SerVivo();
	    	String [] dna = 
	    	{"CTGAGA", 
	    	 "CTTTGC", 
	    	 "TATTGT", 
	    	 "AGAGAT", 
	    	 "ACCCTT", 
	    	 "TCAAAA"
	    	 };
	    	
	    	ser.setDna(dna);
	    	
	        boolean a = service.isSimian(dna);	        

	        Assertions.assertEquals(a,true);
	    }
}
