package com.atguigu.client;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import com.atguigu.entity.Customer;
import com.google.gson.Gson;

public class MainClient {

	public static void main(String[] args) throws ClientProtocolException, IOException {
//		使用 HttpClient需要以下6个步骤：
		 CloseableHttpClient httpclient = HttpClientBuilder.create().build();
		 
		 
		 HttpPost httpPost=new  HttpPost("http://192.168.10.252:9999/rest_test/crm/addcustomer/");
		 	
		
		 
		 Customer customer=new Customer("1", "zz", 12);
		Gson gson=new Gson();
		String string = gson.toJson(customer);
		 HttpEntity entity=new StringEntity(string);
		 httpPost.setEntity(entity);
		  httpPost.addHeader("Content-Type", "application/json");
		  
		  HttpResponse httpResponse= httpclient.execute(httpPost);
		 
		  HttpEntity entity2=  httpResponse.getEntity();
		  
		  if(httpResponse.getStatusLine().getStatusCode()==HttpStatus.SC_OK){
			String result = EntityUtils.toString(entity, "UTF-8");
			System.out.println(result);
 
		  }else{
			System.out.println("err:"+httpResponse.getStatusLine()); 

		   }
		  
  //		1. 创建 HttpClient 的实例
//
//		2. 创建某种连接方法的实例
//
//		3. 调用第一步中创建好的实例的execute方法来执行第二步中创建好的链接类实例
//
//		4. 读response获取HttpEntity
//
//		5. 对得到后的内容进行处理
//
//		6. 释放连接。无论执行方法是否成功，都必须释放连接


		
		

//CloseableHttpClient httpclient = HttpClientBuilder.create().build();
//HttpGet httpget = new HttpGet("http://localhost:8888/restws/crm/customer/1122");
// 
//HttpResponse response = httpclient.execute(httpget);
//HttpEntity entity = response.getEntity();
//if(response.getStatusLine().getStatusCode()==HttpStatus.SC_OK){
//String result = EntityUtils.toString(entity, "UTF-8");
//System.out.println(entity);
//return result ;
//}else{
//	return "err:"+response.getStatusLine(); 
//
//    }
//EntityUtils.consume(entity);
//httpclient.close();
//}

	}

}
