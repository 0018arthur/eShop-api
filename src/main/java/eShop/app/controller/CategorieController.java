package eShop.app.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eShop.app.dto.CategorieRequest;
import eShop.app.dto.CategorieResponse;
import eShop.app.serviceImpl.CategorieServiceImpl;

@RestController
@RequestMapping("eShop/v1/categories/")
@CrossOrigin(origins = "*")
public class CategorieController {
	
	
	private CategorieServiceImpl categorieServiceImpl;
	
	public CategorieController(CategorieServiceImpl categorieServiceImpl) {
		this.categorieServiceImpl = categorieServiceImpl;
	}
	
	@GetMapping()
	public ResponseEntity<List<CategorieResponse>> getCategories(){
		List<CategorieResponse> ca = categorieServiceImpl.listeCategories();
		return new ResponseEntity<>(ca, HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<CategorieResponse> getCategorie(@PathVariable("id") UUID tracking){
		CategorieResponse ca = categorieServiceImpl.getCategorie(tracking);
		return new ResponseEntity<>(ca, HttpStatus.OK);
	}
	
	@PostMapping()
	public ResponseEntity<CategorieResponse> createCategorie(@RequestBody CategorieRequest categorieRequest){
		CategorieResponse ca = categorieServiceImpl.createCategorie(categorieRequest);
		return new ResponseEntity<>(ca, HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<CategorieResponse> updateCategorie(@RequestBody CategorieRequest categoriRequest, @PathVariable("x") UUID tracking){
		CategorieResponse ca = categorieServiceImpl.updateCategorie(categoriRequest, tracking);
		return new ResponseEntity<>(ca, HttpStatus.OK);
	}
	
	@DeleteMapping()
	public ResponseEntity<Void> deleteCategorie(@PathVariable("x") UUID trackingId){
			categorieServiceImpl.deleteCategorie(trackingId);
		return new ResponseEntity<>( HttpStatus.OK);
	}
}
