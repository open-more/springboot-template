package org.openmore.coursemore.service;

/**
 * THIS IS AUTO GENERATED SOURCE CODE
 * Created by org.openmore.coursemore
 * on 2017-08-17
 */
public interface StorageService {
    /**
     * 获得作品图片上传token
     *
     * @return
     */
    String getCreationImageUploadToken();

    /**
     * 获得作品模型文件上传token
     *
     * @return
     */
    String getCreationModelUploadToken();


    /**
     * 获得颜料/图案7牛上传token
     *
     * @return
     */
    String getResourceImageUploadToken();
}
