package com.reviewdekho.image.controller;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Base64;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import com.google.gson.internal.bind.util.ISO8601Utils;
import com.mysql.cj.protocol.a.result.ByteArrayRow;
import com.reviewdekho.image.dao.ProductImageDao;
import com.reviewdekho.image.model.ProductImage;
import com.reviewdekho.image.service.ImageService;
import com.reviewdekho.product.model.Product;
import com.reviewdekho.product.service.ProductService;

@WebServlet( "/product_image" )
@MultipartConfig
public class ProductImageController extends HttpServlet {

	private ProductService productService;
	private ImageService imageService;
//	ProductImageDao dao;
	
	HttpSession session;
	
	@Override
	public void init() throws ServletException {
//		dao = new ProductImageDao();
		productService = new ProductService();
		imageService = new ImageService();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session = request.getSession();
		ProductImage image = null;
		try {
			image = imageService.get(19);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		byte[] imageBytes = image.getImage();
		
//		String img = Base64.getEncoder().encodeToString( imageBytes );
		session.setAttribute( "image", image );
//		session.setAttribute( "img", img);
		response.sendRedirect( "views/Admin/Product/tempResp.jsp" );
	} 

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("From Product Image controller...........");
		
		Integer productId = Integer.parseInt( request.getParameter( "productId" ) );
		
		Part imagePart = request.getPart( "image" );
		
		InputStream image = imagePart.getInputStream();
//		InputStreamReader isr = new InputStreamReader(image);
//		
//		BufferedReader reader = new BufferedReader(isr);
//	      StringBuffer sb = new StringBuffer();
//	      String str;
//	      while((str = reader.readLine())!= null){
//	         sb.append(str);
//	      }
		
		byte[] imageBytes = new byte[ image.available() ];
		String base64Image = Base64.getEncoder().encodeToString( image.readAllBytes() );
		
		System.out.println("inert base64 : "+base64Image);
		
		ProductImage pImage = new ProductImage();
		Product product = new Product();
		product.setProduct_id(productId);
		pImage.setProduct( product );
		pImage.setImage( base64Image );
		
		try {
			imageService.add(pImage);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.sendRedirect( "views/Admin/Product/products.jsp" );
	}

}
