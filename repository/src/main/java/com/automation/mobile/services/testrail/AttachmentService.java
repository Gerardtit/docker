package com.automation.mobile.services.testrail;

import java.io.IOException;

public class AttachmentService extends TestRailService {

    public AttachmentService() {

        super();
    }

    public void addAttachmentResult(int resultId, String fileName) throws IOException, APIException {

        apiClient.sendPost("add_attachment_to_result/" + resultId, fileName);
    }
}
