package com.automation.mobile.helpers;

import com.automation.mobile.appium.AppiumDevice;
import com.automation.mobile.cache.CommonCache;
import com.automation.mobile.entities.ConfigType;
import com.automation.mobile.entities.MobileConfType;
import com.automation.mobile.manager.ThreadLocalManager;
import com.automation.mobile.models.Feature;
import com.automation.mobile.models.FeatureScenario;
import com.automation.mobile.models.ScenarioStep;
import com.automation.mobile.services.testrail.*;
import io.cucumber.gherkin.Gherkin;
import io.cucumber.messages.IdGenerator;
import io.cucumber.messages.Messages;
import io.cucumber.messages.Messages.GherkinDocument.Feature.FeatureChild;
import io.cucumber.messages.Messages.GherkinDocument.Feature.Step;
import org.apache.commons.collections.CollectionUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Collections.singletonList;

public class TestRailHelper {

    private static class Tuple {

        int id;

        boolean status = false;
    }

    private static class GroupPair {

        String configName;

        int groupId;

        public GroupPair(String configName, int groupId) {

            this.configName = configName;

            this.groupId = groupId;
        }
    }

//    public static void updateResult(String[] caseIds, Scenario scenario, String runId) throws IOException, APIException {
//
//        JSONObject resultObj;
//
//        int status_id = 0;
//
//        String comment = "";
//
//        ResultService resultService = new ResultService();
//
////        TestRunService runService = new TestRunService();
////
////        JSONObject result = runService.getRun(runId);
////
////        CaseService caseService = new CaseService();
////
////        JSONObject caseResult = caseService.getCases();
//
//
////        if(scenario.getStatus() == "failed"){
////
////            status_id = 5;
////        }
////        else if(scenario.getStatus() == "passed"){
////
////            status_id = 1;
////        }
////        else if(scenario.getStatus() == "skipped"){
////
////            status_id = 4;
////        }
//
//        if(scenario.isFailed()){
//
//            status_id = 5;
//        }
//        else {
//
//            status_id = 4;
//        }
//
//        JSONObject body = new JSONObject();
//
//        JSONArray results = new JSONArray();
//
//        for (String caseId : caseIds){
//
//            resultObj = new JSONObject();
//
//            resultObj.put("case_id", Integer.valueOf(caseId.substring(1)));
//
//            resultObj.put("status_id", status_id);
//
//            resultObj.put("comment", comment);
//
//            results.add(resultObj);
//        }
//
//        body.put("results", results);
//
//        resultService.addResultsForCases(runId, body);
//    }

    public static void updateResult(Feature pFeature, FeatureScenario scenario) throws IOException, APIException {

        int testId = 0;

        int resultId = 0;

        TestService testService = new TestService();

        JSONArray tests = (JSONArray) testService.getTests(pFeature.getRunId()).get("tests");

        for (Object obj : tests) {

            JSONObject test = (JSONObject) obj;

            int caseId = Integer.parseInt(test.get("case_id").toString());

            if (caseId == scenario.getId()) {

                testId = Integer.parseInt(test.get("id").toString());

                break;
            }
        }

        JSONObject body = new JSONObject();

        JSONArray steps = new JSONArray();

        for (ScenarioStep scenarioStep : scenario.getStepList()) {

            JSONObject step = new JSONObject();

            if (null != scenarioStep.getComment()) {

                step.put("status_id", scenarioStep.getStatus());

                step.put("actual", scenarioStep.getComment());

                step.put("expected", scenarioStep.getExpectedResult());

                step.put("content", scenarioStep.getName());
            } else {

                step.put("status_id", 3);

                step.put("actual", "SKIPPED");

                step.put("expected", scenarioStep.getExpectedResult());

                step.put("content", scenarioStep.getName());
            }

            steps.add(step);
        }

        body.put("status_id", scenario.getStatus());

        body.put("comment", scenario.getComment());

        body.put("custom_step_results", steps);

        //body.put("test_id", testId);

        ResultService resultService = new ResultService();

        JSONObject response = resultService.addResult(body, testId);

        resultId = Integer.parseInt(response.get("id").toString());

        if (scenario.getStatus() == 5) {

            AttachmentService attachmentService = new AttachmentService();

            attachmentService.addAttachmentResult(resultId, scenario.getFileName());
        }
    }

