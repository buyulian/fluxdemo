package com.me.fluxstudy;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

public class HelloWorldHandlerTest {

    private CloseableHttpClient httpclient = HttpClients.createDefault();
    private String encoding= HTTP.UTF_8;


    public static void main(String[] args) {
        HelloWorldHandlerTest helloWorldHandlerTest=new HelloWorldHandlerTest();
        helloWorldHandlerTest.testTest();
    }

    public void testTest(){
        int times=12;
        Thread[] threads=new Thread[times];
        long start=System.currentTimeMillis();
        for(int i=0;i<times;i++){
            String url="http://localhost:8080/test?id="+i;
            threads[i]=new Thread(()->{
                try {
                    Thread.sleep(100);
                    final String s = doGet(url);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            threads[i].start();
        }

        for(int i=0;i<times;i++){
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long end=System.currentTimeMillis();
        System.out.println((end-start)/1000);
    }

    public String doGet(String url) throws Exception {
        HttpGet httpGet = new HttpGet(url);

        CloseableHttpResponse response = httpclient.execute(httpGet);
        //获取结果实体
        HttpEntity entity = response.getEntity();
        String body=null;
        if (entity != null) {
            //按指定编码转换结果实体为String类型
            body = EntityUtils.toString(entity, encoding);
        }
        EntityUtils.consume(entity);
        //释放链接
        response.close();
        return body;
    }

}
