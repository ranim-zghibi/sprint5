package com.example.parfums.restcontrollers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.example.parfums.entities.Image;
import com.example.parfums.entities.Parfum;
import com.example.parfums.service.ImageService;
import com.example.parfums.service.ImageServiceImpl;
import com.example.parfums.service.ParfumService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
@RestController
@RequestMapping("/api/image")
@CrossOrigin(origins = "*")

public class ImageRestController {
	@Autowired
	ImageService imageService ;
	
	@Autowired
	ParfumService parfumService;


	@RequestMapping(value = "/upload" , method = RequestMethod.POST)
	public Image uploadImage(@RequestParam("image")MultipartFile file) throws IOException {
		return imageService.uplaodImage(file);
	}
	@RequestMapping(value = "/get/info/{id}" , method = RequestMethod.GET)
	public Image getImageDetails(@PathVariable("id") Long id) throws IOException {
		return imageService.getImageDetails(id);

	}

	@PostMapping(value = "/uplaodImageParf/{idParf}" )
	public Image uploadMultiImages(@RequestParam("image")MultipartFile file,
			@PathVariable("idParf") Long idParf)
					throws IOException {
		return imageService.uplaodImageParf(file,idParf);
	}
	
	
	@RequestMapping(value = "/getImagesParf/{idParf}" ,
			method = RequestMethod.GET)
	public List<Image> getImagesProd(@PathVariable("idParf") Long idParf)
			throws IOException {
		return imageService.getImagesParParf(idParf);
	}
	@RequestMapping(value = "/load/{id}" , method = RequestMethod.GET)
	public ResponseEntity<byte[]> getImage(@PathVariable("id") Long id) throws IOException
	{
		return imageService.getImage(id);
	}


	@RequestMapping(value = "/delete/{id}" , method = RequestMethod.DELETE)
	public void deleteImage(@PathVariable("id") Long id){
		imageService.deleteImage(id);
	}
	@RequestMapping(value="/update",method = RequestMethod.PUT)
	public Image UpdateImage(@RequestParam("image")MultipartFile file) throws IOException {
		return imageService.uplaodImage(file);
	}
	
	
	
	@RequestMapping(value = "/uploadFS/{id}" , method = RequestMethod.POST)
	 public void uploadImageFS(@RequestParam("image") MultipartFile
	file,@PathVariable("id") Long id) throws IOException {
	 Parfum p = parfumService.getParfum(id);
	 p.setImagePath(id+".jpg");

	Files.write(Paths.get(System.getProperty("user.home")+"/OneDrive/images/"+p.getImagePath())
	, file.getBytes());
	 parfumService.saveParfum(p);

	 }
	 @RequestMapping(value = "/loadfromFS/{id}" ,
	 method = RequestMethod.GET,
	 produces = org.springframework.http.MediaType.IMAGE_JPEG_VALUE)
	 public byte[] getImageFS(@PathVariable("id") Long id) throws IOException {

	 Parfum p = parfumService.getParfum(id);
	 return
	Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/OneDrive/images/"+p.getImagePath()));
	 }


}
