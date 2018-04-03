package org.openmore.coursemore.service.impl;

import org.openmore.coursemore.service.StorageService;
import com.qiniu.util.StringMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.qiniu.util.Auth;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * THIS IS AUTO GENERATED SOURCE CODE
 * Created by org.openmore.coursemore
 * on 2017-08-17
 */
@Service
public class StorageServiceImpl implements StorageService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());


    private final String ACCESS_KEY = "Nut-cB3jw-PW63yZtEYBHFYMIbW6dMEvx1124GKc";
    private final String SECRET_KEY = "qqzAwV0OWEbZ9AWmDzPyOZcWPz0LsjHHKtHkO_gi";

    private static final String BUCKET_SPACE = "public-storage";

    private String getUploadToken(String keyPrefix) {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
        String dateString = formatter.format(currentTime);
        String key = keyPrefix + "/" + dateString + "/" + UUID.randomUUID();

        logger.debug("key = " + key);
        Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
        StringMap putPolicy = new StringMap();
        putPolicy.put("saveKey", key);
        putPolicy.put("returnBody", "{\"key\":\"$(key)\",\"hash\":\"$(etag)\",\"bucket\":\"$( )\",\"fsize\":$(fsize)}");
        long expireSeconds = 3600;
        String upToken = auth.uploadToken(BUCKET_SPACE, null, expireSeconds, putPolicy);
        logger.debug("upload token = " + upToken);
        return upToken;
    }

    /**
     * 获得作品图片上传token
     */
    public String getCreationImageUploadToken() {
        return this.getUploadToken("creation_cover");
    }

    /**
     * 获得作品模型上传token
     *
     * @return
     */
    public String getCreationModelUploadToken() {
        return this.getUploadToken("creation_model");
    }

    /**
     * 获得颜料/图案7牛上传token
     *
     * @return
     */
    public String getResourceImageUploadToken() {
        return this.getUploadToken("resource");
    }
}