    public static Tuple ifExist(JSONArray data, String name) {

        Tuple tuple = new Tuple();

        for (int i = 0; i < data.size(); i++) {

            JSONObject section = (JSONObject) data.get(i);

            if (section.get("name").toString().equalsIgnoreCase(name)) {

                tuple.id = Integer.parseInt(section.get("id").toString());

                tuple.status = true;

                break;
            }
        }

        return tuple;
    }

    public static int createParentSection() throws IOException, APIException {

        int sectionId;

        SectionService sectionService = new SectionService();

        String sectionName = "automation execution";

        JSONArray sections = (JSONArray) sectionService.getSections().get("sections");

        Tuple tuple = ifExist(sections, sectionName);

        if (!tuple.status) {

            JSONObject body = new JSONObject();

            body.put("name", sectionName);

            body.put("description", "parent automation section");

            JSONObject result = sectionService.addSection(body);

            sectionId = Integer.parseInt(result.get("id").toString());
        } else {

            sectionId = tuple.id;
        }

        return sectionId;
    }

    public static int createSection(String sectionName) throws IOException, APIException {

        int sectionId;

        SectionService sectionService = new SectionService();

        JSONArray sections = (JSONArray) sectionService.getSections().get("sections");

        Tuple tuple = ifExist(sections, sectionName);

        if (!tuple.status) {
            JSONObject body = new JSONObject();

            body.put("name", sectionName);

            body.put("description", sectionName);

            //body.put("parent_id", parentId);

            body.put("suite_id", 142);

            JSONObject result = sectionService.addSection(body);

            sectionId = Integer.parseInt(result.get("id").toString());
        } else {

            sectionId = tuple.id;
        }

        return sectionId;
    }

    public static void addUpdateCases(JSONArray cases, Feature pFeature) throws IOException, APIException {

        CaseService caseService = new CaseService();

        Set<String> testrailSet = new HashSet<>();

        Set<String> scenarioSet = new HashSet<>();

        for (Object aCase : cases) {

            JSONObject testCase = (JSONObject) aCase;

            testrailSet.add(testCase.get("title").toString());
        }

        for (FeatureScenario scenario : pFeature.getScenarioList()) {

            scenarioSet.add(scenario.getName());
        }

        List<String> addScenarios = (List<String>) CollectionUtils.removeAll(scenarioSet, testrailSet);

        List<String> removeScenarios = (List<String>) CollectionUtils.removeAll(testrailSet, scenarioSet);

        for (String name : addScenarios) {

            JSONObject step;

            FeatureScenario scenario = pFeature.getFromName(name);

            JSONObject body = new JSONObject();

            JSONArray steps = new JSONArray();

            body.put("title", scenario.getName());

            body.put("template_id", 2);

            body.put("type_id", 3);

            for (ScenarioStep scenarioStep : scenario.getStepList()) {

                step = new JSONObject();

                step.put("content", scenarioStep.getName());

                step.put("expected", scenarioStep.getExpectedResult());

                steps.add(step);
            }

            body.put("custom_steps_separated", steps);

            caseService.addCase(body, String.valueOf(pFeature.getId()));
        }

        JSONArray caseIds = new JSONArray();

        for (String name : removeScenarios) {

            caseIds.add(getCaseId(cases, name));
        }

        JSONObject req = new JSONObject();

        if (caseIds.size() != 0) {

            req.put("case_ids", caseIds);

            caseService.deleteCases(req);
        }

        cases = (JSONArray) caseService.getCases(pFeature.getId()).get("cases");

        for (Object aCase : cases) {

            JSONObject testCase = (JSONObject) aCase;

            FeatureScenario scenario = pFeature.getFromName(testCase.get("title").toString());

            JSONArray testCaseSteps = (JSONArray) testCase.get("custom_steps_separated");

            if (scenario.getStepList().size() != testCaseSteps.size()) {

                JSONObject step;

                JSONObject body = new JSONObject();

                JSONArray steps = new JSONArray();

                for (ScenarioStep scenarioStep : scenario.getStepList()) {

                    step = new JSONObject();

                    step.put("content", scenarioStep.getName());

                    step.put("expected", scenarioStep.getExpectedResult());

                    steps.add(step);
                }

                body.put("custom_steps_separated", steps);

                caseService.updateCase(body, testCase.get("id").toString());
            }

            scenario.setId(Integer.parseInt(testCase.get("id").toString()));
        }
    }

    public static int getCaseId(JSONArray cases, String name) {

        int caseId = 0;

        for (Object aCase : cases) {

            JSONObject testCase = (JSONObject) aCase;

            if (name.equalsIgnoreCase(testCase.get("title").toString())) {

                caseId = (int) testCase.get("id");
            }
        }

        return caseId;
    }

