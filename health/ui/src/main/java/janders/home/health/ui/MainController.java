package janders.home.health.ui;

import org.apache.tomcat.util.http.fileupload.FileUploadBase.FileSizeLimitExceededException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import janders.home.health.ui.apple.AppleHealthExportService;

@Controller
public class MainController {
	
	private static final Logger log = LoggerFactory.getLogger(MainController.class);
	
	private final AppleHealthExportService service = new AppleHealthExportService();
	
	/*
	@Autowired
	public MainController(AppleHealthExportService service) {
		this.service = service;
	}
	*/
	
	@RequestMapping("/")
	public String index() {
		log.debug("hit index");
		return "index";
	}
	
	@PostMapping("/upload")
	public String handleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
		log.info("hit upload!");
		service.upload(file);
		redirectAttributes.addFlashAttribute("successMessage", "You successfully uploaded " + file.getOriginalFilename() + "!");
        return "redirect:/";
	}
	
	@ExceptionHandler(FileSizeLimitExceededException.class)
	public String handleFileTooLarge(RedirectAttributes redirectAttribs, FileSizeLimitExceededException e) {
		log.warn(e.getMessage());
		redirectAttribs.addFlashAttribute("errorMessage", "File was too large. Please select a smaller file.");
        return "redirect:/";
	}
	
}
