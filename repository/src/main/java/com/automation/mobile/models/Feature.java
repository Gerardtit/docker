package com.automation.mobile.models;

import java.util.List;

public class Feature {

    private String name;

    private List<FeatureScenario> scenarioList;

    private int id;

    private int runId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<FeatureScenario> getScenarioList() {
        return scenarioList;
    }

    public void setScenarioList(List<FeatureScenario> scenarioList) {
        this.scenarioList = scenarioList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public FeatureScenario getFromName(String name) {

        FeatureScenario featureScenario = null;

        for (FeatureScenario scenario : scenarioList) {

            if (scenario.getName().equalsIgnoreCase(name)) {

                featureScenario = scenario;

                break;
            }
        }

        return featureScenario;
    }

    public int getRunId() {
        return runId;
    }

    public void setRunId(int runId) {
        this.runId = runId;
    }
}
