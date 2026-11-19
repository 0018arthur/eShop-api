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

import eShop.app.dto.PanierRequest;
import eShop.app.dto.PanierResponse;
import eShop.app.serviceImpl.PanierServiceImpl;


@RestController
@RequestMapping("eShop/v1/panier/")
@CrossOrigin(origins = "*")
public class PanierController {
	
	private PanierServiceImpl panierServiceImpl;
	
	public PanierController(PanierServiceImpl panierServiceImpl) {
		this.panierServiceImpl = panierServiceImpl;

	}
	
	@GetMapping()
	public ResponseEntity<List<PanierResponse>> getPaniers(){
		List<PanierResponse> pr = panierServiceImpl.listePaniers();
		return new ResponseEntity<>(pr, HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<PanierResponse> getPanier(@PathVariable("id") UUID trackingId){
		PanierResponse pr = panierServiceImpl.getPanier(trackingId);
		return new ResponseEntity<>(pr, HttpStatus.OK);
	}
	
	@PostMapping()
	public ResponseEntity<PanierResponse> createPanier(@RequestBody PanierRequest panierRequest){
		PanierResponse pr = panierServiceImpl.createPanier(panierRequest);
		return new ResponseEntity<>(pr, HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<PanierResponse> updateProduit(@RequestBody PanierRequest panierRequest, @PathVariable("x") UUID tracking){
		PanierResponse pr = panierServiceImpl.updatePanier(panierRequest, tracking);
		return new ResponseEntity<>(pr, HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> deleteProduit(@PathVariable("x") UUID trackingId){
		panierServiceImpl.deletePanier(trackingId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}

