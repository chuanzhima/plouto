package com.smk.pay.core.meta;

import com.smk.pay.core.base.BaseServiceTest;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * ServiceResultCode Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>12/19/2016</pre>
 */
public class ServiceResultCodeTest extends BaseServiceTest {

    @Autowired
    private ServiceResultCode serviceResultCode;

    @org.junit.Test
    public void testRun() throws Exception {
        serviceResultCode.run();
    }
}
