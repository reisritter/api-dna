package com.dna.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dna.model.SerVivo;
import com.dna.repository.ISerVivoRepository;

@Service
public class SerVivoService {

	@Autowired
	ISerVivoRepository iSerVivoRepository;
	
	public boolean isSimian (String[] dna) 
	{
		char[] aux={};		
		int linha = dna.length;
		int coluna = dna[0].length();
		int contLinha= 0,contDiagR= 0,contDiagL= 0,contCol = 0;
		char[][]dnaChar=new char[linha][coluna];
		
		//Transforma o vetor de String em uma Matrix de caracter
		for(int i=0;i<linha;i++)
		{
			aux = dna[i].toCharArray();
			for(int j=0;j<coluna;j++)			
				dnaChar[i][j]=aux[j];			
		}
		
		//Linha				
		for(int i=0;i<linha;i++)
		{					
			//Coluna
			for(int j=0;j<coluna-1;j++)
			{															
				//Verifica se as linhas possue letras iguais
				if(dnaChar[i][j]==dnaChar[i][j+1]) 				
					contLinha++;				
				else contLinha=0;
				
				//Verifica se as colunas possue letras iguais
				if(dnaChar[j][i]==dnaChar[j+1][i]) 				
					contCol++;				
				else contCol=0;					
				
				//Verifica se a linha está entre as posições 0 e 2
				//Caso não esteja, não faz sentido verificar nas diagonais, pois não terá 4 letras iguais
				if(i>=0 && i<=2) 
				{
					//Verifica se a coluna está entre as posições 0 e 2
					//Caso esteja, faz sentido verificar apenas na diagonal direita
					if(j>=0 && j<=2)											
						for(int k=0;k<3;k++) 
						{				
							if(dnaChar[i+k][j+k]==dnaChar[i+1+k][j+1+k]) 							
								contDiagR++;							
							else 
							{
								contDiagR=0;
								break;
							}							
						}
					
					//Verifica se a coluna está entre as posições 2 e 5
					//Caso esteja, faz sentido verificar apenas na diagonal esquerda
					else if(j>2 && j<=5)											
						for(int k=0;k<3;k++) 
						{			
							if(dnaChar[i+k][j-k]==dnaChar[i+k+1][j-(k+1)]) 							
								contDiagL++;							
							else 
							{
								contDiagL=0;
								break;
							}
						}										
				}
				// Verifica se há alguma combinação de 4 letras iguais em todas as direções
				// Caso verdadeira, retorna true -> Pertence a um símio
				if(contDiagR==3 || contDiagL==3 || contLinha==3 || contCol==3)
					return true;
				
				contDiagL=0;
				contDiagR=0;										
			}
			contLinha=0;
			contCol=0;			
		}
		// Caso não ache nenhuma combinação, retorna false -> Pertence a um humano
		return false;
	}
	
	
	public SerVivo salvar(SerVivo ser) 
	{
		ser.setSimio(isSimian(ser.getDna()));
		return iSerVivoRepository.save(ser);
	}
	
}
