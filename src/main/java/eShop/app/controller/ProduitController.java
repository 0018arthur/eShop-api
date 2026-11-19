package eShop.app.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eShop.app.dto.ProduitRequest;
import eShop.app.dto.ProduitResponse;
import eShop.app.entity.ImageProduit;
import eShop.app.repository.ImageProduitRepository;
import eShop.app.serviceImpl.ProduitServiceImpl;

@RestController
@RequestMapping("eShop/v1/produits/")
@CrossOrigin(origins = "*")
public class ProduitController {
	
	private ProduitServiceImpl produitServiceImpl;
	
	public ProduitController(ProduitServiceImpl produitServiceImpl) {
		this.produitServiceImpl = produitServiceImpl;

	}
	
	@GetMapping()
	public ResponseEntity<List<ProduitResponse>> getProduits(){
		List<ProduitResponse> pr = produitServiceImpl.listeProduits();
		return new ResponseEntity<>(pr, HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<ProduitResponse> getProduit(@PathVariable("id") UUID trackingId){
		ProduitResponse pr = produitServiceImpl.getProduit(trackingId);
		return new ResponseEntity<>(pr, HttpStatus.OK);
	}
	
	@PostMapping()
	public ResponseEntity<ProduitResponse> createProduit(@RequestBody ProduitRequest produitRequest){
		ProduitResponse pr = produitServiceImpl.createProduit(produitRequest);
		return new ResponseEntity<>(pr, HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<ProduitResponse> updateProduit(@RequestBody ProduitRequest produitRequest, @PathVariable("x") UUID tracking){
		ProduitResponse pr = produitServiceImpl.updateProduit(produitRequest, tracking);
		return new ResponseEntity<>(pr, HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> deleteProduit(@PathVariable("x") UUID trackingId){
			produitServiceImpl.deleteProduit(trackingId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
