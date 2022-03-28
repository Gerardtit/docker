package com.automation.mobile.services.perfecto;

import com.automation.mobile.handlers.HttpHandler;
import com.automation.mobile.helpers.FileHelper;
import com.automation.mobile.models.HttpRequest;
import com.automation.mobile.models.HttpResponse;
import com.automation.mobile.services.perfecto.config.PerfectoApiConfig;
import com.automation.mobile.services.perfecto.constants.PerfectoConstants;
import com.automation.mobile.services.perfecto.models.ApiSchema;
import com.google.gson.Gson;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.Callable;

public class RepositoryService {
    Logger logger = LogManager.getLogger(getClass());

    public static HttpResponse getFileList(String platformName, String cloudToken) {

        HttpRequest request = new HttpRequest();

        String url = PerfectoConstants.URL + PerfectoConstants.ARTIFACTS + "?artifactType=" + platformName;

        request.setUrl(url);

        request.setHeaders(PerfectoApiConfig.getHeaders(cloudToken));

        HttpResponse response = HttpHandler.get(request);

        return response;
    }

    private List<ApiSchema.PerfectoExecInfo.Resources.Artifacts> getExecutionInfo(String cloudToken, String executionId) {
        Optional<ApiSchema.PerfectoExecInfo.Resources> resource = null;
        HttpRequest request = new HttpRequest();
        String url = PerfectoConstants.URL_PERFECTO_HOME + PerfectoConstants.EXECUTION_INFO;
        request.setUrl(url);

        //Headers
        request.setHeaders(PerfectoApiConfig.getHeaders(cloudToken));

//        await().atMost(30, TimeUnit.SECONDS).until(executionReportIsGeneratedForId(HttpHandler.get(request), executionId));
        List<ApiSchema.PerfectoExecInfo.Resources> resources;
        for (int i = 0; i < 20; i++) {
            HttpResponse response = HttpHandler.get(request);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ie) {
                // Do nothing here
            }
            resources = new Gson().fromJson(response.getContent(), ApiSchema.PerfectoExecInfo.class).getResources();
            resource = resources.stream().filter(indReport -> indReport.getExternalId().equals(executionId)).findFirst();
            if (resource.isPresent()) {
                logger.info("Test report id:  " + resource.get().getId());
                logger.info("Resources:  " + resource);
                break;
            }
        }

        return resource.get().getArtifacts();
//        return new Gson().fromJson(HttpHandler.get(request).getContent(), ApiSchema.PerfectoExecInfo.class).getResources().stream().filter(indReport -> indReport.getExternalId().equals(executionId)).findFirst().get().getArtifacts();
    }

    private void downloadTheReport(String accessToken, String downloadURL, String fileName) throws IOException {
        HttpRequest request = new HttpRequest();
        request.setUrl(downloadURL);
        //Headers
        request.setHeaders(PerfectoApiConfig.getHeaders(accessToken));
        //Service
        HttpResponse response = HttpHandler.get(request);
        String folderPath = System.getProperty("user.dir") + File.separator + "test-output" + File.separator + "AccessibilityReports" + File.separator;
        Files.createDirectories(Paths.get(folderPath));
        File outputFile = new File(folderPath, fileName + ".zip");
        byte[] fileContents = response.getBodyContentsBytes();
        // output contents to file
        OutputStream outStream = null;
        try {
            outStream = new FileOutputStream(outputFile);
            outStream.write(fileContents);
            logger.info("Accessibility Report successfully saved " + outputFile.getCanonicalPath());
        } catch (Exception e) {
            logger.error("Error writing file " + outputFile.getAbsolutePath());
        } finally {
            if (outStream != null) {
                outStream.close();
            }
        }
    }

    public void downloadAccessibilityReports(String accessToken, String executionId) throws IOException {
        boolean hasAccessiblityReport = false;
        logger.info("Driver execution id:  " + executionId);
        List<ApiSchema.PerfectoExecInfo.Resources.Artifacts> artifacts = new RepositoryService().getExecutionInfo(accessToken, executionId);
        for (ApiSchema.PerfectoExecInfo.Resources.Artifacts desiredArtifact : artifacts) {
            if (desiredArtifact.getType().trim().equalsIgnoreCase("Accessibility Report")) {
                new RepositoryService().downloadTheReport(accessToken, desiredArtifact.getPath(), desiredArtifact.getFileName().replaceAll("\\s", ""));
                hasAccessiblityReport = true;
            }
        }

        if (!hasAccessiblityReport) {
            logger.info("No accessibility report found for execution with id: " + executionId);
        } else {
            String dirPath = System.getProperty("user.dir") + File.separator + "test-output" + File.separator + "AccessibilityReports/";
            new FileHelper().unzipAllFilesWithinFolder(dirPath);
        }
    }

    private Callable<Boolean> executionReportIsGeneratedForId(HttpResponse response, String executionId) {
        List<ApiSchema.PerfectoExecInfo.Resources> axeReports = new Gson().fromJson(response.getContent(), ApiSchema.PerfectoExecInfo.class).getResources();
        return () -> axeReports.stream().filter(indReport -> indReport.getExternalId().equals(executionId)).findFirst().isPresent();
    }


}
