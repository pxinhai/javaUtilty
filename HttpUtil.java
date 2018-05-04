package pxinhai.util;

import java.io.IOException;
import java.nio.charset.Charset;

import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpUtil {

	public static String doGet(String url, final Charset defaultCharset) throws IOException {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		RequestConfig requestConfig = RequestConfig.custom()
				.setConnectTimeout(3000)
				.setConnectionRequestTimeout(1000)
				.setSocketTimeout(3000).build();
		LogUtil.info("httpDoGet",url);
		try {
			HttpGet httpget = new HttpGet(url);
			httpget.setConfig(requestConfig);
			CloseableHttpResponse response = httpclient.execute(httpget);
			HttpEntity httpentity = response.getEntity();
			return EntityUtils.toString(httpentity, defaultCharset);
		} finally {
			httpclient.close();
		}

	}
}
