package com.dna.model;

@lombok.Data
public class Data {

	long count_mutant_dna;
	long count_human_dna;
	double ratio;
	
	public Data(long count_mutant_dna, long count_human_dna, double ratio) {
		super();
		this.count_mutant_dna = count_mutant_dna;
		this.count_human_dna = count_human_dna;
		this.ratio = ratio;
	}	
}
