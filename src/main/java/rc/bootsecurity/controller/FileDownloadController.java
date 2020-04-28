package rc.bootsecurity.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("formations-files")
public class FileDownloadController {
	String folderPath = "C:\\Users\\pc\\Desktop\\test\\";

	@GetMapping("/showFiles/{id}")
	public String showFiles(@PathVariable(name = "id") long id, Model model) {

		File folder = new File(folderPath+id);
		File[] listOfFiles = folder.listFiles();
		model.addAttribute("files", listOfFiles);
		model.addAttribute("formation", id);
		return "admin/showFiles";
	}

	@GetMapping("/file/{id}/{fileName}")
	@ResponseBody
	public void show(@PathVariable(name = "id") long id, @PathVariable("fileName") String fileName, HttpServletResponse response) {

		if (fileName.indexOf(".pdf") > -1)
			response.setContentType("application/pdf");
		if (fileName.indexOf(".zip") > -1)
			response.setContentType("application/zip");
		if (fileName.indexOf(".ppt") > -1)
			response.setContentType("application/ppt");
		if (fileName.indexOf(".doc") > -1)
			response.setContentType("application/msword");
		if (fileName.indexOf(".jpg") > -1)
			response.setContentType("image/jpg");

		response.setHeader("Content-Disposition", "attachement: filename=" + fileName);
		response.setHeader("Content-Transfer-Encoding", "binary");
		try {
			BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
			FileInputStream fis = new FileInputStream(folderPath + id + "/" + fileName);
			int len;
			byte[] buf = new byte[1024];
			while ((len = fis.read(buf)) > 0) {

				bos.write(buf, 0, len);

			}

			bos.close();
			response.flushBuffer();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
