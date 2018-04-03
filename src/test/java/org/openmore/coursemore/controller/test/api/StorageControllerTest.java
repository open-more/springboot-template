package org.openmore.coursemore.controller.test.api;

import org.openmore.coursemore.BaseTestCase;
import org.openmore.coursemore.service.StorageService;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static junit.framework.TestCase.assertTrue;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * StorageController Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>八月 18, 2017</pre>
 */
public class StorageControllerTest extends BaseTestCase {

    @Autowired
    private StorageService storageService;

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: getCreationImageUploadToken()
     */
    @Test
    public void testGetCreationImageUploadToken() throws Exception {
        assertTrue(storageService != null);
        String result = storageService.getCreationImageUploadToken();
        assertTrue(result != null && result.length() > 0);
    }

    /**
     * Method: getCreationModelUploadToken()
     */
    @Test
    public void testGetCreationModelUploadToken() throws Exception {
        assertTrue(storageService != null);
        String result = storageService.getCreationModelUploadToken();
        assertTrue(result != null && result.length() > 0);
    }


} 
