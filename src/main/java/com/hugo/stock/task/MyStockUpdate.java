package com.hugo.stock.task;/**
 * @Author: yuyf
 * @Description:
 * @Date: Created in 9:34 2018-12-26
 */

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hugo.stock.entity.Stock;
import com.hugo.stock.service.StockService;
import com.hugo.stock.utils.CloseableUtil;
import com.hugo.stock.utils.IOUtils;
import com.hugo.stock.utils.SpringToolUtils;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *@ClassName MyStockUpdate
 *@Description TODO
 *@User Administrator
 *@Date 2018-12-26 9:34
 *@Version 1.0
 **/
public class MyStockUpdate {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private final static String APP_KEY = "81c3716ab9e33567d324b9b7f0ee3a77";

    private StockService stockService;

    public MyStockUpdate() {
        stockService = (StockService)SpringToolUtils.getBean("stockService");
    }

    public void task(){
        logger.info("开始更新信息");
        List<Stock> stockList = stockService.findAll();
        try {
            for (Stock stock : stockList){
                request(stock);
                //10s
                Thread.sleep(10000);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void request(Stock stock){
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        InputStream inputStream = null;
        try {
            String url = "http://web.juhe.cn:8080/finance/stock/hs?gid="+stock.getGid()+"&key="+APP_KEY;
            HttpGet httpGet = new HttpGet(url);
            RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(5000).setConnectTimeout(2000).build();
            httpGet.setConfig(requestConfig);
            response = httpClient.execute(httpGet);
            inputStream = response.getEntity().getContent();
            byte[] bytes = IOUtils.readFully(inputStream);
            String result = new String(bytes);
            logger.info(result);
            JSONObject jsonObject  = JSONObject.parseObject(result);
            JSONArray jsonObjectRes  = (JSONArray)jsonObject.get("result");
            JSONObject jsonObjectData = (JSONObject)((JSONObject)jsonObjectRes.get(0)).get("data");

            String increPer = (String) jsonObjectData.get("increPer");
            String increase = (String) jsonObjectData.get("increase");
            String todayStartPri = (String) jsonObjectData.get("todayStartPri");
            String yesterdayEndPri = (String) jsonObjectData.get("yestodEndPri");
            String nowPri = (String) jsonObjectData.get("nowPri");
            String todayMax = (String) jsonObjectData.get("todayMax");
            String todayMin = (String) jsonObjectData.get("todayMin");

            JSONObject jsonObjectPic = (JSONObject)((JSONObject)jsonObjectRes.get(0)).get("gopicture");
            String picMinUrl = (String) jsonObjectPic.get("minurl");
            String picDayUrl = (String) jsonObjectPic.get("dayurl");
            String picWeekUrl = (String) jsonObjectPic.get("weekurl");
            String picMonthUrl = (String) jsonObjectPic.get("monthurl");

            String time = (String) jsonObjectData.get("date")+" "+ (String) jsonObjectData.get("time");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


            stock.setIncrePer(increPer);
            stock.setIncrease(increase);
            stock.setTodayStartPri(todayStartPri);
            stock.setYesterdayEndPri(yesterdayEndPri);
            stock.setNowPri(nowPri);
            stock.setTodayMax(todayMax);
            stock.setTodayMin(todayMin);
            stock.setPicMinUrl(picMinUrl);
            stock.setPicDayUrl(picDayUrl);
            stock.setPicWeekUrl(picWeekUrl);
            stock.setPicMonthUrl(picMonthUrl);
            stock.setDateLastUpdate(sdf.parse(time));
            stockService.update(stock);

        } catch (Exception e) {
            e.printStackTrace();
            logger.error("请求异常"+e.getMessage());
        } finally {
            CloseableUtil.close(inputStream, response, httpClient);
        }

    }





}
