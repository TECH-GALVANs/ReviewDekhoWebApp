package com.reviewdekho.product.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.reviewdekho.product.model.Product;
import com.reviewdekho.product.service.ProductService;
import com.reviewdekho.subcategory.model.SubCategory;
import com.reviewdekho.subcategory.service.SubCategoryService;

@WebServlet( "/product" )
@MultipartConfig
public class ProductController extends HttpServlet {
	
	private ProductService productService;
	private SubCategoryService subCategoryService;
	HttpSession session;
	
    public ProductController() {
    	System.out.println( "From Product Controller Constructor....." );
    }
    
    @Override
    public void init() throws ServletException {
    	productService = new ProductService();
    	subCategoryService = new SubCategoryService();
    	System.out.println("From product init.....");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("From Get ProductController");
		session = request.getSession();
		if( request.getParameter( "update" ) != null ) {
			Integer productId = Integer.parseInt( request.getParameter( "update" ));
			
			Product product = productService.getById(productId);
			List< SubCategory > subCategories = subCategoryService.get();
			
			System.out.println(productId);
			System.out.println(product.getProduct_name());
			
			session.setAttribute( "product", product );
			session.setAttribute("subCategories", subCategories);
			
			response.sendRedirect( "views/Admin/Product/edit-product.jsp" );
			
		}
		
		else if( request.getParameter( "add" ) != null ) {
			List< SubCategory > subCategories = subCategoryService.get();
			session.setAttribute("subCategories", subCategories);
			response.sendRedirect( "views/Admin/Product/add-products.jsp" );
			
		}
		
		else if( request.getParameter( "delete" ) != null ) {
			doDelete( request, response ); 
		}
		
		else if( request.getParameter( "delete" ) == null && request.getParameter( "update" ) == null ) {
			getAllProducts(response);
		}
	}

	private void getAllProducts( HttpServletResponse response ) throws IOException {
		List< Product > products = productService.get();
		
		session.setAttribute( "products", products );
		
		response.sendRedirect( "views/Admin/Product/products.jsp" );

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if( request.getParameter( "productId" ) != null ) {
			doPut( request, response );
			return;
		}
		
		Integer subCategoryId = Integer.parseInt( request.getParameter( "subCategory" ) );
		
		Part imagePart = request.getPart( "productImage" );
		InputStream image = imagePart.getInputStream();
		byte[] imageBytes = new byte[ image.available() ];
		String base64Image = Base64.getEncoder().encodeToString( image.readAllBytes() );
		System.out.println( "\n \n \n" + imagePart.getContentType() + "\n \n \n"  );
		
		String imageType = imagePart.getContentType().substring(imagePart.getContentType().indexOf( "/" ) + 1 );
		
		System.out.println( "\n \n \n" + imageType + "\n \n \n"  );
		
		Product product = new Product();
		product.setProduct_name( request.getParameter( "productName" ) );
		product.setProduct_description( request.getParameter( "productDescription" ) );
		product.setProduct_price( Integer.parseInt( request.getParameter( "productPrice" ) ));
		product.setImage(base64Image);
		product.setImageType( imageType );
		SubCategory subCategory = new SubCategory();
		subCategory.setSub_category_id( subCategoryId );
		product.setSubCategory( subCategory );
		
		productService.add(product);
		
		getAllProducts(response);
	}
	
	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		Integer productId = Integer.parseInt( request.getParameter( "productId" ) );
		
		Product product = new Product();
		product.setProduct_name( request.getParameter( "productName" ) );
		System.out.println(product.getProduct_name());
		product.setProduct_description( request.getParameter( "productDescription" ) );
		product.setProduct_price( Integer.parseInt( request.getParameter( "productPrice" ) ));		
		
		productService.update( productId, product);
		getAllProducts(response);
	}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer productId = Integer.parseInt( request.getParameter( "delete" ));
		System.out.println(productId);
		productService.delete(productId);
		
		getAllProducts(response);
	
	}
}
