package eShop.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import eShop.app.entity.ImageProduit;
import eShop.app.entity.Produit;
import eShop.app.repository.ImageProduitRepository;
import eShop.app.repository.ProduitRepository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("eShop/v1/UploadImageProduct/upload-multiple/")
@CrossOrigin(origins = "*")
public class UploadImageProductController {

    private final String UPLOAD_DIR = "src/main/resources/static/assets/produits/";
    private final ProduitRepository produitRepository;
    private final ImageProduitRepository imageProduitRepository;

    public UploadImageProductController(ProduitRepository produitRepository, ImageProduitRepository imageProduitRepository) {
        this.produitRepository = produitRepository;
        this.imageProduitRepository = imageProduitRepository;
    }
    
    
    @PostMapping("{x}")
    public ResponseEntity<?> uploadImages(@PathVariable("x") UUID x, @RequestParam("files") List<MultipartFile> files) {
        Optional<Produit> produitOpt = produitRepository.findByTrackingId(x);
        if (produitOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", "Produit non trouvé"));
        }
        Produit produit = produitOpt.get();
        
        List<String> imageUrls = new ArrayList<>();
        try {
        	Path uploadPath = Paths.get(UPLOAD_DIR);
        	if (!Files.exists(uploadPath)) {
        	    Files.createDirectories(uploadPath); // Créer le dossier s'il n'existe pas
        	}
            for (MultipartFile file : files) {
                String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
                Path filePath = Paths.get(UPLOAD_DIR, fileName);
                Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

                String imageUrl = "/assets/produits/" + fileName;
                imageUrls.add(imageUrl);

                // Associer l'image au produit
                ImageProduit iP = new ImageProduit();
                iP.setProduit(produit);
                iP.setUrl(imageUrl);
                imageProduitRepository.save(iP);
            }
            return ResponseEntity.ok(Map.of("imageUrls", imageUrls));
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("error", "Erreur de stockage"));
        }
    }
}
