package br.com.alura.screenmatch.principal.busca;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Scanner;

import com.google.gson.Gson;

import br.com.alura.screenmatch.modelos.Titulo;

public class Busca {
	public static void main(String[] args) throws IOException, InterruptedException {
		try(Scanner sc = new Scanner(System.in)){
			System.out.print("Nome do filme: ");
			var nome = sc.nextLine();
			
			var endereco = "https://www.omdbapi.com/?t=" + nome + "&apikey=db0c4f7";
			
			HttpClient client = HttpClient.newHttpClient();
			HttpRequest request = HttpRequest.newBuilder()
					.uri(URI.create(endereco))
					.build();
			
			HttpResponse<String> response = client.send(request, BodyHandlers.ofString()); 
			var jj = response.body();
			System.out.println(jj);
			
			Gson gg = new Gson();
			Titulo tt = gg.fromJson(jj, Titulo.class);
			System.out.println(tt.getNome());
		}
		
	}
}