    private static void createConfigGroups() throws IOException, APIException {

        int groupId;

        String[] groups = {"Devices", "Banners", "Platforms", "PlatformVersions", "DeviceTypes"};

        ConfigService configService = new ConfigService();

        Map<String, Integer> groupIds = new HashMap<>();

        JSONArray configs = configService.getConfigs();

        for (String group : groups) {

            Tuple tuple = ifExist(configs, group);

            if (!tuple.status) {

                JSONObject body = new JSONObject();

                body.put("name", group);

                groupId = Integer.parseInt(configService.addConfigGroup(body).get("id").toString());

                groupIds.put(group, groupId);
            } else {

                groupIds.put(group, tuple.id);
            }
        }

        CommonCache.testrailCache.put("Config_Groups", groupIds);
    }

    private static List<Integer> createConfigs(AppiumDevice appiumDevice) throws IOException, APIException {

        List<Integer> configIds = new ArrayList<>();

        int configId;

        ConfigService configService = new ConfigService();

        Map<String, GroupPair> configMap = new HashMap<>();

        String platform = appiumDevice.getConfigureData(MobileConfType.PLATFORM_NAME);

        String banner = appiumDevice.getConfigureData(ConfigType.BANNER);

        String deviceType = appiumDevice.getConfigureData(MobileConfType.DEVICE_TYPE);

        String deviceName = appiumDevice.getConfigureData(MobileConfType.DEVICE_NAME);

        String platformVersion = appiumDevice.getConfigureData(MobileConfType.PLATFORM_VERSION);

        Map<String, Integer> groupIds = (Map<String, Integer>) CommonCache.testrailCache.get("Config_Groups");

        configMap.put("Platforms", new GroupPair(platform, groupIds.get("Platforms")));

        configMap.put("Banners", new GroupPair(banner, groupIds.get("Banners")));

        configMap.put("DeviceTypes", new GroupPair(deviceType, groupIds.get("DeviceTypes")));

        configMap.put("Devices", new GroupPair(deviceName, groupIds.get("Devices")));

        configMap.put("PlatformVersions", new GroupPair(platformVersion, groupIds.get("PlatformVersions")));

        JSONArray configs = configService.getConfigs();

        for (String name : configMap.keySet()) {

            Tuple tuple = ifConfigExist(configs, configMap.get(name).configName, name);

            if (!tuple.status) {

                JSONObject body = new JSONObject();

                body.put("name", configMap.get(name).configName);

                configId = Integer.parseInt(configService.addConfig(body, configMap.get(name).groupId).get("id").toString());
            } else {

                configId = tuple.id;
            }

            configIds.add(configId);
        }

        return configIds;
    }

    private static Tuple ifConfigExist(JSONArray configs, String configName, String groupName) {

        Tuple tuple = new Tuple();

        for (Object obj : configs) {

            JSONObject configGroup = (JSONObject) obj;

            if (configGroup.get("name").toString().equalsIgnoreCase(groupName)) {

                JSONArray configArray = (JSONArray) configGroup.get("configs");

                for (Object child : configArray) {

                    JSONObject config = (JSONObject) child;

                    if (config.get("name").toString().equalsIgnoreCase(configName)) {

                        tuple.id = Integer.parseInt(config.get("id").toString());

                        tuple.status = true;

                        break;
                    }
                }
            }
        }

        return tuple;
    }

    private static int createMilestone() throws IOException, APIException {

        int milestoneId;

        String milestoneName = "Automation";

        MilestoneService milestoneService = new MilestoneService();

        JSONArray milestones = (JSONArray) milestoneService.getMilestones().get("milestones");

        Tuple tuple = ifExist(milestones, milestoneName);

        if (!tuple.status) {

            JSONObject body = new JSONObject();

            body.put("name", milestoneName);

            body.put("description", milestoneName);

            JSONObject result = milestoneService.addMilestone(body);

            milestoneId = Integer.parseInt(result.get("id").toString());
        } else {

            milestoneId = tuple.id;
        }

        return milestoneId;
    }

