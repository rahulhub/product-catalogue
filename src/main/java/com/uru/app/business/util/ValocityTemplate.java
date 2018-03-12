package com.uru.app.business.util;



import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.naming.NamingException;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import com.uru.app.entity.EcomOrder;
import com.uru.app.entity.EcomOrderLine;
import com.uru.app.entity.EcomPayment;
import com.uru.app.model.EcomOrderLineModel;


public class ValocityTemplate {
	
	public static void notify(String str,String[] mailAddressTo) throws NamingException, AddressException, MessagingException {

		VelocityEngine ve = new VelocityEngine();
		Properties p = new Properties();
		p.setProperty("resource.loader", "class");
		p.setProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
		ve.init(p);
        VelocityContext context = new VelocityContext();
        String useremail=mailAddressTo[0];
        context.put("uname", useremail);
        Template t = ve.getTemplate("templates/"+str);
        StringWriter writer = new StringWriter();
        t.merge(context, writer);
        System.out.println( writer.toString() );
        EmailNotification.sendMail(writer.toString(),mailAddressTo);
        
	}
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void order_notify(String str,String[] mailAddressTo,EcomOrder eo,List<EcomOrderLine> ecomOrderList) throws NamingException, AddressException, MessagingException {

		VelocityEngine ve = new VelocityEngine();
		Properties p = new Properties();
		p.setProperty("resource.loader", "class");
		p.setProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
		ve.init(p);
		
		ArrayList list = new ArrayList();
		
		VelocityContext context = new VelocityContext();
		for(int i=0;i<ecomOrderList.size();i++)
		{
			Map map = new HashMap();	
			//map.put("custName", eo.getEcomCustomer().getFirstContactFirstName());
			map.put("OrderId", eo.getOrderId());
			map.put("OrderDate", eo.getOrderDate());
			map.put("Description",eo.getEcomOrderLines().get(i).getDescription());
			map.put("Quantity",eo.getEcomOrderLines().get(i).getQuantity());
			map.put("MRP",eo.getEcomOrderLines().get(i).getMsrpAmount());
			map.put("Discount",eo.getEcomOrderLines().get(i).getDiscount());
			map.put("Disc_Amount",eo.getEcomOrderLines().get(i).getDiscountPrice());
			map.put("Tax_Amount",eo.getEcomOrderLines().get(i).getTaxAmount());
			map.put("Sub_Total", eo.getEcomOrderLines().get(i).getCalculatedAmount());
			list.add( map );
			//VelocityContext context = new VelocityContext();
			context.put("custname", eo.getEcomCustomer().getFirstContactFirstName());
			context.put("Total", eo.getPriceAmount());
			context.put("OrderList", list);
        }
        Template t = ve.getTemplate("templates/"+str);
        StringWriter writer = new StringWriter();
        t.merge(context, writer);
        System.out.println( writer.toString() );
        EmailNotification.sendMail(writer.toString(),mailAddressTo);
	}
	
	public static void forgotPasswordnotify(String str,String loginName,String pwd,String[] mailAddressTo) throws NamingException, AddressException, MessagingException {

		VelocityEngine ve = new VelocityEngine();
		Properties p = new Properties();
		p.setProperty("resource.loader", "class");
		p.setProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
		ve.init(p);
        VelocityContext context = new VelocityContext();
        context.put("username",loginName );
        context.put("password", pwd);
        Template t = ve.getTemplate("templates/"+str);
        StringWriter writer = new StringWriter();
        t.merge(context, writer);
        System.out.println( writer.toString() );
        EmailNotification.sendMail(writer.toString(),mailAddressTo);
        
	}

}
