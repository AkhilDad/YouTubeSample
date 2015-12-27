package com.akhil.youtubesample;

import android.os.AsyncTask;
import android.util.Log;

import com.rightutils.rightutils.net.BasicRightRequest;

import ch.boye.httpclientandroidlib.HttpResponse;
import ch.boye.httpclientandroidlib.HttpStatus;
import ch.boye.httpclientandroidlib.util.EntityUtils;

/**
 * Created by akhil on 27/12/15.
 */
public class VideoLoaderAsyncTask extends AsyncTask<Void, Void, Void> {
    private static final boolean ENABLE_GZIP = false;
    private static final int TIMEOUT_MILLIS = 30 * 1000; // 30 seconds
    private static final String key = "AIzaSyBc8Wegsw0UckjjZuD6idrdW8tJ6ucAJnc";
    @Override
    protected Void doInBackground(Void... params) {
        try {
            HttpResponse response = new BasicRightRequest(3,2).getHttpResponse("https://www.googleapis.com/youtube/v3/playlistItems?part=snippet&maxResults=10&playlistId=PL0vcQp16X6WjG9P9Rzu3sfGMS4404zPDi&key="+key);
            int status = response.getStatusLine().getStatusCode();
            Log.i("TAG", "status code: " + String.valueOf(status));
            if (status == HttpStatus.SC_OK) {
                Log.e("Response", "-->"+EntityUtils.toString(response.getEntity()));
            }
        } catch (Exception e) {
            Log.e("TAG", "run", e);
        }
        return null;
    }

}