    private static int createPlanEntry(Feature pFeature, List<Integer> configIds) throws IOException, APIException {

        int runId = 0;

        TestPlanService testPlanService = new TestPlanService();

        JSONObject body = new JSONObject();

        JSONArray configs = new JSONArray();

        JSONArray caseIds = new JSONArray();

        JSONArray runs = new JSONArray();

        JSONObject run = new JSONObject();

        for (int id : configIds) {

            configs.add(id);
        }

        for (FeatureScenario scenario : pFeature.getScenarioList()) {

            caseIds.add(scenario.getId());
        }

        run.put("include_all", false);

        run.put("config_ids", configs);

        run.put("case_ids", caseIds);

        runs.add(run);

        body.put("suite_id", 142);

        body.put("name", pFeature.getName());

        body.put("description", pFeature.getName());

        body.put("include_all", false);

        body.put("config_ids", configs);

        body.put("case_ids", caseIds);

        body.put("runs", runs);

        JSONObject result = testPlanService.addPlanEntry(body, Integer.parseInt(CommonCache.testrailCache.get("PLAN_ID").toString()));

        JSONArray runsArray = (JSONArray) result.get("runs");

        for (Object aRun : runsArray) {

            JSONObject runObject = (JSONObject) aRun;

            runId = Integer.parseInt(runObject.get("id").toString());

            break;
        }

        return runId;
    }

    public static void initTesPlan(String planName) throws IOException, APIException {

        int planId;

        TestPlanService testPlanService = new TestPlanService();

        //TestRunService testRunService = new TestRunService();

        createConfigGroups();

        int milestoneId = createMilestone();

        JSONArray plans = (JSONArray) testPlanService.getPlans().get("plans");

        Tuple tuple = ifExist(plans, planName);

        if (!tuple.status) {

            JSONObject body = new JSONObject();

            body.put("name", planName);

            body.put("description", planName);

            body.put("milestone_id", milestoneId);

            planId = Integer.parseInt(testPlanService.addPlan(body).get("id").toString());
        } else {

            planId = tuple.id;
        }

        CommonCache.testrailCache.put("PLAN_ID", planId);
    }

    public static void setupTestRail(String featurePath, AppiumDevice appiumDevice) throws IOException, APIException {

        parseFeature(featurePath);

        CaseService caseService = new CaseService();

        //int parentId = createParentSection();

        Feature lFeature = ThreadLocalManager.feature.get();

        int featureId = createSection(lFeature.getName());

        lFeature.setId(featureId);

        JSONArray cases = (JSONArray) caseService.getCases(featureId).get("cases");

        //if(cases.size() != lFeature.getScenarioList().size()){

        addUpdateCases(cases, lFeature);
        //}

        List<Integer> configIds = createConfigs(appiumDevice);

        int runId = createPlanEntry(lFeature, configIds);

        lFeature.setRunId(runId);
    }

    public static void parseFeature(String path) {

        List<ScenarioStep> stepList;

        FeatureScenario featureScenario;

        ScenarioStep scenarioStep;

        Feature lFeature = new Feature();

        List<FeatureScenario> scenarioList = new ArrayList<>();

        //uri = "/Users/saadalikhan/eclipse-workspace/Digital-Automation-Mobile/src/test/resources/Mobile/gg_features/gg_dashboard.feature";

        IdGenerator idGenerator = new IdGenerator.Incrementing();

        List<String> paths = singletonList(path);

        boolean includeSource = false;

        boolean includeAst = true;

        boolean includePickles = false;

        List<Messages.Envelope> envelopes = Gherkin.fromPaths(paths, includeSource, includeAst, includePickles, idGenerator).collect(Collectors.toList());

        // Get the AST
        Messages.GherkinDocument gherkinDocument = envelopes.get(0).getGherkinDocument();

        // Get the Feature node of the AST
        Messages.GherkinDocument.Feature feature = gherkinDocument.getFeature();

        // Get the first Scenario node of the Feature node
        List<FeatureChild> featureChildList = feature.getChildrenList();

        for (FeatureChild scenario : featureChildList) {

            stepList = new ArrayList<>();

            featureScenario = new FeatureScenario();

            List<Step> stepsList = scenario.getScenario().getStepsList();

            for (Step step : stepsList) {

                scenarioStep = new ScenarioStep();

                scenarioStep.setName(step.getText());

                scenarioStep.setExpectedResult(step.getDocString().getContent());

                stepList.add(scenarioStep);
            }

            featureScenario.setName(scenario.getScenario().getName());

            featureScenario.setStepList(stepList);

            scenarioList.add(featureScenario);
        }

        lFeature.setName(feature.getName());

        lFeature.setScenarioList(scenarioList);

        ThreadLocalManager.feature.set(lFeature);
    }

//    public static void main(String args[]) throws IOException, APIException {
//
//        parseFeature("");
//
//        setupTestRail();
//    }
}


