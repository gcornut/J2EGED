/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.gphy.piotrgui.j2eged.controllers;

import com.mysql.jdbc.Statement;
import fr.gphy.piotrgui.j2eged.helpers.ServletHelper;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import javax.persistence.Entity;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Piotr
*/

@WebServlet(name = "ImageServlet", urlPatterns = {"/ImageServlet/*"})  
public class ImageServlet extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 4593558495041379082L;
    
    private ServletHelper helper = new ServletHelper();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Statement stmt = null;
//PreparedStatement ps;
        ResultSet rs;
        InputStream sImage;

        try {

            String id = request.getParameter("Image_id");
            System.out.println("inside servlet–>" + id);

                byte[] bytearray = this.helper.retriveByteFromID(id);
                int size = 0;
                response.reset();
                //response.setContentType("image / jpeg");
                    response.getOutputStream().write(bytearray);
                
            

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
