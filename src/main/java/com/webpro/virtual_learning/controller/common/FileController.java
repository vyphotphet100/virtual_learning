package com.webpro.virtual_learning.controller.common;

import com.webpro.virtual_learning.utils.GoogleCloudUtil;
import org.springframework.util.ResourceUtils;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ResourceBundle;

@WebServlet(urlPatterns = {"/file"})
public class FileController extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String fileName = request.getParameter("name");

        if (fileName == null)
            return;

        // check if file exists, if file does not exist, download it from google cloud
        ResourceBundle rb = ResourceBundle.getBundle("google_cloud");
        String anchorPath = rb.getString("anchor.path");
        String downloadedPath = ResourceUtils.getFile(anchorPath).getAbsolutePath().split("anchor.file")[0];



//        if (!ResourceUtils.getFile(downloadedPath + fileName).exists())
//            GoogleCloudUtil.getFileFromGoogleCloud(fileName);

        // reads input file from an absolute path
        String filePath = "downloaded/"+ fileName;
        File downloadFile = new File(filePath);
        FileInputStream inStream = new FileInputStream(downloadFile);

        // if you want to use a relative path to context root:
        String relativePath = getServletContext().getRealPath("");
        System.out.println("relativePath = " + relativePath);

        // obtains ServletContext
        ServletContext context = getServletContext();

        // gets MIME type of the file
        String mimeType = context.getMimeType(filePath);
        if (mimeType == null) {
            // set to binary type if MIME mapping not found
            mimeType = "application/octet-stream";
        }
        System.out.println("MIME type: " + mimeType);

        // modifies response
        response.setContentType(mimeType);
        response.setContentLength((int) downloadFile.length());

        // forces download
        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"", downloadFile.getName());
        response.setHeader(headerKey, headerValue);

        // obtains response's output stream
        OutputStream outStream = response.getOutputStream();

        byte[] buffer = new byte[4096];
        int bytesRead = -1;

        while ((bytesRead = inStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, bytesRead);
        }

        inStream.close();
        outStream.close();
    }
}